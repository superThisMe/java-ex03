package lab.lotto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LottoManager extends JFrame {

	private int[] lotto = new int[6];
	private JTextField[] lottoNums = new JTextField[6];
	private JButton pickLotto;
	private JTextField avr;
	private LottoHandler l = new LottoHandler();

	public LottoManager() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setTitle("로또");
		setSize(570, 230);
		setResizable(false);
		
		pickLotto = new JButton();
		pickLotto.setSize(530, 50);
		pickLotto.setLocation(10, 10);
		pickLotto.setFont(new Font("휴먼고딕", Font.BOLD, 24));
		pickLotto.setText("당첨예상번호뽑기");
		pickLotto.addActionListener(l);
		add(pickLotto);

	}

	class LottoHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			selectBasicNumbers();
			lottoBox();

			avr = new JTextField();
			avr.setSize(160, 50);
			avr.setLocation(380, 130);
			avr.setFont(new Font("맑은고딕", Font.BOLD, 30));
			avr.setHorizontalAlignment(JTextField.CENTER); 
			String txt = String.format("%.2f", getAvr(lotto));
			avr.setText(txt);
			add(avr);

		}

	}

	void lottoBox() {
		for (int i = 0; i < lotto.length; i++) {
			lottoNums[i] = new JTextField();
			lottoNums[i].setSize(80, 50);
			lottoNums[i].setLocation(10 + 90 * i, 70);
			lottoNums[i].setFont(new Font("고딕", Font.BOLD, 28));
			lottoNums[i].setHorizontalAlignment(JTextField.CENTER); 
			lottoNums[i].setText(String.valueOf(lotto[i]));
			lottoNums[i].setEnabled(false);
			add(lottoNums[i]);
		}
	}

	int[] selectBasicNumbers() {

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		return lotto;
	}

	double getAvr(int[] arr) {
		int sum = 0;
		double avr = 0.0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		avr = (double) sum / 6;
		return avr;
	}
}
