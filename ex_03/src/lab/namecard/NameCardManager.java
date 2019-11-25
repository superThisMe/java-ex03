package lab.namecard;

import java.util.Scanner;

public class NameCardManager {

	//1. 여러 개의 명함을 관리할 수 있습니다. (CRUD)
	//   - 새 명함을 등록할 수 있어야 합니다. (C)
	//   - 전체 명함 목록을 볼 수 있어야 합니다. (R)
	//   - 명함을 (이름으로) 검색할 수 있어야 합니다. (R)
	//   - 명함을 삭제할 수 있어야 합니다. (D)
	//   - 명함을 수정할 수 있어야 합니다. (U)
	
	//변수 선언
	private NameCard[] cards = new NameCard[1000]; //명함을 저장할 배열
	private int nextPosition; //새 명함을 저장할 위치 번호
	private Scanner scanner = new Scanner(System.in);
	
	public void doManage() { // 기존에 사용했던 main 함수 역할
		
		outer: //문장에 이름 붙이기 (여기서는 while문의 이름을 outer로 지정)
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
			case "4": break;
			case "5": break;
			case "9": // 프로그램 종료 -> while 종료
				System.out.println("프로그램을 종료합니다.");
				//break; //switch문 종료
				//return; // return: 메서드 종료 -> 여기서는 doManage 종료
				break outer; // outer로 지정된 문장 break -> 여기서는 while
			default : 
				System.out.println("지원하지 않는 작업입니다.");
				break;
			}
		}		
	}
	
	void searchNameCard() {
		System.out.print("검색할 이름 : ");
		String name = scanner.nextLine();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nextPosition; i++) {
			//if ( name.equals(cards[i].getName()) ) { //equals : 완전일치
			if ( cards[i].getName().contains(name) ) { //contains : 부분일치
				sb.append( String.valueOf(i) ); // String.valueOf : 숫자 -> String,  append : 문자열 결합 (덧붙이기)
				sb.append(" ");
			}
		}
		
		//System.out.println(sb.toString());
		
		String index = sb.toString();
		
		if (index.length() == 0) { //검색된 내용이 없는 경우 ( String.length : 문자 갯수 )
			System.out.println("** 검색된 연락처가 없습니다 **");
			// break; // switch-case에서 사용
			return; // 메서드에서 사용
		}

		index = index.trim(); // 양 끝에서 공백 제거
		String[] tempAr = index.split(" "); // "1 2 3" -> 배열로 변환 : ["1"]["2"]["3"]
		int[] indexAr = new int[tempAr.length];
		for (int i = 0; i < tempAr.length; i++) {
			indexAr[i] = Integer.parseInt(tempAr[i]); // parseInt : "1" -> 1
		}
		
		System.out.println("[ 검색된 연락처 목록 ]");
		for (int i = 0; i < indexAr.length; i++) {
			int pos = indexAr[i];
			System.out.println(cards[pos]);
		}

	}

	void showAllNameCards() {
		if (nextPosition == 0) { //등록된 연락처가 없는 경우
			System.out.println("** 등록된 연락처가 없습니다. **");
			return;
		}
		
		System.out.println("[ 전체 연락처 목록 ]");
		for (int i = 0; i < nextPosition; i++) {
			String info = cards[i].toString();
			System.out.println(info);
		}		
	}

	void registerNameCard() {
		//입력 : 이름, 이메일, 전화번호
		System.out.println("[ 등록할 연락처 정보 ]");
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		System.out.print("이메일 : ");
		String email = scanner.nextLine();
		
		//NameCard 객체 만들기 + 입력받은 데이터 저장(set 메서드 호출)
		NameCard card = new NameCard();
		card.setNo(nextPosition); // 1부터 시작하려면 nextPosition + 1
		card.setName(name);
		card.setPhone(phone);
		card.setEmail(email);
		
		//NameCard 배열에 데이터 저장
		cards[nextPosition] = card;
		nextPosition++;
	}
	
	public String selectMenu() {
		System.out.println();//여백
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
		System.out.println();//여백
		return selection;
	}
	
	///////////////////////////////////////////
	
	public static void main(String[] args) {
		NameCardManager manager = new NameCardManager();
		manager.doManage();
	}
	
}







