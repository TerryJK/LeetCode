// 17. Letter Combinations of a Phone Number
//
// Given a digit string, return all possible letter combinations that the number
// could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given
// below.
//
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// My java solution with FIFO queue

public List<String> letterCombinations(String digits) {
LinkedList<String> ans = new LinkedList<String>();
String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
ans.add("");
for(int i =0; i<digits.length();i++){
    int x = Character.getNumericValue(digits.charAt(i));
    while(ans.peek().length()==i){// key point
        String t = ans.remove();// key point
        for(char s : mapping[x].toCharArray())
            ans.add(t+s);// key point
    }
}
return ans;
}

// LinkedLinst -> peek()
// Retrieves, but does not remove, the head (first element) of this list.
