package arthur.mobileapps.com.vendingmachine.ui.presenter;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class PresenterModule_ProvideVendingPresenterFactory implements Factory<VendingPresenter> {
  private final PresenterModule module;

  public PresenterModule_ProvideVendingPresenterFactory(PresenterModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public VendingPresenter get() {  
    VendingPresenter provided = module.provideVendingPresenter();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<VendingPresenter> create(PresenterModule module) {  
    return new PresenterModule_ProvideVendingPresenterFactory(module);
  }
}

