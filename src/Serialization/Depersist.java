package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by SHOBOJIT on 6/18/2017.
 */
class Depersist {
       public static void main(String []args) throws IOException, ClassNotFoundException {
        ObjectInputStream obj = new ObjectInputStream(new FileInputStream("f.txt"));
        Student s = (Student) obj.readObject();
        System.out.println(s.id+" "+s.name);
        String s10 = String.valueOf(obj.read());
       System.out.println(s10);
       }
}
