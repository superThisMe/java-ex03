package lab.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MyFrame04_2 extends JFrame {

	private JTextField tf, tfUSD, tf2, tfKRW;
	private JButton button, button2;
	private ClickHandler handler;

	// 생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame04_2() {
		// 윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);
		// 윈도우 속성 설정 (제목, 크기, ....)
		setTitle("");
		setSize(500, 500);

		tf = new JTextField();
		tf.setSize(120, 30);
		tf.setLocation(10, 10);
		add(tf);

		button = new JButton();
		button.setText("USD");
		button.setSize(70, 30);
		button.setLocation(160, 10);
		button.addActionListener(handler);
		add(button);

		tfUSD = new JTextField();
		tfUSD.setSize(120, 30);
		tfUSD.setLocation(240, 10);
		add(tfUSD);
		
		tf2 = new JTextField();
		tf2.setSize(120, 30);
		tf2.setLocation(10, 50);
		add(tf2);

		button2 = new JButton();
		button2.setText("KRW");
		button2.setSize(70, 30);
		button2.setLocation(160, 50);
		add(button2);

		tfKRW = new JTextField();
		tfKRW.setSize(120, 30);
		tfKRW.setLocation(240, 50);
		add(tfKRW);
	}

	class ClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// 클릭된 버튼 가져오기 (이벤트를 발생시킨 개체 가져오기)
			JButton clickedButton = (JButton)e.getSource();
			
			// 클릭된 버튼에 따라 KRW -> USD or USD -> KRW 처리
			String text = clickedButton.getText();
			if (text.equals("USD")) {
				String skrw = tf.getText();
				double krw = Double.parseDouble(skrw);
				double usd = krw / 1167.6;
				tfUSD.setText(String.valueOf(usd));
			} else {
				String susd2 = tf2.getText();
				double usd2 = Double.parseDouble(susd2);
				double krw2 = usd2 * 1167.6;
				tfKRW.setText(String.valueOf(krw2));
			}
			
		}
	}

	public static void main(String[] args) {

		MyFrame04_2 frame = new MyFrame04_2();
		frame.setVisible(true);
	}

}
