package Thread.FuZhuClass;

import java.util.concurrent.Semaphore;
/*
    Semaphore  信号灯
    可以限制访问某些资源的线程数目
    获得许可后才能继续执行  达到许可上限数量后要等待 有线程释放许可
 */
public class testSemaphore {
    //6辆车 抢 3个车位
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+
                            "获取到了车位");
                    Thread.sleep(1000);

                    System.out.println(Thread.currentThread().getName()+
                            "离开了车位------------");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

    }
}
