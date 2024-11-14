public class Card{
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    //we're making this private because again, they're constant entities and we don't want anyone else to be able to change them - that's cheating :)

    //but we do need getter methods
    public Rank getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public int getValue(){
        return this.rank.value;
    }

    public String toString(){
        return (this.rank + " of " + this.suit + "( " + this.getValue() + " )");
    }
}