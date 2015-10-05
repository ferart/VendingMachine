package arthur.mobileapps.com.vendingmachine;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import javax.inject.Inject;

import arthur.mobileapps.com.vendingmachine.ui.DaggerUIComponent;
import arthur.mobileapps.com.vendingmachine.ui.UIComponent;
import arthur.mobileapps.com.vendingmachine.ui.presenter.PresenterModule;
import arthur.mobileapps.com.vendingmachine.ui.presenter.SplashPresenter;
import arthur.mobileapps.com.vendingmachine.ui.views.GifMovieView;
import butterknife.BindDrawable;

import timber.log.Timber;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * splash screen for the vending machine, it shows a cinemagraph
 */
public class SplashActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 4000;

    @BindDrawable(R.drawable.machine)
    Drawable city;
    GifMovieView gifMovie;

    //dependency injection using dagger2
    @Inject
    SplashPresenter splashPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Timber.i("inicia splash");

        //hiding upper android bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        gifMovie = (GifMovieView) findViewById(R.id.gifSplash);
        gifMovie.setMovieResource(R.drawable.light);

        //using dagger we inject the dependency  (the presenter)
        ((ApplicationManager)getApplication()).getUiComponent().inject(this);
        splashPresenter.stopsSplashScreen(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
