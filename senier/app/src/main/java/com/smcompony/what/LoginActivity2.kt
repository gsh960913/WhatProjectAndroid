package com.smcompony.what

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley

import org.json.JSONObject

class LoginActivity2 : AppCompatActivity() {

    private var dialog: AlertDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerButton = findViewById<View>(R.id.registerButton) as TextView
        registerButton.setOnClickListener {
            val registerIntent = Intent(this@LoginActivity2, RegisterActivity::class.java)
            this@LoginActivity2.startActivity(registerIntent)
        }

        val idText = findViewById<View>(R.id.idText) as EditText
        val passwordText = findViewById<View>(R.id.passwordText) as EditText
        val loginButton = findViewById<View>(R.id.loginButton) as Button

        loginButton.setOnClickListener() // 로그인 버튼 이벤트 처리
        {
            val userID = idText.text.toString()
            val userPassword = passwordText.text.toString()

            val responseListener = Response.Listener<String> { response ->
                // 결과 받기
                try {
                    val jsonResponse = JSONObject(response)
                    val success = jsonResponse.getBoolean("success")
                    if (success) {
                        val builder = AlertDialog.Builder(this@LoginActivity2)
                        dialog = builder.setMessage("로그인에 성공했습니다.")
                                .setPositiveButton("확인", null)
                                .create()
                        dialog!!.show()
                        val intent = Intent(this@LoginActivity2, MainActivity::class.java)
                        intent.putExtra("userID", userID)
                        this@LoginActivity2.startActivity(intent)
                        finish()
                    } else {
                        val builder = AlertDialog.Builder(this@LoginActivity2)
                        dialog = builder.setMessage("로그인에 실패 했습니다.")
                                .setNegativeButton("다시 시도", null)
                                .create()
                        dialog!!.show()

                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            val loginRequest = LoginRequest(userID, userPassword, responseListener)
            val queue = Volley.newRequestQueue(this@LoginActivity2)
            queue.add(loginRequest)
        }

        val information = findViewById<View>(R.id.information) as TextView
        information.setOnClickListener { startActivity(Intent(this@LoginActivity2, Popup::class.java)) }

    }

    override fun onStop() {
        super.onStop()
        if (dialog != null) {
            dialog!!.dismiss()
            dialog = null
        }
    }
}
