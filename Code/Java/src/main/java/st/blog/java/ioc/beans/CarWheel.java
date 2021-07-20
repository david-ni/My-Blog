package st.blog.java.ioc.beans;

import st.blog.java.ioc.annotations.Component;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
@Component
public class CarWheel{
    public void print(){
        System.out.println("I'm CarWheel!");
    }
}
