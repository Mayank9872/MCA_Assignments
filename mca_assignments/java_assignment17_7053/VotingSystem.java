import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteMap = new HashMap<>();
    Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        linkedVoteMap.put(candidate, linkedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayResultsSorted() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);
        System.out.println("Results (Sorted by Candidate Name):");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayResultsInOrder() {
        System.out.println("Results (Order of Voting):");
        for (Map.Entry<String, Integer> entry : linkedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");

        System.out.println("Vote Count (HashMap):");
        System.out.println(system.voteMap);

        System.out.println();
        system.displayResultsSorted();

        System.out.println();
        system.displayResultsInOrder();
    }
}
