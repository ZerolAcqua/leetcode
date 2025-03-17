/*
 * @lc app=leetcode id=208 lang=java
 * @lcpr version=30005
 *
 * [208] Implement Trie (Prefix Tree)
 */


// @lcpr-template-start
// @lcpr-template-end

// @lc code=start
class Trie {

    private class TrieNode {
        Object val = null;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root = null;

    public Trie() {

    }

    public void insert(String word) {
        root = insert(root, word, 0, new Object());
    }

    public boolean search(String word) {
        TrieNode node = getNode(root, word);
        return node != null && node.val != null;
    }

    public boolean startsWith(String prefix) {
        return getNode(root, prefix) != null;
    }

    private TrieNode insert(TrieNode node, String word, int idx, Object val) {
        if (node == null) {
            node = new TrieNode();
        }

        if (idx == word.length()) {
            node.val = val;
            return node;
        }

        char c = word.charAt(idx);

        node.children[c - 'a'] = insert(node.children[c - 'a'], word, idx + 1, val);

        return node;
    }

    private TrieNode getNode(TrieNode node, String word) {
        if (node == null) {
            return null;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return null;
            }
            node = node.children[c - 'a'];
        }

        return node;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end



