import java.util.HashMap;

public class TrieNode {
	
	protected HashMap<Character, TrieNode> node;
	protected boolean isWord;
	protected Character el ;
	public TrieNode() {
		this.node = new HashMap<Character, TrieNode>();
	}
	public TrieNode(Character el) {
		this.node = new HashMap<Character, TrieNode>();
		this.el = el;
	}
	
	public void setisWord(boolean state) {
		this.isWord = state;
	}
	public HashMap<Character, TrieNode> getNode(){
		return node;
	}
	public void setEl(Character el) {
		this.el = el;
	}
	public Character getEl() {
		return el;
	}
	
}
