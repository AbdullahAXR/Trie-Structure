import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TrieProject {
	public static Trie trie;
	public static Trie trieDic = insertWords("Dictionary.txt");
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Command();	
	}
	
	private static void Command() {
		String userInput = null;

		do {
			try {
			System.out.println("TRIE PROJECT: Enter your choice?");
			System.out.println("	   1) Create an empty trie");
			System.out.println("	   2) Create a trie with initial letters");
			System.out.println("	   3) Insert a word");
			System.out.println("	   4) Delete a word");
			System.out.println("	   5) List all words that begin with a prefix");
			System.out.println("	   6) Size of the trie");
			System.out.println("	   7) End");
			userInput = scanner.next();
			switch (userInput) {
			case "1":{
				trie = firstOption();
				System.out.println("An Empty trie has been created");
				break;
			}
			case "2":{
				trie = secondOption();
				break;
			}
			case "3":{
				if(check()) {
					System.out.println("Write a word: ");
					trie.insert(scanner.next());
				}
				else {
					throw new NullPointerException();
				}
				break;
			}
			case "4":{
				if(check()) {
					System.out.print("Write a word: ");
					String input = scanner.next();
					if(trie.contains(input)) {
						trie.delete(input);
						System.out.println();
					}
					else {
						System.out.println("Word can not be found.");
					}
				}
				else {
					throw new NullPointerException();
				}
				break;
			}		
			case "5":{
				if(check()) {
					System.out.println("Write a Prefix");
					String input = scanner.next();
					String[] allWord = trie.allWordsPrefix(input);
					System.out.printf("all words that begin with a %s :", input);
					for (String i : allWord) {
						System.out.print(i + " ");
					}
					System.out.println();
				}
				else {
					throw new NullPointerException();
				}
				break;
			}
			case "6":{
				if(check()) {
					System.out.println("Size of the Trie :"+ trie.size());
				}
				else {
					throw new NullPointerException();
				}
				break;
			}
			default:
				if(userInput.equals("7")) {
					return;
				}
				System.out.println("Write a Valid input");
			}
			}
			catch (NullPointerException e) {
				System.out.println("Please choose either choice 1 or 2 first");
			}
		}
		while(userInput != "7");
		
	}
	private static boolean check() {
		return trie != null;
	}
	private static Trie firstOption() {
		Trie trie = new Trie();
		return trie;
	}
	private static Trie secondOption() {
		Trie trie = new Trie();
		System.out.print("Enter your list of latters> (without spaces) ");
		String input = scanner.next();
		Set<String> a = generatePermutations(input);
		for(String i:a) {
			if(trieDic.contains(i)) {
				trie.insert(i);
			}
		}
		
		System.out.printf("Trie with initial letters (%s) has been created\n",input);
		return trie;
	}
	private static Trie insertWords(String path) {
		Trie trie = new Trie();
		File file = new File(path);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String string = scanner.next();
				trie.insert(string);
			}
			scanner.close();
			return trie;
		} catch (FileNotFoundException e) {
			System.out.println("The File does not exist.");
		}
		return null;
		
		
	}
	private static Set<String> generatePermutations(String input) {
        input = input.toUpperCase();
        Set<String> result = new HashSet<String>();
        permutations("", input, result);
        return result;
    }
    private static void permutations(String prefix, String letters, Set<String> result) {
        if (letters.length() == 0) {
        	if(trieDic.contains(prefix))
        		result.add(prefix);
        } else {
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                String otherLetters = letters.substring(0, i) + letters.substring(i + 1);
                System.out.println(prefix + " : " + i);
                permutations(prefix + letter, otherLetters, result);
                permutations(prefix, otherLetters, result);
            }
        }
    }
}
