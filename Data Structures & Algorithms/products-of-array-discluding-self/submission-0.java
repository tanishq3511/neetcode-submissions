class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        prefix[0] = 1;
        postfix[nums.length-1] = 1;

        for(int x=1; x<nums.length; x++){
            prefix[x] = prefix[x-1]*nums[x-1];
        }

        for(int x=nums.length-2; x>=0; x--){
            postfix[x] = postfix[x+1]*nums[x+1];
        }
        
        for(int x=0; x<nums.length; x++){
            res[x] = prefix[x]*postfix[x];
        }
        
        return res;
    }
}  
