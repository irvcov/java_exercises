package excersices;

import java.util.*;

public class LFU {

    private Map<Integer, Integer> cacheMapVal;
    private Map<Integer, Integer> cacheMapFreq;
    private Map<Integer, LinkedList<Integer>> freqMap;
    private int capacity;

    public LFU(int capacity) {
        this.cacheMapVal = new HashMap<>();
        this.cacheMapFreq = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println("*GET*"+String.valueOf(key));
        if (this.capacity == 0)
            return -1;

        if (cacheMapVal.containsKey(key)) {
            int freq = cacheMapFreq.get(key);
            int freq1 = freq+1;
            cacheMapFreq.put(key, freq1);

            LinkedList<Integer> keys = freqMap.get(freq);
            if (keys.size() < 1)
                freqMap.remove(freq);
            else {
                System.out.println(freqMap);
                while(keys.remove(new Integer(freq))){}
                freqMap.put(freq, keys);
                System.out.println(freqMap);
            }

            if (freqMap.containsKey(freq1)){
                LinkedList<Integer> keystmp = freqMap.get(freq1);
                keystmp.add(key);
                freqMap.put(freq1,keystmp);
            } else {
                LinkedList<Integer> nkeys = new LinkedList<>();
                nkeys.add(key);
                freqMap.put(freq1, nkeys);
            }

            return cacheMapVal.get(key);
        } else
            return -1;
    }

    public void put(int key, int value) {
        System.out.println("*PUT*"+String.valueOf(key));
        if (cacheMapVal.containsKey(key) || this.capacity == 0)
            return;

        if (cacheMapVal.size() >= this.capacity && this.capacity != 0) {
            System.out.println(cacheMapFreq);
            LinkedList<Integer> keyList = new LinkedList<>(cacheMapFreq.values());
            Collections.sort(keyList);
            int tofreq = keyList.getFirst();

            System.out.println("**" + String.valueOf(tofreq));
            LinkedList<Integer> keys = freqMap.get(tofreq);
            System.out.println(freqMap);
            int keytmp = keys.getFirst();
            System.out.println(keytmp);
            keys.removeFirst();
            keys.add(key);
            System.out.println(freqMap);

            freqMap.put(tofreq, keys);
            cacheMapVal.remove(keytmp);
            cacheMapFreq.remove(keytmp);
            cacheMapVal.put(key, value);
            cacheMapFreq.put(key, 1);

        } else {
            cacheMapVal.put(key, value);
            cacheMapFreq.put(key, 1);

            if (freqMap.size() < 1) {
                LinkedList<Integer> keys = new LinkedList<>();
                keys.add(key);
                freqMap.put(1, keys);
            }
            freqMap.get(1).add(key);
        }
        System.out.println("----");
        System.out.println(cacheMapVal);
        System.out.println(cacheMapFreq);
        System.out.println("----");
    }

}
