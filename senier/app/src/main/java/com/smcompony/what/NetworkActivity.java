package com.smcompony.what;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NetworkActivity extends AppCompatActivity {



    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        TextView systemmessage = (TextView) findViewById(R.id.contentText);

        systemmessage.setText("네트워크 해킹이란 네트워크를 통한 해킹을 말합니다.\n" +
                "\n" +
                "보통 시스템 해킹과 함께 이루어 지는 경우가 많습니다.\n" +
                "시스템에 악성코드를 넣고 변조된 웹 사이트에 접속하도록 만들거나" +
                "서버의 취약점을 이용해 루트 권한을 얻는 등의 방법이 있습니다." +
                "e-mail을 통해서 사회 공학적 해킹도 이루어 지며." +
                "최근 올림픽 스케쥴 표로 가장한 pdf 파일을 첨부한 e-mail이 퍼지기도 했습니다." +
                "이 외에도 DDoS 공격도 네트워크 공격 중 하나로 볼 수 있습니다.\n\n" +
                "1. 기밀성\n\n" +
                "- 스니핑 ( Sniffing )\n" +
                "- '킁킁 거리다'의 의미로 네트워크 흐름의 중간에서 도청, 감시 등의 공격을 하는 행위.\n" +
                "\n" +
                "- 패스워드 등의 데이터를 통신하는 과정에서 중간에 도청하여 확인 할 수 있는 위협이 될 수 있음.\n\n" +
                "공격 예 \n\n" +
                "크리덴셜 스터핑 ( Credential Stuffing ) : 공격자가 이미 확보한 크리덴셜(로그인 정보 등 개인 신상과 관련해 암호화한 정보)을 다른" +
                "계정들에 마구 대입하는(stuffing) 방식으로 이용자 정보를 침해하는 것.\n\n" +
                "2. 무결성\n\n" +
                "- 스푸핑(Spoofing) \n\n" +
                "- '변조시키다'의 의미로 사용자가 원하는 행위를 속여 비정상적인 행동을 하는 행위.\n" +
                "- 통신 경로 조작 등을 이용해 정상적인 행동을 비정상적인 행동으로 강제 변환 시킬 수 있음.\n" +
                "공격 예\n\n" +
                "DNS 스푸핑 : DNS를 변조하여 정상적인 URL을 조회하였으나 공격자가 만든 페이지로 이동하게 만드는 공격 ( 피싱 사이트 )" +
                "ARP 스푸핑 : ARP를 이용하여 Mac 주소를 속이는 공격.\n\n" +
                "3. 가용성\n\n" +
                "- Dos 공격\n\n" +
                "Denial of Service의 약자로 서비스 거부 공격을 수행하여 서버나 시스템이 동작하지 못하도록 공격하는 행위 \n\n" +
                "공격 예\n\n" +
                "SYN Flood 공격 : SYN 패킷을 이용하여 네트워크 트래픽 용량을 초과 시켜 정상 접근이 어렵도록 하는 공격." +
                "HTTP Flood 공격 : HTTP 프로토콜 중 GET 또는 POST 메소드를 이용하여 웹 페이지 접근 한도를 초과 시키는 공격. \n\n"
        ) ;
    }

}
