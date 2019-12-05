package com.pyg.manager.model.pageinfo;

import java.util.List;

/**
 * 页面上单个文件明细
 * 
 * @author Administrator
 *
 */
public class ImgPageInfo {

	private String imgSrc;

	private List<String> detail;
	
	private List<String> purDetail;

	public List<String> getPurDetail() {
		return purDetail;
	}

	public void setPurDetail(List<String> purDetail) {
		this.purDetail = purDetail;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public List<String> getDetail() {
		return detail;
	}

	public void setDetail(List<String> detail) {
		this.detail = detail;
	}
	

}
