package arthur.mobileapps.com.vendingmachine.business;

import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.BusinessModule;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.BusinessModule_ProvideVendingManagerFactory;
import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.VendingManager;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerBusinessComponent implements BusinessComponent {
  private Provider<VendingManager> provideVendingManagerProvider;

  private DaggerBusinessComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static BusinessComponent create() {  
    return builder().build();
  }

  private void initialize(final Builder builder) {  
    this.provideVendingManagerProvider = ScopedProvider.create(BusinessModule_ProvideVendingManagerFactory.create(builder.businessModule));
  }

  @Override
  public VendingManager injectVendingManager() {  
    return provideVendingManagerProvider.get();
  }

  public static final class Builder {
    private BusinessModule businessModule;
  
    private Builder() {  
    }
  
    public BusinessComponent build() {  
      if (businessModule == null) {
        this.businessModule = new BusinessModule();
      }
      return new DaggerBusinessComponent(this);
    }
  
    public Builder businessModule(BusinessModule businessModule) {  
      if (businessModule == null) {
        throw new NullPointerException("businessModule");
      }
      this.businessModule = businessModule;
      return this;
    }
  }
}

