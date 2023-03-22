package org.example.quoter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuote();
    }
}