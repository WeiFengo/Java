package Reflection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
   通过读取配置文件的方式 创建类并调用方法
   通过外部文件配置，不修改源码情况下控制程序
   符合ocp开闭原则，框架中常用
 */
public class Question01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //通过Properties类读取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileReader("src\\main\\java\\Reflection\\test.properties"));
        String calssName = properties.get("class").toString();
        String methodName = properties.get("method").toString();
        String propertyName = properties.get("property").toString();


        /*
            反射机制：  Class类可以理解为ReflectionClass  就是一个类 名字特殊而已
            堆中产生的Class类型的对象包含了目标类的完整信息，
            这个对象就像一面镜子，通过镜子可以观察类
         */
        //1.通过全类名获取Class对象 （一个类只有一个Class对象）
        Class<?> cls = Class.forName(calssName);   //cls----java.lang.Class
        //2.获取Cat对象实例 (运行类型为Cat)
        Object object = cls.newInstance();//.getDeclaredConstructor().newInstance();  //object----Reflection.Cat
        //3.获取方法对象
        Method method = cls.getMethod(methodName);  //method----java.lang.reflect.Method
        //4. 方法对象.invoke(对象)  传统：对象.方法
        method.invoke(object);

        //5.获取属性对象  (不能获取私有属性)
        Field field = cls.getField(propertyName);
        System.out.println(field.get(object)); //加菲猫
        field.set(object,"布偶猫");//通过反射改属性名
        System.out.println(field.get(object)); //布偶猫

        //获取所有public属性
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.get(object));
        }

        System.out.println("----------------------");
        //获取所有属性
        Field[] fields2 = cls.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println("属性名:"+f.getName()+
                    ",属性类型:"+f.getType()+
                    ",权限修饰符的值:"+f.getModifiers());
            //默认是0 public是1  private是2 default是4 static是8 final是16

        }


        //  xx.setAccessible(true)  可以关闭访问检查 从而优化 减少时间
        // 也可以"暴破"  访问私有的构造器/方法/属性  或更改私有属性
        Field f = cls.getDeclaredField("sex");
        f.setAccessible(true);
        System.out.println("通过暴破访问私有属性 sex:"+f.get(object));
        f.set(object,"母");
        System.out.println("通过暴破访问私有属性 sex:"+f.get(object));






    }
}
