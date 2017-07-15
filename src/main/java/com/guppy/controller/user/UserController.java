package com.guppy.controller.user;

import com.guppy.repository.entity.User;
import com.guppy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/facebook/complete")
    public String facebookComplete (Principal principal) {
        if (principal == null) {
            // TODO : 익셉션 던지자
            return "error";
        }

        Authentication authentication
                = ((OAuth2Authentication) principal).getUserAuthentication();

        userService.loginComplete(authentication);

        return "index";
    }
}