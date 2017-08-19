package Design_Pattern;
/**
 * Created by SHOBOJIT on 6/19/2017.
 * Singleton Pattern says that just"define a class that has only one
 * instance and provides a global point of access to it".
 *
 * Tutorial :
 * 1. http://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/
 * 2.https://medium.com/@kevalpatel2106/digesting-singleton-design-pattern-in-java-5d434f4f322
 */
    /*There are two forms of singleton design pattern
        Early Instantiation: creation of instance at load time.
        Lazy Instantiation: creation of instance when required.


    */
public class SingeltonPattern {
    public static void main(String[] args) {
        A a = A.getIntance();
        a.Show();

        B b = B.getB();
        b.show();
    };
}

//Early Instantiation
class A{
    //Static member: It gets memory only once because of static, itcontains the instance of the Singleton class
    private static A a = new A();
    //Private constructor: It will prevent to instantiate the Singleton class from outside the class.
    private A(){}
   //Static factory method: This provides the global point of access to the Singleton object and returns the instance to the caller.
    public static A getIntance(){
        return  a; }
    void Show(){
        System.out.println("This is Early, instance will be created at load time");
    }
}

class B{
    private B(){}
    private static B b;
    public static B getB(){
        if(b==null){
            b=new B();
        }
        return b;
    }

    void show(){
        System.out.println("Instance will be created at request time  ");
    }
}