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
public class Fee_info {

	@MyAnnotation(name="门诊费用清单")
    private Fee_details fee_details;
	
	@MyAnnotation(name="社保费用信息")
    private Deduct_sum deduct_sum;
	
    private String calc_amount;
    
    private String Note;
    
	@MyAnnotation(name="合计费用")
    private String sum_amount;
    
	@MyAnnotation(name="医疗费用信息")
    private Medical_fee_info medical_fee_info;
	
    public void setFee_details(Fee_details fee_details) {
         this.fee_details = fee_details;
     }
     public Fee_details getFee_details() {
         return fee_details;
     }

    public void setDeduct_sum(Deduct_sum deduct_sum) {
         this.deduct_sum = deduct_sum;
     }
     public Deduct_sum getDeduct_sum() {
         return deduct_sum;
     }

    public void setCalc_amount(String calc_amount) {
         this.calc_amount = calc_amount;
     }
     public String getCalc_amount() {
         return calc_amount;
     }

    public void setNote(String Note) {
         this.Note = Note;
     }
     public String getNote() {
         return Note;
     }

    public void setSum_amount(String sum_amount) {
         this.sum_amount = sum_amount;
     }
     public String getSum_amount() {
         return sum_amount;
     }

    public void setMedical_fee_info(Medical_fee_info medical_fee_info) {
         this.medical_fee_info = medical_fee_info;
     }
     public Medical_fee_info getMedical_fee_info() {
         return medical_fee_info;
     }

}