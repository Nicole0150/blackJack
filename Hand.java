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

    public int calculateTotalHand(){
        int total = 0;
        for (Card card: hand){
            total += card.getValue();
        }
        return total;
    }

    public String toString(){
        //Use StringBuilder class.  Found this class after researching if Strings could be mutable in Java 
        StringBuilder cards = new StringBuilder();
        for (Card card : hand){
            cards.append(card).append(", ");
        }
        return cards.toString();//String builder was returning an object, so I had to call the toString() method on this so I could actuall get the String I wanted.
    }

    //make a function to calculate what the total of the cards in your hand are??

}