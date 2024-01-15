class Solution {
public List<List<Integer>> findWinners(int[][] matches) {

            HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
            List<Integer> list0 = new LinkedList<Integer>();
            List<Integer> list1 = new LinkedList<Integer>();


            for (int i = 0; i < matches.length; i++) {
                int[] match = matches[i];

                h.putIfAbsent(matches[i][0], 0);
                if (h.putIfAbsent(matches[i][1], -1) != null) {
                    if (h.get(matches[i][1]) == 0) h.put(matches[i][1], -1);
                    else if (h.get(matches[i][1]) == -1) h.put(matches[i][1], -2);
                }
            }

            for (Integer key : h.keySet()) {
                Integer value = h.get(key);
                if (value == 0) list0.add(key);
                if (value == -1) list1.add(key);
            }

            List<List<Integer>> ans = new ArrayList<List<Integer>>(2);
            Collections.sort(list0);
            Collections.sort(list1);
            ans.add(list0);
            ans.add(list1);
            return ans;


    }
}
