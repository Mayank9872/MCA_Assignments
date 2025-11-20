import java.io.*;
import java.util.*;

public class WordCountTop5 {
    public static void main(String[] args) {
        File file = new File("input.txt");

        if (!file.exists()) {
            System.out.println("File not found.");
            return;
        }

        HashMap<String, Integer> map = new HashMap<>();
        int totalWords = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String w : words) {
                    if (w.length() > 0) {
                        totalWords++;
                        map.put(w, map.getOrDefault(w, 0) + 1);
                    }
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Total Words: " + totalWords);
        System.out.println("Top 5 Words:");

        for (int i = 0; i < Math.min(5, list.size()); i++) {
            Map.Entry<String, Integer> e = list.get(i);
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
