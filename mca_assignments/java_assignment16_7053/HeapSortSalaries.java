public class HeapSortSalaries {

   
    public static void heapify(double[] salaries, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

       
        if (left < n && salaries[left] > salaries[largest])
            largest = left;

       
        if (right < n && salaries[right] > salaries[largest])
            largest = right;

        
        if (largest != i) {
            double temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, n, largest);
        }
    }

    
    public static void heapSort(double[] salaries) {
        int n = salaries.length;

      
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(salaries, n, i);

       
        for (int i = n - 1; i > 0; i--) {
         
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

           
            heapify(salaries, i, 0);
        }
    }

    public static void main(String[] args) {
        double[] salaries = {55000.0, 72000.0, 48000.0, 66000.0, 85000.0, 53000.0};

        heapSort(salaries);

        System.out.println("Sorted Salary Demands in Ascending Order:");
        for (double s : salaries) {
            System.out.print(s + " ");
        }
    }
}
