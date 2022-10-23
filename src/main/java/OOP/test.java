package OOP;

public class test {


    public static void main(String[] args) {
        N n = new N();
        n.a(301);

    }

}

class N{
//    private int[] S = new int[];
    private int index=0;
    private int number = 7;
    private int flag = 0;

    public void a(int x)
    {
        if(flag==1 || (x-1)/3==0 || (x-1)/5==0)
        {
            return;
        }else if(  (((x-1)%3==0) && ((x-1)/3==7))  ||  (((x-1)%5==0)  && ((x-1)/5==7)) ){
            System.out.println("在集合中------当前x="  +  x);
            flag=1;
        }else{
            if((x-1)%3==0){
                System.out.println("("+x+"-1)/3=" + (x-1)/3);
                this.a((x-1)/3);
            }

            if((x-1)%5==0){
                System.out.println("("+x+"-1)/5=" + (x-1)/5);
                this.a((x-1)/5);
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}