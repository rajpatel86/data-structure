
import java.util.Scanner;
public class Lab_15_82{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of nodes : ");
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] postorder = new int[n];
        System.out.println("Enter preorder traversal : ");
        for(int i=0; i<n; i++){
            System.out.println("Enter value of preorder["+i+"] : ");
            preorder[i] = sc.nextInt();
        }
        System.out.println("Enter postorder traversal : ");
        for(int i=0; i<n; i++){
            System.out.println("Enter value of postorder["+i+"] : ");
            postorder[i] = sc.nextInt();
        }
        BinaryTree bt = new BinaryTree();
        bt.root = bt.buildTree(preorder, postorder, 0, n-1,0,n-1);
        System.out.println("Display in Inorder : ");
        bt.displayInorder(bt.root);
    }
}
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        left=right=null;
        this.data=data;
    }
}
class BinaryTree{
    Node root;
    BinaryTree(){
        root=null;
    }
    Node buildTree(int[] preorder,int[] postorder,int preStart,int preEnd,int postStart,int postEnd){
        if(preStart>preEnd || postStart>postEnd){
            return null;
        }
        Node root = new Node(preorder[preStart]);
        if(preStart==preEnd || postStart==postEnd){
            return root;
        }
        int nextRootValue=preorder[preStart+1];
        int index=postStart;
        while(index<=postEnd && postorder[index]!=nextRootValue){
            index++;
        }
        int leftSubtreeSize = index-postStart+1;
        root.left = buildTree(preorder,postorder,preStart+1,preStart+leftSubtreeSize,postStart,index);
        root.right = buildTree(preorder,postorder,preStart+leftSubtreeSize+1,preEnd,index+1,postEnd-1);
        return root;
    }
    void displayInorder(Node node){
        if(node==null){
            return;
        }
        displayInorder(node.left);
        System.out.print(node.data+" ");
        displayInorder(node.right);
    }
}
