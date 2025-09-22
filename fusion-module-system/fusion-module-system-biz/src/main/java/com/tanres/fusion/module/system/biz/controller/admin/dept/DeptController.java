package com.tanres.fusion.module.system.biz.controller.admin.dept;

import com.tanres.fusion.module.system.biz.controller.admin.dept.vo.dept.DeptSaveReqVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "管理后台 - 部门")
@RestController
@RequestMapping("/sys/dept")
public class DeptController {

    @PostMapping("/create")
    @Operation(summary = "创建部门")
    public void createDept(@Valid @RequestBody DeptSaveReqVO createReqVO) {

    }
}
