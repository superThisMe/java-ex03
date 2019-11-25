package lab.network;

import java.net.*;
import java.io.*;

public class SimpleServer {

	public static void main(String[] args) throws IOException {
		System.out.println("서버가 시작되었습니다.");
		while (true) {
			// 1. 서버 소켓 만들기
			// 2. Bind : IP, Port 할당
			// 3. Listen : 설정
			ServerSocket listener = new ServerSocket(9999, 100);

			// 4. 클라이언트의 연결을 기다리기 -> 연결되면 클라이언트와 연결된 통신 소켓 반환
			Socket socket = listener.accept();

			// 5. 읽기/쓰기 -> IO 객체 사용
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			InputStreamReader reader = new InputStreamReader(is); // String으로 읽을 수 있는 객체
			BufferedReader bReader = new BufferedReader(reader); // 행(버퍼) 단위로 읽을 수 있는 객체
			PrintStream ps = new PrintStream(os);

			String line = bReader.readLine();
			System.out.printf("[%s]: %s\n", socket.getRemoteSocketAddress(), line);
			ps.println("MESSEGE FROM SERVER : " + line);
			ps.flush(); // 남아있는 전송대기중인 데이터를 강제 전송

			// 6. 연결 끊기
			ps.close();
			bReader.close();
			socket.close();
			listener.close();
		}

	}

}
