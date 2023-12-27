package Game;
import Players.*;
import Utilits.Log;
import java.util.Scanner;

public abstract class AbstractGame {
    protected AbstractPlayer p1, p2;
    protected Scanner in = new Scanner(System.in); 
    public AbstractGame(int maxHP) {
        Log.out("Введите имя первого игрока");
        p1 = new Player(in.nextLine(), maxHP);
    }
    public void go() {
        start();
        gameProcess();
        end();
    }
    public abstract void gameProcess();

    public void start() {
        Log.out("The battle had started.");
    }

    public void end() {
        AbstractPlayer winner = p1.alive() ? p1: p2;
        Log.out(winner.getName() + " won.");
    }
}
