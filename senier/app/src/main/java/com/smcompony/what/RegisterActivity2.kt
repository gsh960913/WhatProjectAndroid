package com.smcompony.what

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText

import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley

import org.json.JSONObject

class RegisterActivity2 : AppCompatActivity() {

    private val adapter: ArrayAdapter<*>? = null
    private val userID: String? = null
    private val userPassword: String? = null
    private val userEmail: String? = null
    private var dialog: AlertDialog? = null
    private var validate = false       // 사용할수 있는 회원 ID 인지 체크


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val idText = findViewById<View>(R.id.idText) as EditText
        val passwordText = findViewById<View>(R.id.passwordText) as EditText
        val emailText = findViewById<View>(R.id.emailText) as EditText

        val validateButton = findViewById<View>(R.id.validateButton) as Button       //회원 중복체크 버튼
        validateButton.setOnClickListener(View.OnClickListener {
            val userID = idText.text.toString()
            if (validate)
            // 회원이 존재한다면
            {
                return@OnClickListener
            }
            if (userID == "")
            // 유저이름이 공백이라면
            {
                val builder = AlertDialog.Builder(this@RegisterActivity2)
                dialog = builder.setMessage("아이디는 빈 칸일수 없습니다.")
                        .setPositiveButton("확인", null)
                        .create()
                dialog!!.show()
                return@OnClickListener
            }
            val responseListener = Response.Listener<String> { response ->
                // 중복 체크 진행

                try {
                    val jsonResponse = JSONObject(response)
                    val success = jsonResponse.getString("responses")
                    if (success == "0") {
                        val builder = AlertDialog.Builder(this@RegisterActivity2)
                        dialog = builder.setMessage("사용 할 수 있는 아이디입니다.")
                                .setPositiveButton("확인", null)
                                .create()
                        dialog!!.show()
                        idText.isEnabled = false       //아이디 수정 불가능
                        validate = true
                        idText.setBackgroundColor(resources.getColor(R.color.colorGray))   // 색상지정;
                        validateButton.setBackgroundColor(resources.getColor(R.color.colorGray))
                    } else {
                        val builder = AlertDialog.Builder(this@RegisterActivity2)
                        dialog = builder.setMessage("사용 할 수 없는 아이디입니다.")
                                .setNegativeButton("확인", null)
                                .create()
                        dialog!!.show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            val validateRequest = ValidateRequest(userID, responseListener)      // 접속가능 ID 확인
            val queue = Volley.newRequestQueue(this@RegisterActivity2)
            queue.add(validateRequest)
        })

        val registerButton = findViewById<View>(R.id.registerButton) as Button            // 회원 등록구현
        registerButton.setOnClickListener(View.OnClickListener {
            val userID = idText.text.toString()
            val userPassword = passwordText.text.toString()
            val userEmail = emailText.text.toString()


            if (!validate) {
                val builder = AlertDialog.Builder(this@RegisterActivity2)
                dialog = builder.setMessage("먼저 중복 체크를 해주세요.")
                        .setNegativeButton("확인", null)
                        .create()
                dialog!!.show()
                return@OnClickListener
            }

            if (userID == "" || userPassword == "" || userEmail == "") {
                val builder = AlertDialog.Builder(this@RegisterActivity2)
                dialog = builder.setMessage("빈 칸 없이 입력해주세요")
                        .setNegativeButton("확인", null)
                        .create()
                dialog!!.show()
                return@OnClickListener
            }

            val responseListener = Response.Listener<String> { response ->
                // 회원등록 성공


                try {
                    val jsonResponse = JSONObject(response)
                    val success = jsonResponse.getString("responses")
                    if (success == "1") {
                        val builder = AlertDialog.Builder(this@RegisterActivity2)
                        dialog = builder.setMessage("회원 등록에 성공했습니다.")
                                .setPositiveButton("확인", null)
                                .create()
                        dialog!!.show()
                        finish()
                    } else {
                        val builder = AlertDialog.Builder(this@RegisterActivity2)
                        dialog = builder.setMessage("회원 등록에 실패했습니다.")
                                .setNegativeButton("확인", null)
                                .create()
                        dialog!!.show()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            val registerRequest = RegisterRequest(userID, userPassword, userEmail, responseListener)      // 접속 가능하게
            val queue = Volley.newRequestQueue(this@RegisterActivity2)
            queue.add(registerRequest)
        })
    }


    override fun onStop() {
        super.onStop()
        if (dialog != null) {
            dialog!!.dismiss()
            dialog = null
        }
    }
}
