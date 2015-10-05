package arthur.mobileapps.com.vendingmachine.ui;

import arthur.mobileapps.com.vendingmachine.ApplicationManager;
import arthur.mobileapps.com.vendingmachine.SplashActivity;
import arthur.mobileapps.com.vendingmachine.SplashActivity_MembersInjector;
import arthur.mobileapps.com.vendingmachine.ui.presenter.PresenterModule;
import arthur.mobileapps.com.vendingmachine.ui.presenter.PresenterModule_ProvideSplashPresenterFactory;
import arthur.mobileapps.com.vendingmachine.ui.presenter.PresenterModule_ProvideVendingPresenterFactory;
import arthur.mobileapps.com.vendingmachine.ui.presenter.SplashPresenter;
import arthur.mobileapps.com.vendingmachine.ui.presenter.VendingPresenter;
import arthur.mobileapps.com.vendingmachine.ui.views.VendingActivity;
import arthur.mobileapps.com.vendingmachine.ui.views.VendingActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerUIComponent implements UIComponent {
  private Provider<SplashPresenter> provideSplashPresenterProvider;
  private MembersInjector<SplashActivity> splashActivityMembersInjector;
  private Provider<VendingPresenter> provideVendingPresenterProvider;
  private MembersInjector<VendingActivity> vendingActivityMembersInjector;

  private DaggerUIComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideSplashPresenterProvider = ScopedProvider.create(PresenterModule_ProvideSplashPresenterFactory.create(builder.presenterModule));
    this.splashActivityMembersInjector = SplashActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), provideSplashPresenterProvider);
    this.provideVendingPresenterProvider = ScopedProvider.create(PresenterModule_ProvideVendingPresenterFactory.create(builder.presenterModule));
    this.vendingActivityMembersInjector = VendingActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), provideVendingPresenterProvider);
  }

  @Override
  public void inject(ApplicationManager applicationManager) {  
    MembersInjectors.noOp().injectMembers(applicationManager);
  }

  @Override
  public void inject(SplashActivity splashActivity) {  
    splashActivityMembersInjector.injectMembers(splashActivity);
  }

  @Override
  public void inject(VendingActivity vendingActivity) {  
    vendingActivityMembersInjector.injectMembers(vendingActivity);
  }

  public static final class Builder {
    private PresenterModule presenterModule;
  
    private Builder() {  
    }
  
    public UIComponent build() {  
      if (presenterModule == null) {
        throw new IllegalStateException("presenterModule must be set");
      }
      return new DaggerUIComponent(this);
    }
  
    public Builder presenterModule(PresenterModule presenterModule) {  
      if (presenterModule == null) {
        throw new NullPointerException("presenterModule");
      }
      this.presenterModule = presenterModule;
      return this;
    }
  }
}

