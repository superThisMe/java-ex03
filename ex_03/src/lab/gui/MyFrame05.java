package lab.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyFrame05 extends JFrame {

	private JButton selectNumbersButton;
	private JTextField[] numbersField = new JTextField[6];
	private JTextField meanField;

	// 생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame05() {
		// 윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);
		// 윈도우 속성 설정 (제목, 크기, ....)
		setTitle("");
		setSize(675, 370);

		setResizable(false);

		selectNumbersButton = new JButton("당첨 예상 번호 뽑기");
		selectNumbersButton.setSize(650, 100);
		selectNumbersButton.setLocation(10, 10);
		selectNumbersButton.setFont(new Font("휴먼편지체", Font.BOLD, 60));
		selectNumbersButton.setBackground(new Color(224, 255, 255));
		selectNumbersButton.setForeground(new Color(220, 20, 60));
		selectNumbersButton.setFocusPainted(false);
		add(selectNumbersButton);

		selectNumbersButton.addActionListener(new ButtonClickHandler());

		for (int i = 0; i < numbersField.length; i++) {
			numbersField[i] = new JTextField();
			numbersField[i].setSize(100, 100);
			numbersField[i].setLocation(10 + 110 * i, 120);
			numbersField[i].setEditable(false);
			numbersField[i].setHorizontalAlignment(JTextField.CENTER);
			numbersField[i].setFont(new Font("맑은고딕", Font.BOLD, 50));
			numbersField[i].setBackground(new Color(0, 0, 0));
			numbersField[i].setForeground(new Color(255, 69, 0));
			add(numbersField[i]);
		}

		meanField = new JTextField();
		meanField.setSize(210, 100);
		meanField.setLocation(450, 235);
		meanField.setEditable(false);
		meanField.setHorizontalAlignment(JTextField.CENTER);
		meanField.setFont(new Font("맑은고딕", Font.BOLD, 50));
		meanField.setBackground(Color.darkGray);
		meanField.setForeground(new Color(200, 200, 200));
		add(meanField);

	}

	class ButtonClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Lotto lotto = new Lotto();
			int[] numbers = lotto.getLotto();

			int sum = 0;
			for (int i = 0; i < numbers.length; i++) {
				numbersField[i].setText(String.valueOf(numbers[i]));
				sum += numbers[i];
			}

			meanField.setText(String.format("%.2f", (double) sum / numbers.length));

		}
	}

	public static void main(String[] args) {

		MyFrame05 frame = new MyFrame05();
		frame.setVisible(true);
	}

}
