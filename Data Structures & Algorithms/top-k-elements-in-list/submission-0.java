class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> a= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            a.putIfAbsent(nums[i],0);
            a.put(nums[i],a.get(nums[i])+1);
        }

        int b[]= new int[k];

        for(int i=0;i<k;i++){
            int maxKey = Collections.max(a.entrySet(), Map.Entry.comparingByValue()).getKey();
            b[i]= maxKey;
            a.remove(maxKey);
        }
        return b;
    }
}