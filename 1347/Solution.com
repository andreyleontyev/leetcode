class Solution {

    public int minSteps(String s, String t) {

        int ans = 0;
        
        int[] hash = new int[26];
        byte[] sb = s.getBytes(), tb = t.getBytes();

        for (int i = 0; i < s.length(); i++) {
            hash[sb[i] - 'a']++;
            hash[tb[i] - 'a']--;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] < 0) ans = ans - hash[i];
            else ans = ans+ hash[i];
        }

        return ans/2;
    }

}
