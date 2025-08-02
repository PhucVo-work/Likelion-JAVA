package vn.edu.likelion.ktc.bean.annotation;

import org.springframework.context.annotation.Bean;

public class AppConfiguration {

    @Bean
    public Developer mobile() {
        Developer mbDev = new Developer();
        mbDev.setId(3);
        mbDev.setName("to@gmail.com");
        mbDev.setMajor("Mobile Developer");
        return mbDev;
    }

    @Bean
    public Developer fullstack() {
        Developer fsDev = new Developer();
        fsDev.setId(4);
        fsDev.setName("tin@gmail.com");
        fsDev.setMajor("Fullstack Developer");
        return fsDev;
    }
}