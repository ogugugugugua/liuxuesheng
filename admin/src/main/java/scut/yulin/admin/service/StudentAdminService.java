package scut.yulin.admin.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import scut.yulin.admin.dto.login.LoginDTO;
import scut.yulin.admin.dto.student.InsertStudentDTO;
import scut.yulin.admin.dto.student.ModifyStudentDTO;
import scut.yulin.admin.dto.student.QueryStudentDTO;
import scut.yulin.admin.model.Student;

public interface StudentAdminService {
    List<Student> getStudentList(QueryStudentDTO queryStudentDTO);
    Student getStudentByUUID(QueryStudentDTO queryStudentDTO);
    Student getStudentByAccountName(String name);
    Integer addNewStudent(InsertStudentDTO insertStudentDTO);
    Integer modifyStudent(ModifyStudentDTO modifyStudentDTO);

    int blockStudentByUUID(QueryStudentDTO queryStudentDTO);
    int unblockStudentByUUID(QueryStudentDTO queryStudentDTO);

    String login(LoginDTO loginDTO);
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);
}
