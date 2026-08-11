class Solution {
    public int[] productExceptSelf(int[] nums) {
      int[] prefix = new int[nums.length];
      int[] suffix = new int[nums.length];
      int[] res = new int[nums.length];

      prefix[0] = suffix[nums.length - 1] = 1;

      for(int x = 1; x < nums.length; x++){
          prefix[x] = nums[x-1] * prefix[x-1];
      }

      for(int x = nums.length - 2; x >= 0; x--){
          suffix[x] = nums[x+1] * suffix[x+1];
      }

      for(int x = 0; x < nums.length; x++){
          res[x] = prefix[x] * suffix[x];
      }

      return res;
    }
}  
