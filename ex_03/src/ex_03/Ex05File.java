package ex_03;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex05File {

	public static void main(String[] args) {

		// C:\Windows 디렉토리를 관리하는 객체 만들기
		File winDir = new File("C:\\Windows");
		// if (winDir.isDirectory() == false) { // 디렉토리라면 true 반환
		if (!winDir.isDirectory()) { // ! : 논리부정연산자 -> !true == false / !false == true
			System.out.println("정상적인 디렉토리(폴더)가 아닙니다.");
			return;
		}

		// winDir 객체가 관리하는 디렉토리에 포하된 모든 파일 및 디렉토리를 파일 객체에 담아서 배열로 반환
		File[] filesOrDirs = winDir.listFiles();
		for (File fileOrDir : filesOrDirs) {
//			System.out.println(fileOrDir.getAbsolutePath()); // getAbsolutePath : 절대 경로 반환

			// 시간을 "2019-10-28 오후 04:27" 과 같은 형식의 문자열로 변환하는 객체 만들기
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			// java.util.Date : 날짜와 시간을 관리하는 클래스, 경과시간으로 객체 생성(ms)
			Date lastModified = new Date(fileOrDir.lastModified());

			if (fileOrDir.isDirectory()) { // 디렉토리인 경우
				System.out.printf("%s%7s%12s  %s\n", f.format(lastModified), "<DIR>", "", fileOrDir.getName()); // lastModified : 최종 수정 일자
			} else { // 파일인 경우
				System.out.printf("%s%7s%12d  %s\n", f.format(lastModified), "", fileOrDir.length(), fileOrDir.getName()); // File.length() : 파일의 크기 (byte)
			}
		}
	}

}
