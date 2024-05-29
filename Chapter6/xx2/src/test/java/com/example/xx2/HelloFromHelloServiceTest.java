package com.example.xx2;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class HelloFromHelloServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingShouldReturnMessageFromService() throws Exception {
        mockMvc.perform(get("/home/hello")).andExpect(status().isOk());
//        this.mockMvc.perform(get("/fromService")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Hello From Service")));
    }
}
