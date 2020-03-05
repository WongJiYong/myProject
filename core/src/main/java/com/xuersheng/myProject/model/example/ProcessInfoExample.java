package com.xuersheng.myProject.model.example;

import java.util.ArrayList;
import java.util.List;

public class ProcessInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessInfoExample() {
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
            addCriterion("pi.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("pi.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("pi.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("pi.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("pi.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("pi.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("pi.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("pi.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("pi.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("pi.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pi.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("pi.server_id is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("pi.server_id is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Integer value) {
            addCriterion("pi.server_id =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Integer value) {
            addCriterion("pi.server_id <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Integer value) {
            addCriterion("pi.server_id >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi.server_id >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Integer value) {
            addCriterion("pi.server_id <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Integer value) {
            addCriterion("pi.server_id <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Integer> values) {
            addCriterion("pi.server_id in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Integer> values) {
            addCriterion("pi.server_id not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Integer value1, Integer value2) {
            addCriterion("pi.server_id between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pi.server_id not between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pi.pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pi.pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pi.pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pi.pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pi.pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi.pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pi.pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pi.pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pi.pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pi.pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pi.pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pi.pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("pi.name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("pi.name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("pi.name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("pi.name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("pi.name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("pi.name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("pi.name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("pi.name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("pi.name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("pi.name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("pi.name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("pi.name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("pi.name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("pi.name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("pi.port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("pi.port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("pi.port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("pi.port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("pi.port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi.port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("pi.port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("pi.port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("pi.port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("pi.port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("pi.port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("pi.port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("pi.detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("pi.detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("pi.detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("pi.detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("pi.detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("pi.detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("pi.detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("pi.detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("pi.detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("pi.detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("pi.detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("pi.detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("pi.detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("pi.detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andRootPathIsNull() {
            addCriterion("pi.root_path is null");
            return (Criteria) this;
        }

        public Criteria andRootPathIsNotNull() {
            addCriterion("pi.root_path is not null");
            return (Criteria) this;
        }

        public Criteria andRootPathEqualTo(String value) {
            addCriterion("pi.root_path =", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotEqualTo(String value) {
            addCriterion("pi.root_path <>", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathGreaterThan(String value) {
            addCriterion("pi.root_path >", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathGreaterThanOrEqualTo(String value) {
            addCriterion("pi.root_path >=", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathLessThan(String value) {
            addCriterion("pi.root_path <", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathLessThanOrEqualTo(String value) {
            addCriterion("pi.root_path <=", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathLike(String value) {
            addCriterion("pi.root_path like", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotLike(String value) {
            addCriterion("pi.root_path not like", value, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathIn(List<String> values) {
            addCriterion("pi.root_path in", values, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotIn(List<String> values) {
            addCriterion("pi.root_path not in", values, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathBetween(String value1, String value2) {
            addCriterion("pi.root_path between", value1, value2, "rootPath");
            return (Criteria) this;
        }

        public Criteria andRootPathNotBetween(String value1, String value2) {
            addCriterion("pi.root_path not between", value1, value2, "rootPath");
            return (Criteria) this;
        }

        public Criteria andStartupShIsNull() {
            addCriterion("pi.startup_sh is null");
            return (Criteria) this;
        }

        public Criteria andStartupShIsNotNull() {
            addCriterion("pi.startup_sh is not null");
            return (Criteria) this;
        }

        public Criteria andStartupShEqualTo(String value) {
            addCriterion("pi.startup_sh =", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShNotEqualTo(String value) {
            addCriterion("pi.startup_sh <>", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShGreaterThan(String value) {
            addCriterion("pi.startup_sh >", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShGreaterThanOrEqualTo(String value) {
            addCriterion("pi.startup_sh >=", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShLessThan(String value) {
            addCriterion("pi.startup_sh <", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShLessThanOrEqualTo(String value) {
            addCriterion("pi.startup_sh <=", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShLike(String value) {
            addCriterion("pi.startup_sh like", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShNotLike(String value) {
            addCriterion("pi.startup_sh not like", value, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShIn(List<String> values) {
            addCriterion("pi.startup_sh in", values, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShNotIn(List<String> values) {
            addCriterion("pi.startup_sh not in", values, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShBetween(String value1, String value2) {
            addCriterion("pi.startup_sh between", value1, value2, "startupSh");
            return (Criteria) this;
        }

        public Criteria andStartupShNotBetween(String value1, String value2) {
            addCriterion("pi.startup_sh not between", value1, value2, "startupSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShIsNull() {
            addCriterion("pi.shutdown_sh is null");
            return (Criteria) this;
        }

        public Criteria andShutdownShIsNotNull() {
            addCriterion("pi.shutdown_sh is not null");
            return (Criteria) this;
        }

        public Criteria andShutdownShEqualTo(String value) {
            addCriterion("pi.shutdown_sh =", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShNotEqualTo(String value) {
            addCriterion("pi.shutdown_sh <>", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShGreaterThan(String value) {
            addCriterion("pi.shutdown_sh >", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShGreaterThanOrEqualTo(String value) {
            addCriterion("pi.shutdown_sh >=", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShLessThan(String value) {
            addCriterion("pi.shutdown_sh <", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShLessThanOrEqualTo(String value) {
            addCriterion("pi.shutdown_sh <=", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShLike(String value) {
            addCriterion("pi.shutdown_sh like", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShNotLike(String value) {
            addCriterion("pi.shutdown_sh not like", value, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShIn(List<String> values) {
            addCriterion("pi.shutdown_sh in", values, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShNotIn(List<String> values) {
            addCriterion("pi.shutdown_sh not in", values, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShBetween(String value1, String value2) {
            addCriterion("pi.shutdown_sh between", value1, value2, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andShutdownShNotBetween(String value1, String value2) {
            addCriterion("pi.shutdown_sh not between", value1, value2, "shutdownSh");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("pi.status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("pi.status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("pi.status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("pi.status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("pi.status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pi.status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("pi.status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("pi.status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("pi.status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("pi.status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("pi.status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("pi.status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("pi.status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("pi.status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("pi.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("pi.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("pi.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("pi.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("pi.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pi.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("pi.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("pi.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("pi.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("pi.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("pi.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pi.deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("pi.version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("pi.version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("pi.version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("pi.version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("pi.version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("pi.version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("pi.version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("pi.version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("pi.version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("pi.version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("pi.version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("pi.version not between", value1, value2, "version");
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