package com.smcompony.what;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView registerButton = (TextView) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener()  {

            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);

            }
        });

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {     // 로그인 버튼 이벤트 처리
            @Override
            public void onClick(View v) {
                final String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();

               /* Response.Listener<String> responseListener = new Response.Listener<String>() {  // 결과 받기
                    @Override
                    public void onResponse(String response) { */
                try{
                           /* JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) { */
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    dialog = builder.setMessage("로그인에 성공했습니다.")
                            .setPositiveButton("확인", null)
                            .create();
                    dialog.show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("userID", userID);
                    LoginActivity.this.startActivity(intent);
                    finish();
                           /* }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                dialog = builder.setMessage("로그인에 실패 했습니다.")
                                        .setNegativeButton("다시 시도", null)
                                        .create();
                                dialog.show();

                            }*/

                } catch( Exception e)
                {
                    e.printStackTrace();
                }
                //}

            };
               /* LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);*/
            // }

        });

        TextView information = (TextView) findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Popup.class  ));
            }
        });

    }

    @Override

    protected void onStop() {
        super.onStop();
        if(dialog != null)
        {
            dialog.dismiss();
            dialog = null;
        }
    }
}
