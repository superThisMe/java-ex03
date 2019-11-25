package lab.namecard2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class NameCardManager implements Manager {

	// 1. 여러 개의 명함을 관리할 수 있습니다. (CRUD)
	// - 새 명함을 등록할 수 있어야 합니다. (C)
	// - 전체 명함 목록을 볼 수 있어야 합니다. (R)
	// - 명함을 (이름으로) 검색할 수 있어야 합니다. (R)
	// - 명함을 삭제할 수 있어야 합니다. (D)
	// - 명함을 수정할 수 있어야 합니다. (U)

	private ArrayList<NameCard> nlist = null;
	private Scanner sc = new Scanner(System.in);

	public NameCardManager() {
		nlist = getFile();
	}

	public boolean insertNameCard(NameCard card) {
		boolean result = false;

		NameCard find = findNameCard(card.getName());
		if (find == null) {
			if (nlist.add(card)) {
				result = setFile(nlist);
			}
		}
		return result;
	}

	public NameCard findNameCard(String name) {
		NameCard result = null;
		for (NameCard a : nlist) {
			if (a.getName().equals(name)) {
				result = a;
			}
		}
		return result;
	}

	public boolean modifyNameCard() {
		System.out.print("|이름 입력| ");
		NameCard result2 = findNameCard(sc.next());
		boolean bl = false;
		if (result2 == null) {
			System.out.println("검색결과 : 데이터에 없는 이름!");
			return bl;
		}
		int a = 0;
		System.out.println("수정할 데이터를 선택하세요. (1: 이름, 2: 전화번호, 3: 이메일 )");
		a = sc.nextInt();
		int x = nlist.indexOf(result2);
		switch (a) {
		case 1:
			System.out.println("|이름  입력| ");
			nlist.get(x).setName(sc.next());
			System.out.println("수정되었습니다.");
			break;
		case 2:
			System.out.println("|전화번호  입력| ");
			nlist.get(x).setPhone(sc.next());
			System.out.println("수정되었습니다.");
			break;
		case 3:
			System.out.println("|이메일  입력| ");
			nlist.get(x).setEmail(sc.next());
			System.out.println("수정되었습니다.");
			break;
		default:
			System.out.println("|입럭오류! 다시 입력하세요.|");
			bl = true;
			break;
		}
		setFile(nlist);

		return bl;
	}

	public boolean deleteNameCard(String name) {
		boolean result = false;
		NameCard find = findNameCard(name);
		if (find != null) {
			if (nlist.remove(find)) {
				result = setFile(nlist);
			}
		}
		return result;
	}

	public void showAll() {
		for (NameCard a : nlist) {
			a.showInfo();
		}
	}

	public boolean setFile(ArrayList<NameCard> nal) {
		boolean result = true;
		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("namecard.dat"))));
			oos.writeObject(nlist);
		} catch (FileNotFoundException e) {
			result = false;
		} catch (IOException e2) {
			result = false;
		} catch (Exception e3) {
			result = false;
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				result = false;
			}
		}
		return result;
	}

	public ArrayList<NameCard> getFile() {
		ArrayList<NameCard> result = null;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("namecard.dat"))));
			result = (ArrayList<NameCard>) ois.readObject();
		} catch (FileNotFoundException e) {
		} catch (IOException e2) {
		} catch (Exception e3) {
		} finally {
			try {
				if (result == null) {
					result = new ArrayList<NameCard>();
				}
				ois.close();
			} catch (Exception e) {

			}
		}
		return result;
	}

}
