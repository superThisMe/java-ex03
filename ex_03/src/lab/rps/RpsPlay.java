package lab.rps;

import java.util.Arrays;

public class RpsPlay {

	public String play() {

		String[] arr = { "가위", "바위", "보" };
		String result[] = new String[arr.length];
		Swap swap = new Swap();
		String cResult = null;

		result = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < result.length; i++) {

			swap.swapArr(result, i, (int) (Math.random() * 3));

		}
		cResult = result[1];
		return cResult;
	}
	
	public int getResult(String a, String b) {
		int result = 0; // 0: lose, 1: win, 2: draw
		if (a.equals("가위") && b.equals("보") || a.equals("바위") && b.equals("가위") || a.equals("보") && b.equals("바위")) {
			result = 1;
		} else if (a.equals(b)) {
			result = 2;
		}
		return result;
	}
}
