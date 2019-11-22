/**
 * Poker class includes main method of running a Poker game(with no limit of Players).
 * 
 * Each player will be assigned with 5 poker cards in terms of user's input(input in args[]).
 * Then program will give every player's hand description and show the result of this game.
 * 
 * The inputs should:
 * 1.In two-character format: first one indicates rank(from 2~9 and T,J,Q,K,A), latter for suit(C,D,S,H),case doesn't matter.
 * 2.Only accept inputs of positive multiples of 5,since every player holds 5 cards.
 * 
 * @throws exceptions when invalid inputs occurs.
 * 
 * @author Tannmenn
 *
 */

import java.util.Arrays;
import java.util.Stack;

public class Poker {
    
    public static void main(String[] args){

        PokerCard[] assignedCard = new PokerCard[args.length];
        Player[] player = new Player[args.length / 5];

        for (int i = 0; i < args.length; i++) {
            assignedCard[i] = new PokerCard();
        }

        for(int i = 0; i<args.length/5;i++){
            player[i] = new Player();
        }

        if (args.length % 5 != 0 || args.length <= 0) {
            System.out.println("Error: wrong number of arguments; must be a multiple of 5");
            System.exit(0);
        }

        /** 
        *Create a PokerCard instance for each two-character string in command line and store them in array assignedCard[].    
        */
        for (int i = 0; i < args.length; i++) {
            args[i] = args[i].toUpperCase();

            try {
                assignedCard[i] = new PokerCard(args[i]);
            } catch (Exception e){
                System.out.println("Error: invalid card name '"+ args[i]+"'");
                System.exit(1);
            }
        }

        /** 
        *Create a player instance for each 5 PokerCard instances and store them in array player[].
        */
        for (int i = 0; i < args.length; i += 5) {

            PokerCard[] tempPokerCard = Arrays.copyOfRange(assignedCard, i, i + 5);
            player[i / 5] = new Player(tempPokerCard, (i / 5) + 1);

        }

        if(player.length == 1){
            Poker.showDescription(player);
        }else {
            Poker.showDescription(player);
            Poker.showWinner(player);
        }
    }
     
    /**
     * Print hand description of each player in required format.
     * 
     * @param player An Player array holds all player's info in this game.
     */
    private static void showDescription(Player[] player){

        for(Player x : player){
            System.out.println("Player "+x.getNumber()+": "+x.getDescription());
        }
    }

    /**
     * Print the result of this game: who is winner or which players draw.
     * 
     * @param player An Player array holds all player's info in this game.
     */
    private static void showWinner(Player[] player){
        int length = player.length - 1;

        Stack<Player> winner = new Stack<>();

        for(int i = 0;i < player.length;i++){
            if(winner.empty()){
                winner.push(player[length - i]);
            }else{
                if(player[length - i].getHandWeightString().compareTo(winner.peek().getHandWeightString()) == 0){
                    winner.push(player[length - i]);
                }

                if(player[length - i].getHandWeightString().compareTo(winner.peek().getHandWeightString()) > 0){
                    while(!winner.empty()){
                        winner.pop();
                    }
                    winner.push(player[length - i]);
                }
            }
        }

        if(winner.size() == 1){
            System.out.println("Player "+winner.peek().getNumber()+" wins.");
        }else{
            System.out.print("Players ");

            while(winner.size() > 2){
                System.out.print(winner.pop().getNumber()+", ");
            }

            System.out.print(winner.pop().getNumber()+" and "+
                    winner.pop().getNumber()+" draw.");

            System.out.println();
        }
    }
}


