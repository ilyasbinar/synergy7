package com.example.unitTestingMockDemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class AdminTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void helloService_getPersonObject() throws Exception {

//        mockMvc
//                .perform(get("/admin").with(user("admin").passsword("123").roles));
    }
}
