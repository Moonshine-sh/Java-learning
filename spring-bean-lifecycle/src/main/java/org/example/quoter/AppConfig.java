package org.example.quoter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

//    @Bean
//    public Quoter quoter() {
//        TerminatorQuoter terminatorQuoter = new TerminatorQuoter();
//        terminatorQuoter.setMessage("I'll be back");
//        return terminatorQuoter;
//    }
}
