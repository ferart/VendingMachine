package arthur.mobileapps.com.vendingmachine.ui.views;

import android.support.v7.app.AppCompatActivity;
import arthur.mobileapps.com.vendingmachine.ui.presenter.VendingPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class VendingActivity_MembersInjector implements MembersInjector<VendingActivity> {
  private final MembersInjector<AppCompatActivity> supertypeInjector;
  private final Provider<VendingPresenter> vendingPresenterProvider;

  public VendingActivity_MembersInjector(MembersInjector<AppCompatActivity> supertypeInjector, Provider<VendingPresenter> vendingPresenterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert vendingPresenterProvider != null;
    this.vendingPresenterProvider = vendingPresenterProvider;
  }

  @Override
  public void injectMembers(VendingActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.vendingPresenter = vendingPresenterProvider.get();
  }

  public static MembersInjector<VendingActivity> create(MembersInjector<AppCompatActivity> supertypeInjector, Provider<VendingPresenter> vendingPresenterProvider) {  
      return new VendingActivity_MembersInjector(supertypeInjector, vendingPresenterProvider);
  }
}

