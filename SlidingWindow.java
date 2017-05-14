import java.util.Deque;
import java.util.ArrayDeque;



public class SlidingWindow{
	String a;

	SlidingWindow(){
		a = "sliding window max";
	}


public static int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || k <= 0) {
			return new int[0];
		}
		int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
	}

	public static void main(String args[]) {
		int[] a = new int[] {3,3,5,5,6,7};
		//SlidingWindow max = new SlidingWindow(a, 3);
		int[] max = new int[5];
		max  = maxSlidingWindow(a, 3);

		for(int m: max){
			System.out.println("max:" + m);
		}


	}

}
