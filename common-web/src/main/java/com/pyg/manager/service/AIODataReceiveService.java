package com.pyg.manager.service;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.pyg.manager.commonutils.LoggerEnum;
import com.pyg.manager.commonutils.MyDateUtils;
import com.pyg.manager.commonutils.MyLogger;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.model.BaseAcResponse;
import com.pyg.manager.model.DataReceiveACRequest;
import com.pyg.manager.model.AIOJsonModel.Clinic_info;
import com.pyg.manager.model.AIOJsonModel.Clinic_record;
import com.pyg.manager.model.AIOJsonModel.Inpatient_info;
import com.pyg.manager.model.AIOJsonModel.Inpatient_record;
import com.pyg.manager.model.AIOJsonModel.JsonRootBean;
import com.pyg.manager.model.AIOJsonModel.ResultData;
import com.pyg.manager.model.WebApiResponse.BaseResponse;

public class AIODataReceiveService extends BaseService {

	@Override
	public void Excute() {
		BaseAcResponse baseAcResponse = new BaseAcResponse();
		try {

			response = new BaseResponse();
			DataReceiveACRequest dataReceiveACRequest = (DataReceiveACRequest) request.Info;
			String caseId = dataReceiveACRequest.caseId;
			String result = JSON.toJSONString(dataReceiveACRequest);
			String curTime = MyDateUtils.getDateTimeNow(null);

			// 1.结果存储
			// saveImageResult(caseId, result, curTime);

			// 2.案件表头状态更新
			updateCaseInfo(caseId, result, curTime);

			// 3.单独更新行信息
			updateImageInfo(result, curTime);

			response.ErrCode = 0;
			response.ErrMsg = "处理完成!";
			baseAcResponse.code = 0;
			baseAcResponse.message = "接收成功";
			response.Info = baseAcResponse;

		} catch (Exception e) {
			response.ErrCode = -100000;
			response.ErrMsg = String.format("AIODataReceiveService执行异常:%s",
					e.getMessage());
			baseAcResponse.code = -10000;
			baseAcResponse.message = "接收失败";
		}
	}

	/**
	 * 保存解析结果 image_result表,弃用函数
	 * 
	 * @param caseId
	 * @param result
	 * @param curTime
	 */
	@SuppressWarnings("unused")
	private void saveImageResult(String caseId, String result, String curTime) {
		try {
			// List<TbImageResult> imageResults = imageResultService
			// .findByCaseId(caseId);
			// if (imageResults != null && imageResults.size() > 0) {
			// // 更新
			// TbImageResult existImageResult = imageResults.get(0);
			// existImageResult.setResult(result);
			// existImageResult.setResultdate(curTime);
			// imageResultService.update(existImageResult);
			//
			// } else {
			// // 新增
			// TbImageResult addImageResult = new TbImageResult();
			// addImageResult.setCaseid(caseId);
			// addImageResult.setResult(result);
			// addImageResult.setResultdate(curTime);
			// imageResultService.add(addImageResult);
			// }

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * 2.案件表头状态更新
	 * 
	 * @param caseId
	 */
	private void updateCaseInfo(String caseId, String result, String curTime) {
		try {
			List<TbImageCaseInfo> imageCaseInfos = imageCaseInfoService
					.findByCaseId(caseId);
			if (imageCaseInfos != null && imageCaseInfos.size() > 0) {
				TbImageCaseInfo imageCaseInfo = imageCaseInfos.get(0);
				imageCaseInfo.setCasestatus("完成");
				imageCaseInfo.setResult(result);
				imageCaseInfo.setResultdate(curTime);
				imageCaseInfoService.update(imageCaseInfo);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * 3.单独更新行信息
	 * 
	 * @param result
	 */
	private void updateImageInfo(String result, String curTime) {
		try {
			JsonRootBean rootBean = JSON.toJavaObject(JSON.parseObject(result),
					JsonRootBean.class);
			if (rootBean != null) {
				String caseId = rootBean.getCaseId();
				ResultData resultData = rootBean.getResultData();
				// 3.1获取当前案件对应所有信息
				List<TbImage> images = imageService.findByCaseId(caseId);
				for (TbImage tbImage : images) {
					tbImage.setImgresultdate(curTime);
					Clinic_info clinic_infos = resultData.getClinic_info();
					Inpatient_info inpatient_info = resultData
							.getInpatient_info();
					getClinicinfos(tbImage, clinic_infos);
					getInpatientinfo(tbImage, inpatient_info);
					imageService.update(tbImage);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void getClinicinfos(TbImage tbImage, Clinic_info clinic_infos) {
		try {

			String imgName = tbImage.getImgname();
			if (clinic_infos != null) {
				List<Clinic_record> clinic_record = clinic_infos
						.getClinic_record();
				if (clinic_record != null && clinic_record.size() > 0) {
					for (Clinic_record clinic_record_item : clinic_record) {
						// 此字段作为图片名称,记录,直接和参数对比即可
						// 如果一致，直接返回，不继续遍历剩余
						String accident_status = clinic_record_item
								.getAccident_status();
						if (imgName.equals(accident_status)) {
							// 后续页面查询客户端使用
							String curItemResult = JSON
									.toJSONString(clinic_record_item);
							String curItemClassName = clinic_record_item
									.getClass().toString()
									.replace("class ", "");
							tbImage.setImgresult(curItemResult);
							tbImage.setImgresultmodelclass(curItemClassName);

							// 直接把简要信息填入info1字段
							List<String> purList = new ArrayList<>();
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
									String.format("金额:%s", clinic_record_item
											.getFee_info().getSum_amount()));
							tbImage.setInfo1(JSON.toJSONString(purList));
						}
					}
				}
			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.Error,
					String.format("执行函数getClinicinfos发生异常:%s", e.getMessage()));
		}
	}

	private void getInpatientinfo(TbImage tbImage,
			Inpatient_info inpatient_info) {
		try {

			String imgName = tbImage.getImgname();
			if (inpatient_info != null) {
				List<Inpatient_record> clinic_record = inpatient_info
						.getInpatient_record();
				if (clinic_record != null && clinic_record.size() > 0) {
					for (Inpatient_record inpatient_record : clinic_record) {
						// 此字段作为图片名称,记录,直接和参数对比即可
						// 如果一致，直接返回，不继续遍历剩余
						String accident_status = inpatient_record
								.getAccident_status();
						if (imgName.equals(accident_status)) {
							// 后续页面查询客户端使用
							String curItemResult = JSON
									.toJSONString(inpatient_record);
							String curItemClassName = inpatient_record
									.getClass().toString()
									.replace("class ", "");
							tbImage.setImgresult(curItemResult);
							tbImage.setImgresultmodelclass(curItemClassName);

							// 直接把简要信息填入info1字段
							List<String> purList = new ArrayList<>();
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
							tbImage.setInfo1(JSON.toJSONString(purList));
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
