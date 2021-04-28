package scut.yulin.trip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TripRoutineRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public TripRoutineRelationExample() {
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
            addCriterion("tripuuid_routineuuid_routineserial.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("tripuuid_routineuuid_routineserial.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("tripuuid_routineuuid_routineserial.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("tripuuid_routineuuid_routineserial.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tripuuid_routineuuid_routineserial.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("tripuuid_routineuuid_routineserial.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("tripuuid_routineuuid_routineserial.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("tripuuid_routineuuid_routineserial.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("tripuuid_routineuuid_routineserial.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("tripuuid_routineuuid_routineserial.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("tripuuid_routineuuid_routineserial.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("tripuuid_routineuuid_routineserial.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidIsNull() {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid is null");
            return (Criteria) this;
        }

        public Criteria andTripUuidIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andTripUuidEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid =", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidNotEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid <>", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidGreaterThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid >", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidGreaterThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid >=", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidLessThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid <", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidLessThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid <=", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid like", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidNotLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid not like", value, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid in", values, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidNotIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid not in", values, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid between", value1, value2, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andTripUuidNotBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.trip_uuid not between", value1, value2, "tripUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidIsNull() {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid =", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid <>", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidGreaterThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid >", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidGreaterThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid >=", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidLessThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid <", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidLessThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid <=", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid like", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid not like", value, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid in", values, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid not in", values, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid between", value1, value2, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineUuidNotBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_uuid not between", value1, value2, "routineUuid");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialIsNull() {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial is null");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialEqualTo(Integer value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial =", value, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialNotEqualTo(Integer value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial <>", value, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialGreaterThan(Integer value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial >", value, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialGreaterThanOrEqualTo(Integer value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial >=", value, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialLessThan(Integer value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial <", value, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialLessThanOrEqualTo(Integer value) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial <=", value, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialIn(List<Integer> values) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial in", values, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialNotIn(List<Integer> values) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial not in", values, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialBetween(Integer value1, Integer value2) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial between", value1, value2, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andRoutineSerialNotBetween(Integer value1, Integer value2) {
            addCriterion("tripuuid_routineuuid_routineserial.routine_serial not between", value1, value2, "routineSerial");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("tripuuid_routineuuid_routineserial.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("tripuuid_routineuuid_routineserial.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("tripuuid_routineuuid_routineserial.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("tripuuid_routineuuid_routineserial.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("tripuuid_routineuuid_routineserial.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("tripuuid_routineuuid_routineserial.deleted not between", value1, value2, "deleted");
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