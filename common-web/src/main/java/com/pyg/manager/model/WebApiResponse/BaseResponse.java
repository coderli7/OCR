package com.pyg.manager.model.WebApiResponse;

public class BaseResponse {

	/// <summary>
	/// 错误码
	/// </summary>
	public int ErrCode;

	/// <summary>
	/// 错误描述
	/// </summary>
	public String ErrMsg;

	/// <summary>
	/// 请求唯一标识
	/// </summary>
	public String RequestKey;

	/// <summary>
	/// 相关信息
	/// </summary>
	public Object Info;

}
