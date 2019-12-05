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
public class Inpatient_record {

	@MyAnnotation(name="手术信息")
    private Surgery_info surgery_info;
	
	@MyAnnotation(name="住院人信息")
    private Patient_info patient_info;
	
	
    private String accident_status;
    
    @MyAnnotation(name="住院号")
    private String hospital_code;
    
    private String accident_id;
    
    @MyAnnotation(name="出院日期")
    private String out_date;
    
    @MyAnnotation(name="住院信息发票号")
    private String seq;
    
    @MyAnnotation(name="费用信息")
    private Fee_info fee_info;
    
    @MyAnnotation(name="住院日期")
    private String in_date;
    
    @MyAnnotation(name="科别")
    private String operation_type;
    
    private String hospital_num;
    
    private String accident_type;
    
    @MyAnnotation(name="住院号")
    private String operation_no;
    public void setSurgery_info(Surgery_info surgery_info) {
         this.surgery_info = surgery_info;
     }
     public Surgery_info getSurgery_info() {
         return surgery_info;
     }

    public void setPatient_info(Patient_info patient_info) {
         this.patient_info = patient_info;
     }
     public Patient_info getPatient_info() {
         return patient_info;
     }

    public void setAccident_status(String accident_status) {
         this.accident_status = accident_status;
     }
     public String getAccident_status() {
         return accident_status;
     }

    public void setHospital_code(String hospital_code) {
         this.hospital_code = hospital_code;
     }
     public String getHospital_code() {
         return hospital_code;
     }

    public void setAccident_id(String accident_id) {
         this.accident_id = accident_id;
     }
     public String getAccident_id() {
         return accident_id;
     }

    public void setOut_date(String out_date) {
         this.out_date = out_date;
     }
     public String getOut_date() {
         return out_date;
     }

    public void setSeq(String seq) {
         this.seq = seq;
     }
     public String getSeq() {
         return seq;
     }

    public void setFee_info(Fee_info fee_info) {
         this.fee_info = fee_info;
     }
     public Fee_info getFee_info() {
         return fee_info;
     }

    public void setIn_date(String in_date) {
         this.in_date = in_date;
     }
     public String getIn_date() {
         return in_date;
     }

    public void setOperation_type(String operation_type) {
         this.operation_type = operation_type;
     }
     public String getOperation_type() {
         return operation_type;
     }

    public void setHospital_num(String hospital_num) {
         this.hospital_num = hospital_num;
     }
     public String getHospital_num() {
         return hospital_num;
     }

    public void setAccident_type(String accident_type) {
         this.accident_type = accident_type;
     }
     public String getAccident_type() {
         return accident_type;
     }

    public void setOperation_no(String operation_no) {
         this.operation_no = operation_no;
     }
     public String getOperation_no() {
         return operation_no;
     }

}