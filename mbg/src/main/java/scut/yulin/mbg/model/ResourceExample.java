package scut.yulin.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public ResourceExample() {
        oredCriteria = new ArrayList<>();
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    public void setForUpdate(Boolean forUpdate) {
        this.forUpdate = forUpdate;
    }

    public Boolean getForUpdate() {
        return forUpdate;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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
            addCriterion("resource.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("resource.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("resource.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("resource.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("resource.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resource.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("resource.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("resource.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("resource.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("resource.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("resource.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("resource.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("resource.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("resource.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("resource.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("resource.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("resource.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("resource.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("resource.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("resource.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("resource.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("resource.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("resource.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("resource.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("resource.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("resource.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidIsNull() {
            addCriterion("resource.category_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidIsNotNull() {
            addCriterion("resource.category_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidEqualTo(String value) {
            addCriterion("resource.category_uuid =", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidNotEqualTo(String value) {
            addCriterion("resource.category_uuid <>", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidGreaterThan(String value) {
            addCriterion("resource.category_uuid >", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidGreaterThanOrEqualTo(String value) {
            addCriterion("resource.category_uuid >=", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidLessThan(String value) {
            addCriterion("resource.category_uuid <", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidLessThanOrEqualTo(String value) {
            addCriterion("resource.category_uuid <=", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidLike(String value) {
            addCriterion("resource.category_uuid like", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidNotLike(String value) {
            addCriterion("resource.category_uuid not like", value, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidIn(List<String> values) {
            addCriterion("resource.category_uuid in", values, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidNotIn(List<String> values) {
            addCriterion("resource.category_uuid not in", values, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidBetween(String value1, String value2) {
            addCriterion("resource.category_uuid between", value1, value2, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andCategoryUuidNotBetween(String value1, String value2) {
            addCriterion("resource.category_uuid not between", value1, value2, "categoryUuid");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("resource.url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("resource.url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("resource.url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("resource.url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("resource.url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("resource.url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("resource.url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("resource.url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("resource.url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("resource.url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("resource.url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("resource.url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("resource.url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("resource.url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("resource.`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("resource.`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("resource.`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("resource.`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("resource.`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource.`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("resource.`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("resource.`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("resource.`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("resource.`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("resource.`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("resource.`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("resource.`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("resource.`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("resource.description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("resource.description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("resource.description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("resource.description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("resource.description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("resource.description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("resource.description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("resource.description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("resource.description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("resource.description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("resource.description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("resource.description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("resource.description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("resource.description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("resource.`path` is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("resource.`path` is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("resource.`path` =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("resource.`path` <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("resource.`path` >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("resource.`path` >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("resource.`path` <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("resource.`path` <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("resource.`path` like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("resource.`path` not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("resource.`path` in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("resource.`path` not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("resource.`path` between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("resource.`path` not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andComponentIsNull() {
            addCriterion("resource.component is null");
            return (Criteria) this;
        }

        public Criteria andComponentIsNotNull() {
            addCriterion("resource.component is not null");
            return (Criteria) this;
        }

        public Criteria andComponentEqualTo(String value) {
            addCriterion("resource.component =", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotEqualTo(String value) {
            addCriterion("resource.component <>", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThan(String value) {
            addCriterion("resource.component >", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThanOrEqualTo(String value) {
            addCriterion("resource.component >=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThan(String value) {
            addCriterion("resource.component <", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThanOrEqualTo(String value) {
            addCriterion("resource.component <=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLike(String value) {
            addCriterion("resource.component like", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotLike(String value) {
            addCriterion("resource.component not like", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentIn(List<String> values) {
            addCriterion("resource.component in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotIn(List<String> values) {
            addCriterion("resource.component not in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentBetween(String value1, String value2) {
            addCriterion("resource.component between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotBetween(String value1, String value2) {
            addCriterion("resource.component not between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andIconclsIsNull() {
            addCriterion("resource.iconCls is null");
            return (Criteria) this;
        }

        public Criteria andIconclsIsNotNull() {
            addCriterion("resource.iconCls is not null");
            return (Criteria) this;
        }

        public Criteria andIconclsEqualTo(String value) {
            addCriterion("resource.iconCls =", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotEqualTo(String value) {
            addCriterion("resource.iconCls <>", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsGreaterThan(String value) {
            addCriterion("resource.iconCls >", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsGreaterThanOrEqualTo(String value) {
            addCriterion("resource.iconCls >=", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsLessThan(String value) {
            addCriterion("resource.iconCls <", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsLessThanOrEqualTo(String value) {
            addCriterion("resource.iconCls <=", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsLike(String value) {
            addCriterion("resource.iconCls like", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotLike(String value) {
            addCriterion("resource.iconCls not like", value, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsIn(List<String> values) {
            addCriterion("resource.iconCls in", values, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotIn(List<String> values) {
            addCriterion("resource.iconCls not in", values, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsBetween(String value1, String value2) {
            addCriterion("resource.iconCls between", value1, value2, "iconcls");
            return (Criteria) this;
        }

        public Criteria andIconclsNotBetween(String value1, String value2) {
            addCriterion("resource.iconCls not between", value1, value2, "iconcls");
            return (Criteria) this;
        }

        public Criteria andKeepaliveIsNull() {
            addCriterion("resource.keepAlive is null");
            return (Criteria) this;
        }

        public Criteria andKeepaliveIsNotNull() {
            addCriterion("resource.keepAlive is not null");
            return (Criteria) this;
        }

        public Criteria andKeepaliveEqualTo(String value) {
            addCriterion("resource.keepAlive =", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveNotEqualTo(String value) {
            addCriterion("resource.keepAlive <>", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveGreaterThan(String value) {
            addCriterion("resource.keepAlive >", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveGreaterThanOrEqualTo(String value) {
            addCriterion("resource.keepAlive >=", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveLessThan(String value) {
            addCriterion("resource.keepAlive <", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveLessThanOrEqualTo(String value) {
            addCriterion("resource.keepAlive <=", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveLike(String value) {
            addCriterion("resource.keepAlive like", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveNotLike(String value) {
            addCriterion("resource.keepAlive not like", value, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveIn(List<String> values) {
            addCriterion("resource.keepAlive in", values, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveNotIn(List<String> values) {
            addCriterion("resource.keepAlive not in", values, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveBetween(String value1, String value2) {
            addCriterion("resource.keepAlive between", value1, value2, "keepalive");
            return (Criteria) this;
        }

        public Criteria andKeepaliveNotBetween(String value1, String value2) {
            addCriterion("resource.keepAlive not between", value1, value2, "keepalive");
            return (Criteria) this;
        }

        public Criteria andRequireauthIsNull() {
            addCriterion("resource.requireAuth is null");
            return (Criteria) this;
        }

        public Criteria andRequireauthIsNotNull() {
            addCriterion("resource.requireAuth is not null");
            return (Criteria) this;
        }

        public Criteria andRequireauthEqualTo(String value) {
            addCriterion("resource.requireAuth =", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthNotEqualTo(String value) {
            addCriterion("resource.requireAuth <>", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthGreaterThan(String value) {
            addCriterion("resource.requireAuth >", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthGreaterThanOrEqualTo(String value) {
            addCriterion("resource.requireAuth >=", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthLessThan(String value) {
            addCriterion("resource.requireAuth <", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthLessThanOrEqualTo(String value) {
            addCriterion("resource.requireAuth <=", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthLike(String value) {
            addCriterion("resource.requireAuth like", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthNotLike(String value) {
            addCriterion("resource.requireAuth not like", value, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthIn(List<String> values) {
            addCriterion("resource.requireAuth in", values, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthNotIn(List<String> values) {
            addCriterion("resource.requireAuth not in", values, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthBetween(String value1, String value2) {
            addCriterion("resource.requireAuth between", value1, value2, "requireauth");
            return (Criteria) this;
        }

        public Criteria andRequireauthNotBetween(String value1, String value2) {
            addCriterion("resource.requireAuth not between", value1, value2, "requireauth");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("resource.parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("resource.parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("resource.parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("resource.parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("resource.parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("resource.parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("resource.parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("resource.parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("resource.parentId like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("resource.parentId not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("resource.parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("resource.parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("resource.parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("resource.parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("resource.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("resource.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("resource.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("resource.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("resource.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resource.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("resource.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("resource.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("resource.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("resource.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("resource.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("resource.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("resource.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("resource.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("resource.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("resource.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("resource.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("resource.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("resource.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("resource.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("resource.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("resource.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("resource.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("resource.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("resource.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("resource.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("resource.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("resource.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("resource.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("resource.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("resource.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("resource.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("resource.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("resource.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("resource.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("resource.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("resource.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("resource.deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }
    }

    /**
     */
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