public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my Blackjack Project");
        DeckList deck = new DeckList();
        Hand hand = new Hand();
        deck.makeDeck();
        deck.shuffleDeck();
        hand.putCardInHand(deck);
        hand.putCardInHand(deck);
        System.out.println(hand);
        int total = hand.calculateTotalHand();
        System.out.println(total);
        Person nicole = new Person();
        nicole.setName("Nicole");

        
        //poss add in rules information?  Conditional for do you know the rules and if no, make a rules class?
        PlayGame game = new PlayGame();

    }
}