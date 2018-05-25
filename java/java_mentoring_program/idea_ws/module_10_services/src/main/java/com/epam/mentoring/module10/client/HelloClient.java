package com.epam.mentoring.module10.client;

public class HelloClient {

    public static void main(String[] args) {
        HelloService service = new HelloService();
        Hello hello = service.getHelloPort();
        String text = hello.sayHello("Dave");
        System.out.println(text);
    }
}
