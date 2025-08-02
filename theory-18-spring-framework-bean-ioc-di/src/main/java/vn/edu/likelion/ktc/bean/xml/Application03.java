package vn.edu.likelion.ktc.bean.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application03 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc-container-01.xml");

        Developer fe = (Developer) context.getBean("frontend");
        System.out.println(fe);
        Developer be = (Developer) context.getBean("backend");
        System.out.println(be);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
