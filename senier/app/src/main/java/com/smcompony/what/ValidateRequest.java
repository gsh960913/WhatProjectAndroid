package com.smcompony.what;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest {

    final static private String URL = "http://192.168.0.27:8080/BootstrapEx/validateAndroid.jsp";
    private Map<String, String> parameters;             // 파라미터 생성

    public ValidateRequest(String userID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);                    //해당 URL에 파라미터를 POST(숨김)방식으로 넘김
        parameters = new HashMap<>();
        parameters.put("userID", userID);
}

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
