package scut.yulin.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import scut.yulin.admin.model.Student;
import scut.yulin.admin.service.StudentAdminService;
import scut.yulin.common.constant.ResultCode;
import scut.yulin.common.vo.ResponseVO;

import java.util.List;

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
    public ResponseVO<List<Student>> listAllStudent(){
        return ResponseVO.success(studentAdminService.listAll());
    }

    @ApiOperation("根据id获得留学生信息")
    @GetMapping("/student/{id}")
    public ResponseVO<Student> listById(@PathVariable("id") Long id){
        Student student = studentAdminService.listById(id);
        if (student!=null) {
            return ResponseVO.success(student);
        }else {
            return ResponseVO.failed();
        }
    }

    @ApiOperation("根据id获得留学生信息")
    @GetMapping("/student/{name}")
    public ResponseVO<Student> listByAccountName(@PathVariable("name") String name){
        Student student = studentAdminService.listByAccountName(name);
        if (student!=null) {
            return ResponseVO.success(student);
        }else {
            return ResponseVO.failed();
        }
    }

    @ApiOperation("新增留学生")
    @PostMapping("/student")
    public ResponseVO addStudent(@RequestBody Student student){
        if (studentAdminService.listByAccountName(student.getAccountName())!=null){
            return ResponseVO.failed("已存在该用户名，请重新选择用户名");
        }
        Integer result = studentAdminService.add(student);
        if (result.equals(0)){
            return ResponseVO.failed(ResultCode.INSERT_FAILED, student);
        }
        return ResponseVO.success("数据插入成功");
    }

    @ApiOperation("更新留学生")
    @PutMapping("/student")
    public ResponseVO update(@Validated @RequestBody Student student){
        if (studentAdminService.listByAccountName(student.getAccountName())!=null){
            return ResponseVO.failed("已存在该用户名，请重新选择用户名");
        }
        Integer result = studentAdminService.update(student);
        if (result.equals(0)){
            return ResponseVO.failed(ResultCode.UPDATE_FAILED, student);
        }
        return ResponseVO.success("数据更新成功");
    }
}
