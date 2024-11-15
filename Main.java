public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my Blackjack Project");
        Card card = new Card(Suit.SPADE, Rank.TEN);
        System.out.println(card.toString());
        DeckList deck = new DeckList();
        System.out.println(deck.makeDeck().size());
        System.out.println(deck.shuffleDeck());
        
        //poss add in rules information?  Conditional for do you know the rules and if no, make a rules class?
        PlayGame game = new PlayGame();

    }
}