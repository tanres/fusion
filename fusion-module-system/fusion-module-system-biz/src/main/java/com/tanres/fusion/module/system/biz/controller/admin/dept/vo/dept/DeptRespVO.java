package com.tanres.fusion.module.system.biz.controller.admin.dept.vo.dept;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "管理后台 - 部门信息 Response VO")
public class DeptRespVO {

    @Schema(description = "部门编号", example = "1024")
    private Long id;

    @Schema(description = "部门名称", example = "研发部")
    private String name;

    @Schema(description = "父部门编号", example = "1024")
    private Long parentId;

    @Schema(description = "显示顺序", example = "1024")
    private Integer sort;

    @Schema(description = "负责人用户编号", example = "1024")
    private Long leaderUserId;

    @Schema(description = "手机", example = "18964780700")
    private String mobile;

    @Schema(description = "邮箱", example = "gang@tanres.com")
    private String email;

    @Schema(description = "状态,见 StatusEnum 枚举", example = "1")
    private Integer status;

    @Schema(description = "创建时间", example = "时间戳格式")
    private LocalDateTime createTime;
    
}
