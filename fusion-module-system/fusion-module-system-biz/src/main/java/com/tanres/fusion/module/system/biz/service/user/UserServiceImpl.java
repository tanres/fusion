package com.tanres.fusion.module.system.biz.service.user;

import com.tanres.fusion.module.system.biz.dal.dataobject.UserDO;
import com.tanres.fusion.module.system.biz.dal.redis.RedisKeyConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final Map<String, UserDO> userMap = new HashMap<>();

    @Cacheable(value = RedisKeyConstants.SYSTEM_USER_KEY, key = "#username")
    @Override
    public UserDO getUser(String username) {
        log.warn("从MySQL数据库中获取用户信息！");
        return userMap.get(username);
    }

    @CachePut(value = RedisKeyConstants.SYSTEM_USER_KEY, key = "#user.username")
    @Override
    public UserDO addUser(UserDO user) {
        userMap.put(user.getUsername(), user);
        return user;
    }

    @CachePut(value = RedisKeyConstants.SYSTEM_USER_KEY, key = "#user.username")
    @Override
    public void putUser(UserDO user) {
        userMap.put(user.getUsername(), user);
    }

    @CacheEvict(value = RedisKeyConstants.SYSTEM_USER_KEY, key = "#username")
    @Override
    public void deleteUser(String username) {
//        userMap.remove(username);
    }
}

