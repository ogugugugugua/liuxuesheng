package scut.yulin.trip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoutineScheduleRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public RoutineScheduleRelationExample() {
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
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid =", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid <>", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidGreaterThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid >", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidGreaterThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid >=", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidLessThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid <", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidLessThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid <=", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid like", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid not like", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid in", values, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid not in", values, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid between", value1, value2, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.routine_uuid not between", value1, value2, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid =", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid <>", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid >", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid >=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid <", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid <=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid not like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid not in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_uuid not between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid =", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid <>", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid >", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid >=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid <", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid <=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid not like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid not in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_type_uuid not between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial is null");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialEqualTo(Integer value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial =", value, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialNotEqualTo(Integer value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial <>", value, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialGreaterThan(Integer value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial >", value, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialGreaterThanOrEqualTo(Integer value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial >=", value, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialLessThan(Integer value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial <", value, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialLessThanOrEqualTo(Integer value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial <=", value, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialIn(List<Integer> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial in", values, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialNotIn(List<Integer> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial not in", values, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialBetween(Integer value1, Integer value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial between", value1, value2, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andScheduleSerialNotBetween(Integer value1, Integer value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.schedule_serial not between", value1, value2, "scheduleSerial");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial.deleted not between", value1, value2, "deleted");
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