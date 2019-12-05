/**
  * Copyright 2019 bejson.com 
  */
package com.pyg.manager.model.AIOJsonModel;

import com.pyg.manager.commonutils.MyAnnotation;

/**
 * Auto-generated: 2019-11-07 14:8:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Surgery_record {

	@MyAnnotation(name = "手术信息编号")
	private String seq;

	@MyAnnotation(name = "手术日期")
	private String surgery_code;

	@MyAnnotation(name = "手术代码")
	private String surgery_date;

	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeq() {
		return seq;
	}

	public void setSurgery_code(String surgery_code) {
		this.surgery_code = surgery_code;
	}
	public String getSurgery_code() {
		return surgery_code;
	}

	public void setSurgery_date(String surgery_date) {
		this.surgery_date = surgery_date;
	}
	public String getSurgery_date() {
		return surgery_date;
	}

}