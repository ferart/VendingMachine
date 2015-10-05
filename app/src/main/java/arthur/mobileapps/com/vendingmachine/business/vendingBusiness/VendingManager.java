package arthur.mobileapps.com.vendingmachine.business.vendingBusiness;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Interface that defines the contract for the business implementation of the vending machine
 */
public interface VendingManager {

   /**
    * adds money to spend in the vending machine
    * simulates insert coin
    * @param coin, can be of 5, 10, 25 cents or 5,2,1 dollars
    */
   void addMoney(float coin);

   /**
    * returns the money inserted into the machine
    * @return the balance
    */
   float getTotalMoney();

   /**
    * when a purchase is done, it decrease the money it has ( anew balance)
    * @param amount price of the product
    */
   void decreaseMoney(float amount);

   /**
    * checks wheter it has enough money to buy a product of the amount specified in the
    * argument
    * @param amount price of the product intended to be bought
    * @return
    */
   boolean hasEnoughMoney(float amount);

   /**
    * check if the vending machine has at least one product to sell
    * @param stock
    * @return true if there is at least one product to sell
    */
   boolean hasStock(int stock);

   /**
    * calculates the change to be given after a purchased
    */
   void calculateChange();

   /**
    * creates a string indicating the currency to be returned in change
    * @return
    */
   String getChangeString();

}
