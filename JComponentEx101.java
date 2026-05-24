import java.awt.*;          // GUI 배치, 색상 등을 위한 클래스
import java.awt.event.*;    // 이벤트 처리용 클래스
import javax.swing.*;       // Swing GUI 클래스

// JFrame(창)을 상속받아 GUI 프로그램 생성
public class JComponentEx101 extends JFrame {

    // 생성자
    public JComponentEx101() {

        // 창 제목 설정
        super("JComponent의 공통 메소드 예제");

        // 창 종료 시 프로그램도 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨테이너(컴포넌트를 올릴 영역) 가져오기
        Container c = getContentPane();

        // FlowLayout 배치 사용
        // 컴포넌트를 왼쪽 -> 오른쪽 순서로 배치
        c.setLayout(new FlowLayout());

        // 버튼 생성
        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton("Disabled Button");
        JButton b3 = new JButton("getX(), getY()");

        // b1 버튼 배경색 설정
        b1.setBackground(Color.YELLOW);

        // b1 버튼 글자색 설정
        b1.setForeground(Color.MAGENTA);

        // 폰트 설정
        // Arial, 기울임체, 크기 20
        b1.setFont(new Font("Arial", Font.ITALIC, 20));

        // b2 버튼 비활성화
        // 클릭 불가능 상태
        b2.setEnabled(false);

        // b3 버튼 클릭 이벤트 등록
        b3.addActionListener(new ActionListener() {

            // 버튼 클릭 시 자동 실행되는 메소드
            public void actionPerformed(ActionEvent e) {

                // 이벤트가 발생한 객체 가져오기
                JButton b = (JButton)e.getSource();

                // 버튼의 x, y 좌표를 제목에 출력
                setTitle(b.getX() + ", " + b.getY());
            }
        });

        // 컨테이너에 버튼 추가
        c.add(b1);
        c.add(b2);
        c.add(b3);

        // 창 크기 설정
        setSize(260, 200);

        // 창 화면에 출력
        setVisible(true);
    }

    // 프로그램 시작 지점
    public static void main(String[] args) {

        // 객체 생성 -> 생성자 실행 -> GUI 출력
        new JComponentEx101();
    }
}