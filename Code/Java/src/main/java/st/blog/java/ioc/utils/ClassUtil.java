package st.blog.java.ioc.utils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author David Wang <https://github.com/superTerrorist>
 */
public class ClassUtil{
    private static ClassUtil instance = new ClassUtil();

    /**
     * 获取包下所有类名
     */
    private static Set<String> getClassNamesByPackageName(String packageName, Set<String> classes){

        if(classes == null) classes = new HashSet<>();

        String path = packageName.replace(".",File.separator);
        URL url = instance.getClass().getClassLoader().getResource(path);

        File rootDir = new File(url.getPath());

        if(rootDir == null) return null;

        for(File file: rootDir.listFiles()){
            if(file.isDirectory()){
                getClassNamesByPackageName(packageName+"."+file.getName(),classes);
            }else if(file.getName().indexOf(".class") > 0){
                classes.add(packageName + "." + file.getName().replaceAll("\\.class$",""));
            }
        }

        return classes;
    }

    public static Map<String,Class<?>> getClassesByPackageName(String packageName){

        Set<String> classNames = getClassNamesByPackageName(packageName,null);
        HashMap<String,Class<?>> classes = new HashMap<>();

        for(String name: classNames){
            try{
                classes.put(name,Class.forName(name));
            }catch(ClassNotFoundException exception){
                System.out.println("The Class " + name + " Not Exist!");
            }
        }

        return classes;
    }
}
