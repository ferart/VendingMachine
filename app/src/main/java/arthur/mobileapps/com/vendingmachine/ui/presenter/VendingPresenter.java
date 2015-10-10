package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.content.Context;

import java.util.List;

import arthur.mobileapps.com.vendingmachine.beans.ProductBean;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * contract of the vending presenter
 * these methods are a bridge between the view-presenter and the model (business)
 */
public interface VendingPresenter {

    /**
     * restock the vending machine
     * @return the list of products
     */
    List<ProductBean> fillListToAdapter();

    /**
     * sells a product if there is a product in stock and has enough balance,
     * if the sell continues, the balance is decreased and the change to be given is calculated
     * @param context
     * @param productBean product to be bought
     * @return
     */
    float sellProduct(Context context, ProductBean productBean);

    /**
     * bridge between the presenter and the model (business)
     * @param value of the coin or dollar to be added
     */
    void addCoins(float value);

    /**
     * balance of the user
     * @return
     */

    float getMoneyToSpend();

    /**
     * opens the Slides with wiewPager
     * @param context
     */
    void openSlide(Context context);
}
