package Java8.Lambda;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/*
    函数式接口：一个接口中的抽象方法只有一个,那么这个接口就是一个函数式接口
    Lambda : 本质是作为接口的实例
 */
public class testLambda {

    @Test
    public void test1(){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("正在执行run方法...");
            }
        };
        runnable.run();

        //  ()内是形参列表  右侧是要实现的方法体
        Runnable runnable1 = ()->{
            System.out.println("通过Lambda执行run方法...");
        };
        runnable1.run();
    }


    @Test
    public void test2() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return i.compareTo(j);
            }
        };
        System.out.println("比较10和20的大小: "+comparator.compare(10,20));

        //前面指定了参数类型  所以()内的参数类型可以省略
        // 若方法内只有一条执行语句 {}可以省略 return也可以省略
        Comparator<Integer> comparator1 = (i,j) -> {
            return i.compareTo(j);
        };

//        Comparator<Integer> comparator3 = Integer::compareTo;

//        Comparator<Integer> comparator2 = (i,j) -> i.compareTo(j);
        System.out.println("比较20和10的大小: "+comparator1.compare(20,10));



    }

}
