class TrieNode {
    TrieNode[] child;
    public TrieNode(){
        child = new TrieNode[10];
    }
}
public class LongestCommonPrefixWithTrieNode {
    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
    static int longestCommonPrefix(int[] arr1, int[] arr2){
        TrieNode root = new TrieNode();
        for(int num : arr1){
            insert(root, num);
        }
        int maxPrefix = 0;
        for(int num : arr2){
            maxPrefix = Math.max(maxPrefix,search(root, num));
        }
        return maxPrefix;
    }
    static void insert(TrieNode root, int num){
        TrieNode node = root;
        String s = String.valueOf(num);
        for(char c : s.toCharArray()){
            int d = c - '0';
            if(node.child[d] == null){
                node.child[d] = new TrieNode();
            }
            node = node.child[d];
        }
    }
    static int search(TrieNode root, int num){
        String s = String.valueOf(num);
        TrieNode node = root;
        int count = 0;
        for(char c : s.toCharArray()){
            int d = c - '0';
            if(node.child[d] == null) break;
            node = node.child[d];
            count++;
        }
        return count;
    }
}

