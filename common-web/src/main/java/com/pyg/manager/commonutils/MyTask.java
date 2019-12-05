package com.pyg.manager.commonutils;

import com.alibaba.fastjson.JSON;
import com.pyg.manager.dao.ImageCaseInfoService;
import com.pyg.manager.dao.ImageService;
import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;
import com.pyg.manager.model.BaseAcResponse;
import com.pyg.manager.model.WebApiRequest.BaseRequest;
import com.pyg.manager.service.BHClientGetAIOStatusService;
import com.pyg.manager.service.BHClientUploadFileToAIOService;
import com.pyg.manager.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyTask {

	@Autowired
	private ImageService imageService;

	@Autowired
	private ImageCaseInfoService imageCaseInfoService;
	
	/**
	 * 1.在每天的5点至23点之间，每隔10分钟执行一次
	 */
	@Scheduled(cron = "0 0/10 5-23 * * ? ")
	public void getToken() {
		try {
			// 维持Token
			MyLogger.log(LoggerEnum.TaskService, "开始获取Token");
			TokenService.getTokenKey();
			MyLogger.log(LoggerEnum.TaskService,
					String.format("最新Token:%s", TokenService.tokenKey));

		} catch (Exception e) {
			MyLogger.log(LoggerEnum.TaskService,
					String.format("获取Token异常:%s", e.getMessage()));
		}
	}

	/**
	 * 2.在每天的5点至23点之间，每隔5分钟检测一次，是否存在异常流向数据
	 * 
	 */
	@Scheduled(cron = "0 0/5 5-23 * * ? ")
	public void reSendFailedCase() {
		try {
			String startDate=MyDateUtils.getDateTimeNow("yyyy-MM-dd");
			String endDate=startDate;
			List<TbImageCaseInfo> caseInfos = imageCaseInfoService.findByDate("admin", startDate, endDate,"未完成");
			for (TbImageCaseInfo tbImageCaseInfo : caseInfos) {
				//1.查询当前案件对应安诚状态
				//2.如当前案件状态为未接受,再次发送即可
				String caseid = tbImageCaseInfo.getCaseid();
				BaseService service = new BHClientGetAIOStatusService();
				service.request = new BaseRequest();
				service.request.CaseId = caseid;
				service.Excute();
				if (service.response.Info != null) {
					BaseAcResponse acResponse = (BaseAcResponse) service.response.Info;
					if ("赔案不存在".equals(acResponse.message)) {
						BaseService reSendService = new BHClientUploadFileToAIOService();
						reSendService.request = new BaseRequest();
						List<TbImageCaseInfo> imageCaseInfos = imageCaseInfoService
								.findByCaseId(caseid);
						if (imageCaseInfos != null && imageCaseInfos.size() >= 0) {
							List<TbImage> curCaseImages = imageService.findByCaseId(caseid);
							int size = curCaseImages.size();
							if (size > 0) {
								reSendService.request.Info = curCaseImages;
								reSendService.Excute();
							}
						}
						BaseAcResponse reSendacResponse=null;
						if (reSendService.response != null) {
							reSendacResponse= (BaseAcResponse) reSendService.response.Info;
							MyLogger.log(LoggerEnum.TaskService,
									String.format("案件%s重新发送成功:%s",caseid,JSON.toJSONString(reSendacResponse)));
						} else {
							MyLogger.log(LoggerEnum.TaskService,
									String.format("案件%s重新发送失败:%s",caseid,JSON.toJSONString(reSendacResponse)));
						}
					}
				}
			}
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.TokenService,
					String.format("执行reSendFailedCase异常:%s", e.getMessage()));
		}
	}

}
