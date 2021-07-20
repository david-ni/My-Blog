package st.blog.java.ioc.beans;

import st.blog.java.ioc.annotations.Autowire;
import st.blog.java.ioc.annotations.Component;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@Component
public class Car{
    @Autowire
    public CarWheel carWheel;

    public void print(){
        carWheel.print();
    }
}
