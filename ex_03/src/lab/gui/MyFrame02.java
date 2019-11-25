package lab.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MyFrame02 extends JFrame {

	private JButton button;

	// 생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame02() {
		// 윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);

		// 윈도우 속성 설정 (제목, 크기, ....)
		setTitle("상속으로 만든 윈도우");
		setSize(500, 600);

		// 윈도우의 사용자 영역을 관리하는 객체 가져오기
		Container container = getContentPane();
		container.setBackground(Color.orange);

		// 버튼 만들기
		button = new JButton();
		// 버튼 속성 설정
		button.setText("눌러 주세요");
		button.setSize(300, 100);
		button.setLocation((getWidth() - button.getWidth()) / 2, ((getHeight() - 50) - button.getHeight()) / 2);

		// 버튼이 클릭되었을 때 호출할 메서드를 버튼에게 전달
		ClickHandler handler = new ClickHandler();
		button.addActionListener(handler);

		// 윈도우에 버튼 추가
		add(button);
	}

	// 버튼이 클릭되었을 때 호출할 약속된 메서드를 정의하는 클래스 (ActionListener 인터페이스 구현)
	class ClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 팝업 다이얼로그 표시하는 static 메서드 호출
			// JOptionPane.showMessageDialog(null, "눌러 주셔서 대단히 감사합니다.");

			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			// Color 클래스 : 색상을 red, green, blue의 조합으로 관리하는 클래스
			//  - 생성자 메소드에 red, green, blue 값을 전달해야 합니다.
			//  - red, green, blue : 0 ~ 256 (int) or 0 ~ 1 (float)
			Color color = new Color(r, g, b);

			// MyFrame02.this : 현재 클래스를 포함하는 외부 클래스들 중에서 MyFrame02 객체를 참조
			// 	- 사용하는 멤버가 외부 클래스에 있는 것이 명확하다면 생략 가능
			Container container = /*MyFrame02.this.*/getContentPane();
			container.setBackground(color);

		}
	}

	public static void main(String[] args) {

		MyFrame02 frame = new MyFrame02();
		frame.setVisible(true);
	}

}
