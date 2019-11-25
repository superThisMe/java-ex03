package lab.namecard2;

import java.util.Scanner;

public class NameCardUI {

	private NameCardManager manager = new NameCardManager();
	private Scanner sc = new Scanner(System.in);

	public NameCardUI() {
		while (true) {
			printMainMenu();
			int no = 0;
			String name = null;

			try {
				no = (int) Integer.parseInt(sc.next());
			} catch (NumberFormatException e) {
				System.out.println("입력오류! 다시 입력하세요.");
				continue;
			}

			switch (no) {
			case 1:
				this.insertNameCard();
				break;
			case 2:
				System.out.println("|이름 입력| ");
				name = sc.next();
				NameCard result = manager.findNameCard(name);
				if (result == null) {
					System.out.println("검색결과 : 데이터에 없는 이름!");
				} else {
					result.showInfo();
				}
				break;
			case 3:
				manager.modifyNameCard();
				break;
			case 4:
				System.out.print("|이름 입력| ");
				name = sc.next();
				boolean answer = manager.deleteNameCard(name);
				if (answer == true) {
					System.out.println("|삭제 완료|");
				} else if (answer == false) {
					System.out.println("|삭제 실패!");
				}
				break;
			case 5:
				manager.showAll();
				break;
			case 9:
				return;
			default:
				System.out.println("메뉴 입력오류!");
			}
		}
	}

	public void insertNameCard() {
		NameCard n = makeNameCard();
		boolean answer = manager.insertNameCard(n);
		if (answer == true) {
			System.out.println("정상등록되었습니다.");
		} else if (answer == false) {
			System.out.println("동일한 주민번호가 존재합니다.");
		}
	}

	public NameCard makeNameCard() {
		NameCard result = null;
		System.out.println("|이름| ");
		String n = sc.next();

		System.out.print("|전화번호| ");
		String p = sc.next();

		System.out.print("|이메일| ");
		String e = sc.next();

		result = new NameCard(n, p, e);

		return result;
	}

	public void printMainMenu() {
		System.out.println("┌────────────────────────────────┐");
		System.out.println("│           명함 관리 시스템                          │");
		System.out.println("└────────────────────────────────┘");
		System.out.println("┌────────────────────────────────┐");
		System.out.println("│1.등록                                                                │");
		System.out.println("│2.찾기                                                                │");
		System.out.println("│3.수정                                                                │");
		System.out.println("│4.삭제                                                                │");
		System.out.println("│5.전체출력                                                          │");
		System.out.println("│9.종료                                                                │");
		System.out.println("└────────────────────────────────┘");
		System.out.print(" 메뉴 번호를 선택하세요=> ");
	}

}
