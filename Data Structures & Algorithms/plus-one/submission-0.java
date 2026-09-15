class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> arr= new ArrayList<>();
        int n=digits.length;
        digits[n-1]+=1;
        if(digits[n-1]<10){
            return digits;
        }
        else{
            digits[n-1]-=1;
            int carry=1;
            for(int i=n-1;i>=0;i--){
                if(carry==0)
                    break;
                digits[i]=digits[i]+carry;
                carry=digits[i]/10;
                digits[i]=digits[i]%10;
            }
            if(carry==0)
                return digits;
            else{
                int[] result = new int[digits.length + 1];
                result[0] = 1; 
                System.arraycopy(digits, 0, result, 1, digits.length);
                return result;
            }
        }
    }
}
