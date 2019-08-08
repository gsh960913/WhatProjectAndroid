package com.smcompony.what;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {



    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        TextView systemmessage = (TextView) findViewById(R.id.contentText);

        systemmessage.setText("웹 해킹이란 크게 SQL Injection, XSS(Cross Site Script), 웹셀업로드 등으로 볼 수 있습니다. \n" +
                "SQL Injection이란 웹서버의 DB에 대해 공격자가 SQL쿼리문을 직접 전송하여 DB의 조작 및 변조하기 위한 공격이고 \n" +
                "XSS(Cross Site Script)는 타 사용자의 브라우저에 악성 코드의 실행을 목적으로 하는 공격이며, \n" +
                "웹쉘 업로드는 웹서버에서 실행 가능한 확장자로 웹쉘파일의 확장자를 변조 업로드하여 악의적인 명령을 수행하는 공격입니다.\n\n" +

                "SQL Injection이란 웹 애플리케이션에서 입력받아 데이터베이스로 전달하는 SQL 쿼리를 바꾸거나, 다른 SQL 문장을 추가하여 불법" +
                "로그인, DB 데이터 추출, 시스템 명령 실행 등을 수행하는 공격 기법이다. Blind SQL 인젝션, 에러 기반 SQL 인젝션, Union SQL 인젝션 등 종류도 다양하다.\n\n" +
                "- SQL Injection 특징\n" +
                "  - DB에 악성코드를 대량으로 삽입\n" +
                "  - 자동 삽입 스크립트를 사용하여 한번에 악성코드를 대량 삽입\n" +
                "  - POST나 HTTP Header를 이용한 경우는 공격 로그를 찾기 어려움\n" +
                "  - 악성코드 삽입 과정에서 데이터의 손실 또는 유실 발생 \n\n" +

                "XSS(Cross Site Script)란 웹 어플리케이션에서 사용자 입력 값에 대한 필터링이 제대로 이루어지지 않을 경우" +
                ", 공격자가 입력이 가능한 폼에 악의적인 스크립트를 삽입하여 해당 스크립트가 희생자 측에서 동작하도록 하여" +
                " 악의적인 행위를 수행하는 취약점이다. 공격자는 취약점을 이용하여 사용자의 개인정보 및 쿠키정보 탈취, 악성코드 감염, 웹 페이지 변조 등의 공격을 수행한다. \n\n" +
                "- XSS 공격 종류 \n\n" +

                "1. Stored XSS (저장형 XSS)\n" +
                "\n" +
                " 공격자가 취약한 웹서버에 악성 스크립트를 저장하면 희생자가 해당 자료를 요청할 떄 해당 악성 스크립트가 삽입된 응답 페이지가 전달되어 클라이언트 측에서 동작하는 방식이다.\n\n" +
                "2. Reflected XSS (반사형 XSS)\n" +
                "\n" +
                "    * 외부에 있는 악성 스크립트가 희생자 액션에 의해 취약한 웹서버로 전달되고, 웹서버의 응답 페이지에 해당 악성 스크립트가 삽입되어 희생자 측에서 동작하는 방식이다. \n" +
                "\n" +
                "3. DOM based XSS (DOM 기반 XSS)\n" +
                "\n" +
                "희생자의 웹 브라우저에서 응답 페이지에 포함된 정상적인 스크립트가 동작하면서 DOM 객체를 실행할 때" +
                "URL 등에 포함된 악성 스크립트가 동작하는 방식이다. 응답 페이지에 관계없이 웹 브라우저에서 발생한다.\n\n" +
                "" +
                "- 웹쉘(Webshell)이란 \n" +
                "\n" +
                "웹쉘은 공격자가 악의적인 목적을 가지고 만든 프로그램으로, 주로 주로 SSS(Server Side Script)언어(ASP, PHP, JSP등)를" +
                " 사용하여 제작합니다. 웹쉘이 완성되면, 취약점이 존재하는 서버에 업로드시킵니다. 일단, 공격자가 만든 웹쉘이 성공적으로" +
                " 서버에 업로드가 된다면, 공격자는 자신이 서버에서 실행시키고자 하는 명령어를 전송하여, 서버에서 실행이 되게 합니다." +
                " 즉, 공격자는 해당 서버의 모든 제어권을 장악하고, 정보탈취, 변조, 악성스크립트 삽입등 각종 악성행위를 합니다." +
                " 웹쉘공격은 HTTP서비스를 통하여 통신을 하기 때문에 탐지가 매우 어려우며, 제작이 비교적 쉽고 서버제어 및 관리가 용이하기 때문에 흔히 사용되는 공격방법 입니다.\n" +
                "\n\n" +
                "") ;
}

}
