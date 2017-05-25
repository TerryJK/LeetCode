
// 49. Group Anagrams

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class Q049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String args[]){
      //String [] str = new String(){"eat", "tea", "tan", "ate", "nat", "bat"};
      String [] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
      Q049_Group_Anagrams ga = new Q049_Group_Anagrams();
      ga.groupAnagrams(str);
    }
}
