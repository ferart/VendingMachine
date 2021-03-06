package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import arthur.mobileapps.com.vendingmachine.R;
import arthur.mobileapps.com.vendingmachine.SplashActivity;
import arthur.mobileapps.com.vendingmachine.ui.views.VendingActivity;

/**
 * Created by Arthur Rocha on 01/10/2015.
 */
public class SplashPresenterImpl implements SplashPresenter {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    public SplashPresenterImpl() {

    }

    @Override
    public void stopsSplashScreen(final Context activityContext) {
        /* New Handler to start the Vending-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Vending-Activity. */
                Intent mainIntent = new Intent(activityContext,VendingActivity.class);
                activityContext.startActivity(mainIntent);
                if (activityContext instanceof SplashActivity){
                    ((SplashActivity)activityContext).overridePendingTransition(R.anim.right_entrance,R.anim.left_out);
                    AnimatorSet animator=(AnimatorSet) AnimatorInflater.loadAnimator(activityContext, R.animator.alpha_changing);
                    animator.setTarget(activityContext);
                    animator.start();

                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
