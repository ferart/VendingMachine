package arthur.mobileapps.com.vendingmachine;

import android.app.Application;

import arthur.mobileapps.com.vendingmachine.business.BusinessComponent;
import arthur.mobileapps.com.vendingmachine.business.DaggerBusinessComponent;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.BusinessModule;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.VendingManagerImpl;
import arthur.mobileapps.com.vendingmachine.ui.DaggerUIComponent;
import arthur.mobileapps.com.vendingmachine.ui.UIComponent;
import arthur.mobileapps.com.vendingmachine.ui.presenter.PresenterModule;
import timber.log.Timber;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * custom application class
 * it handles the components that inject dependencies
 */

public class ApplicationManager extends Application {

    //components
    private UIComponent uiComponent;
    private BusinessComponent businessComponent;


    @Override
    public void onCreate() {
        super.onCreate();


       //logging only on debug mode
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        //creates the components for the presenters and business
        uiComponent= DaggerUIComponent.builder().presenterModule(new PresenterModule(this,new VendingManagerImpl())).build();
        businessComponent= DaggerBusinessComponent.builder().businessModule(new BusinessModule()).build();


    }

    public UIComponent getUiComponent() {
        return uiComponent;
    }

    public BusinessComponent getBusinessComponent() {
        return businessComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
