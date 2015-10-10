package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import arthur.mobileapps.com.vendingmachine.ApplicationManager;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.NetworkOperations;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.VendingManager;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Module that provides dependencies of presenters to the User interface
 * using this kind of injections we folloe the Model-view-presenter design pattern
 */
@Module
public class PresenterModule {

    private Application context;            //custom Application
    private VendingManager vendingManager;  //dependency needed
    private NetworkOperations networkOperations;

    public PresenterModule(Context Context,VendingManager vendingManager,NetworkOperations networkOperations) {
        this.context = context;
        this.vendingManager=vendingManager;
        this.networkOperations=networkOperations;
    }

    /**
     * creates a new splash presenter needed in splash activity
     * @return
     */
    @Provides @Singleton SplashPresenter provideSplashPresenter(){
        return new SplashPresenterImpl();
    }

    /**
     * Creates a new vending presenter needed in vending Activity
     * @return
     */
    @Provides @Singleton VendingPresenter provideVendingPresenter(){
        return new VendingPresenterImpl(vendingManager);
    }

    @Provides @Singleton FeedsPresenter provideFeedsPresenter(){
        return  new FeedsPresenterImpl(networkOperations);
    }
}
