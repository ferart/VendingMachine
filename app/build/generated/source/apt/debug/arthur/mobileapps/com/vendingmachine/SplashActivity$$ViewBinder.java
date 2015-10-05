// Generated code from Butter Knife. Do not modify!
package arthur.mobileapps.com.vendingmachine;

import android.content.res.Resources;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SplashActivity$$ViewBinder<T extends arthur.mobileapps.com.vendingmachine.SplashActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    Resources res = finder.getContext(source).getResources();
    target.city = res.getDrawable(2130837587);
  }

  @Override public void unbind(T target) {
  }
}
