package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() <= list.get(i + 1).length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }

    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }

    }

    public void switchPairs(List<String> list) {
        for(int i =0; i < list.size() -1; i += 2){
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);

        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; ){
            if(list.get(i).equals(list.get(i + 1))){
                list.remove(i + 1);
            }else{
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).length() == 4){
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int number : queue) {
            stack.push(number);
        }
        for (int number : queue) {
            if (number != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    public void reorder(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = queue.size();
        int positiveCount = 0;
        for (int i = 0; i < count; i++) {
            int number = queue.remove();
            if (number < 0) {
                stack.push(number);
            } else {
                queue.add(number);
                positiveCount++;
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < positiveCount; i++) {
            queue.add(queue.remove());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = queue.size();
        int evenCount = 0;
        for (int i = 0; i < count; i++) {
            int number = queue.remove();
            if (number % 2 != 0) {
                stack.push(number);
            } else {
                queue.add(number);
                evenCount++;
            }
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < evenCount; i++) {
            queue.add(queue.remove());
        }
        int oddCount = count - evenCount;
        for (int i = 0; i < oddCount; i++) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
    public int maxLength(Set<String> set) {
        int max = 0;
        for(String word : set){
            if (word.length() > max){
                max = word.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(word -> word.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> common = new HashSet<>(list1);
        common.retainAll(list2);
        return common.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>(map.values());
        return values.size() == map.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        for(String key : map1.keySet()) {
            if (map2.containsKey(key) && map1.get(key).equals(map2.get(key))) {
                result.put(key, map1.get(key));
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        for(Integer key : map.keySet()){
            result.put(map.get(key), key);
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int value : map.values()) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }
        int rarest = 0;
        int minCount = 0;
        boolean first = true;
        for (int value : counts.keySet()) {
            if (first || counts.get(value) < minCount ||
                    (counts.get(value) == minCount && value < rarest)) {
                rarest = value;
                minCount = counts.get(value);
                first = false;
            }
        }
        return rarest;
    }
    public int maxOccurrences(List<Integer> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = 0;
        for (int number : list){
            int count = counts.getOrDefault(number, 0 ) + 1;
            counts.put(number, count);
            if (count > max){
                max = count;
            }
        }
        return max;
    }

}
