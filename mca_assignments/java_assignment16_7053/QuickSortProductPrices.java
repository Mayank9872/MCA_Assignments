public class QuickSortProductPrices {

   
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; 
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

     
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }


    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);

            quickSort(prices, low, pi - 1);  
            quickSort(prices, pi + 1, high); 
        }
    }

    public static void main(String[] args) {
        double[] prices = {999.99, 499.50, 1200.00, 750.25, 300.00, 650.75};

        quickSort(prices, 0, prices.length - 1);

        System.out.println("Sorted Product Prices in Ascending Order:");
        for (double price : prices) {
            System.out.print(price + " ");
        }
    }
}
