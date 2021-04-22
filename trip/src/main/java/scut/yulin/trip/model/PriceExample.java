package scut.yulin.trip.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public PriceExample() {
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
            addCriterion("price.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("price.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("price.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("price.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("price.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("price.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("price.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("price.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("price.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("price.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("price.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("price.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("price.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("price.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("price.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("price.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("price.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("price.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("price.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("price.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("price.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("price.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("price.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("price.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("price.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("price.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNull() {
            addCriterion("price.schedule_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNotNull() {
            addCriterion("price.schedule_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidEqualTo(String value) {
            addCriterion("price.schedule_uuid =", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotEqualTo(String value) {
            addCriterion("price.schedule_uuid <>", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThan(String value) {
            addCriterion("price.schedule_uuid >", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("price.schedule_uuid >=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThan(String value) {
            addCriterion("price.schedule_uuid <", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThanOrEqualTo(String value) {
            addCriterion("price.schedule_uuid <=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLike(String value) {
            addCriterion("price.schedule_uuid like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotLike(String value) {
            addCriterion("price.schedule_uuid not like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIn(List<String> values) {
            addCriterion("price.schedule_uuid in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotIn(List<String> values) {
            addCriterion("price.schedule_uuid not in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidBetween(String value1, String value2) {
            addCriterion("price.schedule_uuid between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotBetween(String value1, String value2) {
            addCriterion("price.schedule_uuid not between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNull() {
            addCriterion("price.schedule_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNotNull() {
            addCriterion("price.schedule_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidEqualTo(String value) {
            addCriterion("price.schedule_type_uuid =", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotEqualTo(String value) {
            addCriterion("price.schedule_type_uuid <>", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThan(String value) {
            addCriterion("price.schedule_type_uuid >", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("price.schedule_type_uuid >=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThan(String value) {
            addCriterion("price.schedule_type_uuid <", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("price.schedule_type_uuid <=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLike(String value) {
            addCriterion("price.schedule_type_uuid like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotLike(String value) {
            addCriterion("price.schedule_type_uuid not like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIn(List<String> values) {
            addCriterion("price.schedule_type_uuid in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotIn(List<String> values) {
            addCriterion("price.schedule_type_uuid not in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidBetween(String value1, String value2) {
            addCriterion("price.schedule_type_uuid between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotBetween(String value1, String value2) {
            addCriterion("price.schedule_type_uuid not between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("price.`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("price.`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("price.`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("price.`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("price.`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("price.`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("price.`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("price.`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("price.`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("price.`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("price.`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("price.`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("price.`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("price.`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("price.original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("price.original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("price.original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("price.original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("price.original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price.original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("price.original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price.original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("price.original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("price.original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price.original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price.original_price not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("price.discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("price.discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("price.discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("price.discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("price.discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price.discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(BigDecimal value) {
            addCriterion("price.discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price.discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("price.discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("price.discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price.discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price.discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNull() {
            addCriterion("price.creator_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNotNull() {
            addCriterion("price.creator_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidEqualTo(String value) {
            addCriterion("price.creator_uuid =", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotEqualTo(String value) {
            addCriterion("price.creator_uuid <>", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThan(String value) {
            addCriterion("price.creator_uuid >", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("price.creator_uuid >=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThan(String value) {
            addCriterion("price.creator_uuid <", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThanOrEqualTo(String value) {
            addCriterion("price.creator_uuid <=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLike(String value) {
            addCriterion("price.creator_uuid like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotLike(String value) {
            addCriterion("price.creator_uuid not like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIn(List<String> values) {
            addCriterion("price.creator_uuid in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotIn(List<String> values) {
            addCriterion("price.creator_uuid not in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidBetween(String value1, String value2) {
            addCriterion("price.creator_uuid between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotBetween(String value1, String value2) {
            addCriterion("price.creator_uuid not between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("price.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("price.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("price.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("price.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("price.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("price.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("price.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("price.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("price.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("price.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("price.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("price.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("price.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("price.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("price.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("price.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("price.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("price.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("price.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("price.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("price.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("price.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("price.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("price.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("price.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("price.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("price.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("price.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("price.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("price.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("price.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("price.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("price.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("price.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("price.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("price.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("price.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("price.deleted not between", value1, value2, "deleted");
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