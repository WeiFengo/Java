package BasicDataType;

import lombok.Data;

import java.io.*;

public class testSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filePath = "E:\\java\\Spring\\person.obj";

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        Person person = new Person("微风",18);
        objectOutputStream.writeObject(person);
        System.out.println(person);
        System.out.println(person.hashCode());
        objectOutputStream.close();

        /*
        当序列化和反序列化一个对象时，JVM会创建一个单独的对象。
	    在反序列化时，JVM创建对象并不会调用任何构造函数，
	   为了反序列化一个对象，需要让我们的POJO类实现Serializable接口
         */
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        System.out.println(objectInputStream);
        Object object1 = objectInputStream.readObject();
        System.out.println(object1);
        System.out.println(objectInputStream);


        objectInputStream.close();

    }
}

@Data
class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {

    }
}