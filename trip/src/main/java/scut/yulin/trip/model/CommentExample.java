package scut.yulin.trip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    private Boolean forUpdate;

    public CommentExample() {
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
            addCriterion("comment.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("comment.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("comment.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("comment.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("comment.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("comment.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("comment.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("comment.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("comment.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("comment.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("comment.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("comment.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("comment.uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("comment.uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("comment.uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("comment.uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("comment.uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("comment.uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("comment.uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("comment.uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("comment.uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("comment.uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("comment.uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("comment.uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("comment.uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("comment.uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNull() {
            addCriterion("comment.schedule_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIsNotNull() {
            addCriterion("comment.schedule_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidEqualTo(String value) {
            addCriterion("comment.schedule_uuid =", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotEqualTo(String value) {
            addCriterion("comment.schedule_uuid <>", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThan(String value) {
            addCriterion("comment.schedule_uuid >", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("comment.schedule_uuid >=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThan(String value) {
            addCriterion("comment.schedule_uuid <", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLessThanOrEqualTo(String value) {
            addCriterion("comment.schedule_uuid <=", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidLike(String value) {
            addCriterion("comment.schedule_uuid like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotLike(String value) {
            addCriterion("comment.schedule_uuid not like", value, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidIn(List<String> values) {
            addCriterion("comment.schedule_uuid in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotIn(List<String> values) {
            addCriterion("comment.schedule_uuid not in", values, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidBetween(String value1, String value2) {
            addCriterion("comment.schedule_uuid between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleUuidNotBetween(String value1, String value2) {
            addCriterion("comment.schedule_uuid not between", value1, value2, "scheduleUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNull() {
            addCriterion("comment.schedule_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIsNotNull() {
            addCriterion("comment.schedule_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidEqualTo(String value) {
            addCriterion("comment.schedule_type_uuid =", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotEqualTo(String value) {
            addCriterion("comment.schedule_type_uuid <>", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThan(String value) {
            addCriterion("comment.schedule_type_uuid >", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("comment.schedule_type_uuid >=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThan(String value) {
            addCriterion("comment.schedule_type_uuid <", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("comment.schedule_type_uuid <=", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidLike(String value) {
            addCriterion("comment.schedule_type_uuid like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotLike(String value) {
            addCriterion("comment.schedule_type_uuid not like", value, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidIn(List<String> values) {
            addCriterion("comment.schedule_type_uuid in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotIn(List<String> values) {
            addCriterion("comment.schedule_type_uuid not in", values, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidBetween(String value1, String value2) {
            addCriterion("comment.schedule_type_uuid between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andScheduleTypeUuidNotBetween(String value1, String value2) {
            addCriterion("comment.schedule_type_uuid not between", value1, value2, "scheduleTypeUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNull() {
            addCriterion("comment.creator_uuid is null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIsNotNull() {
            addCriterion("comment.creator_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidEqualTo(String value) {
            addCriterion("comment.creator_uuid =", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotEqualTo(String value) {
            addCriterion("comment.creator_uuid <>", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThan(String value) {
            addCriterion("comment.creator_uuid >", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidGreaterThanOrEqualTo(String value) {
            addCriterion("comment.creator_uuid >=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThan(String value) {
            addCriterion("comment.creator_uuid <", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLessThanOrEqualTo(String value) {
            addCriterion("comment.creator_uuid <=", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidLike(String value) {
            addCriterion("comment.creator_uuid like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotLike(String value) {
            addCriterion("comment.creator_uuid not like", value, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidIn(List<String> values) {
            addCriterion("comment.creator_uuid in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotIn(List<String> values) {
            addCriterion("comment.creator_uuid not in", values, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidBetween(String value1, String value2) {
            addCriterion("comment.creator_uuid between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andCreatorUuidNotBetween(String value1, String value2) {
            addCriterion("comment.creator_uuid not between", value1, value2, "creatorUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidIsNull() {
            addCriterion("comment.parent_uuid is null");
            return (Criteria) this;
        }

        public Criteria andParentUuidIsNotNull() {
            addCriterion("comment.parent_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andParentUuidEqualTo(String value) {
            addCriterion("comment.parent_uuid =", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotEqualTo(String value) {
            addCriterion("comment.parent_uuid <>", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidGreaterThan(String value) {
            addCriterion("comment.parent_uuid >", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidGreaterThanOrEqualTo(String value) {
            addCriterion("comment.parent_uuid >=", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidLessThan(String value) {
            addCriterion("comment.parent_uuid <", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidLessThanOrEqualTo(String value) {
            addCriterion("comment.parent_uuid <=", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidLike(String value) {
            addCriterion("comment.parent_uuid like", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotLike(String value) {
            addCriterion("comment.parent_uuid not like", value, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidIn(List<String> values) {
            addCriterion("comment.parent_uuid in", values, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotIn(List<String> values) {
            addCriterion("comment.parent_uuid not in", values, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidBetween(String value1, String value2) {
            addCriterion("comment.parent_uuid between", value1, value2, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andParentUuidNotBetween(String value1, String value2) {
            addCriterion("comment.parent_uuid not between", value1, value2, "parentUuid");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("comment.content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("comment.content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("comment.content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("comment.content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("comment.content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("comment.content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("comment.content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("comment.content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("comment.content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("comment.content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("comment.content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("comment.content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("comment.content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("comment.content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andPreferenceIsNull() {
            addCriterion("comment.preference is null");
            return (Criteria) this;
        }

        public Criteria andPreferenceIsNotNull() {
            addCriterion("comment.preference is not null");
            return (Criteria) this;
        }

        public Criteria andPreferenceEqualTo(String value) {
            addCriterion("comment.preference =", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceNotEqualTo(String value) {
            addCriterion("comment.preference <>", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceGreaterThan(String value) {
            addCriterion("comment.preference >", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceGreaterThanOrEqualTo(String value) {
            addCriterion("comment.preference >=", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceLessThan(String value) {
            addCriterion("comment.preference <", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceLessThanOrEqualTo(String value) {
            addCriterion("comment.preference <=", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceLike(String value) {
            addCriterion("comment.preference like", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceNotLike(String value) {
            addCriterion("comment.preference not like", value, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceIn(List<String> values) {
            addCriterion("comment.preference in", values, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceNotIn(List<String> values) {
            addCriterion("comment.preference not in", values, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceBetween(String value1, String value2) {
            addCriterion("comment.preference between", value1, value2, "preference");
            return (Criteria) this;
        }

        public Criteria andPreferenceNotBetween(String value1, String value2) {
            addCriterion("comment.preference not between", value1, value2, "preference");
            return (Criteria) this;
        }

        public Criteria andApprovedIsNull() {
            addCriterion("comment.approved is null");
            return (Criteria) this;
        }

        public Criteria andApprovedIsNotNull() {
            addCriterion("comment.approved is not null");
            return (Criteria) this;
        }

        public Criteria andApprovedEqualTo(Integer value) {
            addCriterion("comment.approved =", value, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedNotEqualTo(Integer value) {
            addCriterion("comment.approved <>", value, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedGreaterThan(Integer value) {
            addCriterion("comment.approved >", value, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment.approved >=", value, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedLessThan(Integer value) {
            addCriterion("comment.approved <", value, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedLessThanOrEqualTo(Integer value) {
            addCriterion("comment.approved <=", value, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedIn(List<Integer> values) {
            addCriterion("comment.approved in", values, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedNotIn(List<Integer> values) {
            addCriterion("comment.approved not in", values, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedBetween(Integer value1, Integer value2) {
            addCriterion("comment.approved between", value1, value2, "approved");
            return (Criteria) this;
        }

        public Criteria andApprovedNotBetween(Integer value1, Integer value2) {
            addCriterion("comment.approved not between", value1, value2, "approved");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("comment.created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("comment.created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("comment.created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("comment.created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("comment.created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment.created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("comment.created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment.created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("comment.created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("comment.created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("comment.created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment.created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("comment.updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("comment.updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("comment.updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("comment.updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("comment.updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment.updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("comment.updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment.updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("comment.updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("comment.updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("comment.updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment.updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("comment.`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("comment.`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("comment.`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("comment.`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("comment.`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("comment.`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("comment.`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("comment.`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("comment.`state` like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("comment.`state` not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("comment.`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("comment.`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("comment.`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("comment.`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("comment.deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("comment.deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("comment.deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("comment.deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("comment.deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("comment.deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("comment.deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("comment.deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("comment.deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("comment.deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("comment.deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("comment.deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("comment.deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("comment.deleted not between", value1, value2, "deleted");
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