package com.sudao.cloud.module.catelog.dao.dto;

import com.sudao.cloud.module.base.config.enums.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatelogDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CatelogDTOExample() {
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

        public Criteria andCatelogIdIsNull() {
            addCriterion("catelog_id is null");
            return (Criteria) this;
        }

        public Criteria andCatelogIdIsNotNull() {
            addCriterion("catelog_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatelogIdEqualTo(Long value) {
            addCriterion("catelog_id =", value, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdNotEqualTo(Long value) {
            addCriterion("catelog_id <>", value, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdGreaterThan(Long value) {
            addCriterion("catelog_id >", value, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("catelog_id >=", value, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdLessThan(Long value) {
            addCriterion("catelog_id <", value, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdLessThanOrEqualTo(Long value) {
            addCriterion("catelog_id <=", value, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdIn(List<Long> values) {
            addCriterion("catelog_id in", values, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdNotIn(List<Long> values) {
            addCriterion("catelog_id not in", values, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdBetween(Long value1, Long value2) {
            addCriterion("catelog_id between", value1, value2, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIdNotBetween(Long value1, Long value2) {
            addCriterion("catelog_id not between", value1, value2, "catelogId");
            return (Criteria) this;
        }

        public Criteria andCatelogIconIsNull() {
            addCriterion("catelog_icon is null");
            return (Criteria) this;
        }

        public Criteria andCatelogIconIsNotNull() {
            addCriterion("catelog_icon is not null");
            return (Criteria) this;
        }

        public Criteria andCatelogIconEqualTo(String value) {
            addCriterion("catelog_icon =", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconNotEqualTo(String value) {
            addCriterion("catelog_icon <>", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconGreaterThan(String value) {
            addCriterion("catelog_icon >", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconGreaterThanOrEqualTo(String value) {
            addCriterion("catelog_icon >=", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconLessThan(String value) {
            addCriterion("catelog_icon <", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconLessThanOrEqualTo(String value) {
            addCriterion("catelog_icon <=", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconLike(String value) {
            addCriterion("catelog_icon like", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconNotLike(String value) {
            addCriterion("catelog_icon not like", value, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconIn(List<String> values) {
            addCriterion("catelog_icon in", values, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconNotIn(List<String> values) {
            addCriterion("catelog_icon not in", values, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconBetween(String value1, String value2) {
            addCriterion("catelog_icon between", value1, value2, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogIconNotBetween(String value1, String value2) {
            addCriterion("catelog_icon not between", value1, value2, "catelogIcon");
            return (Criteria) this;
        }

        public Criteria andCatelogNameIsNull() {
            addCriterion("catelog_name is null");
            return (Criteria) this;
        }

        public Criteria andCatelogNameIsNotNull() {
            addCriterion("catelog_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatelogNameEqualTo(String value) {
            addCriterion("catelog_name =", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotEqualTo(String value) {
            addCriterion("catelog_name <>", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameGreaterThan(String value) {
            addCriterion("catelog_name >", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameGreaterThanOrEqualTo(String value) {
            addCriterion("catelog_name >=", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameLessThan(String value) {
            addCriterion("catelog_name <", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameLessThanOrEqualTo(String value) {
            addCriterion("catelog_name <=", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameLike(String value) {
            addCriterion("catelog_name like", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotLike(String value) {
            addCriterion("catelog_name not like", value, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameIn(List<String> values) {
            addCriterion("catelog_name in", values, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotIn(List<String> values) {
            addCriterion("catelog_name not in", values, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameBetween(String value1, String value2) {
            addCriterion("catelog_name between", value1, value2, "catelogName");
            return (Criteria) this;
        }

        public Criteria andCatelogNameNotBetween(String value1, String value2) {
            addCriterion("catelog_name not between", value1, value2, "catelogName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Boolean value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Boolean value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Boolean value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Boolean value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Boolean> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Boolean> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDisableStatusIsNull() {
            addCriterion("disable_status is null");
            return (Criteria) this;
        }

        public Criteria andDisableStatusIsNotNull() {
            addCriterion("disable_status is not null");
            return (Criteria) this;
        }

        public Criteria andDisableStatusEqualTo(Boolean value) {
            addCriterion("disable_status =", value, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusNotEqualTo(Boolean value) {
            addCriterion("disable_status <>", value, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusGreaterThan(Boolean value) {
            addCriterion("disable_status >", value, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("disable_status >=", value, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusLessThan(Boolean value) {
            addCriterion("disable_status <", value, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("disable_status <=", value, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusIn(List<Boolean> values) {
            addCriterion("disable_status in", values, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusNotIn(List<Boolean> values) {
            addCriterion("disable_status not in", values, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("disable_status between", value1, value2, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andDisableStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("disable_status not between", value1, value2, "disableStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Status value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Status value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Status value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Status value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Status value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Status value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Status> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Status> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Status value1, Status value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Status value1, Status value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdIsNull() {
            addCriterion("created_by_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdIsNotNull() {
            addCriterion("created_by_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdEqualTo(Long value) {
            addCriterion("created_by_id =", value, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdNotEqualTo(Long value) {
            addCriterion("created_by_id <>", value, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdGreaterThan(Long value) {
            addCriterion("created_by_id >", value, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdGreaterThanOrEqualTo(Long value) {
            addCriterion("created_by_id >=", value, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdLessThan(Long value) {
            addCriterion("created_by_id <", value, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdLessThanOrEqualTo(Long value) {
            addCriterion("created_by_id <=", value, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdIn(List<Long> values) {
            addCriterion("created_by_id in", values, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdNotIn(List<Long> values) {
            addCriterion("created_by_id not in", values, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdBetween(Long value1, Long value2) {
            addCriterion("created_by_id between", value1, value2, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedByIdNotBetween(Long value1, Long value2) {
            addCriterion("created_by_id not between", value1, value2, "createdById");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Long value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Long value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Long value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Long value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Long value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Long> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Long> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Long value1, Long value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Long value1, Long value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdIsNull() {
            addCriterion("updated_by_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdIsNotNull() {
            addCriterion("updated_by_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdEqualTo(Long value) {
            addCriterion("updated_by_id =", value, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdNotEqualTo(Long value) {
            addCriterion("updated_by_id <>", value, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdGreaterThan(Long value) {
            addCriterion("updated_by_id >", value, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdGreaterThanOrEqualTo(Long value) {
            addCriterion("updated_by_id >=", value, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdLessThan(Long value) {
            addCriterion("updated_by_id <", value, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdLessThanOrEqualTo(Long value) {
            addCriterion("updated_by_id <=", value, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdIn(List<Long> values) {
            addCriterion("updated_by_id in", values, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdNotIn(List<Long> values) {
            addCriterion("updated_by_id not in", values, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdBetween(Long value1, Long value2) {
            addCriterion("updated_by_id between", value1, value2, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIdNotBetween(Long value1, Long value2) {
            addCriterion("updated_by_id not between", value1, value2, "updatedById");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Long value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Long value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Long value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Long value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Long value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Long> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Long> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Long value1, Long value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Long value1, Long value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNull() {
            addCriterion("last_update is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNotNull() {
            addCriterion("last_update is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateEqualTo(Date value) {
            addCriterion("last_update =", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotEqualTo(Date value) {
            addCriterion("last_update <>", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThan(Date value) {
            addCriterion("last_update >", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update >=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThan(Date value) {
            addCriterion("last_update <", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThanOrEqualTo(Date value) {
            addCriterion("last_update <=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIn(List<Date> values) {
            addCriterion("last_update in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotIn(List<Date> values) {
            addCriterion("last_update not in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateBetween(Date value1, Date value2) {
            addCriterion("last_update between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotBetween(Date value1, Date value2) {
            addCriterion("last_update not between", value1, value2, "lastUpdate");
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