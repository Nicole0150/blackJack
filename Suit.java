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

//enums are a special class that are basically all constants.
//I'm using this here because my suits and my ranks are never going to change
//The toString() method runs when I call the object to the console, it makes it more readable and makes it a string which is easier to incorporate into other code later in the program
