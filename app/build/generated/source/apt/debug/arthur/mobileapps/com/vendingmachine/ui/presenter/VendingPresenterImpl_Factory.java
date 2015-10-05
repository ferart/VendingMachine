package arthur.mobileapps.com.vendingmachine.ui.presenter;

import arthur.mobileapps.com.vendingmachine.business.vendingBusiness.VendingManager;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class VendingPresenterImpl_Factory implements Factory<VendingPresenterImpl> {
  private final Provider<VendingManager> vendingManagerProvider;

  public VendingPresenterImpl_Factory(Provider<VendingManager> vendingManagerProvider) {  
    assert vendingManagerProvider != null;
    this.vendingManagerProvider = vendingManagerProvider;
  }

  @Override
  public VendingPresenterImpl get() {  
    return new VendingPresenterImpl(vendingManagerProvider.get());
  }

  public static Factory<VendingPresenterImpl> create(Provider<VendingManager> vendingManagerProvider) {  
    return new VendingPresenterImpl_Factory(vendingManagerProvider);
  }
}

