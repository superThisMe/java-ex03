package lab.rps;

public class Swap {

	public void swapArr(String[] arr, int a, int b) {

		String array = arr[a];
		arr[a] = arr[b];
		arr[b] = array;

	}

}
