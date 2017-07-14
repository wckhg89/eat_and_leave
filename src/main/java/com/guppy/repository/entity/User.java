package com.guppy.repository.entity;

import lombok.*;

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


}
