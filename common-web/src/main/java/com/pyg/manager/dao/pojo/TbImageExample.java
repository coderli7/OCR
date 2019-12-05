package com.pyg.manager.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbImageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNull() {
            addCriterion("caseId is null");
            return (Criteria) this;
        }

        public Criteria andCaseidIsNotNull() {
            addCriterion("caseId is not null");
            return (Criteria) this;
        }

        public Criteria andCaseidEqualTo(String value) {
            addCriterion("caseId =", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotEqualTo(String value) {
            addCriterion("caseId <>", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThan(String value) {
            addCriterion("caseId >", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidGreaterThanOrEqualTo(String value) {
            addCriterion("caseId >=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThan(String value) {
            addCriterion("caseId <", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLessThanOrEqualTo(String value) {
            addCriterion("caseId <=", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidLike(String value) {
            addCriterion("caseId like", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotLike(String value) {
            addCriterion("caseId not like", value, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidIn(List<String> values) {
            addCriterion("caseId in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotIn(List<String> values) {
            addCriterion("caseId not in", values, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidBetween(String value1, String value2) {
            addCriterion("caseId between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andCaseidNotBetween(String value1, String value2) {
            addCriterion("caseId not between", value1, value2, "caseid");
            return (Criteria) this;
        }

        public Criteria andImgnameIsNull() {
            addCriterion("imgName is null");
            return (Criteria) this;
        }

        public Criteria andImgnameIsNotNull() {
            addCriterion("imgName is not null");
            return (Criteria) this;
        }

        public Criteria andImgnameEqualTo(String value) {
            addCriterion("imgName =", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotEqualTo(String value) {
            addCriterion("imgName <>", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameGreaterThan(String value) {
            addCriterion("imgName >", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameGreaterThanOrEqualTo(String value) {
            addCriterion("imgName >=", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameLessThan(String value) {
            addCriterion("imgName <", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameLessThanOrEqualTo(String value) {
            addCriterion("imgName <=", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameLike(String value) {
            addCriterion("imgName like", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotLike(String value) {
            addCriterion("imgName not like", value, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameIn(List<String> values) {
            addCriterion("imgName in", values, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotIn(List<String> values) {
            addCriterion("imgName not in", values, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameBetween(String value1, String value2) {
            addCriterion("imgName between", value1, value2, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgnameNotBetween(String value1, String value2) {
            addCriterion("imgName not between", value1, value2, "imgname");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgPath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgPath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgPath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgPath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgPath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgPath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgPath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgPath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgPath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgPath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgPath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgPath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgPath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgPath not between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andDelstatusIsNull() {
            addCriterion("delStatus is null");
            return (Criteria) this;
        }

        public Criteria andDelstatusIsNotNull() {
            addCriterion("delStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDelstatusEqualTo(String value) {
            addCriterion("delStatus =", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusNotEqualTo(String value) {
            addCriterion("delStatus <>", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusGreaterThan(String value) {
            addCriterion("delStatus >", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusGreaterThanOrEqualTo(String value) {
            addCriterion("delStatus >=", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusLessThan(String value) {
            addCriterion("delStatus <", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusLessThanOrEqualTo(String value) {
            addCriterion("delStatus <=", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusLike(String value) {
            addCriterion("delStatus like", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusNotLike(String value) {
            addCriterion("delStatus not like", value, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusIn(List<String> values) {
            addCriterion("delStatus in", values, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusNotIn(List<String> values) {
            addCriterion("delStatus not in", values, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusBetween(String value1, String value2) {
            addCriterion("delStatus between", value1, value2, "delstatus");
            return (Criteria) this;
        }

        public Criteria andDelstatusNotBetween(String value1, String value2) {
            addCriterion("delStatus not between", value1, value2, "delstatus");
            return (Criteria) this;
        }

        public Criteria andImagedateIsNull() {
            addCriterion("imageDate is null");
            return (Criteria) this;
        }

        public Criteria andImagedateIsNotNull() {
            addCriterion("imageDate is not null");
            return (Criteria) this;
        }

        public Criteria andImagedateEqualTo(String value) {
            addCriterion("imageDate =", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateNotEqualTo(String value) {
            addCriterion("imageDate <>", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateGreaterThan(String value) {
            addCriterion("imageDate >", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateGreaterThanOrEqualTo(String value) {
            addCriterion("imageDate >=", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateLessThan(String value) {
            addCriterion("imageDate <", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateLessThanOrEqualTo(String value) {
            addCriterion("imageDate <=", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateLike(String value) {
            addCriterion("imageDate like", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateNotLike(String value) {
            addCriterion("imageDate not like", value, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateIn(List<String> values) {
            addCriterion("imageDate in", values, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateNotIn(List<String> values) {
            addCriterion("imageDate not in", values, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateBetween(String value1, String value2) {
            addCriterion("imageDate between", value1, value2, "imagedate");
            return (Criteria) this;
        }

        public Criteria andImagedateNotBetween(String value1, String value2) {
            addCriterion("imageDate not between", value1, value2, "imagedate");
            return (Criteria) this;
        }

        public Criteria andInfo1IsNull() {
            addCriterion("info1 is null");
            return (Criteria) this;
        }

        public Criteria andInfo1IsNotNull() {
            addCriterion("info1 is not null");
            return (Criteria) this;
        }

        public Criteria andInfo1EqualTo(String value) {
            addCriterion("info1 =", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotEqualTo(String value) {
            addCriterion("info1 <>", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1GreaterThan(String value) {
            addCriterion("info1 >", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1GreaterThanOrEqualTo(String value) {
            addCriterion("info1 >=", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1LessThan(String value) {
            addCriterion("info1 <", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1LessThanOrEqualTo(String value) {
            addCriterion("info1 <=", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1Like(String value) {
            addCriterion("info1 like", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotLike(String value) {
            addCriterion("info1 not like", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1In(List<String> values) {
            addCriterion("info1 in", values, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotIn(List<String> values) {
            addCriterion("info1 not in", values, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1Between(String value1, String value2) {
            addCriterion("info1 between", value1, value2, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotBetween(String value1, String value2) {
            addCriterion("info1 not between", value1, value2, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo2IsNull() {
            addCriterion("info2 is null");
            return (Criteria) this;
        }

        public Criteria andInfo2IsNotNull() {
            addCriterion("info2 is not null");
            return (Criteria) this;
        }

        public Criteria andInfo2EqualTo(String value) {
            addCriterion("info2 =", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotEqualTo(String value) {
            addCriterion("info2 <>", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2GreaterThan(String value) {
            addCriterion("info2 >", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2GreaterThanOrEqualTo(String value) {
            addCriterion("info2 >=", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2LessThan(String value) {
            addCriterion("info2 <", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2LessThanOrEqualTo(String value) {
            addCriterion("info2 <=", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2Like(String value) {
            addCriterion("info2 like", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotLike(String value) {
            addCriterion("info2 not like", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2In(List<String> values) {
            addCriterion("info2 in", values, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotIn(List<String> values) {
            addCriterion("info2 not in", values, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2Between(String value1, String value2) {
            addCriterion("info2 between", value1, value2, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotBetween(String value1, String value2) {
            addCriterion("info2 not between", value1, value2, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo3IsNull() {
            addCriterion("info3 is null");
            return (Criteria) this;
        }

        public Criteria andInfo3IsNotNull() {
            addCriterion("info3 is not null");
            return (Criteria) this;
        }

        public Criteria andInfo3EqualTo(String value) {
            addCriterion("info3 =", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotEqualTo(String value) {
            addCriterion("info3 <>", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3GreaterThan(String value) {
            addCriterion("info3 >", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3GreaterThanOrEqualTo(String value) {
            addCriterion("info3 >=", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3LessThan(String value) {
            addCriterion("info3 <", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3LessThanOrEqualTo(String value) {
            addCriterion("info3 <=", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3Like(String value) {
            addCriterion("info3 like", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotLike(String value) {
            addCriterion("info3 not like", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3In(List<String> values) {
            addCriterion("info3 in", values, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotIn(List<String> values) {
            addCriterion("info3 not in", values, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3Between(String value1, String value2) {
            addCriterion("info3 between", value1, value2, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotBetween(String value1, String value2) {
            addCriterion("info3 not between", value1, value2, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo4IsNull() {
            addCriterion("info4 is null");
            return (Criteria) this;
        }

        public Criteria andInfo4IsNotNull() {
            addCriterion("info4 is not null");
            return (Criteria) this;
        }

        public Criteria andInfo4EqualTo(String value) {
            addCriterion("info4 =", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4NotEqualTo(String value) {
            addCriterion("info4 <>", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4GreaterThan(String value) {
            addCriterion("info4 >", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4GreaterThanOrEqualTo(String value) {
            addCriterion("info4 >=", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4LessThan(String value) {
            addCriterion("info4 <", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4LessThanOrEqualTo(String value) {
            addCriterion("info4 <=", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4Like(String value) {
            addCriterion("info4 like", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4NotLike(String value) {
            addCriterion("info4 not like", value, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4In(List<String> values) {
            addCriterion("info4 in", values, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4NotIn(List<String> values) {
            addCriterion("info4 not in", values, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4Between(String value1, String value2) {
            addCriterion("info4 between", value1, value2, "info4");
            return (Criteria) this;
        }

        public Criteria andInfo4NotBetween(String value1, String value2) {
            addCriterion("info4 not between", value1, value2, "info4");
            return (Criteria) this;
        }

        public Criteria andTipsIsNull() {
            addCriterion("tips is null");
            return (Criteria) this;
        }

        public Criteria andTipsIsNotNull() {
            addCriterion("tips is not null");
            return (Criteria) this;
        }

        public Criteria andTipsEqualTo(String value) {
            addCriterion("tips =", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotEqualTo(String value) {
            addCriterion("tips <>", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThan(String value) {
            addCriterion("tips >", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThanOrEqualTo(String value) {
            addCriterion("tips >=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThan(String value) {
            addCriterion("tips <", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThanOrEqualTo(String value) {
            addCriterion("tips <=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLike(String value) {
            addCriterion("tips like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotLike(String value) {
            addCriterion("tips not like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsIn(List<String> values) {
            addCriterion("tips in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotIn(List<String> values) {
            addCriterion("tips not in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsBetween(String value1, String value2) {
            addCriterion("tips between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotBetween(String value1, String value2) {
            addCriterion("tips not between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassIsNull() {
            addCriterion("imgResultModelClass is null");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassIsNotNull() {
            addCriterion("imgResultModelClass is not null");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassEqualTo(String value) {
            addCriterion("imgResultModelClass =", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassNotEqualTo(String value) {
            addCriterion("imgResultModelClass <>", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassGreaterThan(String value) {
            addCriterion("imgResultModelClass >", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassGreaterThanOrEqualTo(String value) {
            addCriterion("imgResultModelClass >=", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassLessThan(String value) {
            addCriterion("imgResultModelClass <", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassLessThanOrEqualTo(String value) {
            addCriterion("imgResultModelClass <=", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassLike(String value) {
            addCriterion("imgResultModelClass like", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassNotLike(String value) {
            addCriterion("imgResultModelClass not like", value, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassIn(List<String> values) {
            addCriterion("imgResultModelClass in", values, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassNotIn(List<String> values) {
            addCriterion("imgResultModelClass not in", values, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassBetween(String value1, String value2) {
            addCriterion("imgResultModelClass between", value1, value2, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultmodelclassNotBetween(String value1, String value2) {
            addCriterion("imgResultModelClass not between", value1, value2, "imgresultmodelclass");
            return (Criteria) this;
        }

        public Criteria andImgresultdateIsNull() {
            addCriterion("imgResultDate is null");
            return (Criteria) this;
        }

        public Criteria andImgresultdateIsNotNull() {
            addCriterion("imgResultDate is not null");
            return (Criteria) this;
        }

        public Criteria andImgresultdateEqualTo(String value) {
            addCriterion("imgResultDate =", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateNotEqualTo(String value) {
            addCriterion("imgResultDate <>", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateGreaterThan(String value) {
            addCriterion("imgResultDate >", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateGreaterThanOrEqualTo(String value) {
            addCriterion("imgResultDate >=", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateLessThan(String value) {
            addCriterion("imgResultDate <", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateLessThanOrEqualTo(String value) {
            addCriterion("imgResultDate <=", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateLike(String value) {
            addCriterion("imgResultDate like", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateNotLike(String value) {
            addCriterion("imgResultDate not like", value, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateIn(List<String> values) {
            addCriterion("imgResultDate in", values, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateNotIn(List<String> values) {
            addCriterion("imgResultDate not in", values, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateBetween(String value1, String value2) {
            addCriterion("imgResultDate between", value1, value2, "imgresultdate");
            return (Criteria) this;
        }

        public Criteria andImgresultdateNotBetween(String value1, String value2) {
            addCriterion("imgResultDate not between", value1, value2, "imgresultdate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}