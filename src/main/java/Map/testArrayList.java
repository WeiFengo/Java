package Map;

import java.util.ArrayList;
import java.util.List;

public class testArrayList {
    public static void main(String[] args) {
        List list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        list.add("a");
        list.add("b");
        list.add("a");
        list.add("b");
        System.out.println(list);
        list.remove("a");
        System.out.println(list);

    }
}
