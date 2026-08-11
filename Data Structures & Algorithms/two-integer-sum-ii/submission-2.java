class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;;
        while(numbers[start] + numbers[end] != target && start < end){
            if(numbers[start] + numbers[end]<target){
                start++;
            }else{
                end--;
            }
        }

        int[] pair = new int[2];
        pair[0] = ++start;
        pair[1] = ++end;

        return pair;
    }
}
