public class PlayGame{
    private int player1Score;
    private int dealerScore;
    private DeckList deck, discardDeck;
    private Player player1;
    private Dealer dealer;
    

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
                startRound();
            } else{
                System.out.println("Dealer has Blackjack, you lose.");
                this.dealerScore++;
                startRound();
            }
        }

        if(player1.hasBlackJack(player1.getHand())){
            System.out.println("You have Blackjack, you win!");
            this.player1Score++;
            startRound();
        }

        player1.playerDecision(deck, discardDeck);

        if(player1.getHand().calculateTotalHand() > 21){
            System.out.println("You went bust :(");
            dealerScore++;
            startRound();
        }

        //dealer logic insert here
        dealer.printHand();
        while(dealer.getHand().calculateTotalHand() < 17){
            dealer.hit(deck, discardDeck);
        }

        if (dealer.getHand().calculateTotalHand() > 21){
            System.out.println("Dealer went bust, you win! ");
            player1Score++;
        } else if (dealer.getHand().calculateTotalHand() > player1.getHand().calculateTotalHand()){
            System.out.println("You lose :( ");
            dealerScore++;
        } else if (player1.getHand().calculateTotalHand() > dealer.getHand().calculateTotalHand()){
            System.out.println("You win :) ");
            player1Score++;
        } else{
            System.out.println("It's a tie! ");
            player1Score++;
            dealerScore++;
        }

        startRound();

    }
   
}