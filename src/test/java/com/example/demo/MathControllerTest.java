package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
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

    @Test
    public void testVolume() throws Exception {
        int length = 42;
        int width = 56;
        int height = 79;
        int volume = length * width * height;
        RequestBuilder request = MockMvcRequestBuilders.put("/math/volume/" + length +"/" + width + "/" + height);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(volume)));
    }

    @Test
    public void testCalculatedArea() throws Exception {
        int radius = 4;
        String circleArea = String.valueOf(Math.PI * Math.pow(radius, 2));
        RequestBuilder request = MockMvcRequestBuilders.post("/math/area" )
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", String.valueOf(radius));
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(circleArea)));

        int width = 4;
        int height = 7;
        String rectArea = String.valueOf(width * height);
        request = MockMvcRequestBuilders.post("/math/area" )
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", String.valueOf(width))
                .param("height", String.valueOf(height));
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(rectArea)));
    }






}
