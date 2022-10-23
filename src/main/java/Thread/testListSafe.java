package Thread;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/*
    ArrayList 线程不安全  Vector  CopyOnWriteArrayList  安全
    HashSet  不安全  CopyOnWriteArraySet  安全
    HashMap  不安全  ConcurrentHashMap    安全
 */
public class testListSafe {
    public static void main(String[] args) {

    }


    //junit单元测试使用的是守护线程  主线程结束后就会结束 不会等待子线程
    //存在ConcurrentModification 并发修改异常
    @Test
    public void testArrayList() throws InterruptedException {
        List list2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //向集合中加内容
                list2.add(new Date().toInstant());
                System.out.println(list2);
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("单元测试...");
    }

    //通过vector或Collection工具解决
    @Test
    public void testVector() throws InterruptedException {
        Vector<Object> vector = new Vector<>();
        //或
        List list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //向集合中加内容
                list.add(new Date().toInstant());
                System.out.println(list);
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("单元测试...");
    }

    /*通过CopyOnWriteArrayList解决（推荐）
    更改的时候复制一份在更改  更改后覆盖原来的（写时复制技术）
    */
    @Test
    public void testCopyOnWriteArrayList() throws InterruptedException {
        List copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10; i++) {
            final int n =i;
            new Thread(() -> {
                //向集合中加内容
                copyOnWriteArrayList.add(n);
                System.out.println(copyOnWriteArrayList);
            }).start();
        }

        Thread.sleep(3000);
        System.out.println("单元测试...");

    }


}