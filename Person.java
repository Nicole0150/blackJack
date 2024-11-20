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
}