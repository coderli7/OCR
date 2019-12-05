package com.pyg.manager.service;

import com.alibaba.fastjson.JSON;
import com.pyg.manager.commonutils.LoggerEnum;
import com.pyg.manager.commonutils.MyAnnotation;
import com.pyg.manager.commonutils.MyDateUtils;
import com.pyg.manager.commonutils.MyLogger;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.model.AIOJsonModel.*;
import com.pyg.manager.model.WebApiResponse.BaseResponse;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetStatisticBytes extends BaseService {

	private String curUser;
	private String startDate;
	private String endDate;

	public String getCurUser() {
		return curUser;
	}

	public void setCurUser(String curUser) {
		this.curUser = curUser;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public void Excute() {
		try {

			/**
			 * 1.查询某区间结果 2.遍历，结果，统计案件总数 3.遍历每个案件中，已成功识别出结果数量 4.字节最大数。 5.字节最小数。
			 * 5.字节平均数
			 */
			response = new BaseResponse();

			if ("".equals(startDate) || startDate == null) {
				startDate = MyDateUtils.getDateTimeNow("yyyy-MM-dd");
			}
			if ("".equals(endDate) || endDate == null) {
				endDate = MyDateUtils.getDateTimeNow("yyyy-MM-dd");
			}
			Integer caseCount = 0, caseImgResultCount = 0, imgMaxByte = 0,
					imgMinByte = 0, imgAmount = 0;
			String imgAvgByte = "";
			List<String> result = new ArrayList<>();
			result.add(String.format(
					"*******************  %s ~ %s *******************",
					startDate, endDate));
			List<Integer> allImgByte = new ArrayList<>();
			List<TbImageCaseInfo> imageCaseInfos = imageCaseInfoService
					.findByDate(this.curUser, startDate, endDate, "完成");
			caseCount = imageCaseInfos.size();
			for (TbImageCaseInfo tbImageCaseInfo : imageCaseInfos) {
				String imgResult = tbImageCaseInfo.getResult();
				JsonRootBean rootBean = JSON.toJavaObject(
						JSON.parseObject(imgResult), JsonRootBean.class);
				if (rootBean != null && rootBean.getResultData() != null) {
					ResultData resultData = rootBean.getResultData();
					if (resultData != null) {
						Clinic_info clinic_info = resultData.getClinic_info();
						if (clinic_info != null) {
							List<Clinic_record> clinic_records = clinic_info
									.getClinic_record();
							if (clinic_records != null) {
								for (Clinic_record clinic_record : clinic_records) {
									caseImgResultCount++;
									List<String> values = getValues(
											clinic_record);
									String allVal = values.toString();
									if (!StringUtils.isBlank(allVal)) {
										int length = allVal.length();
										allImgByte.add(length);
										imgAmount += length;
									}
								}
							}
						}
						Inpatient_info inpatient_info = resultData
								.getInpatient_info();
						if (inpatient_info != null) {
							List<Inpatient_record> inpatient_records = inpatient_info
									.getInpatient_record();
							if (inpatient_records != null) {
								for (Inpatient_record inpatient_record : inpatient_records) {
									caseImgResultCount++;
									List<String> values = getValues(
											inpatient_record);
									String allVal = values.toString();
									if (!StringUtils.isBlank(allVal)) {
										int length = allVal.length();
										allImgByte.add(length);
										imgAmount += length;
									}
								}
							}
						}
					}
				}
			}
			if (allImgByte.size() > 0) {
				// 获取最大值
				Collections.sort(allImgByte);
				imgMinByte = allImgByte.get(0);
				imgMaxByte = allImgByte.get(allImgByte.size() - 1);
				DecimalFormat df = new DecimalFormat("0.00");
				imgAvgByte = df.format((float) imgAmount / caseImgResultCount);

				// 设置结果

				result.add(String.format("1.案件总数:%s", caseCount));
				result.add(String.format("2.案件票据数:%s", caseImgResultCount));
				result.add(String.format("3.票据字节最小值:%s", imgMinByte));
				result.add(String.format("4.票据字节最大值:%s", imgMaxByte));
				result.add(String.format("5.票据字节平均值:%s", imgAvgByte));

			} else {
				result.add("未查询到结果!");
			}

			response.Info = result;
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error, String.format(
					"执行函数GetStatisticBytes-excute发生异常:%s", e.getMessage()));
		}

	}

	/**
	 * 只解析非空字段
	 * 
	 * @param model
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private <T> List<String> getValues(T model)
			throws IllegalArgumentException, IllegalAccessException {
		List<String> curSb = new ArrayList<>();
		try {
			Field[] fields = model.getClass().getDeclaredFields();
			for (Field field : fields) {
				String curFieldDes = "";
				Object curFieldVal = null;
				Class<?> curFieldType = null;
				MyAnnotation fildMark = field.getAnnotation(MyAnnotation.class);
				if (fildMark != null) {
					field.setAccessible(true);
					curFieldVal = field.get(model);
					curFieldDes = fildMark.name();
				}
				curFieldType = field.getType();
				if (curFieldVal != null && !StringUtils.isEmpty(curFieldDes)) {
					if (curFieldType.toString().contains("java.lang.String")) {
						String curFieldValStr = curFieldVal.toString();
						if (!StringUtils.isBlank(curFieldValStr)) {
							curSb.add(curFieldValStr.trim());
						}
					} else {
						// 此处需要区分含列表的情况
						if (curFieldType.toString()
								.contains("java.util.List")) {
							Iterable<Object> iterable = (Iterable<Object>) curFieldVal;
							for (Object object : iterable) {
								curSb.addAll(getValues(object));
							}
						} else {
							// 继续遍历
							curSb.addAll(getValues(curFieldVal));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curSb;
	}
}
