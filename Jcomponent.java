import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Jcomponent extends JFrame {

    public Jcomponent() {

        // JFrame 제목 설정
        super("JComponent의 공통 메소드 예제");

        // 컨텐트 팬 가져오기
        Container c = getContentPane();

        // 배치 관리자 설정
        c.setLayout(new FlowLayout());

        // 버튼 생성
        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton("Disabled Button");
        JButton b3 = new JButton("getX(), getY()");

        // 버튼 배경색 설정
        b1.setBackground(Color.YELLOW);

        // 버튼 글자색 설정
        b1.setForeground(Color.MAGENTA);

        // 버튼 폰트 설정
        b1.setFont(new Font("Arial", Font.ITALIC, 20));

        // 버튼 비활성화
        b2.setEnabled(false);

        // 버튼 이벤트 등록
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 이벤트가 발생한 버튼 객체 가져오기
                JButton b = (JButton)e.getSource();

                // 버튼의 x, y 위치를 제목에 출력
                setTitle(b.getX() + ", " + b.getY());
            }
        });

        // 버튼들을 컨텐트 팬에 추가
        c.add(b1);
        c.add(b2);
        c.add(b3);

        // 프레임 크기 설정
        setSize(260, 200);

        // 창 보이기
        setVisible(true);

        // 종료 버튼(X) 클릭 시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JComponentEx101();
    }
}