package Thread.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testShareByLock {
    public static void main(String[] args) {
//        ShareByLock share = new ShareByLock();
//        new Thread(()->{
//            for (int i = 0; i <10 ; i++) {
//                try {
//                    share.add();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"T1(加线程)").start();
//        new Thread(()->{
//            for (int i = 0; i <10 ; i++) {
//                try {
//                    share.sub();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"T2(减线程)").start();

        ShareByLockPrint share2 = new ShareByLockPrint();
        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    share2.Print1();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    share2.Print2();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    share2.Print3();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T3").start();

        System.out.println("主线程结束.....");

    }
}


//+1 -1
class ShareByLock implements Runnable{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int num = 0;

    public void add() throws InterruptedException {

        lock.lock();
        try {
            while(num != 0)  //if 可能存在虚假唤醒问题  用while代替 唤醒后还需要在判断
            {
//                System.out.println(Thread.currentThread().getName()+"等待变0中...");
                condition.await();
            }
            num += 1;
            System.out.println(Thread.currentThread().getName()+"----"+num);
            //通知其他线程
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void sub() throws InterruptedException {
        lock.lock();
        try {
            while(num != 1)  //if 可能存在虚假唤醒问题  用while代替 唤醒后还需要在判断
            {
//                System.out.println(Thread.currentThread().getName()+"等待变0中...");
                condition.await();
            }
            num -= 1;
            System.out.println(Thread.currentThread().getName()+"----"+num);
            //通知其他线程
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {

    }
}


//依次输出  (线程间定制化通信)
class ShareByLockPrint{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int flag=1;

    void Print1() throws InterruptedException {
        lock.lock();
        try {
            while(flag!=1)
            {
                condition1.await();
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() +
                        "正在打印..."+i+"次");
            }
            flag=2;
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }

    void Print2() throws InterruptedException {
        lock.lock();
        try {
            while(flag!=2)
            {
                condition2.await();
            }
            for (int i = 1; i <= 4; i++) {
                System.out.println(Thread.currentThread().getName() +
                        "正在打印..."+i+"次");
            }
            flag=3;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }


    void Print3() throws InterruptedException {
        lock.lock();
        try {
            while(flag!=3)
            {
                condition3.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +
                        "正在打印..."+i+"次");
            }
            flag=1;
            condition1.signal();
        }finally {
            lock.unlock();
        }
    }



}