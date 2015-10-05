package arthur.mobileapps.com.vendingmachine;

import android.support.v7.app.AppCompatActivity;
import arthur.mobileapps.com.vendingmachine.ui.presenter.SplashPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final MembersInjector<AppCompatActivity> supertypeInjector;
  private final Provider<SplashPresenter> splashPresenterProvider;

  public SplashActivity_MembersInjector(MembersInjector<AppCompatActivity> supertypeInjector, Provider<SplashPresenter> splashPresenterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert splashPresenterProvider != null;
    this.splashPresenterProvider = splashPresenterProvider;
  }

  @Override
  public void injectMembers(SplashActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.splashPresenter = splashPresenterProvider.get();
  }

  public static MembersInjector<SplashActivity> create(MembersInjector<AppCompatActivity> supertypeInjector, Provider<SplashPresenter> splashPresenterProvider) {  
      return new SplashActivity_MembersInjector(supertypeInjector, splashPresenterProvider);
  }
}

