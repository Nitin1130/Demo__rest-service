package com.example.restservice.restservice;

import com.example.restservice.restservice.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
    
@RestController
public class RestServiceController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter =  new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Nitin") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}
