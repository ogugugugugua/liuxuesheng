package scut.yulin.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.mbg.mapper.StudentMapper;
import scut.yulin.admin.mbg.model.Student;
import scut.yulin.admin.mbg.model.StudentExample;
import scut.yulin.admin.service.StudentAdminService;

import java.util.List;

@Service
public class StudentAdminServiceImpl implements StudentAdminService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> listAll() {
        return studentMapper.selectByExample(new StudentExample());
    }
}
