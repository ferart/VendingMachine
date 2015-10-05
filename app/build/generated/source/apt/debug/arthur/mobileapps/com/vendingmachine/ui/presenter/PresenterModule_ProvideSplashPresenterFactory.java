package arthur.mobileapps.com.vendingmachine.ui.presenter;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PresenterModule_ProvideSplashPresenterFactory implements Factory<SplashPresenter> {
  private final PresenterModule module;

  public PresenterModule_ProvideSplashPresenterFactory(PresenterModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public SplashPresenter get() {  
    SplashPresenter provided = module.provideSplashPresenter();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<SplashPresenter> create(PresenterModule module) {  
    return new PresenterModule_ProvideSplashPresenterFactory(module);
  }
}

