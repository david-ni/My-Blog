package st.blog.java.ioc;

import st.blog.java.ioc.beans.Car;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class IocTest{
    public static void main(String[] args){
        ApplicationContext context = new ApplicationContext();
        try{
            context.init();
            Car car = (Car) context.getBean("st.blog.java.ioc.beans.Car");
            car.print();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
