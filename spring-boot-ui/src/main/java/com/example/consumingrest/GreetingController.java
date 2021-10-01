package com.example.consumingrest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting-javaconfig")
    public Greeting greetingWithJavaconfig(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== in greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/client")
    public String getClient(@RequestParam(required = false, defaultValue = "World") String name) {

        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://localhost:8080/person/datatable?draw=1&start=0&length=10",
                Quote.class);
        System.out.println(quote.toString());
        // http://localhost:8080/person/datatable?draw=1&start=0&length=10&search[value]=yan
        return quote.toString();
    }
}

/*
 * import java.util.concurrent.atomic.AtomicLong;
 * 
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController public class GreetingController {
 * 
 * private static final String template = "Hello, %s!"; private final AtomicLong
 * counter = new AtomicLong();
 * 
 * @GetMapping("/greeting") public Greeting greeting(@RequestParam(value =
 * "name", defaultValue = "World") String name) { return new
 * Greeting(counter.incrementAndGet(), String.format(template, name)); } }
 */
