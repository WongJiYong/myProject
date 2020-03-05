package com.xuersheng.myProject.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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
            addCriterion("l.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("l.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("l.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("l.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("l.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("l.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("l.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("l.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("l.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("l.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("l.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("l.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("l.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("l.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("l.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("l.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("l.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("l.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("l.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("l.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("l.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("l.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("l.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("l.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("l.description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("l.description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("l.description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("l.description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("l.description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("l.description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("l.description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("l.description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("l.description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("l.description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("l.description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("l.description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("l.description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("l.description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("l.log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("l.log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("l.log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("l.log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("l.log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("l.log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("l.log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("l.log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("l.log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("l.log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("l.log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("l.log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("l.log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("l.log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("l.method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("l.method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("l.method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("l.method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("l.method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("l.method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("l.method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("l.method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("l.method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("l.method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("l.method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("l.method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("l.method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("l.method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andRequestIpIsNull() {
            addCriterion("l.request_ip is null");
            return (Criteria) this;
        }

        public Criteria andRequestIpIsNotNull() {
            addCriterion("l.request_ip is not null");
            return (Criteria) this;
        }

        public Criteria andRequestIpEqualTo(String value) {
            addCriterion("l.request_ip =", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotEqualTo(String value) {
            addCriterion("l.request_ip <>", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpGreaterThan(String value) {
            addCriterion("l.request_ip >", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpGreaterThanOrEqualTo(String value) {
            addCriterion("l.request_ip >=", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpLessThan(String value) {
            addCriterion("l.request_ip <", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpLessThanOrEqualTo(String value) {
            addCriterion("l.request_ip <=", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpLike(String value) {
            addCriterion("l.request_ip like", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotLike(String value) {
            addCriterion("l.request_ip not like", value, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpIn(List<String> values) {
            addCriterion("l.request_ip in", values, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotIn(List<String> values) {
            addCriterion("l.request_ip not in", values, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpBetween(String value1, String value2) {
            addCriterion("l.request_ip between", value1, value2, "requestIp");
            return (Criteria) this;
        }

        public Criteria andRequestIpNotBetween(String value1, String value2) {
            addCriterion("l.request_ip not between", value1, value2, "requestIp");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("l.time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("l.time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Long value) {
            addCriterion("l.time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Long value) {
            addCriterion("l.time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Long value) {
            addCriterion("l.time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("l.time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Long value) {
            addCriterion("l.time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Long value) {
            addCriterion("l.time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Long> values) {
            addCriterion("l.time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Long> values) {
            addCriterion("l.time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Long value1, Long value2) {
            addCriterion("l.time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Long value1, Long value2) {
            addCriterion("l.time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("l.username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("l.username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("l.username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("l.username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("l.username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("l.username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("l.username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("l.username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("l.username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("l.username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("l.username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("l.username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("l.username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("l.username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("l.address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("l.address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("l.address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("l.address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("l.address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("l.address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("l.address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("l.address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("l.address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("l.address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("l.address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("l.address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("l.address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("l.address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNull() {
            addCriterion("l.browser is null");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNotNull() {
            addCriterion("l.browser is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserEqualTo(String value) {
            addCriterion("l.browser =", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotEqualTo(String value) {
            addCriterion("l.browser <>", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThan(String value) {
            addCriterion("l.browser >", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("l.browser >=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThan(String value) {
            addCriterion("l.browser <", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThanOrEqualTo(String value) {
            addCriterion("l.browser <=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLike(String value) {
            addCriterion("l.browser like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotLike(String value) {
            addCriterion("l.browser not like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserIn(List<String> values) {
            addCriterion("l.browser in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotIn(List<String> values) {
            addCriterion("l.browser not in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserBetween(String value1, String value2) {
            addCriterion("l.browser between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotBetween(String value1, String value2) {
            addCriterion("l.browser not between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("l.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("l.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("l.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("l.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("l.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("l.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("l.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("l.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("l.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("l.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("l.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("l.deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("l.version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("l.version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("l.version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("l.version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("l.version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("l.version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("l.version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("l.version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("l.version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("l.version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("l.version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("l.version not between", value1, value2, "version");
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