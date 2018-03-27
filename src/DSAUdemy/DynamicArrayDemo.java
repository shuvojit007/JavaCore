package DSAUdemy;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray<Integer>da = new DynamicArray<>();
        for(int i=0;i<5;i++){
            da.put(i);
            System.out.println(da.getSize());
        }
    }
}
