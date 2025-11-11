import java.util.*;

public class FrequencyCountExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = getFrequency(fruits);

        System.out.println("Frequency of Elements:");
        System.out.println(frequencyMap);
    }

    public static Map<String, Integer> getFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();

        for (String item : list) {
            if (freqMap.containsKey(item)) {
                freqMap.put(item, freqMap.get(item) + 1);
            } else {
                freqMap.put(item, 1);
            }
        }

        return freqMap;
    }
}
