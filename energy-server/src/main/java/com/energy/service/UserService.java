package com.energy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.energy.dto.UserLoginDTO;
import com.energy.entity.User;

public interface UserService extends IService<User> {

    /**
     * 微信用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

}
