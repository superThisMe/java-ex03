package lab.rps;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RpsManager extends JFrame {

	private String[] rps = new String[] { "가위", "바위", "보" };
	private JButton[] rpsButton = new JButton[3];
	private JTextField pSelect, cSelect, versus, result;

	private ButtonClickHandler l = new ButtonClickHandler();

	public RpsManager() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("가위바위보");
		setSize(650, 290);
		setResizable(false);

		for (int i = 0; i < rps.length; i++) {
			rpsButton[i] = new JButton();
			rpsButton[i].setSize(200, 100);
			rpsButton[i].setLocation(10 + 210 * i, 140);
			rpsButton[i].setText(rps[i]);
			rpsButton[i].setFont(new Font("맑은고딕", Font.BOLD, 40));
			rpsButton[i].addActionListener(l);
			add(rpsButton[i]);
		}

		pSelect = new JTextField();
		pSelect.setSize(150, 100);
		pSelect.setLocation(10, 20);
		pSelect.setHorizontalAlignment(JTextField.CENTER);
		pSelect.setFont(new Font("맑은고딕", Font.BOLD, 40));
		pSelect.setEditable(false);
		add(pSelect);

		versus = new JTextField();
		versus.setSize(100, 100);
		versus.setLocation(170, 20);
		versus.setText("VS");
		versus.setHorizontalAlignment(JTextField.CENTER);
		versus.setFont(new Font("맑은고딕", Font.ITALIC, 30));
		versus.setEditable(false);
		add(versus);

		cSelect = new JTextField();
		cSelect.setSize(150, 100);
		cSelect.setLocation(280, 20);
		cSelect.setHorizontalAlignment(JTextField.CENTER);
		cSelect.setFont(new Font("맑은고딕", Font.BOLD, 40));
		cSelect.setEditable(false);
		add(cSelect);

		result = new JTextField();
		result.setSize(190, 100);
		result.setLocation(440, 20);
		result.setHorizontalAlignment(JTextField.CENTER);
		result.setFont(new Font("맑은고딕", Font.BOLD, 40));
		result.setEditable(false);
		add(result);

	}

	class ButtonClickHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton clickedButton = (JButton) e.getSource();

			RpsPlay cRps = new RpsPlay();
			pSelect.setText(clickedButton.getText());
			cSelect.setText(cRps.play());
			int type = 0;
			type = cRps.getResult(pSelect.getText(), cSelect.getText());
			switch (type) {
			case 0:
				result.setText("You lose!");
				break;
			case 1:
				result.setText("You win!");
				break;
			case 2:
				result.setText("Draw!");
				break;
			}

		}

	}

}
