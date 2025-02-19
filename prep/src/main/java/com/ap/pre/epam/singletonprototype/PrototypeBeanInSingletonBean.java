package com.ap.pre.epam.singletonprototype;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

class SingletonBean{

    @Autowired
    PrototypeBean prototypeBean;         //PROBLEM STATEMENT. Since singeton is created only once. so the same protoype will be used everytime.


    @Autowired
    ObjectFactory<PrototypeBean> prototypeBean1; 

    //@Autowired
    ObjectProvider<PrototypeBean> prototypeBeanOP;

    public SingletonBean(ObjectProvider<PrototypeBean> prototypeBeanProvider) {
        this.prototypeBeanOP = prototypeBeanProvider;
    }
    
    //import jakarta.inject.Provider;       //Add this import
    //Provider<PrototypeBean> prototypeBeanP;


    @Autowired
    PrototypeBean prototypeBeanByLookUp = getPrototypeBean(); ;  

    @Lookup
    public PrototypeBean getPrototypeBean() {
        return null; // Spring overrides this method at runtime
    }


}

 class PrototypeBean {
    public PrototypeBean() {
        System.out.println("🚀 PrototypeBean Created!");
    }

 }

public class PrototypeBeanInSingletonBean {
    public static void main(String[] args) {
        System.out.println("🚀 PrototypeBean Created!");
    }
}


