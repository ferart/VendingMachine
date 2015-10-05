package arthur.mobileapps.com.vendingmachine.business.vendingBusiness;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * implementation of the interface VendingManager
 */
public class VendingManagerImpl implements VendingManager {
    private float totalMoney; //amount of money to spend

    private float balance;    //the balance of the user

    //money to give back as change
    float dollar5;
    float dollar2;
    float dollar1;
    float coin25;
    float coin10;
    float coin5;



    public VendingManagerImpl() {
        totalMoney =0f;
    }

    @Override
    public float getTotalMoney() {
        return totalMoney;
    }

    @Override
    public void decreaseMoney(float amount) {
        this.totalMoney-=amount; //a purchased has been made
    }

    @Override
    public boolean hasEnoughMoney(float amount) {
        if ((this.totalMoney-amount)>0) //a sell can be done
            return true;

        return false;
    }

    @Override
    public boolean hasStock(int stock) {
        if (stock>0) //it has more than one product on stock
            return true;
        return false;
    }

    @Override
    public void addMoney(float coin) {
        this.totalMoney +=coin;
    }

    @Override
    public void calculateChange(){
        balance=this.totalMoney;
        this.dollar5=0;
        this.dollar2=0;
        this.dollar1=0;
        this.coin25=0;
        this.coin10=0;
        this.coin5=0;
        calculate();
    }

    @Override
    public String getChangeString() {
        String changeStr = "";

        if (dollar5 > 0) {
            changeStr += "\n" + (int)dollar5 + " of 5 dollar(s)\n";
        }

        if (dollar2 > 0) {
            changeStr += "\n" + (int)dollar2 + " of 2 dollar(s)";
        }

        if (dollar1 > 0) {
            changeStr += "\n" + (int)dollar1 + " of 1 dollar(s)";
        }

        if (coin25 > 0) {
            changeStr += "\n" + (int)coin25 + " of 25 cents";
        }

        if (coin10 > 0) {
            changeStr += "\n" + (int)coin10 + " of 10 cents";
        }

        if (coin5 > 0) {
            changeStr += "\n" + (int)coin5 + " of 5 cents";
        }

        if (changeStr.equals("")) return"";
        return changeStr;
    }

    private  void calculate() {
        float d5 = 0;
        float d2 = 0;
        float d1 = 0;
        float c25 = 0;
        float c10 = 0;
        float c5 = 0;

        if (balance == 0 || balance < 0.05) {
            balance = 0;
            return;
        }

        d5 = (float)Math.floor(balance / 5f);
        if (d5 >= 1) {
            this.dollar5 = d5;
            balance -= d5 * 5f;
        } else {
            d2 = (float)Math.floor(balance / 2f);
            if (d2 >= 1) {
                this.dollar2 = (float)Math.floor(d2);
                balance -= d2 * 2f;
            } else {
                d1 = (float)Math.floor(balance / 1f);
                if (d1 >= 1) {
                    this.dollar1 = d1;
                    balance -= d1 * 1f;
                } else {
                    c25 = (float)Math.floor(balance / .25f);
                    if (c25 >= 1) {
                        this.coin25 = c25;
                        balance -= c25 * .25f;
                    } else {
                        c10 = (float)Math.floor(balance / .10f);
                        if (c10 >= 1) {
                            this.coin10 = c10;
                            balance -= c10 * .10f;
                        } else {
                            c5 = (float)Math.floor(balance / 0.05f);
                            if (c5 >= 1) {
                                this.coin5 = c5;
                                balance -= c5 * 0.05;
                            } else {
                                balance = 0;
                            }
                        }
                    }
                }
            }
        }
        calculate();
    }
}
