/**
  * Copyright 2019 bejson.com 
  */
package com.pyg.manager.model.AIOJsonModel;
import java.util.List;

import com.pyg.manager.commonutils.MyAnnotation;

/**
 * Auto-generated: 2019-11-07 14:8:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Clinic_info {

	@MyAnnotation(name = "门诊记录数")
	private String record_counts;
	@MyAnnotation(name = "门诊记录明细")
	private List<Clinic_record> clinic_record;
	public void setRecord_counts(String record_counts) {
		this.record_counts = record_counts;
	}
	public String getRecord_counts() {
		return record_counts;
	}

	public void setClinic_record(List<Clinic_record> clinic_record) {
		this.clinic_record = clinic_record;
	}
	public List<Clinic_record> getClinic_record() {
		return clinic_record;
	}

}