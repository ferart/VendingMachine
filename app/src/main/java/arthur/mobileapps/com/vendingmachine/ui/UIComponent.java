package arthur.mobileapps.com.vendingmachine.ui;

import javax.inject.Singleton;

import arthur.mobileapps.com.vendingmachine.ApplicationManager;
import arthur.mobileapps.com.vendingmachine.SplashActivity;
import arthur.mobileapps.com.vendingmachine.ui.presenter.PresenterModule;
import arthur.mobileapps.com.vendingmachine.ui.presenter.SplashPresenter;
import arthur.mobileapps.com.vendingmachine.ui.views.VendingActivity;
import dagger.Component;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Component used to inject dependencies for the Presenter Modules
 */
@Singleton
@Component(modules = {PresenterModule.class})
public interface UIComponent {
    void inject(ApplicationManager applicationManager);
    void inject(SplashActivity splashActivity);
    void inject(VendingActivity vendingActivity);
    //SplashPresenter injectSplashPresenter();
}
