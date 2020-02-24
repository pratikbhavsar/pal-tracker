package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final String message;

    public HelloService(@Value("${welcome.message}") String message) {
        this.message = message;
    }

    public String sayHello() {
        return message;
    }
}
