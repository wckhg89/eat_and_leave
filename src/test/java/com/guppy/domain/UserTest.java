package com.guppy.domain;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.guppy.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;
import static org.junit.Assert.*;

/**
 * Created by kanghonggu on 2017. 7. 14..
 */

@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

    private static Logger logger = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void BcryptSalt () {
        logger.info(BCrypt.gensalt());
    }

    @Test
    public void 사용자_로그인시_초기_User_도메인_초기화 () {
        Authentication auth = getAuthentication();

        User loginUser = User.initUser(auth);

        logger.info("loginUser Info - {}", loginUser);

        assertEquals("$2a$10$/L4lnbQy2Myy//jnnuHBNOBSB3zJpoHrrciS4CibIiCRCo3g1n8DO", loginUser.getUserKey());

    }

    private Authentication getAuthentication() {
        return new Authentication() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public Object getCredentials() {
                    return null;
                }

                @Override
                public Object getDetails() {
                    Map<String,String> detailMap =
                            Maps.newHashMap(ImmutableMap.<String, String>builder()
                            .put("name", "Test User")
                            .put("id", "12345").build());

                    return detailMap;
                }

                @Override
                public Object getPrincipal() {
                    return null;
                }

                @Override
                public boolean isAuthenticated() {
                    return false;
                }

                @Override
                public void setAuthenticated(boolean b) throws IllegalArgumentException {

                }

                @Override
                public String getName() {
                    return null;
                }
            };
    }

}
