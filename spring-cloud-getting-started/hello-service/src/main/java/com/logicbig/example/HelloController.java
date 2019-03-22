package com.logicbig.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloController {
    private AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    @HystrixCommand(fallbackMethod="getDataFallBack")
    public HelloObject getHelloWordObject() {
        HelloObject hello = new HelloObject();
        if(true)
        throw new RuntimeException();
        hello.setMessage("Hi there! you are number " + counter.incrementAndGet());
        return hello;
    }

    public HelloObject getDataFallBack() {
    	  HelloObject hello = new HelloObject();
    	  System.out.println("inside getDataFallBack()");
    	  counter.hashCode();
    	  return hello;
    }

}