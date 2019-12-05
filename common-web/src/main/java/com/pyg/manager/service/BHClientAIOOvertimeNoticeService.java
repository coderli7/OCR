package com.pyg.manager.service;

import com.pyg.manager.model.WebApiResponse.BaseResponse;

public class BHClientAIOOvertimeNoticeService extends BaseService {

	@Override
	public void Excute() {
		response=new BaseResponse();
		try {

			// 加班操作，暂不处理
			// response = new BaseResponse();
			// string postData = string.Format("{\"token\":
			// \"{0}\",\"companyId\":\"{1}\",\"days\":[{2}]}",
			// TokenService.Token, Configure.Instance.companyId, request.Info ==
			// null ? "" : request.Info.ToString());
			// string requData = string.Format("?token={0}&companyId={1}",
			// TokenService.Token, Configure.Instance.companyId);
			// string reqUrl = String.Format("{0}{1}", Configure.Instance.url,
			// Configure.Instance.AIOOvertimeNotice, requData);
			// var res = HttpClientHelperCommon.Post(reqUrl, postData, 30);
			// response.Info = res;
			// response.ErrCode = 0;
			// response.ErrMsg = "处理完成";
			
		} catch (Exception e) {
			response.ErrCode=-10000;
			response.ErrMsg=String.format("BHClientAIOOvertimeNoticeService执行异常%s", e.getMessage());
		}		
	}
}
