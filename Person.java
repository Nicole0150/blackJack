public abstract class Person{ //the reason this is abstract is because im never just going to create a Person, it will always be a Dealer or Player 
//you cant directly create an instance of abstract class
    private String name;
    private Hand hand;

    //you need getters and setters for hand and name
    //method to decide if wants another card 
    //method to decide if has blackjack

    public Person(){
        this.name = "";
        this.hand = new Hand();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Hand getHand(){
        return this.hand;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void printHand(){
        System.out.println(this.name + " hand: ");
        System.out.println(this.hand + " hand value: " + this.hand.calculateTotalHand());
    }

    public boolean hasBlackJack(Hand hand){
        if(hand.calculateTotalHand() == 21){
            return true;
        }else {
            return false;
        }
    }

    public void hit(DeckList deck, Decklist discardDeck){
        if(!deck.hasCards()){
            deck.discardToMainDeck(discardDeck);
        }// just added this bit of code in so it doesnt run into errors trying to remove a card from an empty deck, this activates the reloading and reshuffling of a new deck
        this.hand.putCardInHand(deck);
        System.out.println(this.name + "was given a card. ");
        this.printHand();

    }
}