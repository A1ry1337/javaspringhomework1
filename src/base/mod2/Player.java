package base.mod2;

import java.util.Random;


enum VARIANTS {
    ROCK,    // Камень
    PAPER,   // Бумага
    SCISSORS // Ножницы
}


public class Player {
    private String name;
    private VARIANTS choice;

    public Player() {
        this.name = "Bot";
        this.choice = getRandomVariant();
    }

    public Player(VARIANTS choice, String name) {
        this.name = name;
        this.choice = getRandomVariant();
    }

    private VARIANTS getRandomVariant() {
        VARIANTS[] variants = VARIANTS.values();
        Random random = new Random();
        return variants[random.nextInt(variants.length)];
    }

    public static String whoWins(Player p1, Player p2) {
        if (p1.choice == p2.choice) return "Ничья";
        else if ((p1.choice == VARIANTS.PAPER && p2.choice == VARIANTS.ROCK) ||
                (p1.choice == VARIANTS.ROCK && p2.choice == VARIANTS.SCISSORS) ||
                (p1.choice == VARIANTS.SCISSORS && p2.choice == VARIANTS.PAPER)) return p1.name + " победил!";
        else return p2.name + " победил!";
    }

    public String toString() {
        return name + " выбрал " + choice;
    }
}
