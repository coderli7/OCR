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
public class Deduct_sum {

	@MyAnnotation(name = "统筹支付费用")
	private String deduct2;

	@MyAnnotation(name = "其他扣除")
	private String deduct1;

	@MyAnnotation(name = "自费费用")
	private String deduct3;

	public void setDeduct2(String deduct2) {
		this.deduct2 = deduct2;
	}
	public String getDeduct2() {
		return deduct2;
	}

	public void setDeduct1(String deduct1) {
		this.deduct1 = deduct1;
	}
	public String getDeduct1() {
		return deduct1;
	}

	public void setDeduct3(String deduct3) {
		this.deduct3 = deduct3;
	}
	public String getDeduct3() {
		return deduct3;
	}

}