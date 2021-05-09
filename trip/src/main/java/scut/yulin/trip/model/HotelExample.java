package scut.yulin.trip.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public HotelExample() {
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
            addCriterion("hotel.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("hotel.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("hotel.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("hotel.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("hotel.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("hotel.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("hotel.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("hotel.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("hotel.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("hotel.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("hotel.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("hotel.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("hotel.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("hotel.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("hotel.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("hotel.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("hotel.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("hotel.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("hotel.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("hotel.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("hotel.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("hotel.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNull() {
            addCriterion("hotel.schedule_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNotNull() {
            addCriterion("hotel.schedule_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidEqualTo(String value) {
            addCriterion("hotel.schedule_type_uuid =", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotEqualTo(String value) {
            addCriterion("hotel.schedule_type_uuid <>", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThan(String value) {
            addCriterion("hotel.schedule_type_uuid >", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.schedule_type_uuid >=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThan(String value) {
            addCriterion("hotel.schedule_type_uuid <", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("hotel.schedule_type_uuid <=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLike(String value) {
            addCriterion("hotel.schedule_type_uuid like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotLike(String value) {
            addCriterion("hotel.schedule_type_uuid not like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIn(List<String> values) {
            addCriterion("hotel.schedule_type_uuid in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotIn(List<String> values) {
            addCriterion("hotel.schedule_type_uuid not in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidBetween(String value1, String value2) {
            addCriterion("hotel.schedule_type_uuid between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotBetween(String value1, String value2) {
            addCriterion("hotel.schedule_type_uuid not between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andStarsIsNull() {
            addCriterion("hotel.stars is null");
            return (Criteria) this;
        }

        public Criteria andStarsIsNotNull() {
            addCriterion("hotel.stars is not null");
            return (Criteria) this;
        }

        public Criteria andStarsEqualTo(Integer value) {
            addCriterion("hotel.stars =", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsNotEqualTo(Integer value) {
            addCriterion("hotel.stars <>", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsGreaterThan(Integer value) {
            addCriterion("hotel.stars >", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel.stars >=", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsLessThan(Integer value) {
            addCriterion("hotel.stars <", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsLessThanOrEqualTo(Integer value) {
            addCriterion("hotel.stars <=", value, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsIn(List<Integer> values) {
            addCriterion("hotel.stars in", values, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsNotIn(List<Integer> values) {
            addCriterion("hotel.stars not in", values, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsBetween(Integer value1, Integer value2) {
            addCriterion("hotel.stars between", value1, value2, "stars");
            return (Criteria) this;
        }

        public Criteria andStarsNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel.stars not between", value1, value2, "stars");
            return (Criteria) this;
        }

        public Criteria andLocalNameIsNull() {
            addCriterion("hotel.local_name is null");
            return (Criteria) this;
        }

        public Criteria andLocalNameIsNotNull() {
            addCriterion("hotel.local_name is not null");
            return (Criteria) this;
        }

        public Criteria andLocalNameEqualTo(String value) {
            addCriterion("hotel.local_name =", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotEqualTo(String value) {
            addCriterion("hotel.local_name <>", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameGreaterThan(String value) {
            addCriterion("hotel.local_name >", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.local_name >=", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameLessThan(String value) {
            addCriterion("hotel.local_name <", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameLessThanOrEqualTo(String value) {
            addCriterion("hotel.local_name <=", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameLike(String value) {
            addCriterion("hotel.local_name like", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotLike(String value) {
            addCriterion("hotel.local_name not like", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameIn(List<String> values) {
            addCriterion("hotel.local_name in", values, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotIn(List<String> values) {
            addCriterion("hotel.local_name not in", values, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameBetween(String value1, String value2) {
            addCriterion("hotel.local_name between", value1, value2, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotBetween(String value1, String value2) {
            addCriterion("hotel.local_name not between", value1, value2, "localName");
            return (Criteria) this;
        }

        public Criteria andCnNameIsNull() {
            addCriterion("hotel.cn_name is null");
            return (Criteria) this;
        }

        public Criteria andCnNameIsNotNull() {
            addCriterion("hotel.cn_name is not null");
            return (Criteria) this;
        }

        public Criteria andCnNameEqualTo(String value) {
            addCriterion("hotel.cn_name =", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotEqualTo(String value) {
            addCriterion("hotel.cn_name <>", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameGreaterThan(String value) {
            addCriterion("hotel.cn_name >", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.cn_name >=", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLessThan(String value) {
            addCriterion("hotel.cn_name <", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLessThanOrEqualTo(String value) {
            addCriterion("hotel.cn_name <=", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLike(String value) {
            addCriterion("hotel.cn_name like", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotLike(String value) {
            addCriterion("hotel.cn_name not like", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameIn(List<String> values) {
            addCriterion("hotel.cn_name in", values, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotIn(List<String> values) {
            addCriterion("hotel.cn_name not in", values, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameBetween(String value1, String value2) {
            addCriterion("hotel.cn_name between", value1, value2, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotBetween(String value1, String value2) {
            addCriterion("hotel.cn_name not between", value1, value2, "cnName");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("hotel.city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("hotel.city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("hotel.city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("hotel.city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("hotel.city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("hotel.city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("hotel.city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("hotel.city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("hotel.city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("hotel.city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("hotel.city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("hotel.city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("hotel.city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountryUuidIsNull() {
            addCriterion("hotel.country_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCountryUuidIsNotNull() {
            addCriterion("hotel.country_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCountryUuidEqualTo(String value) {
            addCriterion("hotel.country_uuid =", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidNotEqualTo(String value) {
            addCriterion("hotel.country_uuid <>", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidGreaterThan(String value) {
            addCriterion("hotel.country_uuid >", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.country_uuid >=", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidLessThan(String value) {
            addCriterion("hotel.country_uuid <", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidLessThanOrEqualTo(String value) {
            addCriterion("hotel.country_uuid <=", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidLike(String value) {
            addCriterion("hotel.country_uuid like", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidNotLike(String value) {
            addCriterion("hotel.country_uuid not like", value, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidIn(List<String> values) {
            addCriterion("hotel.country_uuid in", values, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidNotIn(List<String> values) {
            addCriterion("hotel.country_uuid not in", values, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidBetween(String value1, String value2) {
            addCriterion("hotel.country_uuid between", value1, value2, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andCountryUuidNotBetween(String value1, String value2) {
            addCriterion("hotel.country_uuid not between", value1, value2, "countryUuid");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("hotel.`location` is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("hotel.`location` is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("hotel.`location` =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("hotel.`location` <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("hotel.`location` >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.`location` >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("hotel.`location` <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("hotel.`location` <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("hotel.`location` like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("hotel.`location` not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("hotel.`location` in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("hotel.`location` not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("hotel.`location` between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("hotel.`location` not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andRatingIsNull() {
            addCriterion("hotel.rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("hotel.rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(BigDecimal value) {
            addCriterion("hotel.rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(BigDecimal value) {
            addCriterion("hotel.rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(BigDecimal value) {
            addCriterion("hotel.rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hotel.rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(BigDecimal value) {
            addCriterion("hotel.rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hotel.rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<BigDecimal> values) {
            addCriterion("hotel.rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<BigDecimal> values) {
            addCriterion("hotel.rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hotel.rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hotel.rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("hotel.url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("hotel.url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("hotel.url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("hotel.url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("hotel.url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("hotel.url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("hotel.url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("hotel.url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("hotel.url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("hotel.url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("hotel.url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("hotel.url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("hotel.url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNull() {
            addCriterion("hotel.check_in_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIsNotNull() {
            addCriterion("hotel.check_in_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeEqualTo(String value) {
            addCriterion("hotel.check_in_time =", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotEqualTo(String value) {
            addCriterion("hotel.check_in_time <>", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThan(String value) {
            addCriterion("hotel.check_in_time >", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.check_in_time >=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThan(String value) {
            addCriterion("hotel.check_in_time <", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLessThanOrEqualTo(String value) {
            addCriterion("hotel.check_in_time <=", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeLike(String value) {
            addCriterion("hotel.check_in_time like", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotLike(String value) {
            addCriterion("hotel.check_in_time not like", value, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeIn(List<String> values) {
            addCriterion("hotel.check_in_time in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotIn(List<String> values) {
            addCriterion("hotel.check_in_time not in", values, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeBetween(String value1, String value2) {
            addCriterion("hotel.check_in_time between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckInTimeNotBetween(String value1, String value2) {
            addCriterion("hotel.check_in_time not between", value1, value2, "checkInTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeIsNull() {
            addCriterion("hotel.check_out_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeIsNotNull() {
            addCriterion("hotel.check_out_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeEqualTo(String value) {
            addCriterion("hotel.check_out_time =", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeNotEqualTo(String value) {
            addCriterion("hotel.check_out_time <>", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeGreaterThan(String value) {
            addCriterion("hotel.check_out_time >", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.check_out_time >=", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeLessThan(String value) {
            addCriterion("hotel.check_out_time <", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeLessThanOrEqualTo(String value) {
            addCriterion("hotel.check_out_time <=", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeLike(String value) {
            addCriterion("hotel.check_out_time like", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeNotLike(String value) {
            addCriterion("hotel.check_out_time not like", value, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeIn(List<String> values) {
            addCriterion("hotel.check_out_time in", values, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeNotIn(List<String> values) {
            addCriterion("hotel.check_out_time not in", values, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeBetween(String value1, String value2) {
            addCriterion("hotel.check_out_time between", value1, value2, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andCheckOutTimeNotBetween(String value1, String value2) {
            addCriterion("hotel.check_out_time not between", value1, value2, "checkOutTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("hotel.description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("hotel.description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("hotel.description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("hotel.description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("hotel.description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("hotel.description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("hotel.description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("hotel.description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("hotel.description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("hotel.description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("hotel.description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("hotel.description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("hotel.description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("hotel.`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("hotel.`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("hotel.`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("hotel.`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("hotel.`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("hotel.`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("hotel.`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("hotel.`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("hotel.`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("hotel.`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("hotel.`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("hotel.`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("hotel.`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andBuiltYearIsNull() {
            addCriterion("hotel.built_year is null");
            return (Criteria) this;
        }

        public Criteria andBuiltYearIsNotNull() {
            addCriterion("hotel.built_year is not null");
            return (Criteria) this;
        }

        public Criteria andBuiltYearEqualTo(String value) {
            addCriterion("hotel.built_year =", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearNotEqualTo(String value) {
            addCriterion("hotel.built_year <>", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearGreaterThan(String value) {
            addCriterion("hotel.built_year >", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.built_year >=", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearLessThan(String value) {
            addCriterion("hotel.built_year <", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearLessThanOrEqualTo(String value) {
            addCriterion("hotel.built_year <=", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearLike(String value) {
            addCriterion("hotel.built_year like", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearNotLike(String value) {
            addCriterion("hotel.built_year not like", value, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearIn(List<String> values) {
            addCriterion("hotel.built_year in", values, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearNotIn(List<String> values) {
            addCriterion("hotel.built_year not in", values, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearBetween(String value1, String value2) {
            addCriterion("hotel.built_year between", value1, value2, "builtYear");
            return (Criteria) this;
        }

        public Criteria andBuiltYearNotBetween(String value1, String value2) {
            addCriterion("hotel.built_year not between", value1, value2, "builtYear");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("hotel.`scale` is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("hotel.`scale` is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(Integer value) {
            addCriterion("hotel.`scale` =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(Integer value) {
            addCriterion("hotel.`scale` <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(Integer value) {
            addCriterion("hotel.`scale` >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel.`scale` >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(Integer value) {
            addCriterion("hotel.`scale` <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(Integer value) {
            addCriterion("hotel.`scale` <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<Integer> values) {
            addCriterion("hotel.`scale` in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<Integer> values) {
            addCriterion("hotel.`scale` not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(Integer value1, Integer value2) {
            addCriterion("hotel.`scale` between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel.`scale` not between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyIsNull() {
            addCriterion("hotel.cancel_policy is null");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyIsNotNull() {
            addCriterion("hotel.cancel_policy is not null");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyEqualTo(String value) {
            addCriterion("hotel.cancel_policy =", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyNotEqualTo(String value) {
            addCriterion("hotel.cancel_policy <>", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyGreaterThan(String value) {
            addCriterion("hotel.cancel_policy >", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.cancel_policy >=", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyLessThan(String value) {
            addCriterion("hotel.cancel_policy <", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyLessThanOrEqualTo(String value) {
            addCriterion("hotel.cancel_policy <=", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyLike(String value) {
            addCriterion("hotel.cancel_policy like", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyNotLike(String value) {
            addCriterion("hotel.cancel_policy not like", value, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyIn(List<String> values) {
            addCriterion("hotel.cancel_policy in", values, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyNotIn(List<String> values) {
            addCriterion("hotel.cancel_policy not in", values, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyBetween(String value1, String value2) {
            addCriterion("hotel.cancel_policy between", value1, value2, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andCancelPolicyNotBetween(String value1, String value2) {
            addCriterion("hotel.cancel_policy not between", value1, value2, "cancelPolicy");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("hotel.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("hotel.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("hotel.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("hotel.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("hotel.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("hotel.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("hotel.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("hotel.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("hotel.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("hotel.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("hotel.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("hotel.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("hotel.remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("hotel.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("hotel.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("hotel.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("hotel.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("hotel.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hotel.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("hotel.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("hotel.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("hotel.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("hotel.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("hotel.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("hotel.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("hotel.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("hotel.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("hotel.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("hotel.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("hotel.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("hotel.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("hotel.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("hotel.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("hotel.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("hotel.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("hotel.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("hotel.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("hotel.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("hotel.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("hotel.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("hotel.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("hotel.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("hotel.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("hotel.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("hotel.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("hotel.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("hotel.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("hotel.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("hotel.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("hotel.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("hotel.deleted not between", value1, value2, "deleted");
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