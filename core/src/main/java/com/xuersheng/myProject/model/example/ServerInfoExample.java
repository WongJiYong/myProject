package com.xuersheng.myProject.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServerInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServerInfoExample() {
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
            addCriterion("si.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("si.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("si.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("si.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("si.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("si.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("si.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("si.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("si.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("si.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("si.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("si.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("si.ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("si.ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("si.ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("si.ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("si.ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("si.ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("si.ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("si.ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("si.ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("si.ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("si.ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("si.ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("si.ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("si.ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("si.name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("si.name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("si.name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("si.name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("si.name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("si.name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("si.name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("si.name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("si.name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("si.name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("si.name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("si.name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("si.name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("si.name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("si.type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("si.type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("si.type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("si.type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("si.type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("si.type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("si.type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("si.type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("si.type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("si.type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("si.type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("si.type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("si.detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("si.detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("si.detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("si.detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("si.detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("si.detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("si.detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("si.detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("si.detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("si.detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("si.detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("si.detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("si.detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("si.detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("si.username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("si.username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("si.username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("si.username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("si.username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("si.username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("si.username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("si.username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("si.username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("si.username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("si.username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("si.username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("si.username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("si.username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("si.password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("si.password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("si.password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("si.password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("si.password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("si.password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("si.password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("si.password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("si.password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("si.password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("si.password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("si.password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("si.password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("si.password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIsNull() {
            addCriterion("si.catalog_id is null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIsNotNull() {
            addCriterion("si.catalog_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogIdEqualTo(Integer value) {
            addCriterion("si.catalog_id =", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotEqualTo(Integer value) {
            addCriterion("si.catalog_id <>", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThan(Integer value) {
            addCriterion("si.catalog_id >", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("si.catalog_id >=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThan(Integer value) {
            addCriterion("si.catalog_id <", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdLessThanOrEqualTo(Integer value) {
            addCriterion("si.catalog_id <=", value, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdIn(List<Integer> values) {
            addCriterion("si.catalog_id in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotIn(List<Integer> values) {
            addCriterion("si.catalog_id not in", values, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdBetween(Integer value1, Integer value2) {
            addCriterion("si.catalog_id between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andCatalogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("si.catalog_id not between", value1, value2, "catalogId");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNull() {
            addCriterion("si.modified_time is null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIsNotNull() {
            addCriterion("si.modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeEqualTo(Date value) {
            addCriterion("si.modified_time =", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotEqualTo(Date value) {
            addCriterion("si.modified_time <>", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThan(Date value) {
            addCriterion("si.modified_time >", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("si.modified_time >=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThan(Date value) {
            addCriterion("si.modified_time <", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("si.modified_time <=", value, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeIn(List<Date> values) {
            addCriterion("si.modified_time in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotIn(List<Date> values) {
            addCriterion("si.modified_time not in", values, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("si.modified_time between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("si.modified_time not between", value1, value2, "modifiedTime");
            return (Criteria) this;
        }

        public Criteria andConnectableIsNull() {
            addCriterion("si.connectable is null");
            return (Criteria) this;
        }

        public Criteria andConnectableIsNotNull() {
            addCriterion("si.connectable is not null");
            return (Criteria) this;
        }

        public Criteria andConnectableEqualTo(Boolean value) {
            addCriterion("si.connectable =", value, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableNotEqualTo(Boolean value) {
            addCriterion("si.connectable <>", value, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableGreaterThan(Boolean value) {
            addCriterion("si.connectable >", value, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("si.connectable >=", value, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableLessThan(Boolean value) {
            addCriterion("si.connectable <", value, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableLessThanOrEqualTo(Boolean value) {
            addCriterion("si.connectable <=", value, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableIn(List<Boolean> values) {
            addCriterion("si.connectable in", values, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableNotIn(List<Boolean> values) {
            addCriterion("si.connectable not in", values, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableBetween(Boolean value1, Boolean value2) {
            addCriterion("si.connectable between", value1, value2, "connectable");
            return (Criteria) this;
        }

        public Criteria andConnectableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("si.connectable not between", value1, value2, "connectable");
            return (Criteria) this;
        }

        public Criteria andMountedOnIsNull() {
            addCriterion("si.mounted_on is null");
            return (Criteria) this;
        }

        public Criteria andMountedOnIsNotNull() {
            addCriterion("si.mounted_on is not null");
            return (Criteria) this;
        }

        public Criteria andMountedOnEqualTo(String value) {
            addCriterion("si.mounted_on =", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnNotEqualTo(String value) {
            addCriterion("si.mounted_on <>", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnGreaterThan(String value) {
            addCriterion("si.mounted_on >", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnGreaterThanOrEqualTo(String value) {
            addCriterion("si.mounted_on >=", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnLessThan(String value) {
            addCriterion("si.mounted_on <", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnLessThanOrEqualTo(String value) {
            addCriterion("si.mounted_on <=", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnLike(String value) {
            addCriterion("si.mounted_on like", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnNotLike(String value) {
            addCriterion("si.mounted_on not like", value, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnIn(List<String> values) {
            addCriterion("si.mounted_on in", values, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnNotIn(List<String> values) {
            addCriterion("si.mounted_on not in", values, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnBetween(String value1, String value2) {
            addCriterion("si.mounted_on between", value1, value2, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andMountedOnNotBetween(String value1, String value2) {
            addCriterion("si.mounted_on not between", value1, value2, "mountedOn");
            return (Criteria) this;
        }

        public Criteria andDiskTotalIsNull() {
            addCriterion("si.disk_total is null");
            return (Criteria) this;
        }

        public Criteria andDiskTotalIsNotNull() {
            addCriterion("si.disk_total is not null");
            return (Criteria) this;
        }

        public Criteria andDiskTotalEqualTo(Integer value) {
            addCriterion("si.disk_total =", value, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalNotEqualTo(Integer value) {
            addCriterion("si.disk_total <>", value, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalGreaterThan(Integer value) {
            addCriterion("si.disk_total >", value, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("si.disk_total >=", value, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalLessThan(Integer value) {
            addCriterion("si.disk_total <", value, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalLessThanOrEqualTo(Integer value) {
            addCriterion("si.disk_total <=", value, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalIn(List<Integer> values) {
            addCriterion("si.disk_total in", values, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalNotIn(List<Integer> values) {
            addCriterion("si.disk_total not in", values, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalBetween(Integer value1, Integer value2) {
            addCriterion("si.disk_total between", value1, value2, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("si.disk_total not between", value1, value2, "diskTotal");
            return (Criteria) this;
        }

        public Criteria andDiskUsedIsNull() {
            addCriterion("si.disk_used is null");
            return (Criteria) this;
        }

        public Criteria andDiskUsedIsNotNull() {
            addCriterion("si.disk_used is not null");
            return (Criteria) this;
        }

        public Criteria andDiskUsedEqualTo(Integer value) {
            addCriterion("si.disk_used =", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedNotEqualTo(Integer value) {
            addCriterion("si.disk_used <>", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedGreaterThan(Integer value) {
            addCriterion("si.disk_used >", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("si.disk_used >=", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedLessThan(Integer value) {
            addCriterion("si.disk_used <", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedLessThanOrEqualTo(Integer value) {
            addCriterion("si.disk_used <=", value, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedIn(List<Integer> values) {
            addCriterion("si.disk_used in", values, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedNotIn(List<Integer> values) {
            addCriterion("si.disk_used not in", values, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedBetween(Integer value1, Integer value2) {
            addCriterion("si.disk_used between", value1, value2, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andDiskUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("si.disk_used not between", value1, value2, "diskUsed");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("si.update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("si.update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("si.update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("si.update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("si.update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("si.update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("si.update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("si.update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("si.update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("si.update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("si.update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("si.update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("si.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("si.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("si.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("si.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("si.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("si.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("si.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("si.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("si.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("si.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("si.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("si.deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("si.version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("si.version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("si.version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("si.version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("si.version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("si.version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("si.version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("si.version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("si.version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("si.version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("si.version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("si.version not between", value1, value2, "version");
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