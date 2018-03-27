package Design_Pattern.Singelton;

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

