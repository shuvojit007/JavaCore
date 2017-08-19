package Interface;
/**
 * Created by SHOBOJIT on 6/18/2017.
 * Marker Interface in Java
 Interface without any method declaration.

 eg : Remote Interface, Serializable Interface

 An interface in the Java programming language is an abstract
 type that is used to specify an interface (in the generic
 sense of the term) that classes must implement.
 */
public class Marker_Interface  implements Permissoin{

    public void show(){
        System.out.println("This is Marker Interface Example");
    }

    public static void main(String[] args) {
        Marker_Interface marker_interface = new Marker_Interface();
        if (marker_interface instanceof  Permissoin){
            marker_interface.show();
        }else{
            System.out.println("No Permission");
        }

        Marker_Interface_02 marker = new Marker_Interface_02();
         if (marker instanceof Permissoin){
             marker.show();
         }else{
             System.out.println("No Permission");
         }
    }
}

class Marker_Interface_02{
    public void show(){
    System.out.println("This is Marker Interface 02");
    }
}

interface  Permissoin {

}