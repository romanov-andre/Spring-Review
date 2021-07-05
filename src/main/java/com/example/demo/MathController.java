package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/pi")
    public String getMathPI() {
        return String.valueOf(Math.PI);
    }

    @GetMapping("/calculate")
    public int getCalculate(@RequestParam(required = false, defaultValue = "sum") String operation, int x, int y) {
        if (operation.equals("sum"))return x + y;
        if (operation.equals("subtract"))return x - y;
        if (operation.equals("multiply"))return x * y;
        if (operation.equals("divide"))return x / y;
        return 0;
    }

    @PostMapping("/sum")
    public int sum(@RequestParam int... n) {
        return Arrays.stream(n).sum();
    }



}


