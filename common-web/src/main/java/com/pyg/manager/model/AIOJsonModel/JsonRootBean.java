/**
  * Copyright 2019 bejson.com 
  */
package com.pyg.manager.model.AIOJsonModel;

/**
 * Auto-generated: 2019-11-07 14:8:9
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String caseId;
    private int code;
    private String message;
    private ResultData resultData;
    private String signature;
    private long timeStamp;
    public void setCaseId(String caseId) {
         this.caseId = caseId;
     }
     public String getCaseId() {
         return caseId;
     }

    public void setCode(int code) {
         this.code = code;
     }
     public int getCode() {
         return code;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setResultData(ResultData resultData) {
         this.resultData = resultData;
     }
     public ResultData getResultData() {
         return resultData;
     }

    public void setSignature(String signature) {
         this.signature = signature;
     }
     public String getSignature() {
         return signature;
     }

    public void setTimeStamp(long timeStamp) {
         this.timeStamp = timeStamp;
     }
     public long getTimeStamp() {
         return timeStamp;
     }

}