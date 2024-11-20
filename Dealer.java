public class Dealer extends Person{

    public Dealer(){
        super.setName("Dealer");
    }//this is a superconstructor 

    //add a method that prints out what the dealers hand was 
    public void printFirstCard(){
        System.out.println("Dealer's hand: ");
        System.out.println(super.getHand().getCard(0));
        System.out.println("Second card remains face down.");
    }

}