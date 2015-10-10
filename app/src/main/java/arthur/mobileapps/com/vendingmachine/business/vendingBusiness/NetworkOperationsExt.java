package arthur.mobileapps.com.vendingmachine.business.vendingBusiness;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;

/**
 * Created by Fernando on 10/10/2015.
 */
public class NetworkOperationsExt extends NetworkOperations {

    public NetworkOperationsExt(Context context) {
        super(context);


    }

    @Override
    public JSONObject getFeed() {
        HashMap<String, String> params = new HashMap<String, String>();
        //params.put("output","")
        //params.put("v", "v=1.0");


       String  url="http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";//"http://api.feedzilla.com/v1/categories/26/articles.json";
 //JSonParams
        JsonObjectRequest req = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());
                    }
                });


        this.getmRequestQueue().add(req);
        return null;
    }
}
