package BasicDataType;

import org.junit.Test;

public class ZhiChuanDi {


    public static void main(String[] args) {
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        ZhiChuanDi.swap(s1, s2);

        System.out.println("swap之后：");
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());

    }

    public static void swap(Student x, Student y) {
//        Student temp = x;
//        x = y;
//        y = temp;
        x.setName("111");
        y.setName("222");

        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

    @Test
    public void test()
    {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        Integer c = 1000;
        Integer d = 1000;

//        System.out.println(100==100);
        System.out.println(a==b);
//        System.out.println(1000==1000);
        System.out.println(c==d);
    }

}

class Student{
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
       return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
