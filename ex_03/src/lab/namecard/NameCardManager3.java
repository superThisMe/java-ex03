package lab.namecard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class NameCardManager3 {

	//1. 여러 개의 명함을 관리할 수 있습니다. (CRUD)
	//   - 새 명함을 등록할 수 있어야 합니다. (C)
	//   - 전체 명함 목록을 볼 수 있어야 합니다. (R)
	//   - 명함을 (이름으로) 검색할 수 있어야 합니다. (R)
	//   - 명함을 삭제할 수 있어야 합니다. (D)
	//   - 명함을 수정할 수 있어야 합니다. (U)
	
	//변수 선언
	private ArrayList<NameCard> cards = null;	
	private Scanner scanner = new Scanner(System.in);
	
	//생성자 : 클래스이름과 같은 이름, 결과형 표현 X, 객체를 생성할 때(new 클래스이름()) 자동 호출
	//        프로그램의 시작 시점으로 사용할 수 있습니다.
	public NameCardManager3() {
		//파일에 저장된 데이터 읽어오기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("cards.dat");
			ois = new ObjectInputStream(fis);
			cards = (ArrayList<NameCard>)ois.readObject();
		} catch (Exception e) {
			cards = new ArrayList<>();
		} finally {
			try { ois.close(); } catch (Exception ex) {}
			try { ois.close(); } catch (Exception ex) {}
		}
	}
	
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
			case "4": // 삭제 
				deleteNameCard();
				break;
			case "5": // 수정 
				break;
			case "9": // 프로그램 종료 -> while 종료
				
				saveNameCards();
				
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

	void saveNameCards() {
		//데이터 저장 : cards 저장 (ArrayList 객체 저장)
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("cards.dat"); // byte[]를 파일에 저장
			oos = new ObjectOutputStream(fos); //객체를 byte[]로 변환
			oos.writeObject(cards); // 저장 명령					
		} catch (IOException e) {
			System.out.println("데이터 저장 실패");
			e.printStackTrace(); //오류 메시지를 화면에 출력 (코드 검토를 위해)
		} finally {
			try { oos.close(); } catch (Exception ex) {}
			try { fos.close(); } catch (Exception ex) {}
		}
	}
	
	void deleteNameCard() {
		System.out.print("검색할 이름 : ");
		String name = scanner.nextLine();		
		//검색된 결과를 저장할 컬렉션 객체
		ArrayList<NameCard> searchedList = new ArrayList<>();
		for (NameCard card : cards) {
			if (card.getName().contains(name)) {
				searchedList.add(card);
			}
		}		
		if (searchedList.size() == 0) { //검색된 내용이 없는 경우
			System.out.println("** 검색된 연락처가 없습니다 **");
			// break; // switch-case에서 사용
			return; // 메서드에서 사용
		}
		System.out.println("[ 검색된 연락처 목록 ]");
		for (int i = 0; i < searchedList.size(); i++) {
			NameCard card = searchedList.get(i);
			System.out.printf("[%d] : %s\n", (i+1), card);
		}		
		System.out.print("삭제할 연락처의 순서 번호 : ");
		int toDelete = scanner.nextInt();
		scanner.nextLine(); // 입력 버퍼에 남아있는 enter를 제거		
		//System.out.printf("%d번째 데이터를 삭제합니다.\n", toDelete);		
		if (toDelete <= searchedList.size() && toDelete > 0) {// 입력 숫자의 범위 확인
			NameCard nc = searchedList.get(toDelete - 1);
			cards.remove(nc); //전체 목록에서 제거
		}

	}
	
	void searchNameCard() {
		System.out.print("검색할 이름 : ");
		String name = scanner.nextLine();
		
		//검색된 결과를 저장할 컬렉션 객체
		ArrayList<NameCard> searchedList = new ArrayList<>();
		for (NameCard card : cards) {
			if (card.getName().contains(name)) {
				searchedList.add(card);
			}
		}
		
		if (searchedList.size() == 0) { //검색된 내용이 없는 경우
			System.out.println("** 검색된 연락처가 없습니다 **");
			// break; // switch-case에서 사용
			return; // 메서드에서 사용
		}

		System.out.println("[ 검색된 연락처 목록 ]");
		for (NameCard card : searchedList) {			
			System.out.println(card); // 자동으로 card.toString() 호출
		}

	}

	void showAllNameCards() {
		if (cards.size() == 0) { //size: 요소의 갯수 -> 등록된 연락처가 없는 경우
			System.out.println("** 등록된 연락처가 없습니다. **");
			return;
		}
		
		System.out.println("[ 전체 연락처 목록 ]");
		
//		for (int i = 0; i < cards.size(); i++) {
//			NameCard card = cards.get(i);
		for (NameCard card : cards) { // enhanced for : cards 목록 순회 (위 주석과 같은 기능)
			String info = card.toString();
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
		//card.setNo(nextPosition); // 1부터 시작하려면 nextPosition + 1
		card.setName(name);
		card.setPhone(phone);
		card.setEmail(email);
		
		//NameCard 배열에 데이터 저장
		//cards[nextPosition] = card;
		cards.add(card); // 목록에 새 연락처 추가
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
	
	int x = 10;
	public static void main(String[] args) {
		NameCardManager3 manager = new NameCardManager3();
		manager.doManage();
	}
	
}







