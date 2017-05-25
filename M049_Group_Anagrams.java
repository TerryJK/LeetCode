
// 49. Group Anagrams

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class M049_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
          System.out.println("str: " + s);
            char[] ca = s.toCharArray();
            Arrays.sort(ca);

            String keyStr = String.valueOf(ca);
            System.out.println("sort: " + keyStr);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }

        System.out.println("RES: " + map.values());

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String args[]){
      //String [] str = new String(){"eat", "tea", "tan", "ate", "nat", "bat"};
      String [] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
      M049_Group_Anagrams ga = new M049_Group_Anagrams();
      ga.groupAnagrams(str);
    }
}
