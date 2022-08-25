package com.red.play;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

//@Component
@Data
@EnableConfigurationProperties({TomAndJerryProperties.class})
public class TomAndJerry {
    private  Cat cat;
    private  Mouse mouse;
    private TomAndJerryProperties tomAndJerryProperties;

    public TomAndJerry(TomAndJerryProperties tomAndJerryProperties){
        this.tomAndJerryProperties = tomAndJerryProperties;
        cat = new Cat();
        cat.setName(tomAndJerryProperties.getCat()!=null&&StringUtils.hasText(tomAndJerryProperties.getCat().getName())
                ?tomAndJerryProperties.getCat().getName():"tom");
        cat.setAge(tomAndJerryProperties.getCat()!=null&&tomAndJerryProperties.getCat().getAge()!=null
                ?tomAndJerryProperties.getCat().getAge():3);
        mouse = new Mouse();
        mouse.setName(tomAndJerryProperties.getMouse()!=null&&StringUtils.hasText(tomAndJerryProperties.getMouse().getName())
                ?tomAndJerryProperties.getMouse().getName():"jerry");
        mouse.setAge(tomAndJerryProperties.getMouse()!=null&&tomAndJerryProperties.getMouse().getAge()!=null
                ?tomAndJerryProperties.getMouse().getAge():3);
    }
    public void play(){
        System.out.println(cat.getAge()+"岁的"+cat.getName()+"正在和"+ mouse.getAge()+"岁的"+mouse.getName()+"玩耍");

    }

}
