package Interface.Level1.Callback;

public class ClassA {

    public void findAGirl(OnFoundListener onFoundListener){
        for (int i =0;i<5;i++){
            try {
                Thread.sleep(1500);
                System.out.println("Class A trying to find a girl for you "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       // onFoundListener.onFound("A Found a girl For You");
        //Suppose A found nothing, So that assign this job for B
        ClassB classB = new ClassB();
        classB.findACuteGirl(onFoundListener);
    }
}
