package com.pyg.manager.dao.pojo;

import java.util.ArrayList;
import java.util.List;


public class TbImageCaseInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbImageCaseInfoExample() {
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

        public Criteria andCasestatusIsNull() {
            addCriterion("caseStatus is null");
            return (Criteria) this;
        }

        public Criteria andCasestatusIsNotNull() {
            addCriterion("caseStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCasestatusEqualTo(String value) {
            addCriterion("caseStatus =", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotEqualTo(String value) {
            addCriterion("caseStatus <>", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusGreaterThan(String value) {
            addCriterion("caseStatus >", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusGreaterThanOrEqualTo(String value) {
            addCriterion("caseStatus >=", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusLessThan(String value) {
            addCriterion("caseStatus <", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusLessThanOrEqualTo(String value) {
            addCriterion("caseStatus <=", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusLike(String value) {
            addCriterion("caseStatus like", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotLike(String value) {
            addCriterion("caseStatus not like", value, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusIn(List<String> values) {
            addCriterion("caseStatus in", values, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotIn(List<String> values) {
            addCriterion("caseStatus not in", values, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusBetween(String value1, String value2) {
            addCriterion("caseStatus between", value1, value2, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasestatusNotBetween(String value1, String value2) {
            addCriterion("caseStatus not between", value1, value2, "casestatus");
            return (Criteria) this;
        }

        public Criteria andCasedateIsNull() {
            addCriterion("caseDate is null");
            return (Criteria) this;
        }

        public Criteria andCasedateIsNotNull() {
            addCriterion("caseDate is not null");
            return (Criteria) this;
        }

        public Criteria andCasedateEqualTo(String value) {
            addCriterion("caseDate =", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateNotEqualTo(String value) {
            addCriterion("caseDate <>", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateGreaterThan(String value) {
            addCriterion("caseDate >", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateGreaterThanOrEqualTo(String value) {
            addCriterion("caseDate >=", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateLessThan(String value) {
            addCriterion("caseDate <", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateLessThanOrEqualTo(String value) {
            addCriterion("caseDate <=", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateLike(String value) {
            addCriterion("caseDate like", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateNotLike(String value) {
            addCriterion("caseDate not like", value, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateIn(List<String> values) {
            addCriterion("caseDate in", values, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateNotIn(List<String> values) {
            addCriterion("caseDate not in", values, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateBetween(String value1, String value2) {
            addCriterion("caseDate between", value1, value2, "casedate");
            return (Criteria) this;
        }

        public Criteria andCasedateNotBetween(String value1, String value2) {
            addCriterion("caseDate not between", value1, value2, "casedate");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("userCode is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("userCode is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(String value) {
            addCriterion("userCode =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(String value) {
            addCriterion("userCode <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(String value) {
            addCriterion("userCode >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(String value) {
            addCriterion("userCode >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(String value) {
            addCriterion("userCode <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(String value) {
            addCriterion("userCode <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLike(String value) {
            addCriterion("userCode like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotLike(String value) {
            addCriterion("userCode not like", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<String> values) {
            addCriterion("userCode in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<String> values) {
            addCriterion("userCode not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(String value1, String value2) {
            addCriterion("userCode between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(String value1, String value2) {
            addCriterion("userCode not between", value1, value2, "usercode");
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

        public Criteria andResultdateIsNull() {
            addCriterion("resultDate is null");
            return (Criteria) this;
        }

        public Criteria andResultdateIsNotNull() {
            addCriterion("resultDate is not null");
            return (Criteria) this;
        }

        public Criteria andResultdateEqualTo(String value) {
            addCriterion("resultDate =", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateNotEqualTo(String value) {
            addCriterion("resultDate <>", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateGreaterThan(String value) {
            addCriterion("resultDate >", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateGreaterThanOrEqualTo(String value) {
            addCriterion("resultDate >=", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateLessThan(String value) {
            addCriterion("resultDate <", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateLessThanOrEqualTo(String value) {
            addCriterion("resultDate <=", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateLike(String value) {
            addCriterion("resultDate like", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateNotLike(String value) {
            addCriterion("resultDate not like", value, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateIn(List<String> values) {
            addCriterion("resultDate in", values, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateNotIn(List<String> values) {
            addCriterion("resultDate not in", values, "resultdate");
            return (Criteria) this;
        }

        public Criteria andResultdateBetween(String value1, String value2) {
            addCriterion("resultDate between", value1, value2, "resultdate");
            return (Criteria) this;
        }

		public Criteria andResultdateNotBetween(String value1, String value2) {
			addCriterion("resultDate not between", value1, value2,
					"resultdate");
			return (Criteria) this;
		}

		public Criteria andResultLike(String value) {
			addCriterion("result like", value, "content");
			return (Criteria) this;
		}
		public Criteria andResultNotLike(String value) {
			addCriterion("result not like", value, "content");
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