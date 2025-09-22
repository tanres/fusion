package com.tanres.fusion.module.system.biz.controller.admin.dept.vo.dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "管理后台 - 部门列表 Request VO")
public class DeptListReqVO {

    @Schema(description = "部门名称,模糊匹配", example = "研发部")
    private String name;

    @Schema(description = "状态,参见 StatusEnum 枚举", example = "1")
    private Integer status;

}
