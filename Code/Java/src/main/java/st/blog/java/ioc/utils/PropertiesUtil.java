package st.blog.java.ioc.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class PropertiesUtil{

    private static PropertiesUtil instance = new PropertiesUtil();

    private Properties properties = null;

    public static void loadProperties(String fileName) throws FileNotFoundException,IOException{

        InputStream inputStream = instance.getClass().getClassLoader().getResourceAsStream(fileName);

        if(inputStream == null) throw new FileNotFoundException("property file " + fileName + " not found in the classpath!");

        if(instance.properties == null) instance.properties = new Properties();

        instance.properties.load(inputStream);

        inputStream.close();
    }

    public static String getByKey(String key){
        if(instance.properties == null) return null;
        return instance.properties.getProperty(key);
    }
}
