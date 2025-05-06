package other;

// On, O1
public class PrintAllSubArrays {

    public static void main(String[] args) {
        PrintAllSubArrays psm = new PrintAllSubArrays();
        int[] arr = {1, 2, 3};
        psm.printSubArray(arr);
    }

    void printSubArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) //This loop will select start element
        {
            for (int j = i; j < n; j++)   //This loop will select end element
            {
                int sum = 0;
                for (int k = i; k <= j; k++) //This loop will print element from start to end
                {
//                    System.out.format("%s%s%n",i,j);
                    sum = sum + arr[k];
                    //   System.out.print(arr[k] + " ");
                }
                System.out.println("sum :" + sum);
//                System.out.println("");
            }
        }
    }
}
