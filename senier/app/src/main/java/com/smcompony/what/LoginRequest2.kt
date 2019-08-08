package com.smcompony.what

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

import java.util.HashMap

class LoginRequest2(userID: String, userPassword: String, listener: Response.Listener<String>) : StringRequest(Request.Method.POST, URL, listener, null) {
    private val parameters: MutableMap<String, String>             // 파라미터 생성

    init {
        parameters = HashMap()
        parameters["userID"] = userID
        parameters["userPassword"] = userPassword
    }//해당 URL에 파라미터를 POST(숨김)방식으로 넘김

    public override fun getParams(): Map<String, String> {
        return parameters
    }

    companion object {

        private val URL = "http://192.168.0.27:8080/BootstrapEx/loginAndroid.jsp"
    }
}
