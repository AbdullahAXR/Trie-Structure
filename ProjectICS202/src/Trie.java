import java.util.ArrayList;


public class Trie {
	protected TrieNode root = null;
	
	Trie(){
		this.root = new TrieNode();
	}
	public void insert(String word){
        TrieNode current = root;
        int length = word.length();
        for (int i = 0; i < length; i++){
            char latter = word.charAt(i);
            TrieNode node = current.getNode().get(latter);
            if(node == null) {
            	node = new TrieNode();
            	current.getNode().put(latter, node);
            }
            current = node;
        }
        current.setisWord(true);
    }
	
	public boolean contains(String s) {
		TrieNode current = root;
		int length = s.length();
		for(int i = 0; i < length ; i++) {
			char latter = s.charAt(i);
			TrieNode node = current.getNode().get(latter);
			if(node == null || (i == length - 1 && !node.isWord)) {
				return false;
			}
			current = node;
		}
		return true;
	}
	public boolean prefix(String p) {
		TrieNode current = root;
		int length = p.length();
		for(int i = 0; i < length ; i++) {
			char latter = p.charAt(i);
			TrieNode node = current.getNode().get(latter);
			if(node == null) {
				return false;
			}
			current = node;
		}
		return current != null;
	}
	
	public void delete(String s) {
		TrieNode inverseCurrent = reachLastLatterNode(s);
		inverseCurrent.setisWord(false);
		for(int i = s.length() - 1 ; i >= 0; i--) {
			inverseCurrent = reachLastLatterNode(s.substring(0,i+1));
			TrieNode inverseCurrent2 = reachLastLatterNode(s.substring(0,i));
			if(inverseCurrent.getNode().size() == 0) {
				inverseCurrent2.getNode().remove(s.charAt(i));
			}
			else {
				return;
			}
		}
	}
	public TrieNode reachLastLatterNode(String s) {
		TrieNode current = root;
		for(int i = 0; i < s.length();i++) {
			char latter = s.charAt(i);
			if(current != null) {
				TrieNode node = current.getNode().get(latter);
				if(node != null) {
					current = node;
				}
			}
		}
		return current;
	}
	
	public boolean isEmpty() {
		return root.getNode().isEmpty();
	}
	
	public void clear() {
		root.getNode().clear();
	}
	public int size() {
		return size(root);
	}
	public int size(TrieNode node) {
		if(node == null) {
			return 0;
		}
		else {
			int count = 0;
			for(Character i:node.getNode().keySet()) {
				count += 1+size(node.getNode().get(i));
			}
			return count;
		}
	}
	
	public String[] allWordsPrefix(String p) {
		ArrayList<String> arrayList = allWordsPrefixHelper(p);
		String[] array = new String[arrayList.size()];
		return arrayList.toArray(array);
	}
	
	private ArrayList<String> allWordsPrefixHelper(String p){
		ArrayList<String> list = new ArrayList<String>();
		TrieNode lastLatter = reachLastLatterNode(p);
		if(lastLatter.getNode().size() == 0) {
			list.add(p);
			return list;
		}else{
			for(Character i: lastLatter.getNode().keySet()) {
				if(lastLatter.getNode().get(i).isWord == true) {
					list.add(p+i);
				}
				if (lastLatter.getNode().get(i).getNode().size()> 0) {
					list.addAll(allWordsPrefixHelper(p+i));
				}
				
			}
			return list;
		}
	}
}
