package lab.namecard;

import java.util.ArrayList;
import java.util.Scanner;

public class NameCardManager2 {

	// 1. 여러 개의 명함을 관리할 수 있습니다. (CRUD)
	// - 새 명함을 등록할 수 있어야 합니다. (C)
	// - 전체 명함 목록을 볼 수 있어야 합니다. (R)
	// - 명함을 (이름으로) 검색할 수 있어야 합니다. (R)
	// - 명함을 삭제할 수 있어야 합니다. (D)
	// - 명함을 수정할 수 있어야 합니다. (U)

	// 변수 선언
//	private NameCard[] cards = new NameCard[1000]; //명함을 저장할 배열
//	private int nextPosition; //새 명함을 저장할 위치 번호
	private ArrayList<NameCard> cal = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	public void doManage() { // 기존에 사용했던 main 함수 역할

		outer: // 문장에 이름 붙이기 (여기서는 while문의 이름을 outer로 지정)
		while (true) {
			String selection = selectMenu();
			switch (selection) {
			case "1": // 등록
				registerNameCard();
				System.out.println("새 연락처를 등록했습니다.");
				break;
			case "2": // 목록 보기
				showAllNameCards();
				break;
			case "3": // 검색
				searchNameCard();
				break;
			case "4":
				break;
			case "5":
				break;
			case "9": // 프로그램 종료 -> while 종료
				System.out.println("프로그램을 종료합니다.");
				// break; //switch문 종료
				// return; // return: 메서드 종료 -> 여기서는 doManage 종료
				break outer; // outer로 지정된 문장 break -> 여기서는 while
			default:
				System.out.println("지원하지 않는 작업입니다.");
				break;
			}
		}
	}

	void searchNameCard() {
		System.out.print("검색할 이름 : ");
		String name = scanner.nextLine();

		// 검색된 결과를 저장할 컬렉션 객체
		ArrayList<NameCard> searchedList = new ArrayList<>();
		for (NameCard card : cal) {
			if (card.getName().contains(name)) {
				searchedList.add(card);
			}
		}

		if (searchedList.size() == 0) { // 검색된 내용이 없는 경우
			System.out.println("** 검색된 연락처가 없습니다 **");
			// break; // switch-case에서 사용
			return; // 메서드에서 사용
		}

		System.out.println("[ 검색된 연락처 목록 ]");
		for (NameCard card : searchedList) {
			System.out.println(card);
		}

	}

	void showAllNameCards() {
		if (cal.size() == 0) { // 등록된 연락처가 없는 경우
			System.out.println("** 등록된 연락처가 없습니다. **");
			return;
		}

		System.out.println("[ 전체 연락처 목록 ]");
		for (NameCard card : cal) { // enhanced for : cal 목록 순회
			System.out.println(card);
		}
	}

	void registerNameCard() {
		// 입력 : 이름, 이메일, 전화번호
//		System.out.println("[ 등록할 연락처 정보 ]");
//		System.out.print("이름 : ");
//		String name = scanner.nextLine();
//		System.out.print("전화번호 : ");
//		String phone = scanner.nextLine();
//		System.out.print("이메일 : ");
//		String email = scanner.nextLine();

		// NameCard 객체 만들기 + 입력받은 데이터 저장(set 메서드 호출)
		NameCard card = new NameCard();
//		card.setNo(nextPosition); // 1부터 시작하려면 nextPosition + 1
		System.out.println("[ 등록할 연락처 정보 ]");
		System.out.print("이름 : ");
		card.setName(scanner.nextLine());
		System.out.print("전화번호 : ");
		card.setPhone(scanner.nextLine());
		System.out.print("이메일 : ");
		card.setEmail(scanner.nextLine());

		// NameCard 배열에 데이터 저장
//		cards[nextPosition] = card;
		cal.add(card); // 목록에 새 연락처 추가
	}

	public String selectMenu() {
		System.out.println();// 여백
		System.out.println("******************************");
		System.out.println("* 1. 명함 등록.");
		System.out.println("* 2. 명함 목록 보기.");
		System.out.println("* 3. 명함 검색.");
		System.out.println("* 4. 명함 삭제.");
		System.out.println("* 5. 명함 수정.");
		System.out.println("* 9. 종료.");
		System.out.println("******************************");
		System.out.print("작업 번호를 입력하세요 : ");
		String selection = scanner.nextLine();
		System.out.println();// 여백
		return selection;
	}

	///////////////////////////////////////////

	public static void main(String[] args) {
		NameCardManager2 manager = new NameCardManager2();
		manager.doManage();
	}

}
