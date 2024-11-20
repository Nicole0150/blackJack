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
    
    public void shuffleDeck(){
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        while(deckList.size() > 0){
            int noCardToRemove = (int)(Math.random() * (deckList.size() -1)); //had issue here because was originally using Math.random *52 which was leading to out of bounds
            //changed to Math.random*52 -1 which was same issue but also negative numbers someimes
            //realised needed a more dynamic variable as the length of the arraylist is changing each iteration and need to mirror that - hence using deckList.size()
            Card removeCard = this.deckList.remove(noCardToRemove);
            shuffledDeck.add(removeCard);
        }
        this.deckList = shuffledDeck;
    }

    public Card getCard(){
        Card card = deckList.remove(0);
        return card;
    }
    //this was easier to read when implemented here rather than in the body if the function where I use it, basically just checking that the deck I want to take from has cards in it
    public boolean hasCards(){
        if (deckList.size() > 0){
            return true;
        } else{
            return false;
        }
    }

    //now need to add methods that takes the discard pile and shuffles it into the main deck

    public void clearDeck(){
        deckList.clear(); //build in functionality for ArrayLists
    }

    public void addCards(ArrayList<Card> cards){
        deckList.add(cards);
    }

    public void discardToMainDeck(DeckList discard){
        this.addCards(discard.getDeckList());//call the get DeckList function on the discard pile of your choice + then calls the addCards function that adds all the cards to the AL
        this.shuffleDeck(); //then it shuffles them
        discard.emptyDeck();// because the above function copies the discard pile to the deck, you need to empty that to signify that they've been moved over
        System.out.println("Created new deck.");
    }

}