package org.example.behavioral;

interface Bird {
    public void fly();
    public void makeSound();
}

class Sparrow implements Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp....");
    }
}

interface Duck {
    public void squeak();
}

class PlasticDuck implements Duck {
    @Override
    public void squeak() {
        System.out.println("Squeakkk....");
    }
}

class BirdAdapter implements Duck {
    Bird bird;
    public BirdAdapter() {

    }

    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void squeak() {
        bird.makeSound();
    }
}

public class Adapter {
    public static void main(String args[]) {
        Sparrow sparrow = new Sparrow();
        Duck duck = new PlasticDuck();
        Duck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("Duck");
        duck.squeak();

        System.out.println("Bird Adapter");
        birdAdapter.squeak();
    }
}