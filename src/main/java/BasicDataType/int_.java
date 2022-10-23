package BasicDataType;

import org.junit.Test;

public class int_ {
    static int aa;

   

    public static void main(String[] args) {
        byte b = 100;
        int i = 255;
//        System.out.println((byte)i);

        System.out.println();
        int_ xxx = new int_();
        System.out.println(xxx.a());
         int a ;
        System.out.println(int_.aa);
    }



//    @Test
    public int a(){
        int x = 1;
        try {
//            x = x+1;
            return x;
        }finally {
            ++x;
            return x;
        }
    }

    @Test
    public void b() {
        int[] array = {5,3,6,3,7,2,8};
        int temp;
//        System.out.println(array);
        for(int i = 0; i<array.length-1;i++)
        {
            for (int j = 0 ;j<array.length-i-1;j++)
            {
                if(array[j]>array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i : array) {
            System.out.println(i);
        }
    }

    @Test
    public void c(){
        int a = 1;
        int b = 1;

        if(a==0 && b++==1  )
        {
            System.out.println("666");
        }else{
            System.out.println("a="+a+",b="+b);
        }


    }

}
