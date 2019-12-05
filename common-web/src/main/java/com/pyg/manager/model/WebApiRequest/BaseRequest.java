package com.pyg.manager.model.WebApiRequest;

public class BaseRequest {

	/// <summary>
	/// 案件ID每个窗口使用一个案件ID
	/// </summary>
	public String CaseId;

	/// <summary>
	/// 超时时间,秒
	/// </summary>
	public int OutTime;

	/// <summary>
	/// 请求唯一标识
	/// </summary>
	public String RequestKey;

	/// <summary>
	/// 同步信息字段
	/// </summary>
	public Object Info;

	/// <summary>
	/// 登录信息以及初始化参数
	/// </summary>
	public LoginParamModel LoginParam;

}
