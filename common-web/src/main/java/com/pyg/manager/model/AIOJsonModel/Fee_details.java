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
public class Fee_details {

	@MyAnnotation(name="门诊费用清单明细")
    private List<Fee_detail> fee_detail;
    
    @MyAnnotation(name="门诊费用清单统计")
    private String fee_count;
    
    public void setFee_detail(List<Fee_detail> fee_detail) {
         this.fee_detail = fee_detail;
     }
     public List<Fee_detail> getFee_detail() {
         return fee_detail;
     }

    public void setFee_count(String fee_count) {
         this.fee_count = fee_count;
     }
     public String getFee_count() {
         return fee_count;
     }

}