package Interface;

/**
 * Created by SHOBOJIT on 6/17/2017.
 * Types of Interface
 * 1. Marker Interface -> Without any method
 * 2. SAM -> Single Abstract Method -> in Java 8 its called Funtional Interface
 * 3. Normal Interface
 */

import okhttp3.OkHttpClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
    Notice the implements interface01 part of the above class declaration.
    This signals to the Java compiler that the MyInterfaceImpl class
    implements the MyInterface interface.

    A class that implements an interface must implement all the methods declared
    in the interface. The methods must have the exact same signature (name + parameters)
    as declared in the interface. The class does not need to implement (declare)
    the variables of an interface. Only the methods.
 */

public class Class_Interface_01 implements interface01 {
    public static void main(String[] args) {
        Class_Interface_01 c = new Class_Interface_01();
        c.show();
        c.Display();

        interface01 in = new Class_Interface_01();
        in.show();


        interface01 in2 = new interface01() {
            @Override
            public void show() {
                System.out.println("This is Annonymous Class");
            }
        };
        in2.show();

        System.out.println(interface01.name);



    }

    @Override
    public void show() {
    System.out.println("This is Show Method");
    }

    public void Display(){
        System.out.println("This is Display Method ");
    }
}
