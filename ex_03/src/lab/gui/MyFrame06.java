package lab.gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MyFrame06 extends JFrame {

	JButton[] buttons = new JButton[3];
	JButton uButton, cButton, rButton;
	String[] imagePaths = { "scissors2.png", "rock2.png", "paper2.png" };
	ButtonClickHandler l = new ButtonClickHandler();

	public MyFrame06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("가위바위보");
		setSize(675, 370);
		setResizable(false);

		try {
			for (int i = 0; i < buttons.length; i++) {
				Image img = ImageIO.read(new File(imagePaths[i]));
				img = img.getScaledInstance(150, 84, Image.SCALE_SMOOTH); // 이미지의 크기 변경
				ImageIcon icon = new ImageIcon(img);
				buttons[i] = new JButton(icon);
				buttons[i].setSize(150, 84);
				buttons[i].setLocation(10 + 160 * i, 10);
				buttons[i].addActionListener(l);
				add(buttons[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		uButton = new JButton();
		uButton.setSize(150, 84);
		uButton.setLocation(10, 120);
		uButton.setEnabled(false);
		add(uButton);

		cButton = new JButton();
		cButton.setSize(150, 84);
		cButton.setLocation(330, 120);
		cButton.setEnabled(false);
		add(cButton);

		rButton = new JButton();
		rButton.setSize(150, 84);
		rButton.setLocation(490, 120);
		rButton.setEnabled(false);
		add(rButton);

	}

	class ButtonClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// 1. 사용자가 선택한 버튼의 이미지를 uButton에 적용
			JButton selectedButton = (JButton) e.getSource();
			uButton.setIcon(selectedButton.getIcon());

			// 2. 랜덤하게 선택한 번호에 따라 이미지를 cButton에 적용
			int cNo = (int) (Math.random() * 3);
			cButton.setIcon(buttons[cNo].getIcon());

			// 3. 두 선택을 비교해서 결과 출력
			int uNo = -1;
			for (int i = 0; i < buttons.length; i++) { // 사용자가 선택한 버튼의 순서 번호 찾기
				if (buttons[i].getIcon() == selectedButton.getIcon()) {
					uNo = i;
					break;
				}
			}

			if (uNo == 0 && cNo == 2 || uNo == 1 && cNo == 0 || uNo == 2 && cNo == 1) {
				rButton.setText("YOU WIN");
			} else if (uNo == cNo) {
				rButton.setText("DRAW");
			} else {
				rButton.setText("YOU LOSE");
			}

		}
	}

	public static void main(String[] args) {

		MyFrame06 frame = new MyFrame06();
		frame.setVisible(true);
	}

}
