package com.pyg.manager.model.pageinfo;

import java.util.List;

import com.pyg.manager.dao.pojo.TbImage;
import com.pyg.manager.dao.pojo.TbImageCaseInfo;

public class CasePageInfo {

	private TbImageCaseInfo imageCaseInfo;

	private List<TbImage> images;

	private List<String> briefInfo;
	
	private List<CasePageStatisticsInfo> casePageStatisticsInfos;
	
	public List<CasePageStatisticsInfo> getCasePageStatisticsInfos() {
		return casePageStatisticsInfos;
	}
	
	public void setCasePageStatisticsInfos(
			List<CasePageStatisticsInfo> casePageStatisticsInfos) {
		this.casePageStatisticsInfos = casePageStatisticsInfos;
	}

	public List<String> getBriefInfo() {
		return briefInfo;
	}

	public void setBriefInfo(List<String> briefInfo) {
		this.briefInfo = briefInfo;
	}

	public TbImageCaseInfo getImageCaseInfo() {
		return imageCaseInfo;
	}

	public void setImageCaseInfo(TbImageCaseInfo imageCaseInfo) {
		this.imageCaseInfo = imageCaseInfo;
	}

	public List<TbImage> getImages() {
		return images;
	}

	public void setImages(List<TbImage> images) {

		this.images = images;
	}

}
