import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class WarRunner{

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"♠", "♥", "♦", "♣"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


    public static void main(String[] args)
    {
        //beginningDeck is the Deck we start with.  When we deal, it gets split into two
        //Decks for each player
        Deck beginningDeck = new Deck(RANKS,SUITS,POINT_VALUES);
        Deck playerDeck = new Deck();
        Deck computerDeck = new Deck();
        while(!beginningDeck.isEmpty()) {
            playerDeck.addToTop(beginningDeck.deal());
            computerDeck.addToTop(beginningDeck.deal());
        }

        boolean isEnd = false;
        boolean didWin = false;
        Scanner s = new Scanner(System.in);
        String quit = "";
        System.out.println("It's a war of cards!");
        System.out.println("Deck sizes: " + playerDeck.size() + " (yours vs. " + computerDeck.size() + " (computer's)");
        while(!isEnd) {
            if(playerDeck.size()>=52) {
                didWin = true;
                isEnd= true;
                break;
            }
            if(computerDeck.size()>=52) {
                didWin = false;
                isEnd = true;
                break;
            }
            System.out.println("Press 'Enter' to fight another battle or 'S' to shuffle your deck!");
            String choice = s.nextLine();
            Card playerDeal = null;
            Card computerDeal = null;
            if(choice.equals("")) {
                 playerDeal = playerDeck.deal();
                 computerDeal = computerDeck.deal();
            }
            if(choice.equals("S")) {
                playerDeck.shuffle();
                 playerDeal = playerDeck.deal();
                 computerDeal = computerDeck.deal();
            }
            while(playerDeal.matches(computerDeal)) {
                System.out.println("Its a tie! Battle again!");
                System.out.println("You and the computer each lay down 3 cards.");

            }

        }
        if(didWin) {
            System.out.println("You won the war!!");
        }else {
            System.out.println("The computer won 😢");
        }
    }
}