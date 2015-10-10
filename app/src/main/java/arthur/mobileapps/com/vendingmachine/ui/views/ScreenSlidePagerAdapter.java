package arthur.mobileapps.com.vendingmachine.ui.views;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import arthur.mobileapps.com.vendingmachine.ui.presenter.FeedsPresenter;

/**
 * Created by Fernando on 10/10/2015.
 */
public class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 5;
    private FeedsPresenter feedsPresenter;


    public ScreenSlidePagerAdapter(FragmentManager fm, FeedsPresenter feedsPresenter) {
        super(fm);
        this.feedsPresenter=feedsPresenter;
    }

    public void addContent(){

    }

    @Override
    public Fragment getItem(int position) {

        String content=feedsPresenter.getFeed();
        return ScreenSlideFragment.newInstance("Heading",content);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
