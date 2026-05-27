# JAVA2
## 202530120 이동건
---
# 2026/05/27

# 키 이벤트와 포커스

## 키 입력 시 이벤트 발생
* 키를 누르는 순간
* 키를 떼는 순간
* 누른 키를 떼는 순간(유니코드 키만 해당)

## 키 이벤트를 받는 조건
* 모든 컴포넌트가 키 이벤트를 받을 수 있는 것은 아님
* 현재 포커스를 가진 컴포넌트가 키 이벤트를 독점

## 포커스(Focus)
* 컴포넌트나 응용 프로그램이 키 이벤트를 독점하는 권한

### 컴포넌트에 포커스 설정
```java
component.requestFocus();
```

---

# 키 리스너(Key Listener)

## 키 리스너 구현
* 응용 프로그램에서 KeyListener를 상속받아 리스너 구현

## KeyListener의 3개 메소드
* `keyPressed()`
* `keyReleased()`
* `keyTyped()`

---

# 유니코드 키와 KeyEvent 객체

## 유니코드의 특징
* 국제 산업 표준
* 전 세계 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계
* 문자들에 대해서만 키 코드 값 정의

## KeyEvent 객체
* 입력된 키 정보를 가진 이벤트 객체
* KeyEvent 객체의 메소드로 입력된 키 판별 가능

## KeyEvent 메소드

### `char KeyEvent.getKeyChar()`
* 키의 유니코드 문자 값 리턴
* 유니코드 문자 키인 경우에만 의미 있음
* 입력된 키를 판별하기 위해 문자 값만 비교

```java
char ch = e.getKeyChar();
```

### `int KeyEvent.getKeyCode()`
* 유니코드 키 포함
* 모든 키에 대한 정수형 키 코드 리턴
* 입력된 키를 판별하기 위해 가상 키 값과 비교해야 함
* 가상 키 값은 `KeyEvent` 클래스에 상수로 선언

```java
int code = e.getKeyCode();
```

---

# 어댑터 클래스(Adapter Class)

## 이벤트 리스너 구현의 부담
* 리스너의 추상 메소드를 모두 구현해야 하는 부담 존재
* 예:
    * 마우스가 눌리는 경우(`mousePressed()`)만 처리하고 싶어도
    * 나머지 메소드도 모두 구현해야 함

## 어댑터 클래스(Adapter)
* 리스너의 모든 메소드를 단순 리턴하도록 만든 클래스
* JDK에서 제공

```java
JLabel la;

contentPane.addMouseListener(new MyMouseAdapter());

class MyMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
        // 필요한 기능만 구현
    }
}
```

## 어댑터 클래스가 없는 경우
* 추상 메소드가 하나뿐인 리스너는 어댑터 클래스 없음
* 예:
    * `ActionAdapter` 없음
    * `ItemAdapter` 없음

---

# 마우스 이벤트와 마우스 리스너

## MouseEvent
* 사용자의 마우스 조작에 따라 발생하는 이벤트

### 발생 상황
* 컴포넌트 위로 올라올 때
* 컴포넌트에서 내려갈 때
* 마우스 버튼 눌릴 때
* 눌린 버튼이 떼어질 때
* 마우스로 클릭할 때
* 마우스 드래그
* 마우스 움직임

---

# 주요 마우스 이벤트 메소드

## `mouseClicked()`
* 마우스가 눌러진 위치에서 그대로 떼어질 때 호출

## `mouseReleased()`
* 눌러진 위치에서 그대로 떼어지든 아니든 항상 호출

## `mouseDragged()`
* 마우스가 드래그되는 동안 계속 여러 번 호출

---

# 마우스 이벤트 호출 순서

## 마우스를 클릭한 경우
```java
mousePressed()
mouseReleased()
mouseClicked()
```

## 마우스를 드래그한 경우
```java
mousePressed()
mouseDragged()
mouseDragged()
...
mouseReleased()
```

---

# 마우스 리스너 등록

## 마우스 리스너 달기
* 마우스 리스너는 컴포넌트에 등록

```java
component.addMouseListener(myMouseListener);
```

## 마우스 이동 및 드래그 처리
* MouseMotionListener를 따로 등록해야 함

```java
component.addMouseMotionListener(myMouseListener);
```

---

# 스윙 컴포넌트 활용

# GUI 프로그래밍 방법

## 컴포넌트 기반 GUI
* 스윙 컴포넌트 사용
* 컴포넌트 범위를 벗어나기 어려움

## 그래픽 기반 GUI 프로그래밍
* 개발자가 직접 그래픽으로 화면 구성
* 독특한 GUI 제작 가능
* GUI 처리 속도가 빨라 게임에서 자주 사용

---

# JComponent

## JComponent 클래스
* 스윙 컴포넌트의 멤버를 모두 상속받는 슈퍼 클래스
* 추상 클래스

## 역할
* 스윙 컴포넌트들이 공통으로 사용하는 메소드와 상수 구현

```java
JComponent
```
---
# 2026/05/20

# 이벤트 기반 프로그래밍

## 이벤트 기반 프로그램

* 이벤트 발생에 의해 프로그램의 흐름이 결정되는 방식
    * 이벤트가 발생하면 이를 처리하는 루틴(이벤트 리스너) 실행
    * 실행될 코드는 이벤트 발생에 의해 결정됨

* 반대 개념: 배치 실행(Batch Programming)
    * 프로그램 개발자가 흐름을 직접 결정하는 방식

## 이벤트 종류

* 사용자 입력
    * 마우스 클릭
    * 마우스 드래그
    * 키보드 입력

* 시스템 및 외부 입력
    * 센서 입력
    * 네트워크 데이터 송수신
    * 다른 응용 프로그램이나 다른 스레드로부터의 메시지

## 이벤트 기반 응용 프로그램 구조

* 각 이벤트마다 처리하는 리스너 코드 보유
* GUI 응용 프로그램은 대부분 이벤트 기반으로 작성됨

### 대표적인 GUI 프레임워크

* C++ MFC
* C# GUI
* Visual Basic
* X Window
* Android
* Java AWT / Swing

---

# 스윙(Swing)에서 이벤트 처리 과정

1. 이벤트 발생
2. 이벤트 객체 생성
3. 이벤트 리스너 탐색
4. 이벤트 리스너에 이벤트 객체 전달
5. 이벤트 리스너 실행

---

# 이벤트 객체(Event Object)

## 이벤트 객체란?

* 발생한 이벤트에 대한 정보를 가진 객체
* 이벤트 리스너에 전달됨
* 리스너가 이벤트 상황을 파악할 수 있도록 도움

## 이벤트 객체가 포함하는 정보

* 이벤트 종류와 소스
* 이벤트 발생 위치 좌표
    * 화면 좌표
    * 컴포넌트 내부 좌표
* 버튼이나 메뉴 아이템의 문자열
* 클릭된 마우스 버튼 번호
* 마우스 클릭 횟수
* 키 코드 값과 문자 값
* 체크박스 / 라디오 버튼 등의 상태

## 이벤트 소스를 알아내는 메소드

```java
Object getSource()
```

* 이벤트 발생 컴포넌트를 반환
* Object 타입으로 반환되므로 형변환 후 사용

예시:

```java
JButton b = (JButton)e.getSource();
```

---

# 리스너 인터페이스(Listener Interface)

## 이벤트 리스너란?

* 이벤트를 처리하는 자바 프로그램 코드
* 보통 클래스로 작성

## 자바의 다양한 리스너 인터페이스

### ActionListener

* 버튼 클릭 이벤트 등을 처리

```java
interface ActionListener {

    // Action 이벤트 발생 시 호출
    public void actionPerformed(ActionEvent e);
}
```

### MouseListener

* 마우스 이벤트 처리

```java
interface MouseListener {

    // 마우스 버튼이 눌리는 순간 호출
    public void mousePressed(MouseEvent e);

    // 눌린 버튼이 떼어지는 순간 호출
    public void mouseReleased(MouseEvent e);

    // 마우스를 클릭하는 순간 호출
    public void mouseClicked(MouseEvent e);

    // 마우스가 컴포넌트 위에 올라가는 순간 호출
    public void mouseEntered(MouseEvent e);

    // 마우스가 컴포넌트 밖으로 나가는 순간 호출
    public void mouseExited(MouseEvent e);
}
```

---

# 이벤트 리스너 작성

## 사용자의 이벤트 리스너 작성 방법

* 자바의 리스너 인터페이스 구현(implements)
* 인터페이스의 모든 추상 메소드 구현 필요

---

# 이벤트 리스너 작성 과정

## 1. 이벤트와 리스너 선택

예시: 버튼 클릭 처리

* 이벤트: `ActionEvent`
* 이벤트 리스너: `ActionListener`

---

## 2. 이벤트 리스너 클래스 작성

```java
import java.awt.event.*;
import javax.swing.*;

class MyActionListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        JButton b = (JButton)e.getSource();

        if(b.getText().equals("Action"))
            b.setText("액션");
        else
            b.setText("Action");
    }
}
```

---

## 3. 이벤트 리스너 등록

* 이벤트를 처리할 컴포넌트에 리스너 등록

```java
component.addXXXListener(listener);
```

* `XXX` : 이벤트 이름
* `listener` : 이벤트 리스너 객체

예시:

```java
MyActionListener listener = new MyActionListener();

btn.addActionListener(listener);
```

---

# 이벤트 리스너 작성 방법 3가지

## 1. 독립 클래스 작성

* 리스너를 완전한 클래스로 작성
* 여러 곳에서 재사용 가능
* 재사용성이 높음

---

## 2. 내부 클래스 작성

* 클래스 내부에 멤버처럼 작성
* 특정 클래스 안에서만 사용하는 경우 적합

예시 구조:

```java
class MyFrame extends JFrame {

    class MyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }
}
```

---

## 3. 익명 클래스 작성

* 이름 없는 클래스로 작성
* 클래스 선언과 객체 생성을 동시에 수행
* 코드가 짧고 간단할 때 사용

예시:

```java
btn.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼 클릭");
    }
});
```

---

# 익명 클래스(Anonymous Class)

## 특징

* 클래스 이름이 없음
* 선언과 동시에 객체 생성
* 간단한 이벤트 처리에 적합
* 코드 길이를 줄일 수 있음

```java
new ActionListener() {

    public void actionPerformed(ActionEvent e) {

    }
}
```# 2026/05/20

# 이벤트 기반 프로그래밍

## 이벤트 기반 프로그램

* 이벤트 발생에 의해 프로그램의 흐름이 결정되는 방식
  * 이벤트가 발생하면 이를 처리하는 루틴(이벤트 리스너) 실행
  * 실행될 코드는 이벤트 발생에 의해 결정됨

* 반대 개념: 배치 실행(Batch Programming)
  * 프로그램 개발자가 흐름을 직접 결정하는 방식

## 이벤트 종류

* 사용자 입력
  * 마우스 클릭
  * 마우스 드래그
  * 키보드 입력

* 시스템 및 외부 입력
  * 센서 입력
  * 네트워크 데이터 송수신
  * 다른 응용 프로그램이나 다른 스레드로부터의 메시지

## 이벤트 기반 응용 프로그램 구조

* 각 이벤트마다 처리하는 리스너 코드 보유
* GUI 응용 프로그램은 대부분 이벤트 기반으로 작성됨

### 대표적인 GUI 프레임워크

* C++ MFC
* C# GUI
* Visual Basic
* X Window
* Android
* Java AWT / Swing

---

# 스윙(Swing)에서 이벤트 처리 과정

1. 이벤트 발생
2. 이벤트 객체 생성
3. 이벤트 리스너 탐색
4. 이벤트 리스너에 이벤트 객체 전달
5. 이벤트 리스너 실행

---

# 이벤트 객체(Event Object)

## 이벤트 객체란?

* 발생한 이벤트에 대한 정보를 가진 객체
* 이벤트 리스너에 전달됨
* 리스너가 이벤트 상황을 파악할 수 있도록 도움

## 이벤트 객체가 포함하는 정보

* 이벤트 종류와 소스
* 이벤트 발생 위치 좌표
  * 화면 좌표
  * 컴포넌트 내부 좌표
* 버튼이나 메뉴 아이템의 문자열
* 클릭된 마우스 버튼 번호
* 마우스 클릭 횟수
* 키 코드 값과 문자 값
* 체크박스 / 라디오 버튼 등의 상태

## 이벤트 소스를 알아내는 메소드

```java
Object getSource()
```

* 이벤트 발생 컴포넌트를 반환
* Object 타입으로 반환되므로 형변환 후 사용

예시:

```java
JButton b = (JButton)e.getSource();
```

---

# 리스너 인터페이스(Listener Interface)

## 이벤트 리스너란?

* 이벤트를 처리하는 자바 프로그램 코드
* 보통 클래스로 작성

## 자바의 다양한 리스너 인터페이스

### ActionListener

* 버튼 클릭 이벤트 등을 처리

```java
interface ActionListener {

    // Action 이벤트 발생 시 호출
    public void actionPerformed(ActionEvent e);
}
```

### MouseListener

* 마우스 이벤트 처리

```java
interface MouseListener {

    // 마우스 버튼이 눌리는 순간 호출
    public void mousePressed(MouseEvent e);

    // 눌린 버튼이 떼어지는 순간 호출
    public void mouseReleased(MouseEvent e);

    // 마우스를 클릭하는 순간 호출
    public void mouseClicked(MouseEvent e);

    // 마우스가 컴포넌트 위에 올라가는 순간 호출
    public void mouseEntered(MouseEvent e);

    // 마우스가 컴포넌트 밖으로 나가는 순간 호출
    public void mouseExited(MouseEvent e);
}
```

---

# 이벤트 리스너 작성

## 사용자의 이벤트 리스너 작성 방법

* 자바의 리스너 인터페이스 구현(implements)
* 인터페이스의 모든 추상 메소드 구현 필요

---

# 이벤트 리스너 작성 과정

## 1. 이벤트와 리스너 선택

예시: 버튼 클릭 처리

* 이벤트: `ActionEvent`
* 이벤트 리스너: `ActionListener`

---

## 2. 이벤트 리스너 클래스 작성

```java
import java.awt.event.*;
import javax.swing.*;

class MyActionListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        JButton b = (JButton)e.getSource();

        if(b.getText().equals("Action"))
            b.setText("액션");
        else
            b.setText("Action");
    }
}
```

---

## 3. 이벤트 리스너 등록

* 이벤트를 처리할 컴포넌트에 리스너 등록

```java
component.addXXXListener(listener);
```

* `XXX` : 이벤트 이름
* `listener` : 이벤트 리스너 객체

예시:

```java
MyActionListener listener = new MyActionListener();

btn.addActionListener(listener);
```

---

# 이벤트 리스너 작성 방법 3가지

## 1. 독립 클래스 작성

* 리스너를 완전한 클래스로 작성
* 여러 곳에서 재사용 가능
* 재사용성이 높음

---

## 2. 내부 클래스 작성

* 클래스 내부에 멤버처럼 작성
* 특정 클래스 안에서만 사용하는 경우 적합

예시 구조:

```java
class MyFrame extends JFrame {

    class MyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }
}
```

---

## 3. 익명 클래스 작성

* 이름 없는 클래스로 작성
* 클래스 선언과 객체 생성을 동시에 수행
* 코드가 짧고 간단할 때 사용

예시:

```java
btn.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼 클릭");
    }
});
```

---

# 익명 클래스(Anonymous Class)

## 특징

* 클래스 이름이 없음
* 선언과 동시에 객체 생성
* 간단한 이벤트 처리에 적합
* 코드 길이를 줄일 수 있음

```java
new ActionListener() {

    public void actionPerformed(ActionEvent e) {

    }
}
```

---

# 2026/05/13

## 컨테이너

* 다른 컴포넌트를 포함할 수 있는 GUI 컴포넌트
* `java.awt.Container` 클래스를 상속받아 사용
* 다른 컨테이너 내부에 포함 가능

### AWT 컨테이너

* `Panel`
* `Frame`
* `Applet`
* `Dialog`
* `Window`

### Swing 컨테이너

* `JPanel`
* `JFrame`
* `JApplet`
* `JDialog`
* `JWindow`

## 컨테이너 배치관리자

* 컨테이너마다 하나의 배치관리자 존재
* 컴포넌트의 위치와 크기를 자동으로 배치

## Swing 프레임

* 모든 스윙 컴포넌트를 담는 최상위 컨테이너
* `JFrame` 클래스를 상속받아 구현

### 특징

* 컴포넌트는 프레임에 부착되어야 화면에 출력됨
* 프레임 종료 시 내부 컴포넌트도 함께 종료
* 프레임 크기 설정 필요
* 화면 출력 코드 필요

### 필수 메소드

```java
setSize(width, height);
setVisible(true);
```

## 배치관리자

### FlowLayout

* 컴포넌트를 왼쪽에서 오른쪽 순서로 배치
* 공간 부족 시 다음 줄로 이동

```java
FlowLayout()
FlowLayout(int align, int hGap, int vGap)
```

### BorderLayout

* 컨테이너를 동, 서, 남, 북, 중앙 5개 영역으로 분할

```java
BorderLayout()
```

### GridLayout

* 동일한 크기의 격자로 분할
* 행과 열 기준으로 배치

### CardLayout

* 카드를 겹쳐 놓은 형태로 배치
* 하나씩 화면에 출력 가능

## 배치관리자가 없는 컨테이너

* 컴포넌트의 위치와 크기를 직접 지정 가능
* 게임 프로그램처럼 위치가 자주 변경되는 경우 사용

### 배치관리자 제거

```java
container.setLayout(null);
```

### 특징

* 자동 배치 기능 제거
* 위치와 크기를 직접 지정해야 함
* 컴포넌트끼리 겹칠 수 있음

```java
void setSize(int width, int height)
```

---

# 2026/05/06

## 모듈

* Java 9부터 도입
* 여러 패키지와 리소스를 하나로 관리
* `.jmod` 파일 형식 사용

## 모듈화

* 자바 API를 여러 모듈로 분리
* 필요한 모듈만 선택 실행 가능

## Object 클래스

* 모든 자바 클래스의 최상위 클래스
* 모든 클래스는 Object를 자동 상속

## Wrapper 클래스

* 기본 타입을 객체 형태로 표현하는 클래스

### 종류

* `Integer`
* `Double`
* `Character`
* `Boolean`

## 박싱 / 언박싱

### 박싱

* 기본 타입 값을 Wrapper 객체로 변환

### 언박싱

* Wrapper 객체 값을 기본 타입으로 변환

## String

### 스트링 리터럴

* 문자열 상수 저장 방식
* 리터럴 테이블에서 관리

### 문자열 비교

#### equals()

* 문자열 내용 비교

#### compareTo()

* 문자열 사전 순 비교

## StringBuffer

* 문자열 수정이 가능한 클래스
* 문자열 변경 작업이 많은 경우 사용

## StringTokenizer

* 문자열을 특정 구분자로 분리하는 클래스

## Math 클래스

* 수학 연산 기능 제공
* 모든 메소드 static 선언

### 예시 메소드

* `Math.random()`
* `Math.abs()`
* `Math.max()`

## Collection

* 여러 객체를 저장하는 자료 구조

### 특징

* 크기 자동 조절
* 삽입, 삭제 가능
* 제네릭 기반 구현

---

# 2026/04/29

## 상속

* 기존 클래스의 기능을 새로운 클래스가 물려받는 것
* 코드 재사용 가능
* 상위 클래스의 기능을 하위 클래스가 물려받음

### 특징

* 자바는 클래스 다중 상속 불가
* 인터페이스 다중 상속 허용

## 슈퍼 클래스와 서브 클래스

### 슈퍼 클래스

* 상위 클래스

### 서브 클래스

* 하위 클래스

### 생성자 호출

* 객체 생성 시 슈퍼 클래스 생성자 먼저 호출

#### 명시적 호출

```java
super();
```

#### 자동 호출

* 기본 생성자 자동 호출

## 업캐스팅 / 다운캐스팅

### 업캐스팅

* 서브 클래스 객체를 슈퍼 클래스 타입으로 변환

### 다운캐스팅

* 슈퍼 클래스 타입을 서브 클래스 타입으로 변환
* 명시적 형변환 필요

## 다형성

### 메소드 오버로딩

* 같은 이름의 메소드를 여러 형태로 작성

### 메소드 오버라이딩

* 슈퍼 클래스 메소드를 서브 클래스에서 재정의

## 추상 클래스

* `abstract` 키워드 사용
* 객체 생성 불가

### 목적

* 공통 기능 제공
* 다형성 구현

## 인터페이스 구성 요소

### 상수

```java
public static final
```

### 추상 메소드

```java
public abstract
```

## 패키지와 모듈

### 패키지

* 관련 클래스 파일 묶음

### 모듈

* 여러 패키지와 리소스를 하나로 구성

---

# 2026/04/15

## 생성자

* 객체 생성 시 자동 호출되는 메소드
* 클래스 이름과 동일
* 리턴 타입 없음

## this 레퍼런스

* 현재 객체 자신 참조

## 객체 생성과 활용

```java
Rectangle rect = new Rectangle();
```

## 객체 배열

### 생성 과정

1. 배열 변수 선언
2. 배열 생성
3. 객체 생성

## 메소드

* 클래스 내부에 선언되는 기능 단위

### 메소드 오버로딩

* 같은 이름의 메소드를 여러 개 선언

#### 조건

* 매개변수 개수 또는 타입이 달라야 함

## 객체 소멸

* JVM이 자동으로 객체 제거

## 가비지 컬렉션

* 사용하지 않는 객체 메모리 자동 회수

## 접근 지정자

### private

* 클래스 내부만 접근 가능

### protected

* 상속 관계 접근 가능

### public

* 모든 클래스 접근 가능

### default

* 같은 패키지 내부 접근 가능

## static 멤버

* 객체와 관계없이 클래스 자체에 생성
* 모든 객체가 공유

## final

### final 클래스

* 상속 불가

### final 메소드

* 오버라이딩 불가

### final 필드

* 값 변경 불가

---

# 2026/04/08

## 배열(Array)

* 동일 타입 데이터를 순차 저장
* 인덱스로 접근 가능

### length 필드

* 배열 크기 저장

### for-each

* 배열 원소를 순차적으로 접근

## 2차원 배열

### 선언

```java
int intArray[][];
int[][] intArray;
```

### 생성

```java
intArray = new int[2][5];
```

## 예외 처리

### try-catch-finally

* 예외 발생 시 처리 코드 작성
* finally는 예외 여부와 관계없이 실행

## 객체 지향 언어의 목적

### 소프트웨어 생산성 향상

* 코드 재사용 가능
* 유지보수 효율 증가

### 실세계 모델링

* 현실 객체를 프로그램으로 표현 가능

## 클래스와 객체

### 클래스

* 객체 설계도

### 객체

* 클래스 기반으로 생성된 실체

---

# 2026/04/01

## 비트 연산

* 비트 단위 연산 수행

### 종류

* AND
* OR
* XOR
* NOT

### 활용

* 성능 최적화
* 비트 마스크 처리

## 조건문

### if / if-else

* 조건에 따라 실행 분기

### switch

* 값에 따라 여러 경우 분기

## 반복문

### for

* 반복 횟수가 정해진 경우 사용

### while

* 조건이 참인 동안 반복

### do-while

* 최소 한 번 실행 후 조건 검사

### continue문

* 다음 반복으로 이동

### break문

* 반복문 즉시 종료

---

# 2026/03/25

## 메소드

* 클래스 내부 기능 단위

## 식별자

* 변수, 클래스, 메소드 이름

## 데이터 타입

* 데이터 종류 지정

## 참조 자료형

* 객체를 참조하는 변수 유형
* Heap 영역 객체 주소 참조

### 특징

* `null` 저장 가능
* 여러 변수가 같은 객체 참조 가능

## 메모리 구조

### Heap

* 객체 저장 영역

### Stack

* 지역 변수와 함수 호출 저장 영역

## 변수 선언

* 값을 저장할 메모리 공간 생성

## 상수 선언

```java
final
```

* 값 변경 불가

## var

* Java 10부터 도입
* 타입 자동 추론

### 제한

* 지역 변수에서만 사용 가능

## 출력 메소드

### System.out.print()

* 줄바꿈 없이 출력

### System.out.println()

* 출력 후 줄바꿈

### System.out.printf()

* 형식 지정 출력

## 타입 변환

### 자동 타입 변환

* 작은 타입 → 큰 타입 자동 변환

### 강제 타입 변환

* 개발자가 직접 형변환 수행

## 키 입력

### System.in

* 표준 입력 스트림

### Scanner

* 다양한 타입 입력 처리

## 비교/논리 연산

### 비교 연산자

* true / false 결과 반환

### 논리 연산자

* 논리 계산 수행

---

# 2026/03/18

## 기계어

* 0과 1의 이진수 언어
* CPU 직접 실행 가능

## 어셈블리어

* 기계어를 기호 형태로 표현

### 예시

* `ADD`
* `SUB`
* `MOVE`

## 고급 언어

* 사람이 이해하기 쉬운 언어

### 절차 지향 언어

* 순서 중심 실행
* 데이터와 함수 분리

#### 예시

* `C`
* `Pascal`
* `Fortran`

### 객체 지향 언어

* 객체 중심 설계
* 상속, 캡슐화, 다형성 사용

#### 예시

* `Java`
* `C++`
* `Python`

### 함수 지향 언어

* 함수 중심 프로그래밍
* 상태 변경 최소화

#### 예시

* `Python`
* `Kotlin`
* `Haskell`
* `Lisp`
* `Scala`

## 용어 정리

### 소스

* 프로그래밍 언어로 작성된 텍스트 파일

### 컴파일

* 소스를 기계어로 변환

```text
Java : .java -> .class
C : .c -> .obj -> .exe
C++ : .cpp -> .obj -> .exe
```

## 자바의 시작

### Green Project

* 1991년 시작
* 제임스 고슬링 개발
* 초기 이름 OAK

## 목적

### 플랫폼 독립성 확보

* 플랫폼 관계없이 실행 가능

### 가전 제품 적용

* 적은 메모리 환경 대응

## 플랫폼 종속성

### 원인

1. CPU 기계어 차이
2. 운영체제 API 차이
3. 실행 파일 형식 차이

## WORA

### Write Once Run Anywhere

* 한 번 작성 후 여러 플랫폼 실행 가능

## 바이트 코드(Byte Code)

* JVM에서 실행되는 코드

## JVM

* 바이트 코드 실행 환경

## JDK와 JRE

### 주요 도구

* `javac`
* `java`
* `javadoc`
* `jar`
* `jmod`
* `jlink`
* `jdb`
* `javap`

### Java SE

* 표준 플랫폼

### Java EE

* 서버 개발 플랫폼

### Java ME

* 임베디드 플랫폼

---

# 2026/03/11

## .gitignore

* Git 관리 제외 파일 지정

### 사용

* `.gitignore.io` 사이트 사용 가능

---

# 2026/03/04

## 버전 관리 시스템(Git)

* 파일 변경 사항 관리 시스템

### Git

* DVCS 방식 사용

## 커널

* 범용 UI 제공 역할

## Git Bash

* Git Bash 사용 권장

## 윈도우와 Shell 명령 차이

* 명령어 체계 차이 존재