package googlecodejam;

import java.util.*;

/*
 * Problem

 At the Infinite House of Pancakes, there are only finitely many pancakes, but there are infinitely many diners who would be willing to eat them! When the restaurant opens for breakfast, among the infinitely many diners, exactly D have non-empty plates; the ith of these has Pi pancakes on his or her plate. Everyone else has an empty plate.

 Normally, every minute, every diner with a non-empty plate will eat one pancake from his or her plate. However, some minutes may be special. In a special minute, the head server asks for the diners' attention, chooses a diner with a non-empty plate, and carefully lifts some number of pancakes off of that diner's plate and moves those pancakes onto one other diner's (empty or non-empty) plate. No diners eat during a special minute, because it would be rude.

 You are the head server on duty this morning, and it is your job to decide which minutes, if any, will be special, and which pancakes will move where. That is, every minute, you can decide to either do nothing and let the diners eat, or declare a special minute and interrupt the diners to make a single movement of one or more pancakes, as described above.

 Breakfast ends when there are no more pancakes left to eat. How quickly can you make that happen?

 Input

 The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line with D, the number of diners with non-empty plates, followed by another line with D space-separated integers representing the numbers of pancakes on those diners' plates.

 Output

 For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the smallest number of minutes needed to finish the breakfast.

 Limits

 1 <= T <= 100.
 Small dataset

 1 <= D <= 6.
 1 <= Pi <= 9.
 Large dataset

 1 <= D <= 1000.
 1 <= Pi <= 1000.
 * 
 */
public class InfintePancake {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		while (T-- > 0) {
			int N = in.nextInt();
			List<Integer> items = new ArrayList<Integer>();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			int result = findMinutes(arr);
			list.add(result);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println("Case #" + (i+1) + ": " + list.get(i));
		}
	}

	private static int findMinutes(int[] stuff) {
		// TODO Auto-generated method stub
		int n = stuff.length;
		int answer = 1000;
		for (int i = 1; i <= 1000; i++) {
			int cur = i;
			for (int j = 0; j < n; j++) {
				cur += (stuff[j] - 1) / i;
			}
			answer = Math.min(answer, cur);
		}
		return answer;
	}

}
