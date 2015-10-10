package arthur.mobileapps.com.vendingmachine.ui.views;

import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

import arthur.mobileapps.com.vendingmachine.ApplicationManager;
import arthur.mobileapps.com.vendingmachine.R;
import arthur.mobileapps.com.vendingmachine.ui.presenter.FeedsPresenter;
import arthur.mobileapps.com.vendingmachine.ui.presenter.VendingPresenter;
import arthur.mobileapps.com.vendingmachine.ui.views.animations.DepthPageTransformer;
import butterknife.Bind;

public class ScreenSlideActivity extends AppCompatActivity implements ScreenSlideFragment.OnFragmentInteractionListener {


    ViewPager viewPager;

    private PagerAdapter mPagerAdapter;

    @Inject
    FeedsPresenter feedsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        //using dagger we inject the dependency  (the presenter)
        ((ApplicationManager)getApplication()).getUiComponent().inject(this);

        viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        mPagerAdapter= new ScreenSlidePagerAdapter(getSupportFragmentManager(),feedsPresenter);
        viewPager.setAdapter(mPagerAdapter); //not in this point

        //viewPager.addOnPageChangeListener(pageListener);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screen_slide, menu);


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

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

   /* ViewPager.OnPageChangeListener pageListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            ((ScreenSlidePagerAdapter) mPagerAdapter).getItem(position);

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    */
}
