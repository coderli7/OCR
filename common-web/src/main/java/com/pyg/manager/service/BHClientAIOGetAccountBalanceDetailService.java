package com.pyg.manager.service;

import com.pyg.manager.commonutils.MyDateUtils;
import com.pyg.manager.commonutils.MyHttpUtils;
import com.pyg.manager.commonutils.TokenService;
import com.pyg.manager.model.WebApiResponse.BaseResponse;

public class BHClientAIOGetAccountBalanceDetailService extends BaseService {

	@Override
	public void Excute() {
		response = new BaseResponse();
		try {
			String startDate = MyDateUtils.getDateTimeNow("yyyyMMdd");
			String enDate = MyDateUtils.getDateTimeNow("yyyyMMdd");
			String getAccountBalanceDetailParams = String.format(
					"?token=%s&companyId=%s&beginTime=%s&endTime=%s",
					TokenService.tokenKey, TokenService.companyId, startDate,
					enDate);
			String getAccountBalanceUrl = String.format("%s%s%s",
					TokenService.url, "/AIOGetAccountDetail",
					getAccountBalanceDetailParams);
			String getAccountBalanceDetailResult = MyHttpUtils
					.Get(getAccountBalanceUrl);

			if (getAccountBalanceDetailResult != null
					&& getAccountBalanceDetailResult != "") {
				// BaseAcResponse baseAcResponse = JSON.toJavaObject(
				// JSONObject.parseObject(getAccountBalanceDetailResult),
				// BaseAcResponse.class);
				response.Info = getAccountBalanceDetailResult;
			}
			response.ErrCode = 0;
			response.ErrMsg = "查询完成!";
		} catch (Exception e) {
			response.ErrCode = -10000;
			response.ErrMsg = String.format(
					"BHClientAIOGetAccountBalanceDetailService执行异常%s",
					e.getMessage());
		}
	}

}
