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
        int aces = 0;
        for (Card card: hand){
            total += card.getValue();

            if (card.getValue() == 11){
                aces++;
            }
        }
        if (total > 21 && aces > 0){ //this is saying if these two conditions are filled, you will then go to the while loop
            while (aces> 0 && total > 21){ //while the value remains over 21, or until you have no aces left (because theyre the only ones with dynamic values...)
                aces--;// you iterate through the loop and change an ace from 11 til 1 (by -10) and then you essentially take that ace out of the count bc it's now a 1.
                total -=10;//this is logically the same as just changing the ace from 11 til 1 but easier to write out logically. 
            }
        }
        return total;
    }
    //needed to add getCard for the dealer's first card in hand
    public Card getCard(int index){
        return hand.get(index);
    }

    public String toString(){
        //Use StringBuilder class.  Found this class after researching if Strings could be mutable in Java 
        StringBuilder cards = new StringBuilder();
        for (Card card : hand){
            cards.append(card).append(", ");
        }
        return cards.toString();//String builder was returning an object, so I had to call the toString() method on this so I could actuall get the String I wanted.
    }

    public void discardHandToDeck(DeckList discardDeck){//adding this in because it basically stores all your previous cards in your hand and never gets rid of them making you have a massive hand 
        discardDeck.addCards(hand);
        hand.clear();
    }

    //make a function to calculate what the total of the cards in your hand are??

}