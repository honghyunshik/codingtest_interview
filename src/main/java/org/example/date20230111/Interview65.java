package org.example.date20230111;

public class Interview65 {

    static int answer = 0;
    public static void main(String[] args){

        int[] nums = new int[]{-1,0,3,5,9,12};
        binary(nums,0,nums.length-1,9);
        System.out.println(answer);

    }

    public static int binarySearch(int[] nums, int target){

        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid-1;
            }else return mid;

        }
        return -1;
    }

    public static void binary(int[] nums, int l, int r, int target){

        int mid = (l+r)/2;
        if(l>r) {
            answer = -1;
            return;
        }
        if(nums[mid]<target){
            binary(nums,mid+1,r,target);
        }else if(nums[mid]>target){
            binary(nums,l,mid-1,target);
        }else {
            answer = mid;
            return;
        }
    }

}
