package arthur.mobileapps.com.vendingmachine.business.vendingBusiness;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;

/**
 * Created by Fernando on 10/10/2015.
 */
public abstract class NetworkOperations {

   private  RequestQueue mRequestQueue;

    public NetworkOperations(Context context) {
        mRequestQueue=Volley.newRequestQueue(context);
    }

    public abstract JSONObject getFeed();

    public RequestQueue getmRequestQueue() {
        return mRequestQueue;
    }

    public void setmRequestQueue(RequestQueue mRequestQueue) {
        this.mRequestQueue = mRequestQueue;
    }
}
