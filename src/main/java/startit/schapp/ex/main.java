package startit.schapp.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class main {
    public static void main(String[] args) {
        //this tells spring where to take its details from
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");

        //this declares and instantiates the datasource and tells it to take its details from above context
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");

        SpringApplication.run(main.class, args);
    }
}
