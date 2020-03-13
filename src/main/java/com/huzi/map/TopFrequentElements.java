package com.huzi.map;

import java.lang.reflect.Array;
import java.util.*;

public class TopFrequentElements {

  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int num : nums) {
      hm.put(num, hm.getOrDefault(num, 0) + 1);
    }

    TreeMap<Integer, List<Integer>> tm = new TreeMap<>();

    for (int num : hm.keySet()) {
      int freq = hm.get(num);
      if (!tm.containsKey(freq)) {
        List<Integer> list = new ArrayList<>();
        list.add(num);
        tm.put(freq, list);
      } else {
        tm.get(freq).add(num);
      }
    }

    List<Integer> result = new ArrayList<>();

    while (result.size() < k) {
      Map.Entry<Integer, List<Integer>> entry = tm.pollLastEntry();
      result.addAll(entry.getValue());
    }
    return result;
  }

  public List<Integer> topKFrequentMaxHeap(int[] nums, int k) {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int num : nums) {
      hm.put(num, hm.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
            new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
      maxHeap.add(entry);
    }

    List<Integer> result = new ArrayList<>();
    while (result.size() < k) {
      Map.Entry<Integer, Integer> entry = maxHeap.poll();
      result.add(entry.getKey());
    }
    return result;
  }


  public List<Integer> topKFrequentBucket(int[] nums, int k) {
    List<Integer>[] buckets = new List[1 + nums.length];
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int num : nums) {
      hm.put(num, hm.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
      Integer freq = entry.getValue();
      if (buckets[freq] == null) {
        List<Integer> list = new ArrayList<>();
        list.add(entry.getKey());
        buckets[freq] = list;
      } else {
        buckets[freq].add(entry.getKey());
      }
    }

    List<Integer> res = new ArrayList<>();
    for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
      if (buckets[i] != null) {
        res.addAll(buckets[i]);
      }
    }

    return res;
  }
}
