package arthur.mobileapps.com.vendingmachine.business.vendingBusiness;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class BusinessModule_ProvideVendingManagerFactory implements Factory<VendingManager> {
  private final BusinessModule module;

  public BusinessModule_ProvideVendingManagerFactory(BusinessModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public VendingManager get() {  
    VendingManager provided = module.provideVendingManager();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<VendingManager> create(BusinessModule module) {  
    return new BusinessModule_ProvideVendingManagerFactory(module);
  }
}

