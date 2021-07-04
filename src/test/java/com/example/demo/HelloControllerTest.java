package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // adds spring functionality to test
@WebMvcTest(HelloController.class) // specifies which controller to test
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHomepage() throws Exception {
        // creates a request
        RequestBuilder request = MockMvcRequestBuilders.get("/test/hello");
        // sends request
        mvc.perform(request)
                .andExpect(status().isOk()) // expects page to exists
                .andExpect(content().string("Hello World")); // expects response content to be ...
    }

}
