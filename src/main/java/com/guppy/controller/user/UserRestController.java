package com.guppy.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by kanghonggu on 2017. 7. 13..
 */

@RestController
public class UserRestController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        // SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }

}
