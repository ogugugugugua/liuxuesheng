package scut.yulin.admin.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.student.InsertStudentDTO;
import scut.yulin.admin.dto.student.ModifyStudentDTO;
import scut.yulin.admin.dto.student.QueryStudentDTO;
import scut.yulin.admin.mbg.mapper.StudentDao;
import scut.yulin.admin.model.Student;
import scut.yulin.admin.model.StudentExample;
import scut.yulin.admin.service.RedisService;
import scut.yulin.admin.service.StudentAdminService;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;

@Slf4j
@Service
public class StudentAdminServiceImpl implements StudentAdminService {

  @Autowired
  StudentDao studentDao;
  @Autowired
  RedisService redisService;

  @Override
  public List<Student> getStudentList(QueryStudentDTO queryStudentDTO) {
    StudentExample studentExample = new StudentExample();
    studentExample.setLimit(queryStudentDTO.getPageSize());
    studentExample.setOffset(queryStudentDTO.getOffset());
    studentExample.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return studentDao.selectByExample(studentExample);
  }

  @Override
  public Student getStudentByUUID(QueryStudentDTO queryStudentDTO) {
    if (queryStudentDTO.getUuid() == null) {
      return null;
    }
    StudentExample studentExample = new StudentExample();
    studentExample
        .createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED)
        .andUuidEqualTo(queryStudentDTO.getUuid());
    List<Student> studentList = studentDao.selectByExample(studentExample);
    if (studentList.size() > 0) {
      return studentDao.selectByExample(studentExample).get(0);
    }
    return null;
  }

  @Override
  public Student getStudentByAccountName(String name) {
    if (name == null) {
      return null;
    }
    StudentExample studentExample = new StudentExample();
    studentExample.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED)
        .andAccountNameEqualTo(name);
    List<Student> studentList = studentDao.selectByExample(studentExample);
    if (studentList.size() > 0) {
      return studentDao.selectByExample(studentExample).get(0);
    }
    return null;
  }

  @Override
  public Integer addNewStudent(InsertStudentDTO insertStudentDTO) {
    String accountName = insertStudentDTO.getAccountName();
    String avatarUrl = insertStudentDTO.getAvatarUrl();
    String city = insertStudentDTO.getCity();
    String country = insertStudentDTO.getCountry();
    String cnPhone = insertStudentDTO.getCnPhone();
    String gender = insertStudentDTO.getGender();
    String grade = insertStudentDTO.getGrade();
    String idCardNumber = insertStudentDTO.getIdCardNumber();
    String localPhone = insertStudentDTO.getLocalPhone();
    String mail = insertStudentDTO.getMail();
    String passportNumber = insertStudentDTO.getPassportNumber();
    String pwd = insertStudentDTO.getPwd();
    String realName = insertStudentDTO.getRealName();
    String phoneCode = insertStudentDTO.getPhoneCode();
    Date lastLogin = insertStudentDTO.getLastLogin();

    Assert.notBlank(accountName, "accountName blank");
    Assert.notBlank(pwd, "password blank");

    Student student = new Student(IdUtil.randomUUID(), accountName, pwd, gender, realName, country,
        city, phoneCode, localPhone, cnPhone, mail, idCardNumber, passportNumber, avatarUrl,
        CommonConstant.ACCOUNT_NORMAL,
        grade);
    return studentDao.insertSelective(student);
  }

  @Override
  public Integer modifyStudent(ModifyStudentDTO modifyStudentDTO) {
    try {
      if (modifyStudentDTO.getUuid() == null) {
        return 2;
      }
      Student student = this.getStudentByUUID(modifyStudentDTO);
      if (student == null) {
        return 2;
      }

      String accountName = modifyStudentDTO.getAccountName();
      String avatarUrl = modifyStudentDTO.getAvatarUrl();
      String city = modifyStudentDTO.getCity();
      String country = modifyStudentDTO.getCountry();
      String cnPhone = modifyStudentDTO.getCnPhone();
      String gender = modifyStudentDTO.getGender();
      String grade = modifyStudentDTO.getGrade();
      String idCardNumber = modifyStudentDTO.getIdCardNumber();
      String localPhone = modifyStudentDTO.getLocalPhone();
      String mail = modifyStudentDTO.getMail();
      String passportNumber = modifyStudentDTO.getPassportNumber();
      String pwd = modifyStudentDTO.getPwd();
      String realName = modifyStudentDTO.getRealName();
      String phoneCode = modifyStudentDTO.getPhoneCode();
      Date lastLogin = modifyStudentDTO.getLastLogin();

      if (Inspections.isNotEmpty(accountName)) {
        student.setAccountName(accountName);
      }
      if (Inspections.isNotEmpty(avatarUrl)) {
        student.setAvatarUrl(avatarUrl);
      }
      if (Inspections.isNotEmpty(city)) {
        student.setCity(city);
      }
      if (Inspections.isNotEmpty(country)) {
        student.setCountry(country);
      }
      if (Inspections.isNotEmpty(cnPhone)) {
        student.setCnPhone(cnPhone);
      }
      if (Inspections.isNotEmpty(gender)) {
        student.setGender(gender);
      }
      if (Inspections.isNotEmpty(grade)) {
        student.setGrade(grade);
      }
      if (Inspections.isNotEmpty(idCardNumber)) {
        student.setIdCardNumber(idCardNumber);
      }
      if (Inspections.isNotEmpty(localPhone)) {
        student.setLocalPhone(localPhone);
      }
      if (Inspections.isNotEmpty(mail)) {
        student.setMail(mail);
      }
      if (Inspections.isNotEmpty(passportNumber)) {
        student.setPassportNumber(passportNumber);
      }
      if (Inspections.isNotEmpty(pwd)) {
        student.setPwd(pwd);
      }
      if (Inspections.isNotEmpty(realName)) {
        student.setRealName(realName);
      }
      if (Inspections.isNotEmpty(phoneCode)) {
        student.setPhoneCode(phoneCode);
      }
      if (Inspections.isNotEmpty(lastLogin)) {
        student.setLastLogin(lastLogin);
      }

      studentDao.updateByPrimaryKeySelective(student);
      return 1;
    } catch (Exception e) {
      log.debug("modify student failed");
      throw e;
    }
  }

  @Override
  public int blockStudentByUUID(QueryStudentDTO queryStudentDTO) {
    return this.changeStudentStatus(queryStudentDTO, CommonConstant.ACCOUNT_BLOCKED);
  }

  @Override
  public int unblockStudentByUUID(QueryStudentDTO queryStudentDTO) {
    return this.changeStudentStatus(queryStudentDTO, CommonConstant.ACCOUNT_NORMAL);
  }

  private int changeStudentStatus(QueryStudentDTO queryStudentDTO, String accountStatus) {
    if (!accountStatus.equals(CommonConstant.ACCOUNT_NORMAL)
        && !accountStatus.equals(CommonConstant.ACCOUNT_BLOCKED)) {
      return 3;
    }
    if (queryStudentDTO.getUuid() == null) {
      return 2;
    }
    Student student = this.getStudentByUUID(queryStudentDTO);
    if (student == null) {
      return 2;
    }
    student.setStatus(accountStatus);
    StudentExample example = new StudentExample();
    example.createCriteria()
        .andUuidEqualTo(queryStudentDTO.getUuid());
    studentDao.updateByExampleSelective(student, example);
    return 1;
  }
}
