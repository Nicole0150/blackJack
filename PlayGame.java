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
    }
}