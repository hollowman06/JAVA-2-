import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BgCr extends JFrame {

    // 화면에 출력할 라벨
    private JLabel la = new JLabel("<Enter>키로 배경색이 바뀝니다.");

    // 생성자
    public BgCr() {

        // JFrame 제목 설정
        super("KeyListener 예제");

        // 종료 버튼(X) 누르면 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트 팬 가져오기
        Container c = getContentPane();

        // 배치 방식 설정
        c.setLayout(new FlowLayout());

        // 라벨 추가
        c.add(la);

        // 키 이벤트 리스너 등록
        c.addKeyListener(new MyKeyListener());

        // 창 크기 설정
        setSize(300, 150);

        // 창 보이기
        setVisible(true);

        // 컨텐트 팬이 키 입력을 받을 수 있게 설정
        c.setFocusable(true);

        // 실행되자마자 포커스 설정
        c.requestFocus();
    }

    // 키 입력 처리 클래스
    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            // 랜덤 RGB 값 생성
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);

            // 입력된 키 문자 가져오기
            switch (e.getKeyChar()) {

                // Enter 키 입력 시
                case '\n':

                    // 라벨에 RGB 값 출력
                    la.setText("r=" + r + ", g=" + g + ", b=" + b);

                    // 배경색 변경
                    getContentPane().setBackground(new Color(r, g, b));

                    break;

                // q 입력 시 프로그램 종료
                case 'q':
                    System.exit(0);
                    break;
            }
        }
    }

    // main 메서드
    public static void main(String[] args) {
        new Ex96KeyCharEx();
    }
}