import java.util.Stack;


class M042_Trapping_Rain_Water{
  public int trap(int[] A){
    int n = A.length;
    int left=0; int right=n-1;
      int res=0;
      int maxleft=0, maxright=0;
      while(left<=right){
          if(A[left]<=A[right]){
              if(A[left]>=maxleft) maxleft=A[left];
              else res+=maxleft-A[left];
              left++;
          }
          else{
              if(A[right]>=maxright) maxright= A[right];
              else res+=maxright-A[right];
              right--;
          }
      }
      return res;
  }

  public int trap2(int[] height){
    //
    int max = 0;
    Stack st = new Stack();
    for(int i =0; i<height.length; i++){
      // System.out.println(" " + height[i]);
      if(height[i] >= max){
        //
      }
    }

    // for(int i =0; i<height.length; i++){
    //   System.out.println(" " + height[i]);
    // }

    return 2;
  }// int trap

  public static void main(String args[]){
    M042_Trapping_Rain_Water water = new M042_Trapping_Rain_Water();

    int[] mat = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println("Trapping Rain Water : " + water.trap(mat));

  } // main
} // END
