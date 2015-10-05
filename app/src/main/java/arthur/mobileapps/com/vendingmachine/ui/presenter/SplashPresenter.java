package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.content.Context;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Interface that specifies the contract of the splash presenter
 */
public interface SplashPresenter {
    /**
     *Creates a new thread to be executed after  2s.
     * this thread opens a new activity
     * @param activityContext
     */
    public void stopsSplashScreen(Context activityContext);
}
