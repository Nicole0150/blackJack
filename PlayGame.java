import java.util.Scanner; //add in

public class PlayGame{
    private int player1Score;
    private int dealerScore;
    private DeckList deck, discardDeck;
    private Player player1;
    private Dealer dealer;

    Scanner scanner = new Scanner(System.in);
    

    public PlayGame(){
        this.player1Score = 0;
        this.dealerScore = 0;

        deck = new DeckList();
        discardDeck = new DeckList();
        deck.makeDeck();
        deck.shuffleDeck();

        player1 = new Player();
        dealer = new Dealer();

        startRound();
    }

    public void startRound(){
        //give the cards out
        //show one of the dealers card (youll need to make this in Dealer class)
        if (player1Score > 0 || dealerScore > 0){
            System.out.println();
            System.out.println("NEXT ROUND BEGINS...");
            System.out.println("Player 1 Score: " + player1Score + ".  Dealer Score: " + dealerScore);
            player1.getHand().discardHandToDeck(discardDeck);//this is basically a reset of the hand situation every loop the startRound method goes through 
            dealer.getHand().discardHandToDeck(discardDeck);
        }
        dealer.getHand().putCardInHand(deck);
        dealer.getHand().putCardInHand(deck);

        player1.getHand().putCardInHand(deck);
        player1.getHand().putCardInHand(deck);

        dealer.printFirstCard();
        player1.printHand();
        
        //originally had the next part of code without the nested statements but upon refactoring, I decided to nest them to save space

        if (dealer.hasBlackJack(dealer.getHand())){
            dealer.printHand();
            if (player1.hasBlackJack(player1.getHand())) {
                System.out.println("It's a tie!");
                this.player1Score++;
                this.dealerScore++;
                //
            } else{
                System.out.println("Dealer has Blackjack, you lose.");
                this.dealerScore++;
                //
            }
        }

        if(player1.hasBlackJack(player1.getHand())){
            System.out.println("You have Blackjack, you win!");
            this.player1Score++;
            //playAgain();
        }

        player1.playerDecision(deck, discardDeck);

        if(player1.getHand().calculateTotalHand() > 21){
            System.out.println("You went bust :(");
            dealerScore++;
            //playAgain();
        }

        //dealer logic insert here
        dealer.printHand();
        while(dealer.getHand().calculateTotalHand() < 17){
            dealer.hit(deck, discardDeck);
        }

        if (dealer.getHand().calculateTotalHand() > 21){
            System.out.println("Dealer went bust, you win! ");
            player1Score++;
            //playAgain(); Left this in as example of where I tripped up - entered a half finished recursion loop that meant inputting No multiple times before it exited the program
        } else if (dealer.getHand().calculateTotalHand() > player1.getHand().calculateTotalHand()){
            System.out.println("You lose :( ");
            dealerScore++;
            //playAgain();
        } else if (player1.getHand().calculateTotalHand() > dealer.getHand().calculateTotalHand()){
            System.out.println("You win :) ");
            player1Score++;
            //playAgain();
        } else{
            System.out.println("It's a tie! ");
            player1Score++;
            dealerScore++;
            //playAgain();
        }

        this.playAgain();

    }

    public void playAgain(){//add in
        int decision = 0;
        boolean decisionMade = true;
        while (decisionMade){
            try{
                System.out.println("Would you like to play again? Enter (1)Yes, (2)No. ");
                decision = scanner.nextInt();
                if(decision == 1){
                    startRound();
                    break;

                } else if (decision == 2){
                    System.out.println("Thanks for playing!\nFinal Scores:\nPlayer1: " + player1Score + "\nDealer: " + dealerScore);
                    break;
                }
            
            } catch(Exception e){
                System.out.println("Invalid input.  ");
                scanner.next();
            }
        }


    }
   
}