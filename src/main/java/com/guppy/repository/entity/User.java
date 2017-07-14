package com.guppy.repository.entity;

import lombok.*;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class User {

    private Long id;
    private String userName;

}
