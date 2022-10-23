package Thread.Lock;

import java.util.concurrent.locks.ReentrantLock;

/*
   Lock接口 实现锁
   相比synchronized可以获得更广泛的锁操作，
   lock锁需要手动操作，发生异常不会主动释放锁，所以要写在finally中
   可以响应中断，在竞争激烈时性能优于syn。
 */
public class testLock {
    public static void main(String[] args) {
        sellTicketByLock ticket = new sellTicketByLock();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.start();
        t2.start();
    }
}

class sellTicketByLock implements Runnable{
    //定义lock可重入锁
    private final ReentrantLock lock = new ReentrantLock();
    private int number = 100;
    public void sale(){
        //上锁:
        lock.lock();

        try{
            //卖票:
            if(number > 0){
                System.out.println(Thread.currentThread().getName()+": 售出一张票,剩余："+(--number));
                // sleep(500);
            }
        }finally {
            //解锁
            lock.unlock();
        }
    }

    @Override
    public void run() {
        while(number>0)
        {
            sale();
        }
    }
}