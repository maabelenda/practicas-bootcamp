package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class MiFactory {

    private static String fileName = "./src/Utils/MiFactory.properties";


    public static Object getInstance(String objName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {

        FileReader reader=new FileReader(fileName);
        Properties properties = new Properties();
        properties.load(reader);

        Class<?> cls = Class.forName(properties.getProperty(objName));
        Constructor<?> ctor = cls.getConstructor();
        Object object = ctor.newInstance(new Object[] {});

        return object;
    }
}
