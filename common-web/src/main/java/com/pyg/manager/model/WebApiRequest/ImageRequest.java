package com.pyg.manager.model.WebApiRequest;

public class ImageRequest extends BaseRequest {

	/// <summary>
	/// 赔案 ID
	/// </summary>
	public String caseId;

	/// <summary>
	/// 影像文件名称
	/// </summary>
	public String fileName;

	/// <summary>
	/// 时间戳
	/// </summary>
	public long timeStamp;

	/// <summary>
	/// 签名字符串
	/// </summary>
	public String signature;
}
