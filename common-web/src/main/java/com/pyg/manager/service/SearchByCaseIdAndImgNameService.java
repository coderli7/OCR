package com.pyg.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.pyg.manager.commonutils.LoggerEnum;
import com.pyg.manager.commonutils.MyCommonUtils;
import com.pyg.manager.commonutils.MyLogger;
import com.pyg.manager.commonutils.ServiceCommonUse;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.model.AIOJsonModel.Clinic_info;
import com.pyg.manager.model.AIOJsonModel.Clinic_record;
import com.pyg.manager.model.AIOJsonModel.Fee_detail;
import com.pyg.manager.model.AIOJsonModel.Inpatient_info;
import com.pyg.manager.model.AIOJsonModel.Inpatient_record;
import com.pyg.manager.model.AIOJsonModel.JsonRootBean;
import com.pyg.manager.model.AIOJsonModel.Medical_fee_info;
import com.pyg.manager.model.AIOJsonModel.ResultData;
import com.pyg.manager.model.WebApiResponse.BaseResponse;
import com.pyg.manager.model.pageinfo.ImgPageInfo;

public class SearchByCaseIdAndImgNameService extends BaseService {

	@Override
	public void Excute() {

		try {
			response = new BaseResponse();
			TbImage srchImg = (TbImage) request.Info;
			String caseId = srchImg.getCaseid();
			String imgName = srchImg.getImgname();
			ImgPageInfo imgPageInfo = new ImgPageInfo();
			// 1.搜索案件号,并获取到图片信息
			imgPageInfo.setImgSrc(
					String.format("../image/%s/%s", caseId, imgName));

			// 2.只需要在每个列表中搜索即可
			List<TbImageCaseInfo> imageResults = imageCaseInfoService
					.findByCaseId(caseId);
			if (imageResults != null && imageResults.size() > 0) {
				TbImageCaseInfo imageResult = imageResults.get(0);
				String imgResult = imageResult.getResult();
				if (StringUtils.isNotEmpty(imgResult)) {
					JsonRootBean rootBean = JSON.toJavaObject(
							JSON.parseObject(imgResult), JsonRootBean.class);
					getModelStrByImgName(imgPageInfo, rootBean, imgName);
				}
			}
			response.Info = imgPageInfo;
		} catch (Exception e) {
		}
	}

	/**
	 * 在医审资料对比中，查找
	 * 
	 * @param rootBean
	 * @param imgName
	 * @return
	 */
	public void getModelStrByImgName(ImgPageInfo imPageInfo,
			JsonRootBean rootBean, String imgName) {
		try {
			ResultData resultData = rootBean.getResultData();
			Clinic_info clinic_info = resultData.getClinic_info();
			Inpatient_info inpatient_info = resultData.getInpatient_info();
			setClinicinfos(imPageInfo, clinic_info, imgName);
			setInpatientinfo(imPageInfo, inpatient_info, imgName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setClinicinfos(ImgPageInfo imPageInfo, Clinic_info clinic_info,
			String imgName) {
		try {
			if (clinic_info != null) {
				List<Clinic_record> clinic_record = clinic_info
						.getClinic_record();
				if (clinic_record != null && clinic_record.size() > 0) {
					for (Clinic_record clinic_record_item : clinic_record) {
						// 此字段作为图片名称,记录,直接和参数对比即可
						// 如果一致，直接返回，不继续遍历剩余
						String accident_status = clinic_record_item
								.getAccident_status();

						// 解决图片切割名称变化场景
						String nameWithoutSubfix = "";
						int nameWithoutSubfixIdx = imgName.lastIndexOf('.');
						if (nameWithoutSubfixIdx > 0) {
							nameWithoutSubfix = imgName.substring(0,
									nameWithoutSubfixIdx) + "$";
						}

						if (imgName.equals(accident_status) || accident_status
								.startsWith(nameWithoutSubfix)) {
							List<String> retList = new ArrayList<>();
							
							List<String> detailPre = imPageInfo.getDetail();
							if (detailPre!=null&&detailPre.size()>0) {
								retList.addAll(detailPre);
							}
							
							// 1>设置当前图片所有信息
							List<String> strings = MyCommonUtils
									.getModelStr(clinic_record_item);
							retList.addAll(strings);
							imPageInfo.setDetail(retList);
							// 2>设置详情
							List<String> purList = new ArrayList<>();
							if (imPageInfo.getPurDetail() != null) {
								purList.addAll(imPageInfo.getPurDetail());
							}
							purList.add(
									"******************摘要信息******************");
							purList.add(String.format("医院:%s",
									clinic_record_item.getHospital_code()));
							purList.add(String.format("票据号:%s",
									clinic_record_item.getClinic_no()));
							purList.add(String.format("姓名:%s",
									clinic_record_item.getName()));
							purList.add(String.format("开始日期:%s",
									clinic_record_item.getFirst_date()));
							purList.add(String.format("结束日期:%s",
									clinic_record_item.getEnd_date()));
							purList.add(
									String.format("金额总计:%s", clinic_record_item
											.getFee_info().getSum_amount()));

							purList.add(String.format("个人费用:%s",
									ServiceCommonUse.getFeeByFtype(
											clinic_record_item.getFee_info(),
											"1")));
							purList.add(String.format("统筹/公记费用:%s", ServiceCommonUse.getFeeByFtype(
									clinic_record_item.getFee_info(), "2")));

							// 明细清单
							if (clinic_record_item.getFee_info() != null
									&& clinic_record_item.getFee_info()
											.getFee_details() != null) {
								List<Fee_detail> fee_detail_List = clinic_record_item
										.getFee_info().getFee_details()
										.getFee_detail();
								if (fee_detail_List != null
										&& fee_detail_List.size() > 0) {
									purList.add("====费用明细====");
									for (Fee_detail fee_detail : fee_detail_List) {
										String curDetailName = fee_detail
												.getItem_name();
										String curDetailAmount = fee_detail
												.getItem_amount();
										String curDetailStr = String.format(
												"%s:%s", curDetailName,
												curDetailAmount);
										purList.add(curDetailStr);
									}
								}
							}
							purList.add("");
							purList.add("END!");
							imPageInfo.setPurDetail(purList);
						}
					}
				}
			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error,
					String.format("执行函数setClinicinfos发生异常:%s", e.getMessage()));
		}

	}

	public void setInpatientinfo(ImgPageInfo imPageInfo,
			Inpatient_info inpatient_info, String imgName) {
		try {

			if (inpatient_info != null) {
				List<Inpatient_record> inpatient_records = inpatient_info
						.getInpatient_record();
				if (inpatient_records != null && inpatient_records.size() > 0) {
					for (Inpatient_record inpatient_record : inpatient_records) {
						// 此字段作为图片名称,记录,直接和参数对比即可
						// 如果一致，直接返回，不继续遍历剩余
						String accident_status = inpatient_record
								.getAccident_status();

						// 解决图片切割名称变化场景
						String nameWithoutSubfix = "";
						int nameWithoutSubfixIdx = imgName.lastIndexOf('.');
						if (nameWithoutSubfixIdx > 0) {
							nameWithoutSubfix = imgName.substring(0,
									nameWithoutSubfixIdx) + "$";
						}

						if (imgName.equals(accident_status)
								|| imgName.startsWith(nameWithoutSubfix)) {
							List<String> retList = new ArrayList<>();
							// 1>设置当前图片所有信息
							List<String> strings = MyCommonUtils
									.getModelStr(inpatient_record);
							
							
							List<String> detailPre = imPageInfo.getDetail();
							if (detailPre!=null&&detailPre.size()>0) {
								retList.addAll(detailPre);
							}
							
							retList.addAll(strings);
							imPageInfo.setDetail(retList);

							// 2>设置详情
							List<String> purList = new ArrayList<>();

							if (imPageInfo.getPurDetail() != null) {
								purList.addAll(imPageInfo.getPurDetail());
							}

							purList.add(
									"******************摘要信息******************");
							purList.add(String.format("医院:%s",
									inpatient_record.getHospital_code()));
							purList.add(String.format("票据号:%s",
									inpatient_record.getOperation_no()));
							purList.add(String.format("姓名:%s", inpatient_record
									.getPatient_info().getName()));
							purList.add(String.format("开始日期:%s",
									inpatient_record.getIn_date()));
							purList.add(String.format("结束日期:%s",
									inpatient_record.getOut_date()));
							purList.add(String.format("金额:%s", inpatient_record
									.getFee_info().getSum_amount()));
							
							purList.add(String.format("个人费用:%s",
									ServiceCommonUse.getFeeByFtype(
											inpatient_record.getFee_info(),
											"1")));
							purList.add(String.format("统筹/公记费用:%s", ServiceCommonUse.getFeeByFtype(
									inpatient_record.getFee_info(), "2")));
							

							// 明细清单
							if (inpatient_record.getFee_info() != null
									&& inpatient_record.getFee_info()
											.getMedical_fee_info() != null) {
								Medical_fee_info medical_fee_info = inpatient_record
										.getFee_info().getMedical_fee_info();
								if (medical_fee_info != null) {
									purList.add("===========费用明细===========");

									List<String> resultList = MyCommonUtils
											.getModelStr(medical_fee_info);

									if (resultList != null
											&& resultList.size() > 0) {
										purList.addAll(resultList);
									}
								}
							}
							purList.add("");
							purList.add("END!");

							imPageInfo.setPurDetail(purList);
						}
					}
				}
			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error, String
					.format("执行函数setInpatientinfo发生异常:%s", e.getMessage()));
		}
	}

//	/**
//	 * 解析费用分类
//	 * 
//	 * @param feeInfo
//	 * @param fType
//	 *            1 个人费用 2公记/社保费用
//	 */
//	private BigDecimal getFeeByFtype(Fee_info feeInfo, String fType) {
//		BigDecimal fee = BigDecimal.ZERO;
//		try {
//			if ("1".equals(fType)) {
//				fee = MyCommonUtils.getBigDecimalVal(feeInfo.getCalc_amount());
//			} else if ("2".equals(fType)) {
//				if (feeInfo.getDeduct_sum() != null) {
//					BigDecimal fee1 = MyCommonUtils.getBigDecimalVal(
//							feeInfo.getDeduct_sum().getDeduct1());
//					BigDecimal fee2 = MyCommonUtils.getBigDecimalVal(
//							feeInfo.getDeduct_sum().getDeduct2());
//					BigDecimal fee3 = MyCommonUtils.getBigDecimalVal(
//							feeInfo.getDeduct_sum().getDeduct3());
//					fee = fee1.add(fee2).add(fee3);
//				}
//			}
//		} catch (Exception e) {
//			MyLogger.log(LoggerEnum.Error, e.getMessage());
//		}
//		return fee;
//	}
}
