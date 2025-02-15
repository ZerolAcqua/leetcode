/*
 * @lc app=leetcode id=785 lang=java
 * @lcpr version=20004
 *
 * [785] Is Graph Bipartite?
 */

// @lcpr-template-start
// @lcpr-template-end
// @lc code=start
class Solution {

    boolean[] visited;
    boolean[] color;
    boolean isBipartite = true;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            traverse(graph, i);
        }

        return isBipartite;
    }

    void traverse(int[][] graph, int s) {
        if (!isBipartite) {
            return;
        }

        visited[s] = true;
        boolean curColor = color[s];
        for (int node : graph[s]) {
            if (visited[node]) {
                if (curColor == color[node]) {
                    isBipartite = false;
                    return;
                }
            } else {
                color[node] = !curColor;
                traverse(graph, node);
            }
        }
    }
}

// @lc code=end
