package scut.yulin.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author xieyulin
 * @date 10/04/2021
 */
@RestController
@RequestMapping("/admin")
@Api()
public class StudentAdminController {
    @RequestMapping("test")
    public String test() {
        return "test";
    }
}
