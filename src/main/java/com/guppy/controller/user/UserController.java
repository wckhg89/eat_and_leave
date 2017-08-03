package com.guppy.controller.user;

import com.guppy.repository.entity.User;
import com.guppy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/facebook/complete")
    public String facebookComplete (Principal principal, HttpSession httpSession) {
        if (principal == null) {
            // TODO : 익셉션 던지자
            return "error";
        }

        Authentication authentication
                = ((OAuth2Authentication) principal).getUserAuthentication();

        User user = userService.loginComplete(authentication);
        // todo : 만일 서버가 여러대이면 Redis와 같은 글로벌 캐시를 써서 세션 관리를 해야함
        httpSession.setAttribute("user", user);

        return "redirect:/";
    }

    @GetMapping("/user/own/info")
    public String userOwnInfo () {

        return "/user/own/info";
    }

    @GetMapping("/user/info/{userIdx}")
    public String userInfo (@PathVariable Long userIdx,
                            Model model) {

        User user = userService.findOne(userIdx);

        if (user == null) {
            return "error";
        }

        model.addAttribute("user", user);

        return "/user/info";
    }
}
