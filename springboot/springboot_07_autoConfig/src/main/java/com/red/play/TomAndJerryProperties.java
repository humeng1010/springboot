package com.red.play;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@Data
@ConfigurationProperties(prefix = "play")
public class TomAndJerryProperties {
    private Cat cat;
    private Mouse mouse;
}
