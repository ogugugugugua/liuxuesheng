package scut.yulin.trip.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public TransportationExample() {
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
            addCriterion("transportation.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("transportation.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("transportation.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("transportation.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("transportation.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transportation.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("transportation.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("transportation.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("transportation.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("transportation.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("transportation.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("transportation.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("transportation.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("transportation.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("transportation.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("transportation.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("transportation.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("transportation.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("transportation.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("transportation.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("transportation.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("transportation.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("transportation.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("transportation.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("transportation.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNull() {
            addCriterion("transportation.schedule_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNotNull() {
            addCriterion("transportation.schedule_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidEqualTo(String value) {
            addCriterion("transportation.schedule_uuid =", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotEqualTo(String value) {
            addCriterion("transportation.schedule_uuid <>", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThan(String value) {
            addCriterion("transportation.schedule_uuid >", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.schedule_uuid >=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThan(String value) {
            addCriterion("transportation.schedule_uuid <", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThanOrEqualTo(String value) {
            addCriterion("transportation.schedule_uuid <=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLike(String value) {
            addCriterion("transportation.schedule_uuid like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotLike(String value) {
            addCriterion("transportation.schedule_uuid not like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIn(List<String> values) {
            addCriterion("transportation.schedule_uuid in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotIn(List<String> values) {
            addCriterion("transportation.schedule_uuid not in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidBetween(String value1, String value2) {
            addCriterion("transportation.schedule_uuid between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotBetween(String value1, String value2) {
            addCriterion("transportation.schedule_uuid not between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNull() {
            addCriterion("transportation.schedule_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNotNull() {
            addCriterion("transportation.schedule_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidEqualTo(String value) {
            addCriterion("transportation.schedule_type_uuid =", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotEqualTo(String value) {
            addCriterion("transportation.schedule_type_uuid <>", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThan(String value) {
            addCriterion("transportation.schedule_type_uuid >", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.schedule_type_uuid >=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThan(String value) {
            addCriterion("transportation.schedule_type_uuid <", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("transportation.schedule_type_uuid <=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLike(String value) {
            addCriterion("transportation.schedule_type_uuid like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotLike(String value) {
            addCriterion("transportation.schedule_type_uuid not like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIn(List<String> values) {
            addCriterion("transportation.schedule_type_uuid in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotIn(List<String> values) {
            addCriterion("transportation.schedule_type_uuid not in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidBetween(String value1, String value2) {
            addCriterion("transportation.schedule_type_uuid between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotBetween(String value1, String value2) {
            addCriterion("transportation.schedule_type_uuid not between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidIsNull() {
            addCriterion("transportation.transportation_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidIsNotNull() {
            addCriterion("transportation.transportation_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidEqualTo(String value) {
            addCriterion("transportation.transportation_type_uuid =", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotEqualTo(String value) {
            addCriterion("transportation.transportation_type_uuid <>", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidGreaterThan(String value) {
            addCriterion("transportation.transportation_type_uuid >", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.transportation_type_uuid >=", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidLessThan(String value) {
            addCriterion("transportation.transportation_type_uuid <", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("transportation.transportation_type_uuid <=", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidLike(String value) {
            addCriterion("transportation.transportation_type_uuid like", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotLike(String value) {
            addCriterion("transportation.transportation_type_uuid not like", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidIn(List<String> values) {
            addCriterion("transportation.transportation_type_uuid in", values, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotIn(List<String> values) {
            addCriterion("transportation.transportation_type_uuid not in", values, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidBetween(String value1, String value2) {
            addCriterion("transportation.transportation_type_uuid between", value1, value2, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotBetween(String value1, String value2) {
            addCriterion("transportation.transportation_type_uuid not between", value1, value2, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIsNull() {
            addCriterion("transportation.default_price is null");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIsNotNull() {
            addCriterion("transportation.default_price is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceEqualTo(BigDecimal value) {
            addCriterion("transportation.default_price =", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotEqualTo(BigDecimal value) {
            addCriterion("transportation.default_price <>", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceGreaterThan(BigDecimal value) {
            addCriterion("transportation.default_price >", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("transportation.default_price >=", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceLessThan(BigDecimal value) {
            addCriterion("transportation.default_price <", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("transportation.default_price <=", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIn(List<BigDecimal> values) {
            addCriterion("transportation.default_price in", values, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotIn(List<BigDecimal> values) {
            addCriterion("transportation.default_price not in", values, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transportation.default_price between", value1, value2, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("transportation.default_price not between", value1, value2, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberIsNull() {
            addCriterion("transportation.vehicle_number is null");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberIsNotNull() {
            addCriterion("transportation.vehicle_number is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberEqualTo(String value) {
            addCriterion("transportation.vehicle_number =", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberNotEqualTo(String value) {
            addCriterion("transportation.vehicle_number <>", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberGreaterThan(String value) {
            addCriterion("transportation.vehicle_number >", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.vehicle_number >=", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberLessThan(String value) {
            addCriterion("transportation.vehicle_number <", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberLessThanOrEqualTo(String value) {
            addCriterion("transportation.vehicle_number <=", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberLike(String value) {
            addCriterion("transportation.vehicle_number like", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberNotLike(String value) {
            addCriterion("transportation.vehicle_number not like", value, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberIn(List<String> values) {
            addCriterion("transportation.vehicle_number in", values, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberNotIn(List<String> values) {
            addCriterion("transportation.vehicle_number not in", values, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberBetween(String value1, String value2) {
            addCriterion("transportation.vehicle_number between", value1, value2, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andVehicleNumberNotBetween(String value1, String value2) {
            addCriterion("transportation.vehicle_number not between", value1, value2, "vehicleNumber");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationIsNull() {
            addCriterion("transportation.boarding_location is null");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationIsNotNull() {
            addCriterion("transportation.boarding_location is not null");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationEqualTo(String value) {
            addCriterion("transportation.boarding_location =", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationNotEqualTo(String value) {
            addCriterion("transportation.boarding_location <>", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationGreaterThan(String value) {
            addCriterion("transportation.boarding_location >", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.boarding_location >=", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationLessThan(String value) {
            addCriterion("transportation.boarding_location <", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationLessThanOrEqualTo(String value) {
            addCriterion("transportation.boarding_location <=", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationLike(String value) {
            addCriterion("transportation.boarding_location like", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationNotLike(String value) {
            addCriterion("transportation.boarding_location not like", value, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationIn(List<String> values) {
            addCriterion("transportation.boarding_location in", values, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationNotIn(List<String> values) {
            addCriterion("transportation.boarding_location not in", values, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationBetween(String value1, String value2) {
            addCriterion("transportation.boarding_location between", value1, value2, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andBoardingLocationNotBetween(String value1, String value2) {
            addCriterion("transportation.boarding_location not between", value1, value2, "boardingLocation");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNull() {
            addCriterion("transportation.creator_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNotNull() {
            addCriterion("transportation.creator_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidEqualTo(String value) {
            addCriterion("transportation.creator_uuid =", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotEqualTo(String value) {
            addCriterion("transportation.creator_uuid <>", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThan(String value) {
            addCriterion("transportation.creator_uuid >", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.creator_uuid >=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThan(String value) {
            addCriterion("transportation.creator_uuid <", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThanOrEqualTo(String value) {
            addCriterion("transportation.creator_uuid <=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLike(String value) {
            addCriterion("transportation.creator_uuid like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotLike(String value) {
            addCriterion("transportation.creator_uuid not like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIn(List<String> values) {
            addCriterion("transportation.creator_uuid in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotIn(List<String> values) {
            addCriterion("transportation.creator_uuid not in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidBetween(String value1, String value2) {
            addCriterion("transportation.creator_uuid between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotBetween(String value1, String value2) {
            addCriterion("transportation.creator_uuid not between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("transportation.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("transportation.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("transportation.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("transportation.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("transportation.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("transportation.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("transportation.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("transportation.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("transportation.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("transportation.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("transportation.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("transportation.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("transportation.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("transportation.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("transportation.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("transportation.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("transportation.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("transportation.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("transportation.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("transportation.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("transportation.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("transportation.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("transportation.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("transportation.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("transportation.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("transportation.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("transportation.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("transportation.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("transportation.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("transportation.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("transportation.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("transportation.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("transportation.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("transportation.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("transportation.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("transportation.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("transportation.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("transportation.deleted not between", value1, value2, "deleted");
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