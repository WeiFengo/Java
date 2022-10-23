package Thread.Lock;

public class testShareBySyn {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1(加线程)").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T2(减线程)").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T3(加线程)").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    share.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T4(减线程)").start();





    }
}

class Share implements Runnable{
    private int num = 0;

    public synchronized void add() throws InterruptedException {
        while(num != 0)  //if 可能存在虚假唤醒问题  用while代替 唤醒后还需要在判断
        {
//            System.out.println("等待变0前");
            System.out.println(Thread.currentThread().getName()+"等待变0中...");
            this.wait();
        }
        num += 1;
        System.out.println(Thread.currentThread().getName()+"----"+num);
        //通知其他线程
        this.notifyAll();
    }

    public synchronized void sub() throws InterruptedException {
//        if(num != 1)     //if 可能存在虚假唤醒问题  用while代替 唤醒后还需要在判断
        while(num != 1)
        {
            System.out.println(Thread.currentThread().getName()+"等待变1中...");
            this.wait();
        }
        num -= 1;
        System.out.println(Thread.currentThread().getName()+"----"+num);
        //通知其他线程
        this.notifyAll();
    }

    @Override
    public void run() {

    }
}