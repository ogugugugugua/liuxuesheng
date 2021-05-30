package scut.yulin.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravelerExample {

  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  private Integer limit;

  private Long offset;

  private Boolean forUpdate;

  public TravelerExample() {
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
      addCriterion("traveler.id is null");
      return (Criteria) this;
    }

    public Criteria andIdIsNotNull() {
      addCriterion("traveler.id is not null");
      return (Criteria) this;
    }

    public Criteria andIdEqualTo(Long value) {
      addCriterion("traveler.id =", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotEqualTo(Long value) {
      addCriterion("traveler.id <>", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThan(Long value) {
      addCriterion("traveler.id >", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdGreaterThanOrEqualTo(Long value) {
      addCriterion("traveler.id >=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThan(Long value) {
      addCriterion("traveler.id <", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdLessThanOrEqualTo(Long value) {
      addCriterion("traveler.id <=", value, "id");
      return (Criteria) this;
    }

    public Criteria andIdIn(List<Long> values) {
      addCriterion("traveler.id in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotIn(List<Long> values) {
      addCriterion("traveler.id not in", values, "id");
      return (Criteria) this;
    }

    public Criteria andIdBetween(Long value1, Long value2) {
      addCriterion("traveler.id between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andIdNotBetween(Long value1, Long value2) {
      addCriterion("traveler.id not between", value1, value2, "id");
      return (Criteria) this;
    }

    public Criteria andUuidIsNull() {
      addCriterion("traveler.uuid is null");
      return (Criteria) this;
    }

    public Criteria andUuidIsNotNull() {
      addCriterion("traveler.uuid is not null");
      return (Criteria) this;
    }

    public Criteria andUuidEqualTo(String value) {
      addCriterion("traveler.uuid =", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidNotEqualTo(String value) {
      addCriterion("traveler.uuid <>", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidGreaterThan(String value) {
      addCriterion("traveler.uuid >", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.uuid >=", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidLessThan(String value) {
      addCriterion("traveler.uuid <", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidLessThanOrEqualTo(String value) {
      addCriterion("traveler.uuid <=", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidLike(String value) {
      addCriterion("traveler.uuid like", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidNotLike(String value) {
      addCriterion("traveler.uuid not like", value, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidIn(List<String> values) {
      addCriterion("traveler.uuid in", values, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidNotIn(List<String> values) {
      addCriterion("traveler.uuid not in", values, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidBetween(String value1, String value2) {
      addCriterion("traveler.uuid between", value1, value2, "uuid");
      return (Criteria) this;
    }

    public Criteria andUuidNotBetween(String value1, String value2) {
      addCriterion("traveler.uuid not between", value1, value2, "uuid");
      return (Criteria) this;
    }

    public Criteria andAccountNameIsNull() {
      addCriterion("traveler.account_name is null");
      return (Criteria) this;
    }

    public Criteria andAccountNameIsNotNull() {
      addCriterion("traveler.account_name is not null");
      return (Criteria) this;
    }

    public Criteria andAccountNameEqualTo(String value) {
      addCriterion("traveler.account_name =", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameNotEqualTo(String value) {
      addCriterion("traveler.account_name <>", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameGreaterThan(String value) {
      addCriterion("traveler.account_name >", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.account_name >=", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameLessThan(String value) {
      addCriterion("traveler.account_name <", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameLessThanOrEqualTo(String value) {
      addCriterion("traveler.account_name <=", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameLike(String value) {
      addCriterion("traveler.account_name like", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameNotLike(String value) {
      addCriterion("traveler.account_name not like", value, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameIn(List<String> values) {
      addCriterion("traveler.account_name in", values, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameNotIn(List<String> values) {
      addCriterion("traveler.account_name not in", values, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameBetween(String value1, String value2) {
      addCriterion("traveler.account_name between", value1, value2, "accountName");
      return (Criteria) this;
    }

    public Criteria andAccountNameNotBetween(String value1, String value2) {
      addCriterion("traveler.account_name not between", value1, value2, "accountName");
      return (Criteria) this;
    }

    public Criteria andPwdIsNull() {
      addCriterion("traveler.pwd is null");
      return (Criteria) this;
    }

    public Criteria andPwdIsNotNull() {
      addCriterion("traveler.pwd is not null");
      return (Criteria) this;
    }

    public Criteria andPwdEqualTo(String value) {
      addCriterion("traveler.pwd =", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdNotEqualTo(String value) {
      addCriterion("traveler.pwd <>", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdGreaterThan(String value) {
      addCriterion("traveler.pwd >", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.pwd >=", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdLessThan(String value) {
      addCriterion("traveler.pwd <", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdLessThanOrEqualTo(String value) {
      addCriterion("traveler.pwd <=", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdLike(String value) {
      addCriterion("traveler.pwd like", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdNotLike(String value) {
      addCriterion("traveler.pwd not like", value, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdIn(List<String> values) {
      addCriterion("traveler.pwd in", values, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdNotIn(List<String> values) {
      addCriterion("traveler.pwd not in", values, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdBetween(String value1, String value2) {
      addCriterion("traveler.pwd between", value1, value2, "pwd");
      return (Criteria) this;
    }

    public Criteria andPwdNotBetween(String value1, String value2) {
      addCriterion("traveler.pwd not between", value1, value2, "pwd");
      return (Criteria) this;
    }

    public Criteria andGenderIsNull() {
      addCriterion("traveler.gender is null");
      return (Criteria) this;
    }

    public Criteria andGenderIsNotNull() {
      addCriterion("traveler.gender is not null");
      return (Criteria) this;
    }

    public Criteria andGenderEqualTo(String value) {
      addCriterion("traveler.gender =", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotEqualTo(String value) {
      addCriterion("traveler.gender <>", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderGreaterThan(String value) {
      addCriterion("traveler.gender >", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.gender >=", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderLessThan(String value) {
      addCriterion("traveler.gender <", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderLessThanOrEqualTo(String value) {
      addCriterion("traveler.gender <=", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderLike(String value) {
      addCriterion("traveler.gender like", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotLike(String value) {
      addCriterion("traveler.gender not like", value, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderIn(List<String> values) {
      addCriterion("traveler.gender in", values, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotIn(List<String> values) {
      addCriterion("traveler.gender not in", values, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderBetween(String value1, String value2) {
      addCriterion("traveler.gender between", value1, value2, "gender");
      return (Criteria) this;
    }

    public Criteria andGenderNotBetween(String value1, String value2) {
      addCriterion("traveler.gender not between", value1, value2, "gender");
      return (Criteria) this;
    }

    public Criteria andRealNameIsNull() {
      addCriterion("traveler.real_name is null");
      return (Criteria) this;
    }

    public Criteria andRealNameIsNotNull() {
      addCriterion("traveler.real_name is not null");
      return (Criteria) this;
    }

    public Criteria andRealNameEqualTo(String value) {
      addCriterion("traveler.real_name =", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameNotEqualTo(String value) {
      addCriterion("traveler.real_name <>", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameGreaterThan(String value) {
      addCriterion("traveler.real_name >", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.real_name >=", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameLessThan(String value) {
      addCriterion("traveler.real_name <", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameLessThanOrEqualTo(String value) {
      addCriterion("traveler.real_name <=", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameLike(String value) {
      addCriterion("traveler.real_name like", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameNotLike(String value) {
      addCriterion("traveler.real_name not like", value, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameIn(List<String> values) {
      addCriterion("traveler.real_name in", values, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameNotIn(List<String> values) {
      addCriterion("traveler.real_name not in", values, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameBetween(String value1, String value2) {
      addCriterion("traveler.real_name between", value1, value2, "realName");
      return (Criteria) this;
    }

    public Criteria andRealNameNotBetween(String value1, String value2) {
      addCriterion("traveler.real_name not between", value1, value2, "realName");
      return (Criteria) this;
    }

    public Criteria andCountryIsNull() {
      addCriterion("traveler.country is null");
      return (Criteria) this;
    }

    public Criteria andCountryIsNotNull() {
      addCriterion("traveler.country is not null");
      return (Criteria) this;
    }

    public Criteria andCountryEqualTo(String value) {
      addCriterion("traveler.country =", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryNotEqualTo(String value) {
      addCriterion("traveler.country <>", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryGreaterThan(String value) {
      addCriterion("traveler.country >", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.country >=", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryLessThan(String value) {
      addCriterion("traveler.country <", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryLessThanOrEqualTo(String value) {
      addCriterion("traveler.country <=", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryLike(String value) {
      addCriterion("traveler.country like", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryNotLike(String value) {
      addCriterion("traveler.country not like", value, "country");
      return (Criteria) this;
    }

    public Criteria andCountryIn(List<String> values) {
      addCriterion("traveler.country in", values, "country");
      return (Criteria) this;
    }

    public Criteria andCountryNotIn(List<String> values) {
      addCriterion("traveler.country not in", values, "country");
      return (Criteria) this;
    }

    public Criteria andCountryBetween(String value1, String value2) {
      addCriterion("traveler.country between", value1, value2, "country");
      return (Criteria) this;
    }

    public Criteria andCountryNotBetween(String value1, String value2) {
      addCriterion("traveler.country not between", value1, value2, "country");
      return (Criteria) this;
    }

    public Criteria andCityIsNull() {
      addCriterion("traveler.city is null");
      return (Criteria) this;
    }

    public Criteria andCityIsNotNull() {
      addCriterion("traveler.city is not null");
      return (Criteria) this;
    }

    public Criteria andCityEqualTo(String value) {
      addCriterion("traveler.city =", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotEqualTo(String value) {
      addCriterion("traveler.city <>", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityGreaterThan(String value) {
      addCriterion("traveler.city >", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.city >=", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityLessThan(String value) {
      addCriterion("traveler.city <", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityLessThanOrEqualTo(String value) {
      addCriterion("traveler.city <=", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityLike(String value) {
      addCriterion("traveler.city like", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotLike(String value) {
      addCriterion("traveler.city not like", value, "city");
      return (Criteria) this;
    }

    public Criteria andCityIn(List<String> values) {
      addCriterion("traveler.city in", values, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotIn(List<String> values) {
      addCriterion("traveler.city not in", values, "city");
      return (Criteria) this;
    }

    public Criteria andCityBetween(String value1, String value2) {
      addCriterion("traveler.city between", value1, value2, "city");
      return (Criteria) this;
    }

    public Criteria andCityNotBetween(String value1, String value2) {
      addCriterion("traveler.city not between", value1, value2, "city");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeIsNull() {
      addCriterion("traveler.phone_code is null");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeIsNotNull() {
      addCriterion("traveler.phone_code is not null");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeEqualTo(String value) {
      addCriterion("traveler.phone_code =", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeNotEqualTo(String value) {
      addCriterion("traveler.phone_code <>", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeGreaterThan(String value) {
      addCriterion("traveler.phone_code >", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.phone_code >=", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeLessThan(String value) {
      addCriterion("traveler.phone_code <", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeLessThanOrEqualTo(String value) {
      addCriterion("traveler.phone_code <=", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeLike(String value) {
      addCriterion("traveler.phone_code like", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeNotLike(String value) {
      addCriterion("traveler.phone_code not like", value, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeIn(List<String> values) {
      addCriterion("traveler.phone_code in", values, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeNotIn(List<String> values) {
      addCriterion("traveler.phone_code not in", values, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeBetween(String value1, String value2) {
      addCriterion("traveler.phone_code between", value1, value2, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andPhoneCodeNotBetween(String value1, String value2) {
      addCriterion("traveler.phone_code not between", value1, value2, "phoneCode");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneIsNull() {
      addCriterion("traveler.local_phone is null");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneIsNotNull() {
      addCriterion("traveler.local_phone is not null");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneEqualTo(String value) {
      addCriterion("traveler.local_phone =", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneNotEqualTo(String value) {
      addCriterion("traveler.local_phone <>", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneGreaterThan(String value) {
      addCriterion("traveler.local_phone >", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.local_phone >=", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneLessThan(String value) {
      addCriterion("traveler.local_phone <", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneLessThanOrEqualTo(String value) {
      addCriterion("traveler.local_phone <=", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneLike(String value) {
      addCriterion("traveler.local_phone like", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneNotLike(String value) {
      addCriterion("traveler.local_phone not like", value, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneIn(List<String> values) {
      addCriterion("traveler.local_phone in", values, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneNotIn(List<String> values) {
      addCriterion("traveler.local_phone not in", values, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneBetween(String value1, String value2) {
      addCriterion("traveler.local_phone between", value1, value2, "localPhone");
      return (Criteria) this;
    }

    public Criteria andLocalPhoneNotBetween(String value1, String value2) {
      addCriterion("traveler.local_phone not between", value1, value2, "localPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneIsNull() {
      addCriterion("traveler.cn_phone is null");
      return (Criteria) this;
    }

    public Criteria andCnPhoneIsNotNull() {
      addCriterion("traveler.cn_phone is not null");
      return (Criteria) this;
    }

    public Criteria andCnPhoneEqualTo(String value) {
      addCriterion("traveler.cn_phone =", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneNotEqualTo(String value) {
      addCriterion("traveler.cn_phone <>", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneGreaterThan(String value) {
      addCriterion("traveler.cn_phone >", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.cn_phone >=", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneLessThan(String value) {
      addCriterion("traveler.cn_phone <", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneLessThanOrEqualTo(String value) {
      addCriterion("traveler.cn_phone <=", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneLike(String value) {
      addCriterion("traveler.cn_phone like", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneNotLike(String value) {
      addCriterion("traveler.cn_phone not like", value, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneIn(List<String> values) {
      addCriterion("traveler.cn_phone in", values, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneNotIn(List<String> values) {
      addCriterion("traveler.cn_phone not in", values, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneBetween(String value1, String value2) {
      addCriterion("traveler.cn_phone between", value1, value2, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andCnPhoneNotBetween(String value1, String value2) {
      addCriterion("traveler.cn_phone not between", value1, value2, "cnPhone");
      return (Criteria) this;
    }

    public Criteria andMailIsNull() {
      addCriterion("traveler.mail is null");
      return (Criteria) this;
    }

    public Criteria andMailIsNotNull() {
      addCriterion("traveler.mail is not null");
      return (Criteria) this;
    }

    public Criteria andMailEqualTo(String value) {
      addCriterion("traveler.mail =", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailNotEqualTo(String value) {
      addCriterion("traveler.mail <>", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailGreaterThan(String value) {
      addCriterion("traveler.mail >", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.mail >=", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailLessThan(String value) {
      addCriterion("traveler.mail <", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailLessThanOrEqualTo(String value) {
      addCriterion("traveler.mail <=", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailLike(String value) {
      addCriterion("traveler.mail like", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailNotLike(String value) {
      addCriterion("traveler.mail not like", value, "mail");
      return (Criteria) this;
    }

    public Criteria andMailIn(List<String> values) {
      addCriterion("traveler.mail in", values, "mail");
      return (Criteria) this;
    }

    public Criteria andMailNotIn(List<String> values) {
      addCriterion("traveler.mail not in", values, "mail");
      return (Criteria) this;
    }

    public Criteria andMailBetween(String value1, String value2) {
      addCriterion("traveler.mail between", value1, value2, "mail");
      return (Criteria) this;
    }

    public Criteria andMailNotBetween(String value1, String value2) {
      addCriterion("traveler.mail not between", value1, value2, "mail");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedIsNull() {
      addCriterion("traveler.mail_verified is null");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedIsNotNull() {
      addCriterion("traveler.mail_verified is not null");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedEqualTo(String value) {
      addCriterion("traveler.mail_verified =", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedNotEqualTo(String value) {
      addCriterion("traveler.mail_verified <>", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedGreaterThan(String value) {
      addCriterion("traveler.mail_verified >", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.mail_verified >=", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedLessThan(String value) {
      addCriterion("traveler.mail_verified <", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedLessThanOrEqualTo(String value) {
      addCriterion("traveler.mail_verified <=", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedLike(String value) {
      addCriterion("traveler.mail_verified like", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedNotLike(String value) {
      addCriterion("traveler.mail_verified not like", value, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedIn(List<String> values) {
      addCriterion("traveler.mail_verified in", values, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedNotIn(List<String> values) {
      addCriterion("traveler.mail_verified not in", values, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedBetween(String value1, String value2) {
      addCriterion("traveler.mail_verified between", value1, value2, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andMailVerifiedNotBetween(String value1, String value2) {
      addCriterion("traveler.mail_verified not between", value1, value2, "mailVerified");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlIsNull() {
      addCriterion("traveler.avatar_url is null");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlIsNotNull() {
      addCriterion("traveler.avatar_url is not null");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlEqualTo(String value) {
      addCriterion("traveler.avatar_url =", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlNotEqualTo(String value) {
      addCriterion("traveler.avatar_url <>", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlGreaterThan(String value) {
      addCriterion("traveler.avatar_url >", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.avatar_url >=", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlLessThan(String value) {
      addCriterion("traveler.avatar_url <", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlLessThanOrEqualTo(String value) {
      addCriterion("traveler.avatar_url <=", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlLike(String value) {
      addCriterion("traveler.avatar_url like", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlNotLike(String value) {
      addCriterion("traveler.avatar_url not like", value, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlIn(List<String> values) {
      addCriterion("traveler.avatar_url in", values, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlNotIn(List<String> values) {
      addCriterion("traveler.avatar_url not in", values, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlBetween(String value1, String value2) {
      addCriterion("traveler.avatar_url between", value1, value2, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andAvatarUrlNotBetween(String value1, String value2) {
      addCriterion("traveler.avatar_url not between", value1, value2, "avatarUrl");
      return (Criteria) this;
    }

    public Criteria andStatusIsNull() {
      addCriterion("traveler.`status` is null");
      return (Criteria) this;
    }

    public Criteria andStatusIsNotNull() {
      addCriterion("traveler.`status` is not null");
      return (Criteria) this;
    }

    public Criteria andStatusEqualTo(String value) {
      addCriterion("traveler.`status` =", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotEqualTo(String value) {
      addCriterion("traveler.`status` <>", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusGreaterThan(String value) {
      addCriterion("traveler.`status` >", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.`status` >=", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLessThan(String value) {
      addCriterion("traveler.`status` <", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLessThanOrEqualTo(String value) {
      addCriterion("traveler.`status` <=", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusLike(String value) {
      addCriterion("traveler.`status` like", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotLike(String value) {
      addCriterion("traveler.`status` not like", value, "status");
      return (Criteria) this;
    }

    public Criteria andStatusIn(List<String> values) {
      addCriterion("traveler.`status` in", values, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotIn(List<String> values) {
      addCriterion("traveler.`status` not in", values, "status");
      return (Criteria) this;
    }

    public Criteria andStatusBetween(String value1, String value2) {
      addCriterion("traveler.`status` between", value1, value2, "status");
      return (Criteria) this;
    }

    public Criteria andStatusNotBetween(String value1, String value2) {
      addCriterion("traveler.`status` not between", value1, value2, "status");
      return (Criteria) this;
    }

    public Criteria andGradeIsNull() {
      addCriterion("traveler.grade is null");
      return (Criteria) this;
    }

    public Criteria andGradeIsNotNull() {
      addCriterion("traveler.grade is not null");
      return (Criteria) this;
    }

    public Criteria andGradeEqualTo(String value) {
      addCriterion("traveler.grade =", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeNotEqualTo(String value) {
      addCriterion("traveler.grade <>", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeGreaterThan(String value) {
      addCriterion("traveler.grade >", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.grade >=", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeLessThan(String value) {
      addCriterion("traveler.grade <", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeLessThanOrEqualTo(String value) {
      addCriterion("traveler.grade <=", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeLike(String value) {
      addCriterion("traveler.grade like", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeNotLike(String value) {
      addCriterion("traveler.grade not like", value, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeIn(List<String> values) {
      addCriterion("traveler.grade in", values, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeNotIn(List<String> values) {
      addCriterion("traveler.grade not in", values, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeBetween(String value1, String value2) {
      addCriterion("traveler.grade between", value1, value2, "grade");
      return (Criteria) this;
    }

    public Criteria andGradeNotBetween(String value1, String value2) {
      addCriterion("traveler.grade not between", value1, value2, "grade");
      return (Criteria) this;
    }

    public Criteria andLastLoginIsNull() {
      addCriterion("traveler.last_login is null");
      return (Criteria) this;
    }

    public Criteria andLastLoginIsNotNull() {
      addCriterion("traveler.last_login is not null");
      return (Criteria) this;
    }

    public Criteria andLastLoginEqualTo(Date value) {
      addCriterion("traveler.last_login =", value, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginNotEqualTo(Date value) {
      addCriterion("traveler.last_login <>", value, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginGreaterThan(Date value) {
      addCriterion("traveler.last_login >", value, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
      addCriterion("traveler.last_login >=", value, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginLessThan(Date value) {
      addCriterion("traveler.last_login <", value, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginLessThanOrEqualTo(Date value) {
      addCriterion("traveler.last_login <=", value, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginIn(List<Date> values) {
      addCriterion("traveler.last_login in", values, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginNotIn(List<Date> values) {
      addCriterion("traveler.last_login not in", values, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginBetween(Date value1, Date value2) {
      addCriterion("traveler.last_login between", value1, value2, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andLastLoginNotBetween(Date value1, Date value2) {
      addCriterion("traveler.last_login not between", value1, value2, "lastLogin");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeIsNull() {
      addCriterion("traveler.created_time is null");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeIsNotNull() {
      addCriterion("traveler.created_time is not null");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeEqualTo(Date value) {
      addCriterion("traveler.created_time =", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeNotEqualTo(Date value) {
      addCriterion("traveler.created_time <>", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeGreaterThan(Date value) {
      addCriterion("traveler.created_time >", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("traveler.created_time >=", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeLessThan(Date value) {
      addCriterion("traveler.created_time <", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
      addCriterion("traveler.created_time <=", value, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeIn(List<Date> values) {
      addCriterion("traveler.created_time in", values, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeNotIn(List<Date> values) {
      addCriterion("traveler.created_time not in", values, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeBetween(Date value1, Date value2) {
      addCriterion("traveler.created_time between", value1, value2, "createdTime");
      return (Criteria) this;
    }

    public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
      addCriterion("traveler.created_time not between", value1, value2, "createdTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeIsNull() {
      addCriterion("traveler.updated_time is null");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeIsNotNull() {
      addCriterion("traveler.updated_time is not null");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeEqualTo(Date value) {
      addCriterion("traveler.updated_time =", value, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeNotEqualTo(Date value) {
      addCriterion("traveler.updated_time <>", value, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeGreaterThan(Date value) {
      addCriterion("traveler.updated_time >", value, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
      addCriterion("traveler.updated_time >=", value, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeLessThan(Date value) {
      addCriterion("traveler.updated_time <", value, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
      addCriterion("traveler.updated_time <=", value, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeIn(List<Date> values) {
      addCriterion("traveler.updated_time in", values, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeNotIn(List<Date> values) {
      addCriterion("traveler.updated_time not in", values, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
      addCriterion("traveler.updated_time between", value1, value2, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
      addCriterion("traveler.updated_time not between", value1, value2, "updatedTime");
      return (Criteria) this;
    }

    public Criteria andDeletedIsNull() {
      addCriterion("traveler.deleted is null");
      return (Criteria) this;
    }

    public Criteria andDeletedIsNotNull() {
      addCriterion("traveler.deleted is not null");
      return (Criteria) this;
    }

    public Criteria andDeletedEqualTo(String value) {
      addCriterion("traveler.deleted =", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedNotEqualTo(String value) {
      addCriterion("traveler.deleted <>", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedGreaterThan(String value) {
      addCriterion("traveler.deleted >", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedGreaterThanOrEqualTo(String value) {
      addCriterion("traveler.deleted >=", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedLessThan(String value) {
      addCriterion("traveler.deleted <", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedLessThanOrEqualTo(String value) {
      addCriterion("traveler.deleted <=", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedLike(String value) {
      addCriterion("traveler.deleted like", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedNotLike(String value) {
      addCriterion("traveler.deleted not like", value, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedIn(List<String> values) {
      addCriterion("traveler.deleted in", values, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedNotIn(List<String> values) {
      addCriterion("traveler.deleted not in", values, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedBetween(String value1, String value2) {
      addCriterion("traveler.deleted between", value1, value2, "deleted");
      return (Criteria) this;
    }

    public Criteria andDeletedNotBetween(String value1, String value2) {
      addCriterion("traveler.deleted not between", value1, value2, "deleted");
      return (Criteria) this;
    }
  }

  /**
   *
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