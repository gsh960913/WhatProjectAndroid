package com.smcompony.what;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://192.168.0.27:8080/BootstrapEx/registerAndroid.jsp";

    private Map<String, String> parameters;             // 파라미터 생성

    public RegisterRequest(String userID, String userPassword , String userEmail, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);                    //해당 URL에 파라미터를 POST(숨김)방식으로 넘김
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userEmail", userEmail);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
