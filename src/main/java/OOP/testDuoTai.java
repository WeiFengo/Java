package OOP;

import java.util.Vector;

public class testDuoTai {
    public static void main(String[] args) {
        Animal animal = new Dog();

        System.out.println(animal.name);
        animal.Say(animal);
        animal.cry();

        show(new Dog());
        show(new Cat());
//        System.out.println(animal.age);

//        Vector vector = new Vector();
//        vector.add(1);
    }

    public static void show(Animal animal)
    {
        animal.cry();
    }


}


class Animal{
    String name = "我是动物..";
    int age = 18;
    public void Say(Animal animal)
    {
        System.out.println(animal.name);
    }

    public void cry()
    {
        System.out.println("wuwuwu..."+this.name);
    }
}

class Dog extends Animal{
    String name = "我是狗..";
    int age = 1;
    public void Say(Dog dog)
    {
        System.out.println(dog.name);
        System.out.println("调用了狗类中的方法");
    }

    public void cry()
    {
        System.out.println("汪汪汪..."+this.name);
    }
}

class Cat extends Animal{
    String name = "我是猫..";
    int age = 1;
    public void Say()
    {
        System.out.println(this.name);
        System.out.println("调用了猫类中的方法");

    }

    public void cry()
    {
        System.out.println("喵喵喵..."+this.name);
    }


}