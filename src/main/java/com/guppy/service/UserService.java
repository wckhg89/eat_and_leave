package com.guppy.service;

import com.guppy.repository.UserMapper;
import com.guppy.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User loginComplete (Authentication authentication) {
        User loginUser = User.initUser(authentication);
        User dbUser = userMapper.findByUserKey(loginUser.getUserKey());

        if (dbUser != null) {
            return loginUser;
        }

        //$2a$10$/L4lnbQy2Myy//jnnuHBNORmAkEcKuVWC6wE9H62GYfpOtAo7QyI2
        userMapper.save(loginUser);

        return loginUser;
    }

}
