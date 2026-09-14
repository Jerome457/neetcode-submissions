class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> a= new HashSet<>();
        while(n!=1){
            a.add(n);
            n=sums(n);
            if(a.contains(n))
                return false;
        }
        return true;
        
    }
    int sums(int temp){
        int sum=0;
        while(temp!=0){
            int r=temp%10;
            sum+=r*r;
            temp/=10;
        }
        return sum;
    }
}

