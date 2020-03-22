/**
 * Template Method - задает "скелет" алгоритма в методе, оставляя
 * реализации некоторых шагов классам наследникам. Классы наследники могут
 * переопределять некоторые части алгоритма без изменения его структуры.
 * 
 * Абстракный класс содержит простые операци и tempalte methode который вызывает эти операции
 * 
 * Классы наследники должны реализовывать простые операции
 * 
 */
abstract class Game {
	//Template Methode - шаги алгоритма
    public void launch() {
        startPlay();
        play();
        endPlay();
    }

	//эти методы должны быть реализованы в конкретных классах
	//которые выполняют этот алгоритм
    abstract void startPlay();
    abstract void play();
    abstract void endPlay();
}

class Hockey extends Game {
    @Override
    void startPlay() {
        System.out.println("Start play Hockey");
    }

    @Override
    void play() {
        System.out.println("Play Hockey....... ");
    }

    @Override
    void endPlay() {
        System.out.println("Hockey the end!");
    }
}

class Football extends Game {
    @Override
    void startPlay() {
        System.out.println("Start play Football");
    }

    @Override
    void play() {
        System.out.println("Play Football ......    GOOOOAAAAAALLLLLL!");
    }

    @Override
    void endPlay() {
        System.out.println("Football the end!");
    }
}

class Main {
    public static void main(String[] args) {
        Hockey hockey = new Hockey();
        Football football = new Football();

        hockey.launch();
        System.out.println("\n************************\n");
        football.launch();
    }
}