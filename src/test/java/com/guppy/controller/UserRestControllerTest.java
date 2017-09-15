//package com.guppy.controller;
//
//import com.guppy.repository.UserMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.security.Principal;
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Created by kanghonggu on 2017. 7. 14..
// */
//
//@Transactional
//@Rollback
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class UserRestControllerTest {
//
//    private static Logger logger = LoggerFactory.getLogger(UserRestControllerTest.class);
//
//    @Autowired
//    private FilterChainProxy springSecurityFilterChain;
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void 셋업 () {
//        this.mockMvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .addFilter(springSecurityFilterChain)
//                .build();
//    }
//
//
//    /*@Test
//    public void 로그인시_유저_데이터_저장_테스트 () throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/login/facebook").with(csrf()))
//                .andDo(print())
//                .andExpect(status().is3xxRedirection());
//                //.andExpect(redirectedUrl("/user"))
//
//    }*/
//
//
//
//}
