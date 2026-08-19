class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        int row = top;

        while(top <= bottom){
            row = (top + bottom) / 2;
            if(matrix[row][0] <= target && matrix[row][matrix[row].length - 1] >= target){
                break;
            }else if(matrix[row][0] > target){
                bottom = row - 1;
            }else{
                top = row + 1;
            }
        }

        int l = 0;
        int r = matrix[row].length - 1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return false;
    }
}
