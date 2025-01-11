//Binary tree travese 
//1st inorder tranvers

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();

            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            i++;
            if (i >= ip.length) break;

            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        Solution solution = new Solution(); // Create an instance of Solution

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            ArrayList<Integer> res =
                solution.preorder(root); // Call the preorder method
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> ans = new ArrayList<Integer>();
    // in preorder its root left then right 
    static void pre(Node root)
    {
        //base case
        if(root == null) return ;
        // add condtion
        ans.add(root.data);
        // recursive case 
        pre(root.left);
        pre(root.right);
        
        
    }
    static ArrayList<Integer> preorder(Node root) {
        // write code here
        ans.clear(); // always clear global variable before use
        pre(root);
        return ans;
        
    }
}

//inorder 
class Solution {
    ArrayList<Integer> now = new ArrayList<>();
    // in inorder left root right
    public void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        now.add(root.val);
        inorder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        now.clear();
        inorder(root);
        return now;
    }
}
//postorder


class Solution {
    ArrayList<Integer> now = new ArrayList<>();
    // in post left  right root
    public void post(TreeNode root)
    {
        if(root==null) return;
        post(root.left);
        post(root.right);
        now.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        now.clear();
        post(root);
        return now;
    }
}

// maxdepth 

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null ) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}

//each level travese

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            ArrayList<ArrayList<Integer>> res = g.levelOrder(root);
            for (ArrayList<Integer> level : res)
                for (Integer num : level) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

// level traves in a binary tree

class Solution {
    // Function to return the level order traversal of a tree.
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        //putting first root in queue
        q.add(root);
        
        //poping out the root and adding child in the queue poped out int the list
        while(q.size()>0)
        {
            ArrayList<Integer> current = new ArrayList<>();
            int size = q.size();
            while(size > 0)
            {   
                Node topnode = q.remove();
                current.add(topnode.data);
                if(topnode.left!=null) q.add(topnode.left);
                if(topnode.right!=null) q.add(topnode.right);
                size --;
            }
            ans.add(new ArrayList<>(current));
        }
        return ans;
        
    }
}


// same tree quetion 
// approch to check val of each from left and right and put it in and condtion if both are same its same tree
class Solution {
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true ;
        if(p == null || q == null) return false ;
        if(p.val==q.val) 
        {
            boolean left = isSameTree(p.left,q.left);
            boolean right = isSameTree(p.right,q.right);
            return (left && right); 
        }
        else return false;
    }
}


// lowest common ancestor


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //return value if found or else null
        if(root == null) return null;
        if(root == q || root == p) return root;
        // recur on left and right 
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // check and return the ans if found values both side return value
        if(left != null && right != null) return root;
        if(left != null ) return left;
        return right;


    }
}