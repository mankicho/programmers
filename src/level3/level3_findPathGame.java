package level3;

import java.util.*;

public class level3_findPathGame {
    public static void main(String[] args) {
        new level3_findPathGame().solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        Tree tree = new Tree();
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            map.put(nodeinfo[i], i + 1);
        }
        Arrays.sort(nodeinfo, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        System.out.println(Arrays.deepToString(nodeinfo));
        for (int i = 0; i < nodeinfo.length; i++) {
            int[] node = nodeinfo[i];
            Node n = new Node(map.get(node), node[0]);
            tree.add(n);
        }

        Node root = tree.root;

        tree.preOrder(root);
        tree.postOrder(root);
        List<Integer> pre = tree.preResult;
        List<Integer> post = tree.postResult;

        int[] preArr = new int[pre.size()];
        int[] postArr = new int[post.size()];

        for (int i = 0; i < preArr.length; i++) {
            preArr[i] = pre.get(i);
            postArr[i] = post.get(i);
        }

        answer = new int[][]{preArr, postArr};
        return answer;
    }
}

class Node {
    Node left;
    Node right;
    int value;
    int x;

    public Node(int value, int x) {
        this.value = value;
        this.x = x;
    }

    public String toString() {
        return this.value + "";
    }
}

class Tree {
    Node root;

    List<Integer> preResult = new ArrayList<>();
    List<Integer> postResult = new ArrayList<>();

    public void preOrder(Node root) {
        if (root != null) {
            preResult.add(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            postResult.add(root.value);
        }
    }

    public void add(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        Node tmp = root;
        boolean isLeft;
        while (true) {
            int v = node.x;
            Node pre = tmp;
            if (v > tmp.x) {
                tmp = tmp.right;
                isLeft = false;
            } else {
                tmp = tmp.left;
                isLeft = true;
            }

            if (tmp == null) {
                if (isLeft) {
                    pre.left = node;
                } else {
                    pre.right = node;
                }
                break;
            }
        }
    }

}