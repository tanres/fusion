package com.tanres.fusion.module.system.biz.controller.admin;

import com.tanres.fusion.module.system.biz.dal.dataobject.UserDO;
import com.tanres.fusion.module.system.biz.service.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemHelloController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser() {
        UserDO admin = userService.getUser("admin");
        return admin.getUsername();
    }

    @GetMapping("/addUser")
    public String addUser() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setUsername("admin");
        user.setPassword("123456");
        userService.addUser(user);
        return "success";
    }

    @GetMapping("/putUser")
    public String putUser() {
        UserDO user = new UserDO();
        user.setId(1L);
        user.setUsername("super");
        user.setPassword("123456");
        userService.addUser(user);
        return "success";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        userService.deleteUser("admin");
        return "success";
    }
}
