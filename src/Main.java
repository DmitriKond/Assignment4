import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pokemon player1 = generatePokemon();
        Pokemon player2 = generatePokemon();

        printMenu(player1);
        int menuSelection = scanner.nextInt();
        switch (menuSelection) {
            case 1 -> {
                System.out.println("Available attacks:");
                player1.printAttacks();
                int attackSelection = scanner.nextInt();
                player1.useAttack(attackSelection, player2);
            }
            case 2 -> player1.standby();
            case 3 -> {
                if (player1.evolve()) {
                    System.out.println("Your Pokemon has evolved into " + player1.getName() + "!");
                } else {
                    System.out.println("Your Pokemon couldn't evolve!");
                }
            }
            case 4 -> player1.useSpecialMove(player2);
        }

        System.out.println(player1.toString());


    }

    public static void printMenu (Pokemon pokemon) {
        System.out.println(pokemon.toString());
        System.out.println("What would you like to do?" + "\n");
        System.out.print("1. Attack");
        if (pokemon.attackIsTripled()) {
            System.out.println(" (Attack power is tripled this turn!)");
        } else {
            System.out.println();
        }
        System.out.println("2. Standby: Gain a random buff; Restore 5-30 HP, restore 0-40 Attack Points or TRIPLE your attack power next turn");
        System.out.println("3. Evolve: " + pokemon.printEvolutionRequirement());
        System.out.println("4. Use Special Move: " + pokemon.printSpecialMove());
    }

    public static Pokemon generatePokemon () {
        Random random = new Random();
        int generate = random.nextInt(6) + 1;
        Pokemon output = null;

        switch (generate) {
            case 1 -> output = new Charmander();
            case 2 -> output = new Salandit();
            case 3 -> output = new Moltres();
            case 4 -> output = new Pichu();
            case 5 -> output = new Blitzle();
            case 6 -> output = new Electabuzz();
        }
        return output;
    }
}
