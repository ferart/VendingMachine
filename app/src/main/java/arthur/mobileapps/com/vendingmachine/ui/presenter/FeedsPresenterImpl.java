package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.content.Context;

import javax.inject.Inject;

import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.NetworkOperations;

/**
 * Created by Fernando on 10/10/2015.
 */
public class FeedsPresenterImpl implements FeedsPresenter {

    private Context context;
    private NetworkOperations networkOperations;

    @Inject
    public FeedsPresenterImpl(NetworkOperations networkOperations) {
       this.networkOperations=networkOperations;
    }

    @Override
    public String getFeed() {
        networkOperations.getFeed();

        return null;
    }
}
