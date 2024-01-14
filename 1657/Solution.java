class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        byte[] b1 = word1.getBytes(), b2 = word2.getBytes();
        int[] abc1 = new int[26];
        int[] abc2 = new int[26];

        for (int i = 0; i < b1.length; i++) {
            abc1[b1[i] - 'a']++;
            abc2[b2[i] - 'a']++;
        }

        for (int i = 0; i < abc1.length; i++) {
            if (abc1[i] == 0 && abc2[i] != 0) return false;
        }

        if (Arrays.compare(abc2, abc1) == 0) return true;

        Arrays.sort(abc1);
        Arrays.sort(abc2);

        if (Arrays.compare(abc2, abc1) == 0) return true;

        return false;
    }
}
