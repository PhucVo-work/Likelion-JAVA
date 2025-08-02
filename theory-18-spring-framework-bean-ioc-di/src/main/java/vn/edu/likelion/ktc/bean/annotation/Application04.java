package vn.edu.likelion.ktc.bean.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application04 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        Developer mbDev = (Developer) context.getBean("mobile");
        System.out.println(mbDev);

        Developer fsDev = (Developer) context.getBean("fullstack");
        System.out.println(fsDev);

        ((AnnotationConfigApplicationContext) context).close();
    }
}
