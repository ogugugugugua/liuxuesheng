package scut.yulin.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.dto.student.InsertStudentDTO;
import scut.yulin.admin.dto.student.ModifyStudentDTO;
import scut.yulin.admin.dto.student.QueryStudentDTO;
import scut.yulin.admin.model.Student;
import scut.yulin.admin.service.StudentAdminService;
import scut.yulin.common.vo.ResponseVO;

/**
 * @author xieyulin
 * @date 10/04/2021
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "StudentAdminController", value = "学生信息controller")
public class StudentAdminController {
    @Autowired
    StudentAdminService studentAdminService;

    @ApiOperation("获得所有留学生列表")
    @RequestMapping("all")
    public ResponseVO getStudentList(){
        return ResponseVO.success(studentAdminService.getStudentList(new QueryStudentDTO()));
    }

    @ApiOperation("根据id获得留学生信息")
    @GetMapping("/student/id/{id}")
    public ResponseVO getStudentByUUID(@PathVariable("id") String uuid){
        Student student = studentAdminService.getStudentByUUID(new QueryStudentDTO(uuid));
        if (student!=null) {
            return ResponseVO.success(student);
        }else {
            return ResponseVO.failed();
        }
    }

    @ApiOperation("根据id获得留学生信息")
    @GetMapping("/student/name/{name}")
    public ResponseVO<Student> getStudentByAccountName(@PathVariable("name") String name){
        Student student = studentAdminService.getStudentByAccountName(name);
        if (student!=null) {
            return ResponseVO.success(student);
        }else {
            return ResponseVO.failed();
        }
    }

    @ApiOperation("新增留学生")
    @PostMapping("/student")
    public ResponseVO addNewStudent(@RequestBody InsertStudentDTO student){
        int status = studentAdminService.addNewStudent(student);
        if (status == 1) {
            return ResponseVO.success("addNewStudent ok");
        }
        return ResponseVO.failed("addNewStudent failed");
    }

    @ApiOperation("更新留学生")
    @PutMapping("/student")
    public ResponseVO modifyStudent(@Validated @RequestBody ModifyStudentDTO student){
        int status = studentAdminService.modifyStudent(student);
        if (status == 1) {
            return ResponseVO.success("modifyStudent ok");
        }
        if (status == 2) {
            return ResponseVO.failed("modifyStudent not found");
        }
        return ResponseVO.failed("modifyStudent failed");
    }

    @ApiOperation("更新留学生")
    @PutMapping("/block/student")
    public ResponseVO blockStudentByUUID(QueryStudentDTO queryStudentDTO) {
        int status = studentAdminService.blockStudentByUUID(queryStudentDTO);
        if (status == 1) {
            return ResponseVO.success("blockStudentByUUID ok");
        }
        if (status == 2) {
            return ResponseVO.failed("blockStudentByUUID not found");
        }
        return ResponseVO.failed("blockStudentByUUID failed");
    }

    @ApiOperation("更新留学生")
    @PutMapping("/unblock/student")
    public ResponseVO unblockStudentByUUID(QueryStudentDTO queryStudentDTO) {
        int status = studentAdminService.unblockStudentByUUID(queryStudentDTO);
        if (status == 1) {
            return ResponseVO.success("unblockStudentByUUID ok");
        }
        if (status == 2) {
            return ResponseVO.failed("unblockStudentByUUID not found");
        }
        return ResponseVO.failed("unblockStudentByUUID failed");
    }
}
