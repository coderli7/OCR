package com.pyg.manager.model.WebApiRequest;

public class DataReceiveRequest extends BaseRequest {

	/// <summary>
	/// 赔案 ID
	/// </summary>
	public String caseId;
	/// <summary>
	/// 0 表示处理成功，非零表示失败
	/// </summary>
	public int code;
	/// <summary>
	/// 处理失败时的错误消息
	/// </summary>
	public String message;
	/// <summary>
	/// 结果数据
	/// </summary>
	public Object resultData;
	public long timeStamp;
	public String signature;

}
