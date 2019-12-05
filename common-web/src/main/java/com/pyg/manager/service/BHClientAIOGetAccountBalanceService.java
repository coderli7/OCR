package com.pyg.manager.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyg.manager.commonutils.MyHttpUtils;
import com.pyg.manager.commonutils.TokenService;
import com.pyg.manager.model.BaseAcResponse;
import com.pyg.manager.model.WebApiResponse.BaseResponse;

public class BHClientAIOGetAccountBalanceService extends BaseService {

	@Override
	public void Excute() {
		response = new BaseResponse();
		try {
			String requParams = String.format("?token=%s&companyId=%s",
					TokenService.tokenKey, TokenService.companyId);
			String getAccountBalanceUrl = String.format("%s%s%s",
					TokenService.url, "/AIOGetAccountBalance", requParams);
			String getAccountBalanceResult = MyHttpUtils
					.Get(getAccountBalanceUrl);
			if (getAccountBalanceResult != null && getAccountBalanceUrl != "") {
				BaseAcResponse baseAcResponse = JSON.toJavaObject(
						JSONObject.parseObject(getAccountBalanceResult),
						BaseAcResponse.class);
				response.Info = baseAcResponse;
			}
			response.ErrCode = 0;
			response.ErrMsg = "查询完成!";
		} catch (Exception e) {
			response.ErrCode = -10000;
			response.ErrMsg = String.format(
					"BHClientAIOGetAccountBalanceService执行异常%s",
					e.getMessage());
		}
	}

}
