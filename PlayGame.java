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
            } else{
                System.out.println("Dealer has Blackjack, you lose.");
                this.dealerScore++;
            }
        }

        if(player1.hasBlackJack(player1.getHand())){
            System.out.println("You have Blackjack, you win!");
            this.player1Score++;
        }

        player1.playerDecision(deck, discardDeck);

    }
   
}