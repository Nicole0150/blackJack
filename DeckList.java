import java.util.ArrayList;

public class DeckList{
    private ArrayList<Card> deckList;

    // make a constructor that makes a new Array list 
    public DeckList(){
        deckList = new ArrayList<Card>();
    }
    //make a getter because its private - dont forget to return it (You always forget to return it)

    public ArrayList<Card> getDeckList(){
        return this.deckList;
    }
    //make a method that constructs a deck - youll need nested for/ each loops look at W3 schools, remember the .add() method for decklists (again w3 schools)

    public ArrayList<Card> makeDeck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                Card newCard = new Card(suit, rank);
                deckList.add(newCard);
            }
        }
        return deckList;
    }
    //make a method to pull a random card from that array list out, i think it will need to involve Math.random and the remove() method as that returns an actual object from that list
    //then youd need to put in a new arraylist??
    



}