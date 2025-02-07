package com.ap.pre.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {

    public static void main(String[] args) throws Exception {
        //singletonTestBasic();
        //singletonBreakByRefectionAndFixWithException();
        //singletonBreakByRefectionAndFixWithEnum();
        //singletonBreakByDesrialicationAndFix();
        singletonBreakByClone();

    }

    static void singletonTestBasic() {
        Singleton obj = Singleton.getObject();
        Singleton obj1 = Singleton.getObject();
        System.out.println("Obj  == " + obj);
        System.out.println("Obj1 == " + obj1);

        System.out.println("\nObj  == " + obj.hashCode());
        System.out.println("Obj1 == " + obj1.hashCode());
    }

    static void singletonBreakByRefectionAndFixWithException() throws NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {

        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton obj = constructor.newInstance();
        Singleton obj1 = constructor.newInstance();
        System.out.println("\nObj  == " + obj.hashCode());
        System.out.println("Obj1 == " + obj1.hashCode());

    }

    static void singletonBreakByRefectionAndFixWithEnum() throws NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            IllegalArgumentException,
            InvocationTargetException {

        //FIXING WITH ENUM. ENUM will not allow to create object
        Constructor<SingletonEnum> constructor = SingletonEnum.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonEnum obj = constructor.newInstance();
        SingletonEnum obj1 = constructor.newInstance();
        System.out.println("\nObj  == " + obj.hashCode());
        System.out.println("Obj1 == " + obj1.hashCode());

    }

    private static void singletonBreakByDesrialicationAndFix() throws Exception {
        Singleton obj = Singleton.getObject();

        System.out.println("\nObj  == " + obj.hashCode());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fileName"));
        oos.writeObject(obj);  //Serialization done

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fileName"));
        Singleton obj1 = (Singleton) ois.readObject();
        System.out.println("Obj1 == " + obj1.hashCode());

    }

    private static void singletonBreakByClone() throws CloneNotSupportedException {
        Singleton obj = Singleton.getObject();
        Singleton obj1 = (Singleton) obj.clone();

        System.out.println("\nObj  == " + obj.hashCode());
        System.out.println("Obj1 == " + obj1.hashCode());
    }

}
