package Design_Pattern.Singelton;



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

class B{
    private B(){}
    private static Design_Pattern.Singelton.B b;
    public static Design_Pattern.Singelton.B getB(){
        if(b==null){
            b=new Design_Pattern.Singelton.B();
        }
        return b;
    }

    void show(){
        System.out.println("Instance will be created at request time  ");
    }
}