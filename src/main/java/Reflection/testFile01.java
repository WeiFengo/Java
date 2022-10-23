package Reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testFile01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> c : declaredConstructors) {
            System.out.println(c);
        }

        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance("E:\\java\\Spring\\mynew.txt");
        Method createNewFile = cls.getDeclaredMethod("createNewFile");
        createNewFile.invoke(o);





    }
}
