public enum Suit{
    SPADE("Spades"),
    DIAMOND("Diamonds"),
    HEART("Hearts"), 
    CLUB("Clubs");
    
    String suit;

    Suit(String suit){
        this.suit = suit;
    }

    public String toString(){
        return suit;
    }
}