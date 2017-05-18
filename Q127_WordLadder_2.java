127. Word Ladder


// Given two words (beginWord and endWord), and a dictionary's word list, find
// the length of shortest transformation sequence from beginWord to endWord,
// such that:
//
// 1. Only one letter can be changed at a time.
// 2. Each transformed word must exist in the word list. Note that beginWord is
//    not a transformed word.
//
// For example,
//
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
//
// Note:
// - Return 0 if there is no such transformation sequence.
// - All words have the same length.
// - All words contain only lowercase alphabetic characters.
// - You may assume no duplicates in the word list.
// - You may assume beginWord and endWord are non-empty and are not the same.
//
// UPDATE (2017/1/20):
// The wordList parameter had been changed to a list of strings (instead of a
// set of strings). Please reload the code definition to get the latest changes.


// ===================== Another Java Solution ==============================


public int ladderLength(String start, String end, Set<String> dict) {
  // Use queue to help BFS
  Queue<String> queue = new LinkedList<String>();
  queue.add(start);
  queue.add(null);

  // Mark visited word
  Set<String> visited = new HashSet<String>();
  visited.add(start);

  int level = 1;

  while (!queue.isEmpty()) {
    String str = queue.poll();

    if (str != null) {
      // Modify str's each character (so word distance is 1)
      for (int i = 0; i < str.length(); i++) {
        char[] chars = str.toCharArray();

        for (char c = 'a'; c <= 'z'; c++) {
          chars[i] = c;

          String word = new String(chars);

          // Found the end word
          if (word.equals(end)) return level + 1;

          // Put it to the queue
          if (dict.contains(word) && !visited.contains(word)) {
            queue.add(word);
            visited.add(word);
          }
        }
      }
    } else {
      level++;

      if (!queue.isEmpty()) {
        queue.add(null);
      }
    }
  }

  return 0;
}
