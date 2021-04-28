package scut.yulin.trip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TripExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public TripExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("trip.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("trip.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("trip.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("trip.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("trip.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trip.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("trip.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("trip.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("trip.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("trip.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("trip.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("trip.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("trip.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("trip.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("trip.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("trip.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("trip.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("trip.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("trip.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("trip.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("trip.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("trip.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("trip.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("trip.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("trip.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("trip.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNull() {
            addCriterion("trip.creator_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNotNull() {
            addCriterion("trip.creator_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidEqualTo(String value) {
            addCriterion("trip.creator_uuid =", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotEqualTo(String value) {
            addCriterion("trip.creator_uuid <>", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThan(String value) {
            addCriterion("trip.creator_uuid >", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("trip.creator_uuid >=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThan(String value) {
            addCriterion("trip.creator_uuid <", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThanOrEqualTo(String value) {
            addCriterion("trip.creator_uuid <=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLike(String value) {
            addCriterion("trip.creator_uuid like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotLike(String value) {
            addCriterion("trip.creator_uuid not like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIn(List<String> values) {
            addCriterion("trip.creator_uuid in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotIn(List<String> values) {
            addCriterion("trip.creator_uuid not in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidBetween(String value1, String value2) {
            addCriterion("trip.creator_uuid between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotBetween(String value1, String value2) {
            addCriterion("trip.creator_uuid not between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("trip.title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("trip.title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("trip.title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("trip.title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("trip.title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("trip.title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("trip.title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("trip.title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("trip.title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("trip.title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("trip.title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("trip.title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("trip.title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("trip.title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("trip.description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("trip.description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("trip.description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("trip.description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("trip.description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("trip.description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("trip.description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("trip.description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("trip.description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("trip.description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("trip.description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("trip.description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("trip.description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("trip.description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNull() {
            addCriterion("trip.classification is null");
            return (Criteria) this;
        }

        public Criteria andClassificationIsNotNull() {
            addCriterion("trip.classification is not null");
            return (Criteria) this;
        }

        public Criteria andClassificationEqualTo(String value) {
            addCriterion("trip.classification =", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotEqualTo(String value) {
            addCriterion("trip.classification <>", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThan(String value) {
            addCriterion("trip.classification >", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationGreaterThanOrEqualTo(String value) {
            addCriterion("trip.classification >=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThan(String value) {
            addCriterion("trip.classification <", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLessThanOrEqualTo(String value) {
            addCriterion("trip.classification <=", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationLike(String value) {
            addCriterion("trip.classification like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotLike(String value) {
            addCriterion("trip.classification not like", value, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationIn(List<String> values) {
            addCriterion("trip.classification in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotIn(List<String> values) {
            addCriterion("trip.classification not in", values, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationBetween(String value1, String value2) {
            addCriterion("trip.classification between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andClassificationNotBetween(String value1, String value2) {
            addCriterion("trip.classification not between", value1, value2, "classification");
            return (Criteria) this;
        }

        public Criteria andDepartTimeIsNull() {
            addCriterion("trip.depart_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartTimeIsNotNull() {
            addCriterion("trip.depart_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartTimeEqualTo(Date value) {
            addCriterionForJDBCDate("trip.depart_time =", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("trip.depart_time <>", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("trip.depart_time >", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("trip.depart_time >=", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeLessThan(Date value) {
            addCriterionForJDBCDate("trip.depart_time <", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("trip.depart_time <=", value, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeIn(List<Date> values) {
            addCriterionForJDBCDate("trip.depart_time in", values, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("trip.depart_time not in", values, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("trip.depart_time between", value1, value2, "departTime");
            return (Criteria) this;
        }

        public Criteria andDepartTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("trip.depart_time not between", value1, value2, "departTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("trip.duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("trip.duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("trip.duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("trip.duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("trip.duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("trip.duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("trip.duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("trip.duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("trip.duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("trip.duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("trip.duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("trip.duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andRankTopIsNull() {
            addCriterion("trip.rank_top is null");
            return (Criteria) this;
        }

        public Criteria andRankTopIsNotNull() {
            addCriterion("trip.rank_top is not null");
            return (Criteria) this;
        }

        public Criteria andRankTopEqualTo(String value) {
            addCriterion("trip.rank_top =", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopNotEqualTo(String value) {
            addCriterion("trip.rank_top <>", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopGreaterThan(String value) {
            addCriterion("trip.rank_top >", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopGreaterThanOrEqualTo(String value) {
            addCriterion("trip.rank_top >=", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopLessThan(String value) {
            addCriterion("trip.rank_top <", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopLessThanOrEqualTo(String value) {
            addCriterion("trip.rank_top <=", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopLike(String value) {
            addCriterion("trip.rank_top like", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopNotLike(String value) {
            addCriterion("trip.rank_top not like", value, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopIn(List<String> values) {
            addCriterion("trip.rank_top in", values, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopNotIn(List<String> values) {
            addCriterion("trip.rank_top not in", values, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopBetween(String value1, String value2) {
            addCriterion("trip.rank_top between", value1, value2, "rankTop");
            return (Criteria) this;
        }

        public Criteria andRankTopNotBetween(String value1, String value2) {
            addCriterion("trip.rank_top not between", value1, value2, "rankTop");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("trip.`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("trip.`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("trip.`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("trip.`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("trip.`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trip.`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("trip.`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("trip.`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("trip.`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("trip.`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("trip.`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("trip.`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("trip.`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("trip.`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPrivateTripIsNull() {
            addCriterion("trip.private_trip is null");
            return (Criteria) this;
        }

        public Criteria andPrivateTripIsNotNull() {
            addCriterion("trip.private_trip is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateTripEqualTo(String value) {
            addCriterion("trip.private_trip =", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripNotEqualTo(String value) {
            addCriterion("trip.private_trip <>", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripGreaterThan(String value) {
            addCriterion("trip.private_trip >", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripGreaterThanOrEqualTo(String value) {
            addCriterion("trip.private_trip >=", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripLessThan(String value) {
            addCriterion("trip.private_trip <", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripLessThanOrEqualTo(String value) {
            addCriterion("trip.private_trip <=", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripLike(String value) {
            addCriterion("trip.private_trip like", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripNotLike(String value) {
            addCriterion("trip.private_trip not like", value, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripIn(List<String> values) {
            addCriterion("trip.private_trip in", values, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripNotIn(List<String> values) {
            addCriterion("trip.private_trip not in", values, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripBetween(String value1, String value2) {
            addCriterion("trip.private_trip between", value1, value2, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andPrivateTripNotBetween(String value1, String value2) {
            addCriterion("trip.private_trip not between", value1, value2, "privateTrip");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNull() {
            addCriterion("trip.original is null");
            return (Criteria) this;
        }

        public Criteria andOriginalIsNotNull() {
            addCriterion("trip.original is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalEqualTo(String value) {
            addCriterion("trip.original =", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotEqualTo(String value) {
            addCriterion("trip.original <>", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThan(String value) {
            addCriterion("trip.original >", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalGreaterThanOrEqualTo(String value) {
            addCriterion("trip.original >=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThan(String value) {
            addCriterion("trip.original <", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLessThanOrEqualTo(String value) {
            addCriterion("trip.original <=", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalLike(String value) {
            addCriterion("trip.original like", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotLike(String value) {
            addCriterion("trip.original not like", value, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalIn(List<String> values) {
            addCriterion("trip.original in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotIn(List<String> values) {
            addCriterion("trip.original not in", values, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalBetween(String value1, String value2) {
            addCriterion("trip.original between", value1, value2, "original");
            return (Criteria) this;
        }

        public Criteria andOriginalNotBetween(String value1, String value2) {
            addCriterion("trip.original not between", value1, value2, "original");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("trip.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("trip.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("trip.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("trip.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("trip.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trip.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("trip.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("trip.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("trip.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("trip.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("trip.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("trip.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("trip.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("trip.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("trip.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("trip.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("trip.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trip.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("trip.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("trip.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("trip.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("trip.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("trip.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("trip.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("trip.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("trip.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("trip.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("trip.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("trip.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("trip.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("trip.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("trip.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("trip.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("trip.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("trip.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("trip.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("trip.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("trip.deleted not between", value1, value2, "deleted");
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