package com.xuersheng.myProject.model.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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
            addCriterion("m.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("m.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("m.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("m.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("m.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("m.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("m.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("m.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("m.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("m.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("m.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("m.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIFrameIsNull() {
            addCriterion("m.i_frame is null");
            return (Criteria) this;
        }

        public Criteria andIFrameIsNotNull() {
            addCriterion("m.i_frame is not null");
            return (Criteria) this;
        }

        public Criteria andIFrameEqualTo(Boolean value) {
            addCriterion("m.i_frame =", value, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameNotEqualTo(Boolean value) {
            addCriterion("m.i_frame <>", value, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameGreaterThan(Boolean value) {
            addCriterion("m.i_frame >", value, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameGreaterThanOrEqualTo(Boolean value) {
            addCriterion("m.i_frame >=", value, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameLessThan(Boolean value) {
            addCriterion("m.i_frame <", value, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameLessThanOrEqualTo(Boolean value) {
            addCriterion("m.i_frame <=", value, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameIn(List<Boolean> values) {
            addCriterion("m.i_frame in", values, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameNotIn(List<Boolean> values) {
            addCriterion("m.i_frame not in", values, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameBetween(Boolean value1, Boolean value2) {
            addCriterion("m.i_frame between", value1, value2, "iFrame");
            return (Criteria) this;
        }

        public Criteria andIFrameNotBetween(Boolean value1, Boolean value2) {
            addCriterion("m.i_frame not between", value1, value2, "iFrame");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("m.name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("m.name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("m.name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("m.name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("m.name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("m.name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("m.name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("m.name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("m.name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("m.name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("m.name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("m.name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("m.name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("m.name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andComponentIsNull() {
            addCriterion("m.component is null");
            return (Criteria) this;
        }

        public Criteria andComponentIsNotNull() {
            addCriterion("m.component is not null");
            return (Criteria) this;
        }

        public Criteria andComponentEqualTo(String value) {
            addCriterion("m.component =", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotEqualTo(String value) {
            addCriterion("m.component <>", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThan(String value) {
            addCriterion("m.component >", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThanOrEqualTo(String value) {
            addCriterion("m.component >=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThan(String value) {
            addCriterion("m.component <", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThanOrEqualTo(String value) {
            addCriterion("m.component <=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLike(String value) {
            addCriterion("m.component like", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotLike(String value) {
            addCriterion("m.component not like", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentIn(List<String> values) {
            addCriterion("m.component in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotIn(List<String> values) {
            addCriterion("m.component not in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentBetween(String value1, String value2) {
            addCriterion("m.component between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotBetween(String value1, String value2) {
            addCriterion("m.component not between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("m.pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("m.pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("m.pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("m.pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("m.pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("m.pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("m.pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("m.pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("m.pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("m.pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("m.pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("m.pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("m.sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("m.sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Long value) {
            addCriterion("m.sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Long value) {
            addCriterion("m.sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Long value) {
            addCriterion("m.sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Long value) {
            addCriterion("m.sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Long value) {
            addCriterion("m.sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Long value) {
            addCriterion("m.sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Long> values) {
            addCriterion("m.sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Long> values) {
            addCriterion("m.sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Long value1, Long value2) {
            addCriterion("m.sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Long value1, Long value2) {
            addCriterion("m.sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("m.icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("m.icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("m.icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("m.icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("m.icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("m.icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("m.icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("m.icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("m.icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("m.icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("m.icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("m.icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("m.icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("m.icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("m.path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("m.path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("m.path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("m.path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("m.path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("m.path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("m.path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("m.path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("m.path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("m.path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("m.path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("m.path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("m.path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("m.path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andCacheIsNull() {
            addCriterion("m.cache is null");
            return (Criteria) this;
        }

        public Criteria andCacheIsNotNull() {
            addCriterion("m.cache is not null");
            return (Criteria) this;
        }

        public Criteria andCacheEqualTo(Boolean value) {
            addCriterion("m.cache =", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotEqualTo(Boolean value) {
            addCriterion("m.cache <>", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheGreaterThan(Boolean value) {
            addCriterion("m.cache >", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheGreaterThanOrEqualTo(Boolean value) {
            addCriterion("m.cache >=", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheLessThan(Boolean value) {
            addCriterion("m.cache <", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheLessThanOrEqualTo(Boolean value) {
            addCriterion("m.cache <=", value, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheIn(List<Boolean> values) {
            addCriterion("m.cache in", values, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotIn(List<Boolean> values) {
            addCriterion("m.cache not in", values, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheBetween(Boolean value1, Boolean value2) {
            addCriterion("m.cache between", value1, value2, "cache");
            return (Criteria) this;
        }

        public Criteria andCacheNotBetween(Boolean value1, Boolean value2) {
            addCriterion("m.cache not between", value1, value2, "cache");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("m.enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("m.enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("m.enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("m.enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("m.enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("m.enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("m.enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("m.enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("m.enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("m.enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("m.enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("m.enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andComponentNameIsNull() {
            addCriterion("m.component_name is null");
            return (Criteria) this;
        }

        public Criteria andComponentNameIsNotNull() {
            addCriterion("m.component_name is not null");
            return (Criteria) this;
        }

        public Criteria andComponentNameEqualTo(String value) {
            addCriterion("m.component_name =", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotEqualTo(String value) {
            addCriterion("m.component_name <>", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameGreaterThan(String value) {
            addCriterion("m.component_name >", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameGreaterThanOrEqualTo(String value) {
            addCriterion("m.component_name >=", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLessThan(String value) {
            addCriterion("m.component_name <", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLessThanOrEqualTo(String value) {
            addCriterion("m.component_name <=", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLike(String value) {
            addCriterion("m.component_name like", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotLike(String value) {
            addCriterion("m.component_name not like", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameIn(List<String> values) {
            addCriterion("m.component_name in", values, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotIn(List<String> values) {
            addCriterion("m.component_name not in", values, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameBetween(String value1, String value2) {
            addCriterion("m.component_name between", value1, value2, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotBetween(String value1, String value2) {
            addCriterion("m.component_name not between", value1, value2, "componentName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("m.create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("m.create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("m.create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("m.create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("m.create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("m.create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("m.create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("m.create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("m.create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("m.create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("m.create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("m.create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNull() {
            addCriterion("m.permission is null");
            return (Criteria) this;
        }

        public Criteria andPermissionIsNotNull() {
            addCriterion("m.permission is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionEqualTo(String value) {
            addCriterion("m.permission =", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotEqualTo(String value) {
            addCriterion("m.permission <>", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThan(String value) {
            addCriterion("m.permission >", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionGreaterThanOrEqualTo(String value) {
            addCriterion("m.permission >=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThan(String value) {
            addCriterion("m.permission <", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLessThanOrEqualTo(String value) {
            addCriterion("m.permission <=", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionLike(String value) {
            addCriterion("m.permission like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotLike(String value) {
            addCriterion("m.permission not like", value, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionIn(List<String> values) {
            addCriterion("m.permission in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotIn(List<String> values) {
            addCriterion("m.permission not in", values, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionBetween(String value1, String value2) {
            addCriterion("m.permission between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andPermissionNotBetween(String value1, String value2) {
            addCriterion("m.permission not between", value1, value2, "permission");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("m.type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("m.type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("m.type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("m.type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("m.type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("m.type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("m.type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("m.type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("m.type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("m.type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("m.type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("m.type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("m.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("m.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("m.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("m.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("m.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("m.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("m.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("m.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("m.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("m.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("m.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("m.deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("m.version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("m.version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("m.version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("m.version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("m.version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("m.version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("m.version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("m.version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("m.version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("m.version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("m.version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("m.version not between", value1, value2, "version");
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