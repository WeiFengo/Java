package Map;


import java.util.*;

public class testHashMap {
    //要求 找出工资大于1.8w的员工
    public static void main(String[] args) {

        Collection collection = new LinkedHashSet();
        Map hashMap = new HashMap();
        hashMap.put(1,new Employee(1,10000,"张三"));
        hashMap.put(2,new Employee(2,20000,"李四"));
        hashMap.put(3,new Employee(3,30000,"王五"));
        hashMap.put(4,new Employee(4,40000,"赵六"));

        Set keySet = hashMap.keySet();
        for (Object o : keySet) {
            Employee e =  (Employee) hashMap.get(o);
            if(e.getMoney()>18000)
            {
                System.out.println(e);
            }
        }
        System.out.println("------------------------");

        Set set = hashMap.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            Employee e = (Employee)entry.getValue();
            if(e.getMoney()>18000)
                System.out.println(e);
        }
        System.out.println("------------------------");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry entry = (Map.Entry) next;
            Employee e =  (Employee)entry.getValue();
            if(e.getMoney()>18000)
                System.out.println(e);
        }

    }

}

class Employee{
    private int id;
    private int money;
    private String name;

    public Employee(int id, int money, String name) {
        this.id = id;
        this.money = money;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                money == employee.money &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, money, name);
    }
}