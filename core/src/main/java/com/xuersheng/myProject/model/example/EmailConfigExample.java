package com.xuersheng.myProject.model.example;

import java.util.ArrayList;
import java.util.List;

public class EmailConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailConfigExample() {
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
            addCriterion("ec.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ec.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ec.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ec.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ec.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ec.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ec.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ec.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ec.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ec.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ec.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ec.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNull() {
            addCriterion("ec.from_user is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIsNotNull() {
            addCriterion("ec.from_user is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserEqualTo(String value) {
            addCriterion("ec.from_user =", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotEqualTo(String value) {
            addCriterion("ec.from_user <>", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThan(String value) {
            addCriterion("ec.from_user >", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserGreaterThanOrEqualTo(String value) {
            addCriterion("ec.from_user >=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThan(String value) {
            addCriterion("ec.from_user <", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLessThanOrEqualTo(String value) {
            addCriterion("ec.from_user <=", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserLike(String value) {
            addCriterion("ec.from_user like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotLike(String value) {
            addCriterion("ec.from_user not like", value, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserIn(List<String> values) {
            addCriterion("ec.from_user in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotIn(List<String> values) {
            addCriterion("ec.from_user not in", values, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserBetween(String value1, String value2) {
            addCriterion("ec.from_user between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andFromUserNotBetween(String value1, String value2) {
            addCriterion("ec.from_user not between", value1, value2, "fromUser");
            return (Criteria) this;
        }

        public Criteria andHostIsNull() {
            addCriterion("ec.host is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("ec.host is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("ec.host =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("ec.host <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("ec.host >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("ec.host >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("ec.host <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("ec.host <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("ec.host like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("ec.host not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<String> values) {
            addCriterion("ec.host in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<String> values) {
            addCriterion("ec.host not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("ec.host between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("ec.host not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andPassIsNull() {
            addCriterion("ec.pass is null");
            return (Criteria) this;
        }

        public Criteria andPassIsNotNull() {
            addCriterion("ec.pass is not null");
            return (Criteria) this;
        }

        public Criteria andPassEqualTo(String value) {
            addCriterion("ec.pass =", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotEqualTo(String value) {
            addCriterion("ec.pass <>", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassGreaterThan(String value) {
            addCriterion("ec.pass >", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassGreaterThanOrEqualTo(String value) {
            addCriterion("ec.pass >=", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLessThan(String value) {
            addCriterion("ec.pass <", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLessThanOrEqualTo(String value) {
            addCriterion("ec.pass <=", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassLike(String value) {
            addCriterion("ec.pass like", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotLike(String value) {
            addCriterion("ec.pass not like", value, "pass");
            return (Criteria) this;
        }

        public Criteria andPassIn(List<String> values) {
            addCriterion("ec.pass in", values, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotIn(List<String> values) {
            addCriterion("ec.pass not in", values, "pass");
            return (Criteria) this;
        }

        public Criteria andPassBetween(String value1, String value2) {
            addCriterion("ec.pass between", value1, value2, "pass");
            return (Criteria) this;
        }

        public Criteria andPassNotBetween(String value1, String value2) {
            addCriterion("ec.pass not between", value1, value2, "pass");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("ec.port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("ec.port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("ec.port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("ec.port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("ec.port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("ec.port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("ec.port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("ec.port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("ec.port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("ec.port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("ec.port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("ec.port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("ec.port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("ec.port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andUserIsNull() {
            addCriterion("ec.user is null");
            return (Criteria) this;
        }

        public Criteria andUserIsNotNull() {
            addCriterion("ec.user is not null");
            return (Criteria) this;
        }

        public Criteria andUserEqualTo(String value) {
            addCriterion("ec.user =", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotEqualTo(String value) {
            addCriterion("ec.user <>", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThan(String value) {
            addCriterion("ec.user >", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserGreaterThanOrEqualTo(String value) {
            addCriterion("ec.user >=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThan(String value) {
            addCriterion("ec.user <", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLessThanOrEqualTo(String value) {
            addCriterion("ec.user <=", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserLike(String value) {
            addCriterion("ec.user like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotLike(String value) {
            addCriterion("ec.user not like", value, "user");
            return (Criteria) this;
        }

        public Criteria andUserIn(List<String> values) {
            addCriterion("ec.user in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotIn(List<String> values) {
            addCriterion("ec.user not in", values, "user");
            return (Criteria) this;
        }

        public Criteria andUserBetween(String value1, String value2) {
            addCriterion("ec.user between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andUserNotBetween(String value1, String value2) {
            addCriterion("ec.user not between", value1, value2, "user");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("ec.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("ec.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("ec.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("ec.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("ec.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ec.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("ec.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("ec.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("ec.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("ec.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("ec.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ec.deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("ec.version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("ec.version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("ec.version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("ec.version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("ec.version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("ec.version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("ec.version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("ec.version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("ec.version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("ec.version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("ec.version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("ec.version not between", value1, value2, "version");
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