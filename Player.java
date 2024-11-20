import java.util.Scanner;

public class Player extends Person{

    Scanner scanner = new Scanner(System.in);

    public Player(){
        super.setName("Player1");
    }

    public void playerDecision(DeckList deck, DeckList discardDeck){
        String decision = "";
        boolean getDecision = true;
        while(getDecision) {
            try{
                System.out.println("Would you like to Hit or Stand? ");
                decision = scanner.nextLine();
            } catch(Exception e){
                System.out.println("Invalid input");
                scanner.next();
            }
            
        }

        System.out.println("You chose to " + decision);
    }

}