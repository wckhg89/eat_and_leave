package com.guppy.controller;

import com.guppy.repository.entity.User;
import com.guppy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by kanghonggu on 2017. 7. 13..
 */

@Controller
public class HomeController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public String index (Model model) {

        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "index";
    }

}
