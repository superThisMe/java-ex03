package ex_03;

public class Ex02BasicClasses {

	public static void main(String[] args) {
		
		//1. 문자열의 동일성 비교
		String str1 = "Hello";
		String str2 = "Hello";
		System.out.println("1." + str1.equals(str2)); //true
		System.out.println("2." + (str1 == str2) ); // ?
		
		str1 = new String("Hello");
		str2 = new String("Hello");
		System.out.println("3." + str1.equals(str2)); //true
		System.out.println("4." + (str1 == str2)); // ?
		
		//2. 고정 문자열
		String str3 = new String("Original String ");
		String str4 = str3;
		str4 = str4 + "Attached String"; // 문자열을 추가하는 순간 새로운 주소가 만들어짐
		System.out.println(str3 == str4);
		System.out.println(str3);
		System.out.println("------------");
		
		//3. 가변 문자열
//		StringBuilder sb = new StringBuilder(36);
		StringBuffer sb = new StringBuffer(36);
		sb.append("Original String ");
		sb.append("Attached String");
		System.out.println(sb.toString());
		
		//4. Primitive Type <==> String
		String s4 = String.valueOf(12.34);			//12.34 -> "12.34"
		int i4a = Integer.parseInt("12345");		//"12345" -> 12345
		int i4b = Integer.valueOf("12345");			//"12345" -> 12345
		double d4a = Double.parseDouble("12.34");	//"12.34" -> 12.34
		System.out.printf("%s / %d / %d / %f\n\n", s4, i4a, i4b, d4a);
		
		//5. String 지원 메서드
		String data = " 12345678901234567890 ";	//양 끝에 공백이 포함된 문자열 
		System.out.println("문자 갯수 : " + data.length());//문자 갯수 반환		
		data = data.trim(); //trim : 양끝 공백 제거
		System.out.println("공백 처리 후 문자 갯수 : " + data.length());//문자 갯수 반환
		
		System.out.println("0의 위치 앞에서 : " + data.indexOf("0"));//"0"의 위치 (앞에서 부터 검색)
		System.out.println("0의 위치 뒤에서 : " + data.lastIndexOf("0"));//"0"의 위치(뒤에서 부터 검색)
		
		System.out.println("5번째 문자부터 : " + data.substring(5));//5번째 문자부터 끝까지 반환
		System.out.println("5번째 ~ 10번째 : " + data.substring(5, 10));//5번째 부터 10번째 까지 반환
		
		String[] strs = "123;456;789;012;345".split(";");//문자열 분리 -> 배열 반환
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + "  ");
		}
		System.out.println();
		System.out.println("test string".contains("Str"));
		System.out.println("test string".endsWith("ing"));
		System.out.println("test string".startsWith("te"));
		
		//6. wrapper 클래스
		Object o;
		int x = 10;
		o = x; // 실제로는 : o = new Integer(x); // Auto Boxing : primitive -> reference
		//o = new Integer(x);
		System.out.println(o);
		int y = (int)o; // 실제로는 : int y = ((Integer)o).intValue(); // Auto Unboxing
		System.out.println(y);

	}

}












