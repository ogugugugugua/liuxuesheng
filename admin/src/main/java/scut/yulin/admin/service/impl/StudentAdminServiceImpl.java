package scut.yulin.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.mbg.mapper.StudentMapper;
import scut.yulin.admin.model.Student;
import scut.yulin.admin.model.StudentExample;
import scut.yulin.admin.service.RedisService;
import scut.yulin.admin.service.StudentAdminService;
import scut.yulin.common.constant.CommonConstant;

import java.util.List;

@Service
public class StudentAdminServiceImpl implements StudentAdminService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    RedisService redisService;

    @Override
    public List<Student> listAll() {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);
        return studentMapper.selectByExample(studentExample);
    }

    @Override
    public Student listById(Long id) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED).andIdEqualTo(id);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        if (studentList.size()>0){
            return studentMapper.selectByExample(studentExample).get(0);
        }
        return null;
    }

    @Override
    public Student listByAccountName(String name) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED).andAccountNameEqualTo(name);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        if (studentList.size()>0){
            return studentMapper.selectByExample(studentExample).get(0);
        }
        return null;
    }

    @Override
    public Integer add(Student student) {
        return studentMapper.insertSelective(student);
    }

    @Override
    public Integer update(Student studentParam) {
        return studentMapper.updateByPrimaryKeySelective(studentParam);
    }
}
