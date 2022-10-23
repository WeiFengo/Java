package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    通过反射创建对象
 */
public class CreateObject {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.先获取Class对象，在newInstance(即调用无参构造创建对象)
        Class<?> cls = Class.forName("Reflection.Cat");
        Object o = cls.newInstance();

        //2.通过public的有参构造创建对象
        Constructor<?> constructor = cls.getConstructor(String.class, int.class, String.class);
        Object o1 = constructor.newInstance("汤姆猫",10,"母");
        System.out.println(o1);

        //3.通过非public的有参构造创建对象
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(String.class, int.class);
        //"暴破 暴力破解" 可以使用反射访问private私有的构造器/方法/属性
        declaredConstructor.setAccessible(true);
        Object o2 = declaredConstructor.newInstance("加菲猫", 8);
        System.out.println(o2);


    }
}
