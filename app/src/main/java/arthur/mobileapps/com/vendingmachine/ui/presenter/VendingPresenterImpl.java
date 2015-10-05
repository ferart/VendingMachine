package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.content.Context;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import arthur.mobileapps.com.vendingmachine.R;
import arthur.mobileapps.com.vendingmachine.beans.ProductBean;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.VendingManager;
import arthur.mobileapps.com.vendingmachine.ui.views.SellProductDialog;
import arthur.mobileapps.com.vendingmachine.ui.views.VendingActivity;

/**
 * Created by Arthur Rocha on 01/10/2015.
 */
public class VendingPresenterImpl implements VendingPresenter {

    private final VendingManager vendingManager;

    @Inject
    public VendingPresenterImpl(VendingManager vendingManager) {
        this.vendingManager = vendingManager;
    }


    @Override
    public List<ProductBean> fillListToAdapter() {
        List<ProductBean> products=new ArrayList<ProductBean>();


        products.add(new ProductBean(R.drawable.agua1,0.75f,10));
        products.add(new ProductBean(R.drawable.agua2,0.5f,10));
        products.add(new ProductBean(R.drawable.agua3,1.75f,10));
        products.add(new ProductBean(R.drawable.agua4,1.5f,10));
        products.add(new ProductBean(R.drawable.agua5,0.75f,10));
        products.add(new ProductBean(R.drawable.agua6,0.5f,10));

        products.add(new ProductBean(R.drawable.galletas1,0.25f,10));
        products.add(new ProductBean(R.drawable.galletas2,0.75f,10));
        products.add(new ProductBean(R.drawable.galletas3,1.75f,10));
        products.add(new ProductBean(R.drawable.galletas4,0.25f,10));
        products.add(new ProductBean(R.drawable.galletas5,1.75f,10));
        products.add(new ProductBean(R.drawable.galletas6,1.00f,10));

        products.add(new ProductBean(R.drawable.soda1,1.00f,10));
        products.add(new ProductBean(R.drawable.soda2,0.50f,10));
        products.add(new ProductBean(R.drawable.soda3,0.75f,10));
        products.add(new ProductBean(R.drawable.soda4,1.75f,10));
        products.add(new ProductBean(R.drawable.soda5,0.50f,10));
        products.add(new ProductBean(R.drawable.soda6,1.75f,10));

        products.add(new ProductBean(R.drawable.papas1,0.75f,10));
        products.add(new ProductBean(R.drawable.papas2,1.75f,10));
        products.add(new ProductBean(R.drawable.papas3,0.50f,10));
        products.add(new ProductBean(R.drawable.papas4,0.75f,10));
        products.add(new ProductBean(R.drawable.papas5,1.00f,10));
        products.add(new ProductBean(R.drawable.papitas6,0.75f,10));

        return products;
    }

    @Override
    public float sellProduct(Context context, ProductBean productBean) {

        if (context instanceof VendingActivity) {//use reflection
            //if a selling can be made
            if (vendingManager.hasEnoughMoney(productBean.getPrice()) && vendingManager.hasStock(productBean.getStock())) {
                vendingManager.decreaseMoney(productBean.getPrice()); //creates a new balance
                vendingManager.calculateChange();   //calculates the change
                String changeStr=vendingManager.getChangeString();

                //open the dialog fragment that indicates the new balance and the change
                DialogFragment newFragment = SellProductDialog.newInstance(context, vendingManager.getTotalMoney(), changeStr, true);
                newFragment.show(((VendingActivity) context).getSupportFragmentManager(), "SellProductDialog");

            }else {
                DialogFragment newFragment = SellProductDialog.newInstance(context, 0,null,false);
                newFragment.show(((VendingActivity) context).getSupportFragmentManager(), "SellProductDialog");
            }
        }

        return 0;
    }

    @Override
    public void addCoins(float value) {
        vendingManager.addMoney(value);
    }

    @Override
    public float getMoneyToSpend() {
        return vendingManager.getTotalMoney();
    }
}
