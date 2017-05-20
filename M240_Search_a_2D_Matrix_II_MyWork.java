


class Q240_Search_a_2D_Matrix_II_MyWork{

  class Solution{
    public boolean searchMatrix(int[][] matrix, int target) {



      //printMatrix(matrix);
      boolean res = false;
      int i = 0, m = matrix.length;
      int j = 0, n = matrix[0].length;

      System.out.println("=m: " + m + " =n: " + n + " mat: " + matrix[4][4]);

      while(matrix[i][j] < target && ( i < (m - 1) || j < (n - 1) )){
      //while(matrix[i][j] < target){

        System.out.println("-i: " + i + " j: " + j);


        //if(matrix[i][j] == target) return true;
        //if(i == m - 1 && j == n - 1) break;
        // i++;
        // j++;
        if(i < m - 1) i++;
        if(j < n - 1) j++;

        System.out.println("+i: " + i + " j: " + j);

      }//while


      System.out.println("==== +i: " + i + " j: " + j);

      for(int c = i; c >= 0; c--){
        if( matrix[c][j] == target ){
          res = true;
          System.out.println("Found: c: " + c + " j: " + j);
        }
      }

      for(int c = j; c >= 0; c--){
        if( matrix[i][c] == target ){
          res = true;
          System.out.println("Found: i: " + i + " c: " + c);
        }
      }



      return res;

    } // searchMatrix


      public void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
          for(int j = 0; j < matrix[0].length; j++){
            System.out.print(matrix[i][j] + " " );
          }
          System.out.println();
        }

      }
  } // Solution




public static void main(String args[]){

  int[][] mat = new int[][]{
    {1,   4,  7, 11, 15},
    {2,   5,  8, 12, 19},
    {3,   6,  9, 16, 22},
    {10, 13, 14, 17, 24},
    {18, 21, 23, 26, 30}
  };

  int[][] mat2 = new int[][]{
    {1,   4,  7, 11, 15, 35, 51},
    {2,   5,  8, 12, 19, 39, 52},
    {3,   6,  9, 16, 22, 42, 57},
    {10, 13, 14, 17, 24, 47, 69},
    {18, 21, 23, 26, 30, 50, 70}
  };

  int target = 51;

  Q240_Search_a_2D_Matrix_II_MyWork pro = new Q240_Search_a_2D_Matrix_II_MyWork();
  Solution sol = pro.new Solution();

  if(sol.searchMatrix(mat2, target)){
    System.out.println(target + " is exist in the matrix");
  }else{
    System.out.println(target + " is NOT exist in the matrix");
  }



} // main
} // class Q240_Search_a_2D_Matrix_II_MyWork
