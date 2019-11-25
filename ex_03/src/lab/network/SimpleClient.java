package lab.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("메시지를 입력하세요(종료는 q) : ");
			String message = sc.nextLine();

			if (message.equalsIgnoreCase("q")) {
				break;
			}

			// 1. 소켓 만들기
			// 2. 서버에 연결 ("ip", port)
			Socket socket = new Socket("172.16.6.31", 9999);

			// 3. 읽기/쓰기 -> IO 객체 사용
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			InputStreamReader reader = new InputStreamReader(is); // String으로 읽을 수 있는 객체
			BufferedReader bReader = new BufferedReader(reader); // 행(버퍼) 단위로 읽을 수 있는 객체
			PrintStream ps = new PrintStream(os);

			ps.println(message); // 서버에게 데이터 쓰기
			ps.flush(); // 남아있는 전송대기중인 데이터를 강제 전송
			String line = bReader.readLine(); // 서버가 보낸 데이터 읽기
			System.out.println(line);

			// 4. 연결 종료
			ps.close();
			bReader.close();
			socket.close();
		}

	}

}
