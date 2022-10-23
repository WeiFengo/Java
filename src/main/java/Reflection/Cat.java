package Reflection;

import org.junit.Test;

public class Cat {
    public String name = "加菲猫";
    public int age = 5;
    private String sex = "公";

    public Cat(){}
    private Cat(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Cat(String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void say()
    {
        System.out.println("喵喵喵...");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }



}


