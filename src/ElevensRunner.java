import java.util.*;
public class ElevensRunner {


    public static void main(String[] args) {
        ElevensBoard gameBoard = new ElevensBoard();
        gameBoard.newGame();
        boolean lose = false;
        Scanner s = new Scanner(System.in);

        while(gameBoard.anotherPlayIsPossible()) {

            if(!gameBoard.anotherPlayIsPossible()&& !gameBoard.gameIsWon()) {
                break;
            }
            System.out.println("There are " + gameBoard.deckSize() + " undealt cards remaining");
            System.out.println("0   1   2   3   4   5   6   7   8");
            String cardsDisplay = "";
            for(int i = 0; i <= 8;i++) {
                if(gameBoard.cardAt(i)==null) {
                    cardsDisplay+=null;
                }else {
                    cardsDisplay += gameBoard.cardAt(i).rank() + "" + gameBoard.cardAt(i).suit() + "  ";
                }
            }
            System.out.println(cardsDisplay);
            String playerChoice = "";
            int firstIndex;
            int secondIndex;
            int thirdIndex = -1;
            System.out.print("Enter 2 two or three cards to remove: ");
            playerChoice = s.nextLine();
            //System.out.println(playerChoice);
            firstIndex = Integer.parseInt(playerChoice, 0, 1, 10);
            secondIndex = Integer.parseInt(playerChoice, 2,3,10);
            if(playerChoice.length()>3) {
                thirdIndex = Integer.parseInt(playerChoice, 4,5,10);
            }

            List<Integer> playerIndexes = new ArrayList<>();
            playerIndexes.add(firstIndex);
            playerIndexes.add(secondIndex);
            if(thirdIndex!=-1) {
                playerIndexes.add(thirdIndex);
            }
            //System.out.println(playerIndexes);
            //System.out.println(gameBoard.isLegal(playerIndexes));
            if(gameBoard.isLegal(playerIndexes)) {
                gameBoard.replaceSelectedCards(playerIndexes);
            }

        }

        if(!gameBoard.gameIsWon()) {
            //System.out.println("You lost 😢");
        }else {
            System.out.println("You won!");

        }
        System.out.println("You won!");
    }
}
