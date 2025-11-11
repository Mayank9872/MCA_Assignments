import java.util.*;
import java.time.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsurancePolicy)) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Name: " + policyholderName +
               ", Expiry: " + expiryDate + ", Type: " + coverageType +
               ", Premium: " + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    private static Set<InsurancePolicy> hashSet = new HashSet<>();
    private static Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    private static Set<InsurancePolicy> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        addSamplePolicies();

        System.out.println("\nAll Unique Policies (HashSet):");
        displaySet(hashSet);

        System.out.println("\nPolicies in Order of Insertion (LinkedHashSet):");
        displaySet(linkedHashSet);

        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        displaySet(treeSet);

        System.out.println("\nPolicies Expiring Within 30 Days:");
        displaySet(getExpiringSoonPolicies(hashSet));

        System.out.println("\nPolicies with Coverage Type 'Auto':");
        displaySet(getPoliciesByType(hashSet, "Auto"));

        System.out.println("\nDuplicate Policies (by Policy Number):");
        displaySet(findDuplicatePolicies());

        comparePerformance();
    }

    private static void addSamplePolicies() {
        InsurancePolicy p1 = new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(15), "Health", 5000);
        InsurancePolicy p2 = new InsurancePolicy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 3500);
        InsurancePolicy p3 = new InsurancePolicy("P103", "Charlie", LocalDate.now().plusDays(25), "Home", 4200);
        InsurancePolicy p4 = new InsurancePolicy("P104", "David", LocalDate.now().plusDays(10), "Auto", 2800);
        InsurancePolicy p5 = new InsurancePolicy("P101", "Alice", LocalDate.now().plusDays(15), "Health", 5000); // duplicate

        hashSet.addAll(Arrays.asList(p1, p2, p3, p4, p5));
        linkedHashSet.addAll(Arrays.asList(p1, p2, p3, p4, p5));
        treeSet.addAll(Arrays.asList(p1, p2, p3, p4, p5));
    }

    private static Set<InsurancePolicy> getExpiringSoonPolicies(Set<InsurancePolicy> policies) {
        Set<InsurancePolicy> result = new HashSet<>();
        LocalDate today = LocalDate.now();
        for (InsurancePolicy p : policies) {
            if (!p.getExpiryDate().isBefore(today) && p.getExpiryDate().isBefore(today.plusDays(30))) {
                result.add(p);
            }
        }
        return result;
    }

    private static Set<InsurancePolicy> getPoliciesByType(Set<InsurancePolicy> policies, String type) {
        Set<InsurancePolicy> result = new HashSet<>();
        for (InsurancePolicy p : policies) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                result.add(p);
            }
        }
        return result;
    }

    private static Set<InsurancePolicy> findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();
        for (InsurancePolicy p : hashSet) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p);
            }
        }
        return duplicates;
    }

    private static void comparePerformance() {
        System.out.println("\n--- Performance Comparison ---");
        int n = 100000;
        List<InsurancePolicy> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(new InsurancePolicy("X" + i, "User" + i, LocalDate.now().plusDays(i % 365), "Auto", i * 10));
        }

        measurePerformance("HashSet", new HashSet<>(), testData);
        measurePerformance("LinkedHashSet", new LinkedHashSet<>(), testData);
        measurePerformance("TreeSet", new TreeSet<>(), testData);
    }

    private static void measurePerformance(String name, Set<InsurancePolicy> set, List<InsurancePolicy> data) {
        long start = System.nanoTime();
        set.addAll(data);
        long addTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (InsurancePolicy p : data) {
            set.contains(p);
        }
        long searchTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (InsurancePolicy p : data) {
            set.remove(p);
        }
        long removeTime = System.nanoTime() - start;

        System.o
