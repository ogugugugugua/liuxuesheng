package scut.yulin.admin.service;

import scut.yulin.admin.model.Student;

import java.util.List;

public interface StudentAdminService {
    List<Student> listAll();
    Student listById(Long id);
    Student listByAccountName(String name);
    Integer add(Student student);
    Integer update(Student student);
}
