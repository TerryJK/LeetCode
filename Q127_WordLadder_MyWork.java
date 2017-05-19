import java.util.*;

public class Q127_WordLadder_MyWork{
  List<String> dic;
  List<String> res = new ArrayList<String>();

  public int ladderLength(String beginWord, String endWord, List<String> wordList){
    dic = new ArrayList<String>(wordList);
    String a = beginWord;
    res.add(beginWord);

    int count = 0;
    while(count++ < wordList.size() && diff(res.get(res.size() - 1), endWord) != 1){
      for(String s : dic){
        if(diff(res.get(res.size() - 1), s) == 1){
          res.add(s);
          dic.remove(s);
          break;
        }
      }
    }
    res.add(endWord);
    System.out.println("res: " + res);
    System.out.println("size: " + res.size());

    return res.size();
  } // ladderLength

  public int diff(String a, String b){
    int n = 0;
    // Assume a and b have the same length
    for(int i = 0; i<a.length(); i++){
      if(a.charAt(i) != b.charAt(i)) n++;
    }
    return n;
  }

  public static void main(String args[]){
    Q127_WordLadder_MyWork wLedder = new Q127_WordLadder_MyWork();
    String beginWord = new String("hit");
    String endWord = new String("cog");

    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
    //List<String> wordList = Arrays.asList("hot", "dot", "drg", "lot", "tog", "eog", "lod", "lpf", "lor", "ccd");

    wLedder.ladderLength(beginWord, endWord, wordList);
  }//main
}
