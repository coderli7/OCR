package com.pyg.manager.model;

import java.util.ArrayList;

public class BHClientUploadFileToAIOModel {
	private String token;
	private String companyId;
	private String caseId;
	private String caseInfo;
	private String priorityNo;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getCaseInfo() {
		return caseInfo;
	}
	public void setCaseInfo(String caseInfo) {
		this.caseInfo = caseInfo;
	}
	public String getPriorityNo() {
		return priorityNo;
	}
	public void setPriorityNo(String priorityNo) {
		this.priorityNo = priorityNo;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getImgCallback() {
		return imgCallback;
	}
	public void setImgCallback(String imgCallback) {
		this.imgCallback = imgCallback;
	}
	public String getDatCallback() {
		return datCallback;
	}
	public void setDatCallback(String datCallback) {
		this.datCallback = datCallback;
	}
	private ArrayList<String> images;
	public ArrayList<String> getImages() {
		return images;
	}
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	private String timeStamp;
	private String signature;
	private String imgCallback;
	private String datCallback;

}
