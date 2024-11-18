public class Person{
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
}