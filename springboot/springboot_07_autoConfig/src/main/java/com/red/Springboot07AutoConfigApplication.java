package com.red;

import com.red.play.TomAndJerry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(TomAndJerry.class)
public class Springboot07AutoConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Springboot07AutoConfigApplication.class, args);
        TomAndJerry tomAndJerry = context.getBean(TomAndJerry.class);
        tomAndJerry.play();

    }

}
