package st.java.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import st.java.springboot.beans.ExampleBean;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@SpringBootConfiguration
@ComponentScan(basePackages = "st.java.springboot")
@EnableAutoConfiguration
public class Application{
    public static void main(String[] args){
       ConfigurableApplicationContext context = SpringApplication.run(Application.class,args);

       System.out.println(context.getBean(""));
    }
}
