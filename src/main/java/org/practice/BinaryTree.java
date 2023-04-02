package org.practice;

public class BinaryTree {

    public static void main(String[] args){

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(binaryTree.root, 1);
        binaryTree.insertNode(binaryTree.root, 17);
        binaryTree.insertNode(binaryTree.root, 29);
        binaryTree.insertNode(binaryTree.root, 103);
        binaryTree.insertNode(binaryTree.root, 0);
        binaryTree.insertNode(binaryTree.root, 28);
        binaryTree.insertNode(binaryTree.root, 4);
        binaryTree.insertNode(binaryTree.root, 97);
        binaryTree.insertNode(binaryTree.root, 3);
        binaryTree.insertNode(binaryTree.root, 106);
        binaryTree.insertNode(binaryTree.root, 27);
        binaryTree.insertNode(binaryTree.root, 30);
        binaryTree.insertNode(binaryTree.root, 3);
        binaryTree.preOrder(binaryTree.root);
        binaryTree.removeNode(binaryTree.root,null,29);
        binaryTree.preOrder(binaryTree.root);

    }

    private class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }

    Node root;      //root 노드

    //recursion 방식으로 구성
    Node insertNode(Node node, int data){

        if(root==null){
            root = new Node(data);
            return root;
        }

        if(node==null) return new Node(data);

        if(node.data>data) node.left = insertNode(node.left,data);
        else if(node.data<data) node.right = insertNode(node.right,data);

        return node;
    }

    Node removeNode(Node node,Node back, int data){

        if(node==null) throw new RuntimeException("해당 노드가 없습니다");

        //node값 찾을 때까지 순회
        if(node.data<data) removeNode(node.right,node,data);
        else if(node.data>data) removeNode(node.left,node,data);
        //노드값 찾았을 때
        else{
            //자식노드가 없을 경우
            if(node.left==null&&node.right==null){
                node = null;
            }
            //자식노드가 한쪽만 있을 경우
            else if(node.left==null||node.right==null){
                Node next = null;
                if(node.left!=null){
                    next = node.left;
                }else{
                    next = node.right;
                }
                if(back.data>node.data) back.left=next;
                else if(back.data<node.data) back.right=next;
            }
            //자식노드가 둘 다 있을 경우
            else{
                Node min = getMinNode(node.right);      //오른쪽 자식 노드중 가장 작은 노드로 대체한다
                if(back.data>node.data) back.left = min;
                else if(back.data<node.data) back.right = min;
                min.left = node.left;
                if(min.data==node.right.data) min.right = node.right.right;
                else min.right = node.right.right;
            }
        }

        return node;
    }

    void preOrder(Node node){
        if(node==null) throw new RuntimeException("노드가 없습니다");
        System.out.println(node.data);
        if(node.left!=null) preOrder(node.left);
        if(node.right!=null) preOrder(node.right);
    }

    Node getMinNode(Node node){

        Node back = null;
        while(node.left!=null){
            back = node;
            node = node.left;
        }
        if(back!=null) back.left = null;
        return node;
    }


}
