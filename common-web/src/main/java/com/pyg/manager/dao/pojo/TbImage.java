package com.pyg.manager.dao.pojo;

public class TbImage {
    private Integer id;

    private String caseid;

    private String imgname;

    private String imgpath;

    private String delstatus;

    private String imagedate;

    private String info1;

    private String info2;

    private String info3;

    private String info4;

    private String tips;

    private String imgresultmodelclass;

    private String imgresultdate;

    private String imgresult;

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

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getDelstatus() {
        return delstatus;
    }

    public void setDelstatus(String delstatus) {
        this.delstatus = delstatus == null ? null : delstatus.trim();
    }

    public String getImagedate() {
        return imagedate;
    }

    public void setImagedate(String imagedate) {
        this.imagedate = imagedate == null ? null : imagedate.trim();
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

    public String getImgresultmodelclass() {
        return imgresultmodelclass;
    }

    public void setImgresultmodelclass(String imgresultmodelclass) {
        this.imgresultmodelclass = imgresultmodelclass == null ? null : imgresultmodelclass.trim();
    }

    public String getImgresultdate() {
        return imgresultdate;
    }

    public void setImgresultdate(String imgresultdate) {
        this.imgresultdate = imgresultdate == null ? null : imgresultdate.trim();
    }

    public String getImgresult() {
        return imgresult;
    }

    public void setImgresult(String imgresult) {
        this.imgresult = imgresult == null ? null : imgresult.trim();
    }
}