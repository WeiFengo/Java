package Thread.FuZhuClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/*
    同步辅助类 CyclicBarrier 循环栅栏
    允许线程互相等待  直到所有线程都达到某个屏障点（临界点）
 */
public class testCyclicBarrier {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("已有5个执行-------------------------");
        });
        for (int i = 1; i <= 24 ; i++) {
            new Thread(()->{

                try {
                    System.out.println(Thread.currentThread().getName()+
                            "号正在执行...");
                    //等待...
                    cyclicBarrier.await();
                    Thread.sleep(1000);

//                    System.out.println(Thread.currentThread().getName()+
//                            "号执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }



    }
}
