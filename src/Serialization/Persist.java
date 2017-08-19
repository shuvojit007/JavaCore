package Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by SHOBOJIT on 6/18/2017.
 */
public class Persist {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student(211,"Shuvojit",23);
        FileOutputStream fout = new FileOutputStream("f.txt");
        ObjectOutputStream obj = new ObjectOutputStream(fout);
        obj.writeObject(s1);
        obj.flush();
        System.out.println("success");

    }
}
