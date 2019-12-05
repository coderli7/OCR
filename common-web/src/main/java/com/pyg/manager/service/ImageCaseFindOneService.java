package com.pyg.manager.service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyg.manager.commonutils.LoggerEnum;
import com.pyg.manager.commonutils.MyAnnotation;
import com.pyg.manager.commonutils.MyCommonUtils;
import com.pyg.manager.commonutils.MyLogger;
import com.pyg.manager.commonutils.ServiceCommonUse;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.model.AIOJsonModel.Clinic_info;
import com.pyg.manager.model.AIOJsonModel.Clinic_record;
import com.pyg.manager.model.AIOJsonModel.Inpatient_info;
import com.pyg.manager.model.AIOJsonModel.Inpatient_record;
import com.pyg.manager.model.AIOJsonModel.JsonRootBean;
import com.pyg.manager.model.AIOJsonModel.Medical_fee_info;
import com.pyg.manager.model.AIOJsonModel.ResultData;
import com.pyg.manager.model.WebApiRequest.BaseRequest;
import com.pyg.manager.model.WebApiResponse.BaseResponse;
import com.pyg.manager.model.pageinfo.CasePageInfo;
import com.pyg.manager.model.pageinfo.CasePageStatisticsInfo;
import com.pyg.manager.model.pageinfo.ImgPageInfo;

public class ImageCaseFindOneService extends BaseService {

	@Override
	public void Excute() {
		Long id = (Long) request.Info;
		CasePageInfo casePageInfo = new CasePageInfo();

		// 1.设置案件表头信息
		TbImageCaseInfo imageCaseInfo = imageCaseInfoService.findOne(id);
		casePageInfo.setImageCaseInfo(imageCaseInfo);
		String caseId = imageCaseInfo.getCaseid();

		// 2.设置案件图片列表
		List<TbImage> images = imageService.findByCaseId(caseId);
		for (TbImage tbImage : images) {
			String orgPath = tbImage.getImgpath();

			// 2.1此处,直接设置缩略图路径
			int subfixIdx = orgPath.lastIndexOf('.');
			if (subfixIdx > 0) {
				String subfix = orgPath.substring(subfixIdx);
				orgPath += (".small" + subfix);
			}
			orgPath = orgPath.replace('\\', '/');
			String idxKey = "image/";
			int adminIndex = orgPath.lastIndexOf(idxKey);
			String webPath = "../" + orgPath.substring(adminIndex);
			tbImage.setInfo1(webPath);

			// 2.2判断是否识别成功
			String imgresultmodelclass = tbImage.getImgresultmodelclass();
			if (imgresultmodelclass == null || imgresultmodelclass == "") {
				tbImage.setInfo2(MyCommonUtils.MyColor_Yellow);
				tbImage.setInfo3("该票据未识别;");
			} else {
				tbImage.setInfo2("");

				// 2.3判断是否包含特殊字符识别
				ImgPageInfo imgPageInfo = null;
				try {
					imgPageInfo = searchResultByCaseIdAndImgName(
							tbImage.getCaseid(), tbImage.getImgname());
				} catch (ClassNotFoundException | IllegalArgumentException
						| IllegalAccessException e) {
					e.printStackTrace();
				}
				if (imageCaseInfo != null) {
					List<String> strings = imgPageInfo.getDetail();
					String allResult = Arrays.toString(strings.toArray());
					if (!StringUtils.isBlank(allResult)
							&& allResult.contains("^")) {
						tbImage.setInfo2(MyCommonUtils.MyColor_Yellow);
						String tips = tbImage.getInfo3();
						tips = StringUtils.isBlank(tips) ? "" : tips;
						tips += "该票据存在识别异常;";
						tbImage.setInfo3(tips);
					}
				}
				
				//获取该图像对应名字，在列表中展示
				List<String> purDetail = imgPageInfo.getPurDetail();
				if (purDetail!=null) {
					String allNames="";
					for (String item : purDetail) {
						String containKey="姓名:";
						if (!StringUtils.isBlank(item)&&item.contains(containKey)) {
							allNames+=String.format("%s;",item.replace(containKey, ""));
						}
					}
					tbImage.setInfo4(allNames);
				}
				//统计字节总数（一张图片中包含多个，按照1张来处理）
				List<String> detail = imgPageInfo.getDetail();
				Integer allByteCount = getByteLength(detail);
				String info4Pre = tbImage.getInfo4();
				if (!StringUtils.isBlank(info4Pre)) {
					String info4New=String.format("%s(%s)", info4Pre,allByteCount);	
					tbImage.setInfo4(info4New);
				}
			}
		}

		if (images != null && images.size() > 0) {
			casePageInfo.setImages(images);
		}

		// 3.设置图片结果信息
		ResultData resultData = null;
		List<TbImageCaseInfo> imageResults = imageCaseInfoService
				.findByCaseId(caseId);
		if (imageResults != null && imageResults.size() > 0) {
			TbImageCaseInfo tbImageResult = imageResults.get(0);

			// 3.1解析详细信息
			String result = tbImageResult.getResult();
			try {
				if (result != null && result != "") {
					JSONObject jsonObject = JSON.parseObject(result);
					JsonRootBean resutBean = JSON.toJavaObject(jsonObject,
							JsonRootBean.class);
					resultData = resutBean.getResultData();
					List<String> briefVal = MyCommonUtils
							.getModelStr(resultData);
					if (briefVal != null && briefVal.size() > 0) {
						casePageInfo.setBriefInfo(briefVal);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 4.设置统计信息
		if (resultData != null) {
			List<CasePageStatisticsInfo> casePageStatisticsInfoList = new ArrayList<>();
			Clinic_info clinic_info = resultData.getClinic_info();
			Inpatient_info inpatient_info = resultData.getInpatient_info();
			// 4.1clinicInfos
			List<Clinic_record> clinic_record = clinic_info.getClinic_record();
			for (Clinic_record record : clinic_record) {
				String name = record.getName();
				String amount = record.getFee_info().getSum_amount();
				BigDecimal curBigDecimal = BigDecimal.ZERO;
				curBigDecimal=	MyCommonUtils.getBigDecimalVal(amount);

				if (!StringUtils.isBlank(name)
						&& curBigDecimal.intValue() > 0) {
					CasePageStatisticsInfo curInfo = getCasePageStatistic(
							casePageStatisticsInfoList, name);
					
					//获取社保金额
					
				BigDecimal personnalAmount=	 ServiceCommonUse.getFeeByFtype(record.getFee_info(),"1");
				BigDecimal socialAmount=	 ServiceCommonUse.getFeeByFtype(record.getFee_info(),"2");

					if (curInfo != null) {
						Integer imgCount = curInfo.getImgCount();
						curInfo.setImgCount(imgCount + 1);
						curInfo.setTotalAmount(curInfo.getTotalAmount().add(curBigDecimal));
						setMedchineInfo(curInfo,
								record.getFee_info().getMedical_fee_info());
						curInfo.setPersonAmount(curInfo.getPersonAmount().add(personnalAmount));
						curInfo.setSocialAmount(curInfo.getSocialAmount().add(socialAmount));
					} else {
						curInfo = new CasePageStatisticsInfo();
						curInfo.setName(name);
						curInfo.setImgCount(1);
						curInfo.setTotalAmount(curBigDecimal);
						curInfo.setMedical_fee_info(
								record.getFee_info().getMedical_fee_info());
						curInfo.setPersonAmount(personnalAmount);
						curInfo.setSocialAmount(socialAmount);
						casePageStatisticsInfoList.add(curInfo);
					}
				}
			}

			// 4.2 inpatient_info
			List<Inpatient_record> inpatients = inpatient_info
					.getInpatient_record();
			for (Inpatient_record inpatient_record : inpatients) {
				String name = inpatient_record.getPatient_info().getName();
				String amount = inpatient_record.getFee_info().getSum_amount();
				BigDecimal curBigDecimal = BigDecimal.ZERO;
				curBigDecimal=	MyCommonUtils.getBigDecimalVal(amount);
				if (!StringUtils.isBlank(name)
						&& curBigDecimal.intValue() > 0) {
					CasePageStatisticsInfo curInfo = getCasePageStatistic(
							casePageStatisticsInfoList, name);
					
					//获取社保金额
					
					BigDecimal personnalAmount=	 ServiceCommonUse.getFeeByFtype(inpatient_record.getFee_info(),"1");
					BigDecimal socialAmount=	 ServiceCommonUse.getFeeByFtype(inpatient_record.getFee_info(),"2");
					
					if (curInfo != null) {
						Integer imgCount = curInfo.getImgCount();						
						curInfo.setImgCount(imgCount + 1);
						curInfo.setTotalAmount(curInfo.getTotalAmount().add(curBigDecimal));
						setMedchineInfo(curInfo, inpatient_record.getFee_info()
								.getMedical_fee_info());
						curInfo.setPersonAmount(curInfo.getPersonAmount().add(personnalAmount));
						curInfo.setSocialAmount(curInfo.getSocialAmount().add(socialAmount));
						
					} else {
						curInfo = new CasePageStatisticsInfo();
						curInfo.setName(name);
						curInfo.setImgCount(1);
						curInfo.setTotalAmount(curBigDecimal);
						curInfo.setMedical_fee_info(inpatient_record
								.getFee_info().getMedical_fee_info());
						
						curInfo.setPersonAmount(personnalAmount);
						curInfo.setSocialAmount(socialAmount);
						casePageStatisticsInfoList.add(curInfo);
					}
				}
			}
			casePageInfo.setCasePageStatisticsInfos(casePageStatisticsInfoList);
		}
		
		//5.设置前端展示列表
		List<CasePageStatisticsInfo> casePageStatisticsInfoList = casePageInfo.getCasePageStatisticsInfos();
		
		if (casePageStatisticsInfoList!=null) {
			for (CasePageStatisticsInfo info : casePageStatisticsInfoList) {
				Medical_fee_info fee_info = info.getMedical_fee_info();
				try {
					List<String> vals = getValues(fee_info);
					if (vals != null && vals.size() > 0) {
						info.setMedicalFeeList(vals);
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					MyLogger.log(LoggerEnum.Error,
							String.format("执行函数getValues异常:%s", e.getMessage()));
				}
			}
		}
		response = new BaseResponse();
		response.Info = casePageInfo;
	}

	private CasePageStatisticsInfo getCasePageStatistic(
			List<CasePageStatisticsInfo> casePageStatisticsInfoList,
			String name) {
		if (casePageStatisticsInfoList != null) {
			for (CasePageStatisticsInfo casePageStatisticsInfo : casePageStatisticsInfoList) {
				String curName = casePageStatisticsInfo.getName();
				if (name.equals(curName)) {
					return casePageStatisticsInfo;
				}
			}
		}
		return null;
	}

	private ImgPageInfo searchResultByCaseIdAndImgName(String caseId,
			String imgName) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {
		ImgPageInfo imgPageInfo = new ImgPageInfo();
		BaseService service = new SearchByCaseIdAndImgNameService();
		TbImage srchImg = new TbImage();
		srchImg.setCaseid(caseId);
		srchImg.setImgname(imgName);
		service.request = new BaseRequest();
		service.request.Info = srchImg;
		service.imageCaseInfoService = imageCaseInfoService;
		service.imageService = imageService;
		service.Excute();
		if (service.response != null && service.response.Info != null) {
			imgPageInfo = (ImgPageInfo) service.response.Info;
		}
		return imgPageInfo;
	}

	private void setMedchineInfo(CasePageStatisticsInfo info,
			Medical_fee_info medicalInfo) {
		try {
			if (info!=null) {
				Medical_fee_info preMedcialInfo = info.getMedical_fee_info();
				//1.遍历旧版本所有属性,并使用新版,合并两个属性总计
				Field[] fields = Medical_fee_info.class.getDeclaredFields();
				for (Field curField : fields) {
					curField.setAccessible(true);

					Object preVal = curField.get(preMedcialInfo);
					Object newVal = curField.get(medicalInfo);
					preVal=preVal==null?"0":preVal;
					newVal=newVal==null?"0":newVal;
					BigDecimal preBigDecimalVal = MyCommonUtils.getBigDecimalVal(preVal.toString());
					BigDecimal newBigDecimalVal = MyCommonUtils.getBigDecimalVal(newVal.toString());
					String curFieldNewVal = preBigDecimalVal.add(newBigDecimalVal).toString();
					curField.set(preMedcialInfo, curFieldNewVal);
				}
			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error, String
					.format("执行函数setMedchineInfo发生异常:%s", e.getMessage()));
		}
	}

	private  <T> List<String> getValues(T model)
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
						if (!StringUtils.isBlank(curFieldValStr)
								&& !"0.00".equals(curFieldValStr)
								&& !"0.0".equals(curFieldValStr)
								&& !"0".equals(curFieldValStr)) {
							String curVal = String.format("%s:%s",
									curFieldDes, curFieldValStr);
							curSb.add(curVal);
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
	
	private Integer getByteLength(List<String> list){
		Integer integer=new Integer(0);
		try {
			/*
			 * 1.汉字，两个字节
			 * 2.其他字母数字，特殊字符，1个字符
			 * */
			StringBuilder allSb=new StringBuilder();
			for (String item : list) {
				int lastIndexOf = item.lastIndexOf(":");
				if (lastIndexOf>0) {
					String newItem=item.substring(lastIndexOf+1);
					if (!StringUtils.isBlank(newItem)) {
						allSb.append(newItem);
					}
				}				
			}
			integer=allSb.toString().length();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return integer;
	}
}
