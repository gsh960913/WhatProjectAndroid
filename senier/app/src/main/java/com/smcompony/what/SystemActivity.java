package com.smcompony.what;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class SystemActivity extends AppCompatActivity {


    private TextView systemmessage;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);

        TextView systemmessage = (TextView) findViewById(R.id.contentText);

        systemmessage.setText("시스템 해킹이란 대상 시스템에 직접 침입하여 행해지는 해킹으로 네트워크 해킹과 함께 이어" +
                        "지는것이 일반적입니다. 시스템 해킹은 컴퓨터 시스템의 관리자 권한을 획득하여 시스템을 제어하고" +
                        "핵심 정보를 빼오는 시스템 탈취와 정보를 삭제하고 하드웨어를 파괴하는 행위인 시스템 파괴를 포함하는" +
                        "해킹 유형입니다.\n\n" +
                        "시스템 해킹에서 자주 사용하는 해킹 기법은 다음과 같은 것들이 있습니다.\n\n" +
                        "- Buffer Overflow (버퍼 오버플로우)\n"+
                        "- Race Condition (레이스 컨디션)\n" +
                        "- Command Injection (커맨드 인젝션)\n" +
                        "- Format String (포맷 스트링)\n" +
                        "- Back Door (백도어)\n" +
                        "\n" +
                        "1. 터미널 분비\n" +
                        "\n" +
                        "해킹 대상 시스템에 원격으로 접속할 수 있는 터미널을 준비합니다.\n" +
                        "\n" +
                        "해킹 대상이 Window인 경우 Cygwin을 많이 사용하며 Unix, Linux 계열의 경우 PuTTY, Xshell을 많이 사용합니다.\n" +
                        "\n" +
                        "2. 안전성 확보\n" +
                        "\n" +
                        "공격자 본인의 컴퓨터를 안전하게 만듭니다. 자신의 컴퓨터나 네트워크 도 공격당할 수 있고 전원지를 추적당할 수 있으므로 이에 대한 대비책을 마련합니다. 대표적인 예로 Proxy 우회를 통한 ip 주소 변조 등이 있습니다.\n" +
                        "\n" +
                        "3. 해킹 대상 테스트\n" +
                        "\n" +
                        "해킹 대상 시스템을 면밀하게 테스트 합니다. \n" +
                        "\n" +
                        "예를들어 ping으로 대상 시스템이 어떻게 응답하는지 알아보는 것도 하나의 방법입니다.\n" +
                        "\n" +
                        "4. 해킹 대상 OS 확인\n" +
                        "\n" +
                        "해킹 대상 시스템의 OS가 어떤 것인지 확인합니다.\n" +
                        "\n" +
                        "ping 명령어를 통해 TTL 값을 받아올 수 있다면 확인 가능하지만 그렇지 않을 경우\n" +
                        "\n" +
                        "Nmap 등의 툴을 이용하여 시스템의 포트를 스캔합니다.\n" +
                        "\n" +
                        "Nmap은 시스템이 오픈하고 있는 포트를 보여주며 사용자가 사용하고 있는 방화벽과 라우터 종류에 대해서도 알려주며 시스템의 OS또한 알려줍니다. 이러한 정보를 바탕으로 대상 시스템을 어떻게 해킹할 것인지 계획을 세운다.\n" +
                        "\n" +
                        "5. 침입 경로 탐색\n" +
                        "\n" +
                        "시스템에 침입하기 위한 경로를 탐색합니다. \n" +
                        "\n" +
                        "21번포트(FTP) 나 80번 포트(HTTP)는 대체로 보안이 잘 되어 있는 편입니다.\n" +
                        "\n" +
                        "따라서 telnet(23번 혹은 사용자 설정) 이나 다른 TCP, UDP 포트로 접근을 시도합니다.\n" +
                        "\n" +
                        "SSH 서비스가 동작중이면 22번 포트가 열려 있으므로 이를 통해 접근을 시도합니다.\n" +
                        "\n" +
                        "6. 루트 권한 획득\n" +
                        "\n" +
                        "시스템을 완전히 장악하기 위해서는 관리자 권한 혹은 루트(root)권한이 필요합니다.\n" +
                        "\n" +
                        "Windows의 경우 administrator이며 Linux 또는 BSD 계열인 경우 root입니다.\n" +
                        "\n" +
                        "네트워크 장치인 라우터는 보통 admin으로 되어 있습니다.\n" +
                        "\n" +
                        "공격자들이 루트 권한을 획득하기 위해 자주 사용하는 기법은 Buffer Overflow입니다. 그들이 심어 놓은 특정 코드를 실행하게 함으로써 root 권한을 획득할 수 있습니다.\n" +
                        "\n" +
                        "루트 권한을 획득하기 위해 대상 시스템의 보안 취약점이 있는 \n" +
                        "\n" +
                        "프로그램 혹은 바이너리를 찾아 공략하는 것이 일방적인 방법입니다. \n" +
                        "\n" +
                        "이후 백도어를 만든 뒤 로그를 지워 흔적을 지워버립니다.\n" +
                        "\n" +
                        "[ 웹 서버 공격 ]\n" +
                        "\n" +
                        "일반인이 가장 자주 접하는 시스템이 있다면 바로 웹 서버일 것입니다.\n" +
                        "\n" +
                        "우리가 인터넷을 한다는 것은 웹 브라우저로 원격에 있는 웹 서버에 원하는 서비스를 요청하고웹 서버가 적절한 처리 후 웹 브라우저로 응답하여 그 결과를 보는 반복적인 행위입니다. \n" +
                        "\n" +
                        "또한 웹 서버에 연결된 데이터베이스 서버에는 개인정보들이 저장되어 있기도 합니다. \n" +
                        "\n" +
                        "웹서버 해킹 유형에는 다음과 같은 것들이 있습니다.\n" +
                        "\n" +
                        "디렉터리 이동 공격 \n" +
                        "\n" +
                        "공개 도메인에 나타나지 않은 비인가 파일이나 폴더에 접근하여 \n" +
                        "\n" +
                        "중요 정보를 탈취하는 방법. 따따 슬래쉬( . . / ) 공격이라고도 합니다\n" +
                        "\n" +
                        "서비스 거부 공격( DOS )\n" +
                        "\n" +
                        "웹 서버를 폭주시켜 다른 사람들이 웹 서버가 제공하는 서비스를 이용하지 못하게 하는 방법\n" +
                        "\n" +
                        "스니핑( Snipping )\n" +
                        "\n" +
                        "네트워크 상에서 암호화 되지 않은 정보를 가로챈 후\n" +
                        "\n" +
                        "이 정보를 활용하여 접근 권한이 없는 웹 서버에 접근하는 방법입니다.\n" +
                        "\n" +
                        "피싱( Pishing )\n" +
                        "\n" +
                        "불특정 다수에게 이메일을 발송하여 위장된 웹 사이트로 접속하도록 한 후 각종 개인정보를 탈취합니다.\n" +
                        "\n" +
                        "파밍 ( Pharming )\n" +
                        "\n" +
                        "DNS를 탈취하거나 DNS, 프록시 서버 주소를 변조하여 특정 사이트로 접속하는 사용자들을\n" +
                        "\n" +
                        "진짜 사이트로 오인할 수 있는 가짜 사이트로 유인한 후 각종 개인정보들을 탈취하는 방법입니다.\n" +
                        "\n"

                );
    }

}
