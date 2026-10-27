class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        int total = nums1.length + nums2.length;
        int half = (total + 1) / 2;

        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        int l = 0;
        int r = a.length;

        while(l <= r){
            int i = (l + r) / 2;
            int j = half - i;

            int al = i > 0 ? a[i-1] : Integer.MIN_VALUE;
            int ar = i < a.length ? a[i] : Integer.MAX_VALUE;
            int bl =  j > 0 ? b[j-1] : Integer.MIN_VALUE;
            int br = j < b.length ? b[j] : Integer.MAX_VALUE;

            if(ar >= bl && br >= al){
                if(total % 2 == 0){
                    return ((Math.max(al, bl) + Math.min(ar, br)) / 2.0);
                }
                return Math.max(al, bl);
            }else if(ar < bl){
                l = i + 1;
            }else{
                r = i - 1;
            }
        }

        return -1.0;
    }
}
