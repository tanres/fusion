package com.tanres.fusion.module.system.biz.dal.dataobject.dept;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tanres.fusion.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName("sys_dept")
public class DeptDO extends BaseDO {
    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String name;


    /**
     * 负责人
     */
    private Long leaderUserId;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态
     */
    private Integer status;
}
