package com.guppy.repository.entity;

import lombok.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"userIdx"})
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userIdx;
    private String userName;
    private String userPrincipal;
    private String socialType;
    private String userKey;
    private String userProfileUrl;
    private String userUrl;

    private User(Authentication authentication) {
        this.setUserInfo(authentication);
    }

    public static User initUser(Authentication authentication) {
        return new User(authentication);
    }

    public void setUserInfo(Authentication authentication) {
        HashMap<String, String> detailMap
                = (HashMap<String, String>) authentication.getDetails();

        this.userName = detailMap.get("name");
        this.userPrincipal = detailMap.get("id");
        this.socialType = "FACEBOOK"; // TODO: 다른 소셜 붙일때 수정 필요

        this.setUserKey();
        this.setUrl();
    }

    public void setUrl() {
        StringBuilder builder = new StringBuilder();

        setInitUserProfileUrl(builder);
        
        builder.setLength(0);

        setInitUserUrl(builder);
    }



    private void setInitUserUrl(StringBuilder builder) {
        this.userUrl = builder
                .append("https://facebook.com/")
                .append(userPrincipal)
                .toString();
    }

    private void setInitUserProfileUrl(StringBuilder builder) {
        this.userProfileUrl = builder
                .append("http://graph.facebook.com/")
                .append(userPrincipal)
                .append("/picture?type=square")
                .append("&width=240")
                .append("&height=170")
                .toString();
    }

    public void setUserKey() {
        final String salt = "$2a$10$/L4lnbQy2Myy//jnnuHBNO";

        StringBuilder builder = new StringBuilder();
        builder.append(userName).append(userPrincipal).append(socialType);

        this.userKey = BCrypt.hashpw(builder.toString(), salt);
    }


}
