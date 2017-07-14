package com.guppy.repository.entity;

import com.google.common.collect.Maps;
import lombok.*;
import org.springframework.security.core.Authentication;

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
    private int userKey;
    private String userProfileUrl;
    private String userUrl;

    private User (Authentication authentication) {
        this.setUserInfo(authentication);
    }

    public static User initUser (Authentication authentication) {
        return new User(authentication);
    }

    public void setUserInfo (Authentication authentication) {
        HashMap<String, String> detailMap
                = (HashMap<String, String>) authentication.getDetails();

        this.userName = detailMap.get("name");
        this.userPrincipal = detailMap.get("id");
        this.socialType = "FACEBOOK"; // TODO: 다른 소셜 붙일때 수정 필요

        this.setUserKey();
        this.setUrl();
    }

    public void setUrl () {
        StringBuilder builder = new StringBuilder();

        this.userProfileUrl = builder
                .append("http://graph.facebook.com/")
                .append(userPrincipal)
                .append("/picture?type=square")
                .toString();

        builder.setLength(0);

        this.userUrl = builder
                .append("https://facebook.com/")
                .append(userPrincipal)
                .toString();
    }

    public void setUserKey() {
        this.userKey = this.hashCode();
    }

    @Override
    public int hashCode() {
        StringBuilder builder = new StringBuilder();
        builder.append(userName).append(userPrincipal).append(socialType);

        return builder.hashCode();
    }


}
