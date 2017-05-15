
import java.lang.Character;
import java.util.*;

class FirstUniqueChar{
  int a;

  public FirstUniqueChar(){
    a = 0;
  }

  private int firstUniqChar(String s){
    int[] freq = new int[26];

    for(char c : s.toCharArray()){
      //System.out.println(c - 'a' + " ");
      freq[c - 'a']++;
    }

    int i = 0;
    for(char c : s.toCharArray()){

      //System.out.println(c - 'a' + " ");
      //if( freq[c - 'a'] == 1) System.out.println(" GOT IT !!!  => " + c);
      if( freq[c - 'a'] == 1) return i;
      i++;
    }

    /*
    for(int i : freq){
      System.out.println(i + " - ");
      //if(i == 1) System.out.println(i + " GOT IT !!!" + Character.toChars(1));
      if(i == 1) System.out.println(i + " GOT IT !!!" + char('a'+2));
    }
    */


    return -1;
  }

  public static void main(String args[]){
    FirstUniqueChar f = new FirstUniqueChar();
    String s = "fesejkipslkjdjeofjoslfejicfesejkiza";
    int i = f.firstUniqChar(s);

    System.out.println("first unique char index is " + i + " which is " + s.charAt(i) + ".");
    return;
  }
}
