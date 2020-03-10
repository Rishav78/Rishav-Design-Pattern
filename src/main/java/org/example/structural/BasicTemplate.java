package org.example.structural;

abstract class Game {
    abstract void initialize();
    abstract void start();
    abstract void end();

    public final void play(){
        initialize();
        start();
        end();
    }
}

class Chess extends Game {
    final static String gameName="Chess";

    @Override
    void initialize() {
        System.out.println(gameName+" Initialized");
    }

    @Override
    void start() {
        System.out.println(gameName+" Started");
    }

    @Override
    void end() {
        System.out.println(gameName+" Finished");
    }
}

class BasketBall extends Game {
    final static String gameName="BasketBall";

    @Override
    void initialize() {
        System.out.println(gameName+" Initialized");
    }

    @Override
    void start() {
        System.out.println(gameName+" Started");
    }
    @Override
    void end() {
        System.out.println(gameName+" Finished");
    }
}

public class BasicTemplate {
    public static void main(String[] args) throws InstantiationException,IllegalAccessException,ClassNotFoundException {
        Class c_chess = Class.forName("org.example.structural.Chess");
        Class c_basketball = Class.forName("org.example.structural.BasketBall");
        Game game;
        game=(Game)c_chess.newInstance();
        game.play();
        game=(Game)c_basketball.newInstance();
        game.play();

    }
}