package com.guppy.repository;

import com.guppy.repository.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */

@Mapper
public interface UserMapper {
    List<User> findAll();

    List<User> findByUserName(@Param("userName") String userName);

    User findByUserKey(@Param("userKey") String userKey);

    User findOne(Long id);

    Boolean exists(Long id);

    void save(User user);

    void update(User user);

    void delete(User user);
}
