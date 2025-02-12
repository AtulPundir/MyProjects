package com.ap.pre.inheritence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

interface Animal {
    void makeSound();
}

@Component
@Primary
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

@Component
class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

@Component
public class PetOwner {
    @Autowired
    private Animal animal; // ❌ ERROR: Multiple beans exist (Dog & Cat)
    
    public void playWithPet() {
        animal.makeSound();
    }

    public static void main(String[] args) {
        PetOwner pa = new PetOwner();
        pa.playWithPet();
    }
}
