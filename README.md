# Trie Structure Implementation in Java

### Project Description

The project involves writing Java classes to implement a trie that supports efficient word lookup in a dictionary. The implementation requires at least two classes: `TrieNode` and `Trie`. The trie must support various operations such as checking if a word exists, if a string is a prefix of any word in the trie, inserting and deleting words, checking if the trie is empty, clearing the trie, listing all words with a given prefix, and getting the size of the trie.

### Operations

1. `contains(String s)`: Checks if the word `s` exists in the trie.
2. `isPrefix(String p)`: Checks if `p` is a prefix of any word in the trie.
3. `insert(String s)`: Inserts the word `s` into the trie.
4. `delete(String s)`: Deletes `s` from the trie.
5. `isEmpty()`: Checks if the trie is empty.
6. `clear()`: Clears the trie.
7. `allWordsPrefix(String p)`: Returns all words in the trie that have `p` as a prefix.
8. `size()`: Returns the number of nodes in the trie.

### Initial Setup

Initially, the program will prompt the user for a list of letters or a word, generate all valid permutations of these letters, and insert them into the trie using a provided dictionary.

### Project Interface

The project should feature a menu-driven interface with options to create an empty trie, create a trie with initial letters, insert words, delete words, list all words with a certain prefix, check the size of the trie, and exit the program.

#### Menu Options

1. **Create an empty trie**: Initializes an empty trie.
2. **Create a trie with initial letters**: Prompts for a list of letters to generate and insert valid permutations into the trie.
3. **Insert a word**: Adds a new word to the trie.
4. **Delete a word**: Removes a word from the trie.
5. **List all words that begin with a prefix**: Displays words starting with the specified prefix.
6. **Size of the trie**: Displays the number of nodes in the trie.
7. **End**: Exits the program.


