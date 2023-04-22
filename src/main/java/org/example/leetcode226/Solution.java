package org.example.leetcode226;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}





class Solution {

    public static void main(String[] args){
        Solution sol = new Solution();
        TreeNode root = new TreeNode(2,new TreeNode(3,new TreeNode(1,null,null),null),null);
        TreeNode node = sol.invertTree(root);

        TreeNode node1 = new TreeNode(1,null,null);
    }

    public TreeNode invertTree(TreeNode root) {

        //tree -> list

        ArrayList<Integer> list = treeToList(root);
        Integer[] arr = changeNode(list);

        TreeNode node = arrToNode(null, arr);
        return node;
    }

    private void proOrder(TreeNode node){


    }

    private TreeNode arrToNode(TreeNode node, Integer[] arr){

        if(arr.length>0) node = new TreeNode(arr[0],null,null);
        int idx = 1;
        int k = 1;
        ArrayList<TreeNode> list = new ArrayList<>();
        if(node!=null) list.add(node);

        while(idx<arr.length){

            ArrayList<TreeNode> temp = new ArrayList<>();
            for(TreeNode treeNode:list){
                if(idx<arr.length){
                    if(treeNode!=null) {

                        if(arr[idx]==null){
                            treeNode.left = null;
                            idx++;
                        }else{
                            treeNode.left = new TreeNode(arr[idx++],null,null);
                            temp.add(treeNode.left);
                        }

                    }
                }
                if(idx<arr.length){
                    if(treeNode!=null){
                        if(arr[idx]==null){
                            treeNode.right = null;
                            idx++;
                        }else{
                            treeNode.right = new TreeNode(arr[idx++],null,null);
                            temp.add(treeNode.right);
                        }

                    }

                }
            }

            list = new ArrayList<>(temp);

        }


        return node;
    }

    private Integer[] changeNode(ArrayList<Integer> list){

        Integer[] arr = list.toArray(new Integer[0]);

        int k = 1;
        int sum = 1;
        while(sum<=arr.length){

            for(int i=sum-k;i<sum-k/2;i++){
                int j = (k-1)*3-i;
                swap(arr,i,j);
            }

            k*=2;
            sum+=k;
        }
        return arr;
    }

    private void swap(Integer[] arr, int a, int b){

        Integer temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private ArrayList<Integer> treeToList(TreeNode root){

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        if(root!=null) nodeList.add(root);
        if(root!=null) list.add(root.val);
        while(true){
            boolean flag = false;

            ArrayList<TreeNode> temp = new ArrayList<>();
            for(TreeNode node:nodeList){
                if(node!=null){
                    if(node.left!=null){
                        temp.add(node.left);
                        flag = true;
                    }else{
                        temp.add(null);
                    }
                    if(node.right!=null){
                        temp.add(node.right);
                        flag = true;

                    }else {
                        temp.add(null);
                    }

                }

            }
            if(temp.size()==0||!flag) break;
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)==null) list.add(null);
                else list.add(temp.get(i).val);
            }

            nodeList = new ArrayList<>(temp);
        }

        return list;
    }
}