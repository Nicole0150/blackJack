import java.util.ArrayList;

public class Hand{
    private ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    //a hand starts with 2 cards in it but it also needs to store more.
    //get the card from the deck to your hand
    //needs toString for printing out the hand

    public void putCardInHand(DeckList deck){
        Card fetchCard = deck.getCard();
        hand.add(fetchCard);
    }

}