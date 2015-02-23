package com.sadvit.controller;

import com.sadvit.persistence.domain.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GreetingsController {

    @RequestMapping("/greetings")
    public List<Greeting> greetings() {
        List<Greeting> greetings = new ArrayList<Greeting>();
        for (int i = 0; i < 10; i++) {
            greetings.add(new Greeting(i, "hi, " + i));
        }
        return greetings;
    }

}
