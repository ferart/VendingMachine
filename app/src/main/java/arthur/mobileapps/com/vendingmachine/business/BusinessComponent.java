package arthur.mobileapps.com.vendingmachine.business;

import javax.inject.Singleton;

import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.BusinessModule;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.NetworkOperations;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.VendingManager;
import arthur.mobileapps.com.vendingmachine.ui.presenter.PresenterModule;
import arthur.mobileapps.com.vendingmachine.ui.presenter.VendingPresenter;
import dagger.Component;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Component used to inject dependencies for the BusinessModule
 */
@Singleton
@Component(modules = {BusinessModule.class})
public interface BusinessComponent {
    //avoid inject(VendingPresenter vendingPresenter);
   VendingManager injectVendingManager();
   NetworkOperations injectNetworkOperations();

}
