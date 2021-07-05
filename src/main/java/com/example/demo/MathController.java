package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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
        if (operation.equals("sum")) return x + y;
        if (operation.equals("subtract")) return x - y;
        if (operation.equals("multiply")) return x * y;
        if (operation.equals("divide")) return x / y;
        return 0;
    }

    @PostMapping("/sum")
    public int sum(@RequestParam int... n) {
        return Arrays.stream(n).sum();
    }


    @RequestMapping("/volume/{length}/{width}/{height}")
    public int volume(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
        return length * width * height;
    }

    @PostMapping("/area")
    public String calculateArea(@RequestParam String type, @RequestParam(required = false, defaultValue = "0") int radius,
                                @RequestParam(required = false, defaultValue = "0") int width,
                                @RequestParam(required = false, defaultValue = "0") int height) {

        if (type.equals("circle")) {
            if (radius == 0) return String.valueOf("Invalid");
            return String.valueOf(Math.PI * Math.pow(radius, 2));
        }
        if (type.equals("rectangle")) {
            if (width == 0 || height == 0) return String.valueOf("Invalid");
            return String.valueOf(width * height);
        }
        return "Invalid";
    }

}


