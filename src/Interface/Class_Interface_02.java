package Interface;

/**
 * Created by SHOBOJIT on 6/18/2017.
 */
public class Class_Interface_02 implements interface02 {
    @Override
    public void show2() {
    System.out.println("This is interface two show method ");
    }

    //Inherit form interface01
    @Override
    public void show() {
        System.out.println("This is Interface one show method ");
    }

    public static void main(String[] args) {
        Class_Interface_02 c = new Class_Interface_02();

        if (c instanceof interface01){
            c.show();
            System.out.println("");
            c.show2();
            System.out.println("");
        }else{
            System.out.println("No Permissoin");
        }

        interface01 in = new Class_Interface_02();
        in.show();


        interface02 in2 = new Class_Interface_02();
        in2.show();
        in2.show2();

    }
}
