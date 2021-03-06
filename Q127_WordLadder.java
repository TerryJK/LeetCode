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


// Two-end BFS in Java 31ms.

public class Solution {

public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

	int len = 1;
	int strLen = beginWord.length();
	HashSet<String> visited = new HashSet<String>();

	beginSet.add(beginWord);
	endSet.add(endWord);
	while (!beginSet.isEmpty() && !endSet.isEmpty()) {
		if (beginSet.size() > endSet.size()) {
			Set<String> set = beginSet;
			beginSet = endSet;
			endSet = set;
		}

		Set<String> temp = new HashSet<String>();
		for (String word : beginSet) {
			char[] chs = word.toCharArray();

			for (int i = 0; i < chs.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char old = chs[i];
					chs[i] = c;
					String target = String.valueOf(chs);

					if (endSet.contains(target)) {
						return len + 1;
					}

					if (!visited.contains(target) && wordList.contains(target)) {
						temp.add(target);
						visited.add(target);
					}
					chs[i] = old;
				} //for (char c = 'a'; c <= 'z'; c++) {
			} //for (int i = 0; i < chs.length; i++) {
		}

		beginSet = temp;
		len++;
	}

	return 0;
}
}
