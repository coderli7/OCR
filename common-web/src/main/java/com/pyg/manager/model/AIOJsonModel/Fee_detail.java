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
public class Fee_detail {

	@MyAnnotation(name = "项目单价")
	private String item_price;

	@MyAnnotation(name = "扣除比例")
	private String self_pay_part;

	@MyAnnotation(name = "商品名")
	private String item_tradename;

	@MyAnnotation(name = "项目名称")
	private String item_name;

	@MyAnnotation(name = "自费金额")
	private String self_pay_money;

	@MyAnnotation(name = "")
	private String note1;

	@MyAnnotation(name = "门诊费用清单编号")
	private String seq;

	@MyAnnotation(name = "")
	private String note2;

	@MyAnnotation(name = "项目金额")
	private String item_amount;

	@MyAnnotation(name = "医保等级")
	private String medical_class;

	@MyAnnotation(name = "")
	private String flag_on_image;

	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}
	public String getItem_price() {
		return item_price;
	}

	public void setSelf_pay_part(String self_pay_part) {
		this.self_pay_part = self_pay_part;
	}
	public String getSelf_pay_part() {
		return self_pay_part;
	}

	public void setItem_tradename(String item_tradename) {
		this.item_tradename = item_tradename;
	}
	public String getItem_tradename() {
		return item_tradename;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_name() {
		return item_name;
	}

	public void setSelf_pay_money(String self_pay_money) {
		this.self_pay_money = self_pay_money;
	}
	public String getSelf_pay_money() {
		return self_pay_money;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}
	public String getNote1() {
		return note1;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getSeq() {
		return seq;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}
	public String getNote2() {
		return note2;
	}

	public void setItem_amount(String item_amount) {
		this.item_amount = item_amount;
	}
	public String getItem_amount() {
		return item_amount;
	}

	public void setMedical_class(String medical_class) {
		this.medical_class = medical_class;
	}
	public String getMedical_class() {
		return medical_class;
	}

	public void setFlag_on_image(String flag_on_image) {
		this.flag_on_image = flag_on_image;
	}
	public String getFlag_on_image() {
		return flag_on_image;
	}

}