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
public class Inpatient_info {

	@MyAnnotation(name="住院信息记录总计")
    private String record_counts;
	@MyAnnotation(name="住院信息记录明细")
    private List<Inpatient_record> inpatient_record;
    public void setRecord_counts(String record_counts) {
         this.record_counts = record_counts;
     }
     public String getRecord_counts() {
         return record_counts;
     }

    public void setInpatient_record(List<Inpatient_record> inpatient_record) {
         this.inpatient_record = inpatient_record;
     }
     public List<Inpatient_record> getInpatient_record() {
         return inpatient_record;
     }

}