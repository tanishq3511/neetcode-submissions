class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        int half = (nums1.length + nums2.length + 1)/2;

        if(b.length<a.length){
            int[] temp = a;
            a = b;
            b = temp;
        }

        int l = 0, r = a.length; 
        while(l<=r){
            int i = (l+r)/2;
            int j = half-i;

            int aLeft, bLeft, aRight, bRight;
            if(i>0){
                aLeft = a[i-1];
            }else{
                aLeft = Integer.MIN_VALUE;
            }
            if(j>0){
                bLeft = b[j-1];
            }else{
                bLeft = Integer.MIN_VALUE;
            }
            if(i<a.length){
                aRight = a[i];
            }else{
                aRight = Integer.MAX_VALUE;
            }
            if(j<b.length){
                bRight = b[j];
            }else{
                bRight = Integer.MAX_VALUE;
            }

            if(aLeft <= bRight && bLeft <= aRight){
                if((nums1.length + nums2.length)%2 == 1){
                    return Math.max(aLeft, bLeft);
                }
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2.0;
            }else if(aLeft > bRight){
                r = i-1;
            }else{
                l = i+1;
            }
        }

        return -1;
    }
}
