class Solution {
    List<List<String>> arr= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] a= new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                a[i][j]='.';
        }
        backtrack(a,0,n);
        return arr;
    }

    void backtrack(char[][]a, int index ,int n){
        if(index>=n){
            List<String> sub= new ArrayList<>();
            for(int i=0;i<a.length;i++){
                sub.add(String.valueOf(a[i]));
            }
            arr.add(sub);
            return;
        }
        
        for(int j=0;j<n;j++){
            if(validate(a,j,index)){
                a[j][index]='Q';
                backtrack(a,index+1,n);
            }
            a[j][index]='.';

        }
    }
    boolean validate(char [] [] a, int i,int j){

        for(int e=0;e<a.length;e++){
            for(int f=0;f<=j;f++){
                if(a[e][f]=='Q'){
                    if(e==i)
                        return false;
                    if(Math.abs(e-i)==Math.abs(f-j))
                        return false;
                }
            }
        }
        return true;
    }
}
