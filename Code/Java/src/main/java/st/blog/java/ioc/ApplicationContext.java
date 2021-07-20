package st.blog.java.ioc;

import st.blog.java.ioc.annotations.Autowire;
import st.blog.java.ioc.annotations.Component;
import st.blog.java.ioc.utils.ClassUtil;
import st.blog.java.ioc.utils.PropertiesUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class ApplicationContext{

    // 包下所有的类
    public Map<String, Class<?>> classes;

    public Map<String, Object> beans;

    /**
     * 获取需要扫描的路径
     */
    private String getBeanScanPackage() throws IOException{
        PropertiesUtil.loadProperties("application.properties");
        return PropertiesUtil.getByKey("application.scan.package");
    }

    /**
     * 实例化包下的类
     */
    private Map<String, Object> InitBeans(){
        return classes.entrySet().stream().filter((item) -> {
            Class<?> clazz = item.getValue();
            return clazz.getAnnotation(Component.class) != null;
        }).map((item) -> {
            try{
                return new HashMap.SimpleEntry<String, Object>(item.getKey(), item.getValue().newInstance());
            }catch(Exception exception){
                return null;
            }
        }).filter(item -> item != null).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }

    /**
     * 注入
     */
    private void injectAttribute(Object object) throws Exception{

        Class<? extends Object> clazz = object.getClass();
        // [What is the difference between getFields and getDeclaredFields in Java reflection](https://stackoverflow.com/questions/16966629/what-is-the-difference-between-getfields-and-getdeclaredfields-in-java-reflectio)
        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){
            if(field.getAnnotation(Autowire.class) != null){
                String beanId = field.getType().getName();
                Object bean = beans.get(beanId);
                if(bean != null){
                    field.setAccessible(true);
                    field.set(object, bean);
                }
            }
        }

    }

    public void init() throws Exception{
        // 获取包下所有的类
        classes = ClassUtil.getClassesByPackageName(getBeanScanPackage());
        // 实例化注解类
        beans = InitBeans();

        for(Map.Entry<String, Object> entry : beans.entrySet()){
            injectAttribute(entry.getValue());
        }
    }

    public Object getBean(String name){
        return beans.get(name);
    }
}
