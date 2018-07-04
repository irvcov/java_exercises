package excersices;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class topKFrequentElement {

    public List<Integer> topKFrequent(int[] nums, int k) {

        if (nums.length < k)
            return null;

        Map<Integer, Integer> repmap = new HashMap<>();
        for (int i : nums) {
            if (repmap.containsKey(i)) {
                repmap.put(i , repmap.get(i) + 1);
            } else {
                repmap.put(i, 1);
            }
        }

        Map<Integer, List<Integer>> repkey = new HashMap<>();
        for (int i : repmap.keySet()) {
            if (repkey.containsKey(repmap.get(i))) {
                List<Integer> reps = repkey.get(repmap.get(i));
                reps.add(i);
            } else {
                List<Integer> reps = new LinkedList<>();
                reps.add(i);
                repkey.put(repmap.get(i) , reps);
            }
        }

        List<Integer> repList = new LinkedList<>(repmap.values());
        Collections.sort(repList);
        List<Integer> topKfreq = new LinkedList<>();

        for (int i=repList.size()-1; i>=repList.size()-k; i--) {
            List<Integer> reps = repkey.get(repList.get(i));
            topKfreq.add(reps.get(0));
            reps.remove(0);
            repkey.put(repList.get(i), reps);
        }

        return topKfreq;
    }

}
