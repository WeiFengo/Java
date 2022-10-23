package Thread.FuZhuClass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/*
    同步辅助类  CountDownLatch  减少计数
    调用await()方法会使此线程阻塞
    调用countDown()方法会使计数器减1
    计数器值为0时，会唤醒因await而阻塞的线程
 */
public class testCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()
                        +"号同学离开教室...");
            countDownLatch.countDown();//减1
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("已关闭教室门...");
    }
}
