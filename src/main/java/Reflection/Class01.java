package Reflection;

import org.junit.Test;

/* Class类 可以理解为ReflectionClass  就是一个类 名字特殊而已
    Class类不是new出来的  是系统创建的(类加载阶段) 也继承Object
    某个类的Class对象只有一个，就像镜子一样，可得到类的完整结构信息
    类的每个对象都知道自己由哪个Class对象生成

 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            获取Class类对象的方式:
         */
        //1.通过全类名(常通过配置文件获取全类名)
        Class<?> cls1 = Class.forName("Reflection.Cat");

        //2.通过 类名.class
        Class<Cat> cls2 = Cat.class;
        System.out.println(cls2); //Reflection.Cat
        System.out.println(cls2.getClass());//java.lang.Class

        //3.通过 已知类的对象  对象.getClass
        Cat cat = new Cat();
        Class cls3 = cat.getClass();

        //4. 通过类加载器获取
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class<?> cls4 = classLoader.loadClass("Reflection.Cat");

        //5.基本数据类型
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        //6.包装类
        Class<Integer> cls6 = Integer.TYPE;
        Class<Character> cls66 = Character.TYPE;




    }


    public static int i = 5;
    @Test
    public void a(){
//       test1();
        
    }

    public void test1(){
        System.out.println(i++);
        test2();
    }
    public void test2(){
        System.out.println(i++);
        test1();
    }
}
