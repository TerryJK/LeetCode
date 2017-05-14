
public class SlidingWindowMax{

  public static int [] swMax(int[] nums, int k){
    if(nums == null || k <= 0) return new int[0];

    int n = num.length;
    int[] res = new int[n - k + 1];
    int ri = 0;

    Deque<Integer> q = new ArrayDeque<>();
    for(int i = 0 ; i < n ; i++){

      q.offer(i);
      if(i >= k - 1){
        res[ri++] = num[q.peak()];
      }
    }//for



    return nums;
  }//swMax()

  public static void main(String args[]){
    int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
    int[] res = swMax(nums, 3);

    for(int n : res){
      System.out.print(n + " ");
    }

  }//main()

}//class
