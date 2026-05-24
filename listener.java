import java.awt.*;          // GUI 관련 클래스
import java.awt.event.*;    // 이벤트 처리 클래스
import javax.swing.*;       // Swing GUI 클래스

// JFrame(창) 상속
public class listener extends JFrame {
    // 생성자
    public listener() {
        // 창 제목 설정
        setTitle("Action 이벤트 리스너 예제");
        // 창 종료 시 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 컨테이너 가져오기
        Container c = getContentPane();
        // 배치 관리자 설정
        // 컴포넌트를 왼쪽 -> 오른쪽 순서로 배치
        c.setLayout(new FlowLayout());
        // 버튼 생성
        JButton btn = new JButton("Action");
        // 버튼에 Action 이벤트 리스너 등록
        // 버튼 클릭 시 Ex91MyActionListener 클래스 실행
        btn.addActionListener(new Ex91MyActionListener());
        // 컨테이너에 버튼 추가
        c.add(btn);
        // 창 크기 설정
        setSize(250, 120);
        // 창 출력
        setVisible(true);
    }
    // 프로그램 시작 지점
    public static void main(String[] args) {
        // 객체 생성
        new IndepClassListener();
    }
}
// 독립 클래스로 이벤트 리스너 작성
// ActionListener 인터페이스 구현
class Ex91MyActionListener implements ActionListener {
    // 버튼 클릭 시 자동 호출
    public void actionPerformed(ActionEvent e) {
        // 이벤트가 발생한 버튼 객체 가져오기
        JButton b = (JButton)e.getSource();
        // 버튼의 현재 문자열이 "Action"이면
        if(b.getText().equals("Action"))
            // 버튼 문자열을 "액션"으로 변경
            b.setText("액션");
        else
            // 버튼 문자열을 다시 "Action"으로 변경
            b.setText("Action");
    }
}