package org.example.javapatterns;


class Singleton {
    private static Singleton singleton;

    // Using Reflection API we can create constructor and instantiate.
    // To Avoid we will be adding boolean isInstanceCreated and throwing Exception
    private static boolean isInstanceCreated = false;
    private Singleton(){
        if (isInstanceCreated){
            throw new RuntimeException("Pls create instance using getInstance() method");
        }
        isInstanceCreated = true;
    }

    // Thread Safe
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // For serialization Safe
    private Singleton readResolve(){
        return singleton;
    }

    //Cloning safe SIngleton
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning Not Supported");
    }

    public void getMessage(){
        System.out.println("Hi");
    }
}

public class SingletonPattern {

    public static void main(String[] args) throws NoSuchMethodException {
        Singleton singleton = Singleton.getSingleton();
        singleton.getMessage();

        /*Constructor<Singleton> singletonConstructor = Singleton.class.getConstructor(Singleton.class);
        singletonConstructor.setAccessible(true);*/
    }
}
