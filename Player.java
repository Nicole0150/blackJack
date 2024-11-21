import java.util.Scanner;

public class Player extends Person{

    Scanner scanner = new Scanner(System.in);

    public Player(){
        super.setName("Player1");
    }

    public void playerDecision(DeckList deck, DeckList discardDeck){
        int decision = 0;//got the idea to use integers instead as I'm having issues exception handling with my Strings, this is slightly easier for now
        boolean getDecision = true;
        while(getDecision) {
            try{
                System.out.println("Would you like to Hit (1) or Stand (2)? ");
                decision = scanner.nextInt();
                getDecision = false;
            } catch(Exception e){
                System.out.println("Invalid input");
                scanner.next();
            }
            
        }
        if (decision == 1){
            this.hit(deck, discardDeck);
            if(this.getHand().calculateTotalHand()>20){
                System.out.println("You went bust :(");
                return; ///this is to exit if they went bust
            } else{
                this.playerDecision(deck, discardDeck); //this just gives them the option to hit again if they didn't go bust
            }
        } else{
            System.out.println("You chose to Stand");
        }
        
    }

}