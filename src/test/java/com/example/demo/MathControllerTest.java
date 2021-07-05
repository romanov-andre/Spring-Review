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

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)

public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testMathPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Math.PI)));
    }

    @Test
    public void testMathCalculate() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=sum&x=15&y=3");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(18)));
    }

    @Test
    public void testSum() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=5&n=3&n=2");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(10)));
    }






}
