package lab.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MyFrame03 extends JFrame {

	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.red, Color.orange, Color.yellow,
			Color.green, Color.blue, new Color(0, 0, 128), new Color(128, 0, 128)));
	private JPanel canvas = null;
	ClickHandler handler = new ClickHandler();

	// 생성자 메서드 (constructor) : 객체가 만들어질 때(new 할 때) 자동으로 호출되는 메서드 / 초기화
	public MyFrame03() {
		// 윈도우가 닫히면 프로그램도 종료하는 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 윈도우에 포함된 구성요소의 위치 관리를 위해 절대 크기와 좌표를 사용
		setLayout(null);

		// 윈도우 속성 설정 (제목, 크기, ....)
		setTitle("");
		setSize(750, 600);

		makeButton(25);

		canvas = new JPanel();
		canvas.setSize(680, 450);
		canvas.setLocation(25, 85);
		canvas.setBackground(Color.black);
		add(canvas);

	}

	void makeButton(int location) {
		for (int i = 0; i < colors.size(); i++) {
			buttons.add(new JButton());
			buttons.get(i).setSize(80, 50);
			buttons.get(i).setLocation(location, 10);
			location += 100;
			buttons.get(i).setBackground(colors.get(i));
			buttons.get(i).addActionListener(handler);
			add(buttons.get(i));
		}
	}

	class ClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton clickedButton = (JButton) e.getSource();
			canvas.setBackground(clickedButton.getBackground());

		}
	}

	public static void main(String[] args) {

		MyFrame03 frame = new MyFrame03();
		frame.setVisible(true);
	}

}
