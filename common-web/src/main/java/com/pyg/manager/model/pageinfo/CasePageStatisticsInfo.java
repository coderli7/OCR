package com.pyg.manager.model.pageinfo;

import java.math.BigDecimal;
import java.util.List;

import com.pyg.manager.model.AIOJsonModel.Medical_fee_info;

public class CasePageStatisticsInfo {
	
	private String name;
	
	private BigDecimal totalAmount;
	
	private BigDecimal personAmount;
	
	private BigDecimal socialAmount;
	
	public BigDecimal getPersonAmount() {
		return personAmount;
	}

	public void setPersonAmount(BigDecimal personAmount) {
		this.personAmount = personAmount;
	}

	public BigDecimal getSocialAmount() {
		return socialAmount;
	}

	public void setSocialAmount(BigDecimal socialAmount) {
		this.socialAmount = socialAmount;
	}

	private BigDecimal inspectionFee;
	
	private Integer imgCount;
	
	private Medical_fee_info medical_fee_info;
	
	private List<String> medicalFeeList; 
	
	public List<String> getMedicalFeeList() {
		return medicalFeeList;
	}

	public void setMedicalFeeList(List<String> medicalFeeList) {
		this.medicalFeeList = medicalFeeList;
	}

	public Medical_fee_info getMedical_fee_info() {
		return medical_fee_info;
	}

	public void setMedical_fee_info(Medical_fee_info medical_fee_info) {
		this.medical_fee_info = medical_fee_info;
	}

	public BigDecimal getInspectionFee() {
		return inspectionFee;
	}

	public void setInspectionFee(BigDecimal inspectionFee) {
		this.inspectionFee = inspectionFee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getImgCount() {
		return imgCount;
	}

	public void setImgCount(Integer imgCount) {
		this.imgCount = imgCount;
	}

}
