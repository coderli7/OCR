package com.pyg.manager.model;

public class ServerStatusModel extends BaseAcResponse  {

	 /// <summary>
    /// 登陆标记
    /// </summary>
    public String Token ;

    /// <summary>
    /// 返回系统登陆地址
    /// </summary>
    public String LoginUrl ;

    /// <summary>
    /// 是否通过WinForm窗口上传（前期测试使用,后期如与核心对接，移除掉即可）
    /// </summary>
    public boolean ImportByForm ;
}
