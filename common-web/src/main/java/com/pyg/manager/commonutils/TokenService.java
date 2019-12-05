package com.pyg.manager.commonutils;

import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pyg.manager.model.TokenACResponse;

public class TokenService {

	public static String tokenKey;
	public static String companyId;
	public static String key;
	public static String url;
	public static String ImgCallback;
	public static String DatCallback;
	public static String UnSendToAIO;

	static {
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
			companyId = resourceBundle.getString("companyId");
			key = resourceBundle.getString("key");
			url = resourceBundle.getString("url");
			ImgCallback = resourceBundle.getString("ImgCallback");
			DatCallback = resourceBundle.getString("DatCallback");
			UnSendToAIO = resourceBundle.getString("UnSendToAIO");

			// 维持Token
			TokenService.getTokenKey();
			MyLogger.log(LoggerEnum.TokenService,
					String.format("最新Token:%s", TokenService.tokenKey));
		} catch (Exception e) {
			MyLogger.log(LoggerEnum.TokenService,
					String.format("初始化Token异常:%s", e.getMessage()));
			e.printStackTrace();
		}
	}

	public synchronized static void getTokenKey() {
		try {
			long timeStamp = System.currentTimeMillis();
			String requestDataPre = String.format(
					"companyid=%s&timestamp=%s&key=%s", companyId, timeStamp,
					key);
			String urlParams = String.format(
					"companyid=%s&timestamp=%s&signature=%s", companyId,
					timeStamp, MyCommonUtils.getMD5Str(requestDataPre));
			String getTokenUrl = String.format("%s/AIOLogin?%s", url,
					urlParams);
			String tokenResult = MyHttpUtils.Get(getTokenUrl);
			if (!StringUtils.isEmpty(tokenResult)) {
				JSONObject jsonObject = JSON.parseObject(tokenResult);
				TokenACResponse acResponse = JSON.toJavaObject(jsonObject,
						TokenACResponse.class);
				if (acResponse != null && acResponse.code == 0) {
					tokenKey = acResponse.data;
				}
			}
		} catch (Exception e) {
		}
	}
}
