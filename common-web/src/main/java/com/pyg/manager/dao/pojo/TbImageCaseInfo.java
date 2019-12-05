package com.pyg.manager.dao.pojo;

public class TbImageCaseInfo {
    private Integer id;

    private String caseid;

    private String casestatus;

    private String casedate;

    private String usercode;

    private String info1;

    private String info2;

    private String info3;

    private String info4;

    private String tips;

    private String resultdate;

    private String result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    public String getCasestatus() {
        return casestatus;
    }

    public void setCasestatus(String casestatus) {
        this.casestatus = casestatus == null ? null : casestatus.trim();
    }

    public String getCasedate() {
        return casedate;
    }

    public void setCasedate(String casedate) {
        this.casedate = casedate == null ? null : casedate.trim();
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1 == null ? null : info1.trim();
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2 == null ? null : info2.trim();
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3 == null ? null : info3.trim();
    }

    public String getInfo4() {
        return info4;
    }

    public void setInfo4(String info4) {
        this.info4 = info4 == null ? null : info4.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public String getResultdate() {
        return resultdate;
    }

    public void setResultdate(String resultdate) {
        this.resultdate = resultdate == null ? null : resultdate.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}