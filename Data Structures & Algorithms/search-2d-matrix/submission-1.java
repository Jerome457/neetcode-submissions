class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int m=matrix.length-1;
        int n= matrix[0].length-1;
        int l=0;
        int mid=0;
        while(l<=m){
            row=(l+m)/2;

            if(matrix[row][0]<=target && target<=matrix[row][n])
                break;
            if(target<=matrix[row][n])
                m=row-1;
            else
                l=row+1;
        }
        if(l>m)
            return false;
        l=0;
        while(l<=n){
            mid=(l+n)/2;

            if(matrix[row][mid]==target)
                return true;
            if(matrix[row][mid]<target)
                l=mid+1;
            else
                n=mid-1;
        }
        return false;
    }
}
