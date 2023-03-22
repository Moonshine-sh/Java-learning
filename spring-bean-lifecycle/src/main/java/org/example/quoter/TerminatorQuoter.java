package org.example.quoter;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Profiling
@Component
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 5)
    private int repeat;

    public void setMessage(String message) {
        this.message = message;
    }

    @Value("I'll be back")
    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1:");
        System.out.println(repeat);
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2:");
        System.out.println(repeat);
    }

    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3:");
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
