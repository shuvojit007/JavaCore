package Serialization;

import java.io.Serializable;

/**
 * Created by SHOBOJIT on 6/18/2017.
 * Serializable is a marker interface (has no data member and method).
 * It is used to "mark" java classes so that objects of these classes
 * may get certain capability. The Cloneable and Remote are also marker interfaces.
 */
public class Student implements Serializable {
    int id ;
    String name;
    transient int age;//Now it will not be serialized

    public Student(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
