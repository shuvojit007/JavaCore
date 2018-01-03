package Interface.Level1.Callback;

public class InterfaceWorld {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.findAGirl(new OnFoundListener() {
            @Override
            public void onFound(String s) {
                System.out.println(s);
            }
        });

        /**
         * With lambda expression
         */
//        classA.findAGirl((String result)->{
//            System.out.println(result);
//        });
    }
}
