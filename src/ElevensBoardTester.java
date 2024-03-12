import java.util.*;

public class ElevensBoardTester
{
    public static void main(String[] args)
    {
        //1. First check the constructor
        //I changed "is debugging" to true
        //Compiling, I can see it creates an unshuffled deck.
        ElevensBoard b = new ElevensBoard();
        //We'll print b each step.  (It prints the 9 card array of cards on the board)

        System.out.println("1. After Constructing: \n"+b);
        //2. Next method I see is newGame()
        b.newGame();
        System.out.println("2. After newGame()\n"+b);
        //3. Now I see size()... which is 9 the whole time?
        System.out.println("3. size() = "+b.size());
        //4. Now I see isEmpty() which will be false if we constructed an ElevensBoard
        System.out.println("4. isEmpty() = "+b.isEmpty());
        //5. Next I see deal(k)
        b.deal(3);
        b.deal(7);
        System.out.println("4. You should see index 3 and 7 cards overwriten by another card");
        System.out.println(b);
        //6. Now I see deckSize()
        System.out.println("5. deckSize() = "+b.deckSize());
        b.deal(4);
        System.out.println("(should be 1 less) deckSize() = "+b.deckSize());
        //7. cardAt(int j) returns the jth card in the card array
        System.out.println("Should see the 5th card cardAt(5) = "+b.cardAt(5));
        //8. Replace selected cards
        List<Integer>  l = new ArrayList<Integer>();
        l.add(3);
        l.add(5);
        b.replaceSelectedCards(l);
        System.out.println("Testing replace selected cards spot 3 and 5 should be new");
        System.out.println(b);
        //9. Then I see cardIndexes() - Card indexes should return all the indexes at this point.
        System.out.println("cardIndexes() = "+b.cardIndexes());
        //10. toString works.  We've been using it the whole time!
        System.out.println("toString() =  "+b.toString());
        //11. Next I see gameIsWon() - Game is won should be false right now
        System.out.println("gameIsWon() = "+b.gameIsWon());
        //12. Next there's isLegal() - Passing in l probably gives false, but check it if gives true
        System.out.println("isLegal(l) = "+ b.isLegal(l));
        //13. Then I see anotherPlayIsPossible() which will probalby be true -
        System.out.println("anotherPlayIsPossible() == "+b.anotherPlayIsPossible());

        //14. dealMyCards() - We've already run this.  You can't really test it here because it's
        //a private method that we can't access

        //15. The last two we have already tested with "anotherPlayIsPossible() ... I think
        //were done here.  Phew that's a lot of work!  What kind of teacher would make their
        //student do all that work?
    }
}