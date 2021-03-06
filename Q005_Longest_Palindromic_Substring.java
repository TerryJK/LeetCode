
// 5. Longest Palindromic Substring
//
//
// Very simple clean java solution
// The performance is pretty good, surprisingly.

public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;

    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}


// ==================================
// Simple C++ solution (8ms, 13 lines)

string longestPalindrome(string s) {
    if (s.empty()) return "";
    if (s.size() == 1) return s;
    int min_start = 0, max_len = 1;
    for (int i = 0; i < s.size();) {
      if (s.size() - i <= max_len / 2) break;
      int j = i, k = i;
      while (k < s.size()-1 && s[k+1] == s[k]) ++k; // Skip duplicate characters.
      i = k+1;
      while (k < s.size()-1 && j > 0 && s[k + 1] == s[j - 1]) { ++k; --j; } // Expand.
      int new_len = k - j + 1;
      if (new_len > max_len) { min_start = j; max_len = new_len; }
    }
    return s.substr(min_start, max_len);
}

// ==================================
// (AC) relatively short and very clear Java solution÷

// Key idea, every time we move to right, we only need to consider whether using
// this new character as tail could produce new palindrome string of length
// (current length +1) or (current length +2)

// For friends who are confused about the key idea to check only new palindrome
// with length = current length +2 or +1, I add some more explanation here.

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
        	if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}


// For friends who are confused about the key idea to check only new palindrome with
// length = current length +2 or +1, I add some more explanation here.
//
// Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now we
// are dealing with the last character 'a'. The current longest palindrome is "bcb"
// with length 3. 1. check "xxxxa" so if it is palindrome we could get a new
// palindrome of length 5.
//
// 2. check "xxxa" so if it is palindrome we could get a new palindrome of length
// 4.
//
// 3. do NOT check "xxa" or any shorter string since the length of the new string
// is  no bigger than current longest length.
//
// 4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome
// then "xxxx" got  from cutting off the head and tail is also palindrom. It has  length > 3 which is impossible.'




// ==================================
// Share my Java solution using dynamic programming

// dp(i, j) represents whether s(i ... j) can form a palindromic substring,
// dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic
// substring. When we found a palindrome, check if it's the longest one. Time
// complexity O(n^2).

public String longestPalindrome(String s) {
  int n = s.length();
  String res = null;

  boolean[][] dp = new boolean[n][n];

  for (int i = n - 1; i >= 0; i--) {
    for (int j = i; j < n; j++) {
      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
        res = s.substring(i, j + 1);
      }
    }
  }

  return res;
}


// ==================================


// ==================================
