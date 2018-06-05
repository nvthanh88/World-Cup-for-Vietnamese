package com.nvt.worldcupforvietnamese.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.nvt.worldcupforvietnamese.R;
import com.nvt.worldcupforvietnamese.api.ApiClient;
import com.nvt.worldcupforvietnamese.api.GroupIDs;
import com.nvt.worldcupforvietnamese.app.MyApplication;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final String url = ApiClient.BASE_URL+"/api-client/fixtures/matches.json?key="+ ApiClient.API_KEY+"&secret="+ApiClient.API_SECRET+"&league="+GroupIDs.GROUP_A.getValue();

// prepare the Request
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );
        MyApplication.getInstance().addToRequestQueue(getRequest);

    }
}
