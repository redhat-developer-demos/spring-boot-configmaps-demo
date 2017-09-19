package com.redhat.developers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class GreeterController {

    @Value("${greeter.message}")
    private String greeterMessageFormat; 

    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        log.info("Prefix :{} and User:{}", prefix, user);
        if (prefix == null) {
            prefix = "Hello!";
        }

        return String.format(greeterMessageFormat, prefix, user);
    }
}