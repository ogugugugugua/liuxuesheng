package scut.yulin.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.mbg.model.Student;
import scut.yulin.admin.service.StudentAdminService;

import java.util.List;

/**
 * @author xieyulin
 * @date 10/04/2021
 */
@RestController
@RequestMapping("/admin")
@Api()
public class StudentAdminController {
    @Autowired
    StudentAdminService studentAdminService;

    @RequestMapping("test")
    public String test() {
        return "test";
    }

    @RequestMapping("all")
    public List<Student> listAllStudent(){
        System.out.println("hey!");
        return studentAdminService.listAll();
    }
}
