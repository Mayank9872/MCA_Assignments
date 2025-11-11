public class SelectionSortExamScores {
    public static void main(String[] args) {
        int[] scores = {78, 92, 65, 88, 56, 99, 73};

        
        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;

            
            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

           
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }

        System.out.println("Sorted Exam Scores in Ascending Order:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
