package scut.yulin.trip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class VehicleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public VehicleExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("vehicle.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("vehicle.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("vehicle.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("vehicle.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("vehicle.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("vehicle.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("vehicle.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("vehicle.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("vehicle.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("vehicle.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("vehicle.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("vehicle.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("vehicle.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("vehicle.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("vehicle.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("vehicle.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("vehicle.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("vehicle.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("vehicle.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("vehicle.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("vehicle.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("vehicle.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("vehicle.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("vehicle.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("vehicle.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNull() {
            addCriterion("vehicle.schedule_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNotNull() {
            addCriterion("vehicle.schedule_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidEqualTo(String value) {
            addCriterion("vehicle.schedule_type_uuid =", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotEqualTo(String value) {
            addCriterion("vehicle.schedule_type_uuid <>", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThan(String value) {
            addCriterion("vehicle.schedule_type_uuid >", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.schedule_type_uuid >=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThan(String value) {
            addCriterion("vehicle.schedule_type_uuid <", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("vehicle.schedule_type_uuid <=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLike(String value) {
            addCriterion("vehicle.schedule_type_uuid like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotLike(String value) {
            addCriterion("vehicle.schedule_type_uuid not like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIn(List<String> values) {
            addCriterion("vehicle.schedule_type_uuid in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotIn(List<String> values) {
            addCriterion("vehicle.schedule_type_uuid not in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidBetween(String value1, String value2) {
            addCriterion("vehicle.schedule_type_uuid between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotBetween(String value1, String value2) {
            addCriterion("vehicle.schedule_type_uuid not between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidIsNull() {
            addCriterion("vehicle.transportation_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidIsNotNull() {
            addCriterion("vehicle.transportation_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidEqualTo(String value) {
            addCriterion("vehicle.transportation_type_uuid =", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotEqualTo(String value) {
            addCriterion("vehicle.transportation_type_uuid <>", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidGreaterThan(String value) {
            addCriterion("vehicle.transportation_type_uuid >", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.transportation_type_uuid >=", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidLessThan(String value) {
            addCriterion("vehicle.transportation_type_uuid <", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("vehicle.transportation_type_uuid <=", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidLike(String value) {
            addCriterion("vehicle.transportation_type_uuid like", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotLike(String value) {
            addCriterion("vehicle.transportation_type_uuid not like", value, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidIn(List<String> values) {
            addCriterion("vehicle.transportation_type_uuid in", values, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotIn(List<String> values) {
            addCriterion("vehicle.transportation_type_uuid not in", values, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidBetween(String value1, String value2) {
            addCriterion("vehicle.transportation_type_uuid between", value1, value2, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andTransportationTypeUuidNotBetween(String value1, String value2) {
            addCriterion("vehicle.transportation_type_uuid not between", value1, value2, "transportationTypeUuid");
            return (Criteria) this;
        }

        public Criteria andLocalNameIsNull() {
            addCriterion("vehicle.local_name is null");
            return (Criteria) this;
        }

        public Criteria andLocalNameIsNotNull() {
            addCriterion("vehicle.local_name is not null");
            return (Criteria) this;
        }

        public Criteria andLocalNameEqualTo(String value) {
            addCriterion("vehicle.local_name =", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotEqualTo(String value) {
            addCriterion("vehicle.local_name <>", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameGreaterThan(String value) {
            addCriterion("vehicle.local_name >", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.local_name >=", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameLessThan(String value) {
            addCriterion("vehicle.local_name <", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameLessThanOrEqualTo(String value) {
            addCriterion("vehicle.local_name <=", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameLike(String value) {
            addCriterion("vehicle.local_name like", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotLike(String value) {
            addCriterion("vehicle.local_name not like", value, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameIn(List<String> values) {
            addCriterion("vehicle.local_name in", values, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotIn(List<String> values) {
            addCriterion("vehicle.local_name not in", values, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameBetween(String value1, String value2) {
            addCriterion("vehicle.local_name between", value1, value2, "localName");
            return (Criteria) this;
        }

        public Criteria andLocalNameNotBetween(String value1, String value2) {
            addCriterion("vehicle.local_name not between", value1, value2, "localName");
            return (Criteria) this;
        }

        public Criteria andCnNameIsNull() {
            addCriterion("vehicle.cn_name is null");
            return (Criteria) this;
        }

        public Criteria andCnNameIsNotNull() {
            addCriterion("vehicle.cn_name is not null");
            return (Criteria) this;
        }

        public Criteria andCnNameEqualTo(String value) {
            addCriterion("vehicle.cn_name =", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotEqualTo(String value) {
            addCriterion("vehicle.cn_name <>", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameGreaterThan(String value) {
            addCriterion("vehicle.cn_name >", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.cn_name >=", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLessThan(String value) {
            addCriterion("vehicle.cn_name <", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLessThanOrEqualTo(String value) {
            addCriterion("vehicle.cn_name <=", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameLike(String value) {
            addCriterion("vehicle.cn_name like", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotLike(String value) {
            addCriterion("vehicle.cn_name not like", value, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameIn(List<String> values) {
            addCriterion("vehicle.cn_name in", values, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotIn(List<String> values) {
            addCriterion("vehicle.cn_name not in", values, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameBetween(String value1, String value2) {
            addCriterion("vehicle.cn_name between", value1, value2, "cnName");
            return (Criteria) this;
        }

        public Criteria andCnNameNotBetween(String value1, String value2) {
            addCriterion("vehicle.cn_name not between", value1, value2, "cnName");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialIsNull() {
            addCriterion("vehicle.vehicle_serial is null");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialIsNotNull() {
            addCriterion("vehicle.vehicle_serial is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialEqualTo(String value) {
            addCriterion("vehicle.vehicle_serial =", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialNotEqualTo(String value) {
            addCriterion("vehicle.vehicle_serial <>", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialGreaterThan(String value) {
            addCriterion("vehicle.vehicle_serial >", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.vehicle_serial >=", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialLessThan(String value) {
            addCriterion("vehicle.vehicle_serial <", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialLessThanOrEqualTo(String value) {
            addCriterion("vehicle.vehicle_serial <=", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialLike(String value) {
            addCriterion("vehicle.vehicle_serial like", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialNotLike(String value) {
            addCriterion("vehicle.vehicle_serial not like", value, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialIn(List<String> values) {
            addCriterion("vehicle.vehicle_serial in", values, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialNotIn(List<String> values) {
            addCriterion("vehicle.vehicle_serial not in", values, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialBetween(String value1, String value2) {
            addCriterion("vehicle.vehicle_serial between", value1, value2, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andVehicleSerialNotBetween(String value1, String value2) {
            addCriterion("vehicle.vehicle_serial not between", value1, value2, "vehicleSerial");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("vehicle.departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("vehicle.departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterion("vehicle.departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterion("vehicle.departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterion("vehicle.departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vehicle.departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterion("vehicle.departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterion("vehicle.departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterion("vehicle.departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterion("vehicle.departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterion("vehicle.departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterion("vehicle.departure_time not between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("vehicle.duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("vehicle.duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Date value) {
            addCriterionForJDBCTime("vehicle.duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Date value) {
            addCriterionForJDBCTime("vehicle.duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Date value) {
            addCriterionForJDBCTime("vehicle.duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("vehicle.duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Date value) {
            addCriterionForJDBCTime("vehicle.duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("vehicle.duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Date> values) {
            addCriterionForJDBCTime("vehicle.duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Date> values) {
            addCriterionForJDBCTime("vehicle.duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("vehicle.duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("vehicle.duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNull() {
            addCriterion("vehicle.arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNotNull() {
            addCriterion("vehicle.arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeEqualTo(Date value) {
            addCriterion("vehicle.arrival_time =", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotEqualTo(Date value) {
            addCriterion("vehicle.arrival_time <>", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThan(Date value) {
            addCriterion("vehicle.arrival_time >", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vehicle.arrival_time >=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThan(Date value) {
            addCriterion("vehicle.arrival_time <", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThanOrEqualTo(Date value) {
            addCriterion("vehicle.arrival_time <=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIn(List<Date> values) {
            addCriterion("vehicle.arrival_time in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotIn(List<Date> values) {
            addCriterion("vehicle.arrival_time not in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeBetween(Date value1, Date value2) {
            addCriterion("vehicle.arrival_time between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotBetween(Date value1, Date value2) {
            addCriterion("vehicle.arrival_time not between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationIsNull() {
            addCriterion("vehicle.departure_location is null");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationIsNotNull() {
            addCriterion("vehicle.departure_location is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationEqualTo(String value) {
            addCriterion("vehicle.departure_location =", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationNotEqualTo(String value) {
            addCriterion("vehicle.departure_location <>", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationGreaterThan(String value) {
            addCriterion("vehicle.departure_location >", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.departure_location >=", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationLessThan(String value) {
            addCriterion("vehicle.departure_location <", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationLessThanOrEqualTo(String value) {
            addCriterion("vehicle.departure_location <=", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationLike(String value) {
            addCriterion("vehicle.departure_location like", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationNotLike(String value) {
            addCriterion("vehicle.departure_location not like", value, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationIn(List<String> values) {
            addCriterion("vehicle.departure_location in", values, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationNotIn(List<String> values) {
            addCriterion("vehicle.departure_location not in", values, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationBetween(String value1, String value2) {
            addCriterion("vehicle.departure_location between", value1, value2, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andDepartureLocationNotBetween(String value1, String value2) {
            addCriterion("vehicle.departure_location not between", value1, value2, "departureLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationIsNull() {
            addCriterion("vehicle.arrival_location is null");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationIsNotNull() {
            addCriterion("vehicle.arrival_location is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationEqualTo(String value) {
            addCriterion("vehicle.arrival_location =", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationNotEqualTo(String value) {
            addCriterion("vehicle.arrival_location <>", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationGreaterThan(String value) {
            addCriterion("vehicle.arrival_location >", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.arrival_location >=", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationLessThan(String value) {
            addCriterion("vehicle.arrival_location <", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationLessThanOrEqualTo(String value) {
            addCriterion("vehicle.arrival_location <=", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationLike(String value) {
            addCriterion("vehicle.arrival_location like", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationNotLike(String value) {
            addCriterion("vehicle.arrival_location not like", value, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationIn(List<String> values) {
            addCriterion("vehicle.arrival_location in", values, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationNotIn(List<String> values) {
            addCriterion("vehicle.arrival_location not in", values, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationBetween(String value1, String value2) {
            addCriterion("vehicle.arrival_location between", value1, value2, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andArrivalLocationNotBetween(String value1, String value2) {
            addCriterion("vehicle.arrival_location not between", value1, value2, "arrivalLocation");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("vehicle.grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("vehicle.grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("vehicle.grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("vehicle.grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("vehicle.grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("vehicle.grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("vehicle.grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("vehicle.grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("vehicle.grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("vehicle.grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("vehicle.grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("vehicle.grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("vehicle.grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("vehicle.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("vehicle.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("vehicle.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("vehicle.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("vehicle.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vehicle.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("vehicle.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("vehicle.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("vehicle.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("vehicle.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("vehicle.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("vehicle.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("vehicle.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("vehicle.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("vehicle.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("vehicle.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("vehicle.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vehicle.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("vehicle.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("vehicle.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("vehicle.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("vehicle.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("vehicle.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("vehicle.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("vehicle.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("vehicle.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("vehicle.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("vehicle.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("vehicle.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("vehicle.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("vehicle.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("vehicle.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("vehicle.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("vehicle.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("vehicle.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("vehicle.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("vehicle.deleted not between", value1, value2, "deleted");
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