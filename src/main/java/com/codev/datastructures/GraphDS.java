package com.codev.datastructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class GraphDS {

    private static final Logger log = LoggerFactory.getLogger(GraphDS.class);

    static int V;                            // number of vertices
    static List<List<Integer>> adj;          // adjacency list

    // Build the graph
    static void init(int vertices) {
        V = vertices;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    // Add undirected edge (both directions)
    static void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Add directed edge (one direction only)
    static void addDirectedEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {

        log.info("========== GRAPH ==========");

        // Build this undirected graph:
        //   0 — 1 — 3
        //   |   |
        //   2   4

        init(5);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 3);
        addEdge(1, 4);

        log.info("--- Adjacency List ---");
        for (int i = 0; i < V; i++) {
            log.info("node {} → {}", i, adj.get(i));
        }
        // 0 → [1, 2]
        // 1 → [0, 3, 4]
        // 2 → [0]
        // 3 → [1]
        // 4 → [1]

        // ─────────────────────────────────────────
        // BFS — Breadth First Search
        // Explores level by level — uses Queue
        // Use for: shortest path (unweighted), level-by-level traversal
        // ─────────────────────────────────────────
        log.info("--- BFS from node 0 ---");
        bfs(0);

        // ─────────────────────────────────────────
        // DFS — Depth First Search
        // Goes as deep as possible before backtracking — uses Recursion
        // Use for: detecting cycles, connected components, topological sort
        // ─────────────────────────────────────────
        log.info("--- DFS from node 0 ---");
        boolean[] visited = new boolean[V];
        dfs(0, visited);

        // ─────────────────────────────────────────
        // ADJACENCY MATRIX — alternative representation
        // grid[i][j] = 1 means edge between i and j
        // Good for dense graphs or O(1) edge existence check
        // ─────────────────────────────────────────
        log.info("--- Adjacency Matrix ---");
        int nodes = 4;
        int[][] matrix = new int[nodes][nodes];
        matrix[0][1] = 1; matrix[1][0] = 1;   // edge 0-1
        matrix[1][2] = 1; matrix[2][1] = 1;   // edge 1-2
        matrix[2][3] = 1; matrix[3][2] = 1;   // edge 2-3

        for (int r = 0; r < nodes; r++) {
            log.info("row {} = {}", r, Arrays.toString(matrix[r]));
        }

        // Edge exists?
        log.info("edge 0-1 exists = {}", matrix[0][1] == 1);  // true
        log.info("edge 0-3 exists = {}", matrix[0][3] == 1);  // false

        // ─────────────────────────────────────────
        // DIRECTED GRAPH
        // ─────────────────────────────────────────
        log.info("--- Directed Graph ---");
        init(4);
        addDirectedEdge(0, 1);  // 0 → 1
        addDirectedEdge(1, 2);  // 1 → 2
        addDirectedEdge(2, 3);  // 2 → 3
        addDirectedEdge(3, 0);  // 3 → 0 (cycle)

        for (int i = 0; i < V; i++) {
            log.info("node {} → {}", i, adj.get(i));
        }

        // ─────────────────────────────────────────
        // COMPLEXITY
        // Build (adj list)     → O(V + E)
        // BFS / DFS            → O(V + E)
        // Edge check (matrix)  → O(1)
        // Edge check (list)    → O(degree)
        // Space (adj list)     → O(V + E)
        // Space (matrix)       → O(V²)
        // ─────────────────────────────────────────
    }

    static void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;   // mark BEFORE adding to queue
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            log.info("BFS visit      = {}", node);

            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;  // mark BEFORE adding
                    queue.offer(neighbour);
                }
            }
        }
    }

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        log.info("DFS visit      = {}", node);

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited);   // recurse deeper
            }
        }
    }
}
