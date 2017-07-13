package com.guppy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by kanghonggu on 2017. 7. 13..
 */

@Controller
public class HomeController {

    @GetMapping("")
    public String index () {
        return "index";
    }

}
