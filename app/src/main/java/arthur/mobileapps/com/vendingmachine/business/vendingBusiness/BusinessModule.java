package arthur.mobileapps.com.vendingmachine.business.vendingBusiness;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Module of dagger2 to construct the Object Graph
 * for Business dependencies
 */
@Module
public class BusinessModule {

    public BusinessModule() {
    }

    /**
     * Provides a VendingManager instance through a VendingManeger implementation
     * @return
     */
    @Provides
    @Singleton
    VendingManager provideVendingManager(){
        return new VendingManagerImpl();
    }
}
