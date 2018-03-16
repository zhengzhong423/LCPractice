package com.zhong.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RestfulController {
    @RequestMapping(value = "/welcomeRest", method = GET)
    public Person welcome(@RequestParam(value = "name", defaultValue = "Xinyu") String name) {
        Random rand = new Random();
        return new Person(name, rand.nextInt(2) % 2 == 0 ? "Male" : "Female");
    }
}
