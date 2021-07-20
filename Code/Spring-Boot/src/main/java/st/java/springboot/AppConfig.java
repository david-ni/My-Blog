package st.java.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import st.java.springboot.beans.ExampleBean;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@Configuration
@Import({ExampleBean.class})
public class AppConfig{

}
