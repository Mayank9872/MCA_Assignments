import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", name='" + policyholderName + '\'' +
                ", expiry=" + expiryDate +
                ", coverage='" + coverageType + '\'' +
                ", premium=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagementSystem {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, Policy> treeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringSoon = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);

        for (Policy policy : hashMap.values()) {
            if (!policy.expiryDate.isBefore(now) && !policy.expiryDate.isAfter(threshold)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByHolder(String name) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(name)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        hashMap.values().removeIf(p -> p.expiryDate.isBefore(now));
        linkedHashMap.values().removeIf(p -> p.expiryDate.isBefore(now));
        treeMap.values().removeIf(p -> p.expiryDate.isBefore(now));
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 3000));
        system.addPolicy(new Policy("P103", "Alice", LocalDate.now().minusDays(5), "Home", 7000));

        System.out.println("Retrieve by Number (P101):");
        System.out.println(system.getPolicyByNumber("P101"));

        System.out.println("\nPolicies expiring within 30 days:");
        System.out.println(system.getPoliciesExpiringSoon());

        System.out.println("\nPolicies for Alice:");
        System.out.println(system.getPoliciesByHolder("Alice"));

        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();

        System.out.println("\nRemaining Policies:");
        System.out.println(system.hashMap.values());
    }
}
