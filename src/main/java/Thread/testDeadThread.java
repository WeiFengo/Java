package Thread;

import static java.lang.Thread.sleep;
/*
终端命令：
jps查看当前有哪些进程
jstack + 进程号  jvm自带的堆栈跟踪工具
 */
public class testDeadThread {

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"已获得a,等待b中...");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("已获得b");
                }
            }
        },"T1").start();

        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"已获得b,等待a中...");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println("已获得a");
                }
            }
        },"T2").start();
    }
}
