package com.example.unitTestingMockDemo;

import com.example.unitTestingMockDemo.entity.Person;
import com.example.unitTestingMockDemo.repository.PersonRepository;
import com.example.unitTestingMockDemo.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloServiceTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void helloService() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(status().isOk());
    }

    @Test
    void helloService_testData() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(content().string("Hello World"));
    }

    @Test
    void helloService_getPerson() throws Exception {
        String expected = "{\"id\":123,\"name\":\"Ilyas\",\"city\":\"Bandung\"}";

        mockMvc.perform(get("/person/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void helloService_getPersonObject() throws Exception {

        mockMvc.perform(get("/person/123"))
                .andDo(result -> {
                    Person person = mapper.readValue(result.getResponse().getContentAsString(), Person.class);
                    assertEquals("Bandung", person.getCity());
                });
    }


}
