package com.tanres.fusion.module.system.biz.controller.admin.dept.vo.dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "管理后台 - 部门精简信息 Response VO")
public class DeptSimpleRespVO {

    @Schema(description = "部门编号", example = "1024")
    private Long id;

    @Schema(description = "部门名称", example = "研发部")
    private String name;

    @Schema(description = "父部门编号", example = "1024")
    private Long parentId;
    
}
