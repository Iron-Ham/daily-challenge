/*
When someone makes a search, a search engine shows the title of the page.
The task here is to show a short snippet of the page containing the terms that were searched for.

Write a function which returns the shortest snippet of the document, containing all of the given
terms. The length of the snippet is the number of words in the snippet. For example, the length of
"hello my name is" is 4.

The document will be a string of only lower case letters [a-z] and spaces. Words in the string will
be separated by a single place. Words may appear multiple times in one document.

searchTerms is a list of words, each word comprised of lowercase letters. Each search term is
distinct.

Search terms must match exactly.

Return the first substring if multiple substrings are shortest. For example, if the document is
"world there hello hello where world" and the search terms are ["hello", "world"], you must return
"world there hello".

The number of words in the document will be at least one, will not exceed 500, and each word will be
1 to 10 letters long. Repeat words in the document are considered distinct for counting purposes.

The number of words in searchTerms will be at least one, will not exceed 100, and each word will
not be more than 10 letters long.

Test cases
==========

Inputs:
    (string) document = "many google employees can program"
    (string list) searchTerms = ["google", "program"]
Output:
    (string) "google employees can program"

Inputs:
    (string) document = "a b c d a"
    (string list) searchTerms = ["a", "c", "d"]
Output:
    (string) "c d a"

 */


public class SearchEngineSnippets {

	///The index and contents of a matched search term
	public static class KeyWord {
		int index;
		String text;

		public KeyWord(int index, String text) {
			this.index = index;
			this.text = text;
		}
	}

	///The range of words that make up a complete set of search terms.
	public static class Path {
		int startIndex;
		int endIndex;
		int pathLength;

		public Path() {
			startIndex = -1;
			endIndex = -1;
			pathLength = Integer.MAX_VALUE;
		}

		public Path(int startIndex, int endIndex) {
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			pathLength = endIndex - startIndex;
		}

		public String toString() {
			return "Start Index: " + startIndex + ", End Index: " + endIndex + ", Path Length: " + pathLength;
		}
	}

	public static String answer(String document, String[] searchTerms) {
		///Seperate the words based on spaces
		String[] documentWords = document.split(" ");
		Path shortestPath = new Path();
		List<KeyWord> searchHits = new ArrayList<KeyWord>();
		for (int i = 0; i < documentWords.length; i++) {
			for (String word : searchTerms) {
				if (documentWords[i].equals(word)) {
					KeyWord currentWord = new KeyWord(i, word);
					if (searchHits.isEmpty()) {
						searchHits.add(currentWord);
					}
					///Clear the current list of hits, and continue from the next node
					else if (currentWord.text.equals(searchHits.get(0).text)) {
						i = searchHits.get(0).index;
						searchHits.clear();
					}
					else {
						boolean found = false;
						for (KeyWord k : searchHits) {
							if (k.text == word) {
								found = true;
								break;
							}
						}
						if (!found) {
							searchHits.add(currentWord);
						}
					}
					break; //We no longer have to continue searching the array of terms
				} else {
					continue; //Keep searching the array of terms
				}
			}
			if (searchHits.size() == searchTerms.length) {
				///Determine whether the found path is the shortest encountered path
				Path currentPath = new Path(searchHits.get(0).index, searchHits.get(searchHits.size() - 1).index);
				if (currentPath.pathLength < shortestPath.pathLength) {
					shortestPath = currentPath;
				}
				///Clear the results to find other paths.
				i = searchHits.get(0).index;
				searchHits.clear();
			}
		}
		///Construct the answer from the shortest path
		String answer = "";
		for (int i = shortestPath.startIndex; i <= shortestPath.endIndex; i++) {
			answer += documentWords[i] + " ";
		}
		answer = answer.trim();
		return answer;
	}
}
