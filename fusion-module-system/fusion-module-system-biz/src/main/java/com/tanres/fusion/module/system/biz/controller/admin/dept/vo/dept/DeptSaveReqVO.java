package com.tanres.fusion.module.system.biz.controller.admin.dept.vo.dept;

import com.tanres.fusion.framework.core.enums.StatusEnum;
import com.tanres.fusion.framework.core.validation.InEnum;
import com.tanres.fusion.framework.core.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "管理后台 - 部门创建/修改 Request VO")
public class DeptSaveReqVO {

    @Schema(description = "部门编号", example = "1024")
    private Long id;

    @Schema(description = "部门名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "研发部")
    private String name;

    @Schema(description = "父部门编号", example = "1024")
    private Long parentId;

    @Schema(description = "显示顺序", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    @Schema(description = "负责人用户编号", example = "1024")
    private Long leaderUserId;

    @Schema(description = "手机", example = "18964780700")
    @Mobile(message = "手机号格式不正确")
    private String mobile;

    @Schema(description = "邮箱", example = "gang@tanres.com")
    @Email(message = "邮箱格式不正确")
    @Size(max = 64, message = "邮箱长度不能超过 64 个字符")
    private String email;

    @Schema(description = "状态,见 StatusEnum 枚举", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    @InEnum(value = StatusEnum.class, message = "修改状态必须是 {value}")
    private Integer status;
    
}
