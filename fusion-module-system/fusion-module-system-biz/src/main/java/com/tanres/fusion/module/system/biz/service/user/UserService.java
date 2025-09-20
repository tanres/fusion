package com.tanres.fusion.module.system.biz.service.user;

import com.tanres.fusion.module.system.biz.dal.dataobject.UserDO;

public interface UserService {
    UserDO getUser(String username);

    UserDO addUser(UserDO user);

    void putUser(UserDO user);

    void deleteUser(String username);
}
