class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m=nums1.length;
        int n= nums2.length;

        if(m>n){
            return findMedianSortedArrays(nums2,nums1);
        }
        int u=m;
        int l=0;
        int cut1=0;
        int cut2=0;
        int left1=0,left2=0,right1=0,right2=0;
        while(l<=u){
            cut1=(l+u)/2;
            cut2=(m+n+1)/2-cut1;

            left1  = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            left2  = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if(left1<=right2 && left2<=right1)
                break;

            if(left1>right2)
                u=cut1-1;
            else
                l=cut1+1;
        }
        if((m+n)%2==1){
            return Math.max(left1,left2);
        }
        else
        return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
    }
}
