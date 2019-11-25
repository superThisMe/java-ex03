package lab.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MyFrame04 extends JFrame {

	private JTextField fromKRW, fromUSD, toKRW, toUSD;
	private JButton krwToUSD, usdToKRW;

	// 생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame04() {
		// 윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);
		// 윈도우 속성 설정 (제목, 크기, ....)
		setTitle("");
		setSize(460, 400);

		fromKRW = new JTextField();
		fromKRW.setSize(150, 50);
		fromKRW.setLocation(10, 10);
		add(fromKRW);

		krwToUSD = new JButton("USD");
		krwToUSD.setSize(100, 50);
		krwToUSD.setLocation(170, 10);
		add(krwToUSD);
		
		toUSD = new JTextField();
		toUSD.setSize(150, 50);
		toUSD.setLocation(280, 10);
		toUSD.setEnabled(false);
		add(toUSD);
		
		ClickHandler1 handler = new ClickHandler1();
		krwToUSD.addActionListener(handler);
		
		fromUSD = new JTextField();
		fromUSD.setSize(150, 50);
		fromUSD.setLocation(10, 70);
		add(fromUSD);

		usdToKRW = new JButton("KRW");
		usdToKRW.setSize(100, 50);
		usdToKRW.setLocation(170, 70);
		add(usdToKRW);
		
		toKRW = new JTextField();
		toKRW.setSize(150, 50);
		toKRW.setLocation(280, 70);
		toKRW.setEnabled(false);
		add(toKRW);
		
		ClickHandler2 handler2 = new ClickHandler2();
		usdToKRW.addActionListener(handler2);
		
	}

	class ClickHandler1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			int krw = Integer.valueOf(fromKRW.getText());
			double usd = (double)krw * 856 / 1000000;
			toUSD.setText(String.valueOf(usd));

		}
	}
	
	class ClickHandler2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			toKRW.setText(String.valueOf(Double.valueOf(fromUSD.getText()) * 1168));

		}
	}

	public static void main(String[] args) {

		MyFrame04 frame = new MyFrame04();
		frame.setVisible(true);
	}

}
