package lab.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame01 {

	public static void main(String[] args) {
		
		//JFrame : 윈도우를 구현한 클래스
		JFrame frame = new JFrame();
		
		//윈도우가 닫히면 프로그램도 종료하는 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		frame.setLayout(null);
		
		//윈도우 속성 설정 (제목, 크기, ....)
		frame.setTitle("처음 만든 윈도우");
		frame.setSize(500, 600);
		
		//버튼 만들기
		JButton button = new JButton();
		//버튼 속성 설정
		button.setText("눌러 주세요");
		button.setSize(300, 100);
		button.setLocation(
				(frame.getWidth() - button.getWidth()) / 2, 
				( (frame.getHeight() - 50) - button.getHeight() ) / 2);
		
		//윈도우에 버튼 추가
		frame.add(button);
		
		
		//윈도우를 화면에 표시
		frame.setVisible(true);

	}

}








