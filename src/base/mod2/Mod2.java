package base.mod2;


public class Mod2 {
    public static void main(String[] args) {
        Player bot = new Player();
        Player alex = new Player(VARIANTS.SCISSORS, "Alex");
        System.out.println(bot);
        System.out.println(alex);
        System.out.println(Player.whoWins(bot, alex));
    }
}
