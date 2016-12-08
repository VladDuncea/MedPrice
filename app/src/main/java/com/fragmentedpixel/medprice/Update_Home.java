package com.fragmentedpixel.medprice;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vlad on 25-May-16.
 */
public class Update_Home extends StringRequest {

    private static final String Site_URL_Login = "http://pasotee.5gbfree.com/update_home.php";
    private Map<String,String> params;

    public Update_Home(String Name,Response.Listener<String> listener){
        super(Method.POST,Site_URL_Login,listener,null);
        params = new HashMap<>();
        params.put("Name",Name);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
