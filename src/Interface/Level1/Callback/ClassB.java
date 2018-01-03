package Interface.Level1.Callback;

public class ClassB {
    public void findACuteGirl(OnFoundListener onFoundListener){
        for (int i =0;i<2;i++){
            try {
                Thread.sleep(1500);
                System.out.println("Class B trying to find a Cute girl for you "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        onFoundListener.onFound("B Found a cute girl For You");
    }
}
