package scut.yulin.admin.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import scut.yulin.admin.dto.login.LoginDTO;
import scut.yulin.admin.dto.student.InsertStudentDTO;
import scut.yulin.admin.dto.student.ModifyStudentDTO;
import scut.yulin.admin.dto.student.QueryStudentDTO;
import scut.yulin.mbg.model.Resource;
import scut.yulin.mbg.model.Student;

public interface StudentAdminService {
    List<Student> getStudentList(QueryStudentDTO queryStudentDTO);
    Student getStudentByUUID(QueryStudentDTO queryStudentDTO);
    Student getStudentByAccountName(String name);
    Integer addNewStudent(InsertStudentDTO insertStudentDTO);
    Integer modifyStudent(ModifyStudentDTO modifyStudentDTO);

    int blockStudentByUUID(QueryStudentDTO queryStudentDTO);
    int unblockStudentByUUID(QueryStudentDTO queryStudentDTO);

    String login(LoginDTO loginDTO);
    String register(InsertStudentDTO insertStudentDTO);
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取指定用户的可访问资源
     */
    List<Resource> getResourceList(String uuid);
}
