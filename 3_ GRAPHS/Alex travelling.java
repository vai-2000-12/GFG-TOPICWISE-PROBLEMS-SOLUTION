import java.util.*;

class Pair implements Comparable<Pair> {
    int x;
    int price;

    public Pair(int x, int price) {
        this.x = x;
        this.price = price;
    }

    @Override
    public int compareTo(Pair a) {
        return this.price - a.price;
    }
}

class Solution {
    int minimumCost(int[][] flights, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            graph.get(u).add(new Pair(v, w));
        }

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(k, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int node = curr.x;
            int currCost = curr.price;

            if (currCost > cost[node]) {
                continue;
            }

            for (Pair next : graph.get(node)) {
                int newNode = next.x;
                int newCost = next.price;

                if (cost[node] + newCost < cost[newNode]) {
                    cost[newNode] = cost[node] + newCost;
                    q.add(new Pair(newNode, cost[newNode]));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, cost[i]);
        }

        return max;
    }
}

