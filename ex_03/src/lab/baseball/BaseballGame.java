package lab.baseball;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	
	//Scanner를 함수 안에서 만드는 것은 좋지 않습니다. 
	Scanner scanner = new Scanner(System.in); //입력 도구
	
	public void startGame() {
		
		//1. 컴퓨터의 문제 출제 : 숫자 3개 추출 (0 ~ 9, 중복 X, Random)해서 배열에 저장
		int[] cnumbers = new int[3];
		while (true) {
			for (int i = 0; i < cnumbers.length; i++) {
				cnumbers[i] = (int)(Math.random() * 10); // 0 ~ 9			
			}
			if (cnumbers[0] != cnumbers[1] && 
				cnumbers[0] != cnumbers[2] && 
				cnumbers[1] != cnumbers[2]) { //중복이 없는 경우
				break; //반복문 종료
			}
		}		
		Arrays.sort(cnumbers); //Arrays.sort : 배열을 오름차순으로 정렬		
		
		//테스트
		System.out.printf("C : [%d][%d][%d]\n", cnumbers[0], cnumbers[1], cnumbers[2]);		
		
		int[] unumbers = new int[3]; // 사용자 입력을 저장할 배열
		
		int round = 0;
		for (; round < 10; round++) { // 사용자에게 주어지는 10번의 기회
			//2. 사용자 입력 : 숫자 3개, 형식 -> 125, 중복 X, 배열
			while (true) {
				System.out.printf("[%d ROUND] 숫자 3개 입력(예 - 137) : ", (round + 1));
				String line = scanner.nextLine();
				
				//System.out.println(line);
				for (int i = 0; i < unumbers.length; i++) {
					// charAt : 문자열에서 지정된 위치의 문자 반환. "Hello".charAt(1) -> e
					char n = line.charAt(i);
					unumbers[i] = Integer.valueOf(n + "");
				}
				if (unumbers[0] != unumbers[1] && 
					unumbers[0] != unumbers[2] && 
					unumbers[1] != unumbers[2]) { //중복이 없는 경우
					break; //반복문 종료
				}
			}
			//테스트
			System.out.printf("U : [%d][%d][%d]\n", unumbers[0], unumbers[1], unumbers[2]);
			
			//3. 비교 (S : 같은 숫자 + 같은 위치, B : 같은 숫자, 다른 위치, O : 다른 숫자)
			int s = 0, b = 0, o = 0;
			for (int i = 0; i < cnumbers.length; i++) { // 컴퓨터 번호 반복
				for (int j = 0; j < unumbers.length; j++) { // 사용자 번호 반복
					if (cnumbers[i] == unumbers[j]) { // 컴퓨터 번호와 사용자 번호가 같은 경우
						if (i == j) { // 두 번호의 위치가 같은 경우
							s++;
						} else { // 두 번호의 위치가 다른 경우
							b++;
						}
					}
				}
			}
			o = cnumbers.length - (s + b);
			System.out.printf("R : [S:%d][B:%d][O:%d]\n", s, b, o);
			
			if (s == 3) { //정답을 입력한 경우
				break;
			}
		} // end of round while
		
		//승-패 결정
		if (round == 10) { // 실패
			System.out.println("안타깝습니다. 실패입니다.");
		} else {
			System.out.println("축하합니다. 성공입니다.");
		}
		
	}

	public static void main(String[] args) {
		BaseballGame game = new BaseballGame();
		game.startGame();
	}

}






