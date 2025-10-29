class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;
        PetrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    static int findStartingPoint(PetrolPump[] pumps, int n) {
        int start = 0, deficit = 0, balance = 0;
        for (int i = 0; i < n; i++) {
            balance += pumps[i].petrol - pumps[i].distance;
            if (balance < 0) {
                start = i + 1;
                deficit += balance;
                balance = 0;
            }
        }
        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };
        int start = findStartingPoint(pumps, pumps.length);
        System.out.println(start);
    }
}
