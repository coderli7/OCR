package com.pyg.manager.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyg.manager.commonutils.LoggerEnum;
import com.pyg.manager.commonutils.MyCommonUtils;
import com.pyg.manager.commonutils.MyHttpUtils;
import com.pyg.manager.commonutils.MyLogger;
import com.pyg.manager.commonutils.TokenService;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.model.BHClientUploadFileToAIOModel;
import com.pyg.manager.model.BaseAcResponse;
import com.pyg.manager.model.WebApiResponse.BaseResponse;

public class BHClientUploadFileToAIOService extends BaseService {

	@SuppressWarnings("unchecked")
	@Override
	public void Excute() {
		response = new BaseResponse();
		try {
			List<TbImage> curCaseImages = (List<TbImage>) request.Info;
			String token_req = TokenService.tokenKey;
			String companyId_req = TokenService.companyId;
			String key_req = TokenService.key;
			String caseId_req = curCaseImages.get(0).getCaseid();
			String caseInfo_req = "";
			String priorityNo_req = "0";
			long timeStamp_req = System.currentTimeMillis();
			String signature_before_cal = "token=" + token_req + "&"
					+ "companyId=" + companyId_req + "&" + "caseId="
					+ caseId_req + "&" + "caseInfo=" + caseInfo_req + "&"
					+ "priorityNo=" + priorityNo_req + "&" + "timeStamp="
					+ timeStamp_req + "&key=" + key_req;
			String signature_req = MyCommonUtils
					.getMD5Str(signature_before_cal);

			BHClientUploadFileToAIOModel aioModel = new BHClientUploadFileToAIOModel();
			aioModel.setToken(token_req);
			aioModel.setCompanyId(companyId_req);
			aioModel.setCaseId(caseId_req);
			aioModel.setCaseInfo(caseInfo_req);
			aioModel.setPriorityNo(priorityNo_req);
			aioModel.setTimeStamp(String.valueOf(timeStamp_req));

			// 添加图片信息
			ArrayList<String> imageList_req = new ArrayList<>();
			for (TbImage tbImage : curCaseImages) {
				imageList_req.add(tbImage.getImgname());
			}
			aioModel.setImages(imageList_req);
			aioModel.setSignature(signature_req);
			aioModel.setImgCallback(TokenService.ImgCallback);
			aioModel.setDatCallback(TokenService.DatCallback);
			String postData = JSON.toJSONString(aioModel);
			System.out.println("postData=" + postData);
			String url = String.format("%s%s", TokenService.url,
					"/AIOCaseUpload");
			// 此处配置开关,判断是否发送至安诚
			if (!"1".equals(TokenService.UnSendToAIO)) {
				System.out.println("发送信息至AIO");
				MyLogger.log(LoggerEnum.UploadController, String.format("准备发送至安诚:%s", postData));
				String postAioResult = MyHttpUtils.Post(url, postData);
				MyLogger.log(LoggerEnum.UploadController, String.format("发送至安诚结果:%s", postAioResult));
				if (!StringUtils.isEmpty(postAioResult)) {
					JSONObject jsonObject = JSON.parseObject(postAioResult);
					BaseAcResponse acResponse = JSON.toJavaObject(jsonObject,
							BaseAcResponse.class);
					response.Info=acResponse;
					if (acResponse != null && acResponse.code == 0) {
						System.out.println(
								"发送信息至AIO=" + JSON.toJSONString(acResponse));
					}
				}
			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.UploadController, String.format("执行函数BHClientUploadFileToAIOService发生异常:%s", e.getMessage()));
		}
	}

}
