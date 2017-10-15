package com.guppy.mapper;

import com.guppy.repository.UserMapper;
import com.guppy.repository.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */

@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {

    private static Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper memberMapper;

    private User entity;

    @Before
    public void setUp() {
        entity = new User();
        entity.setUserName("stunstun");

        memberMapper.save(entity);

        List<User> userList
                = memberMapper.findByUserName("stunstun");

        assertNotNull(userList);
    }


    @Test
    public void insertAndDelete() {
        assertNotNull(entity);

        List<User> users = memberMapper.findByUserName("stunstun");
        memberMapper.delete(users.get(0));

        List<User> deleteUsers = memberMapper.findByUserName("stunstun");
        assertEquals(0, deleteUsers.size());

    }
}
