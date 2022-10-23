package Thread;

import java.util.Scanner;
//输入Q时 终止 t1线程
public class test {

    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2(thread1);
        new Thread(thread1).start();
        new Thread(thread2).start();


    }

}

class Thread1 implements Runnable{

    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while(flag)
        {
            System.out.println("t1:"+Thread.currentThread().getName()+"____"+(int)(Math.random()*5));
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable{

    private Thread1 t1;
    private Scanner scanner = new Scanner(System.in);

    public Thread2(Thread1 t1) {
        this.t1 = t1;
    }


    @Override
    public void run() {
        while(true)
        {
            System.out.println("请输入指令：(Q)表示退出");
            char c = scanner.next().charAt(0);
            if(c == 'Q'){
                t1.setFlag(false);
                System.out.println(Thread.currentThread().getName() + "线程已终止thread1线程...");
                break;
            }

        }


    }
}
