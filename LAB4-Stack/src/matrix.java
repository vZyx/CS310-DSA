public class matrix
{
    public static void main(String[] args)
    {
        int[][] X = {{10, 3}, {8, 4}};
        int[][] Y = {{1, 2}, {2, 5}};
        int[][] Z = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    Z[i][j] = X[i][k] * Y[k][j];
                }
            }
        }

        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++)
            {
                System.out.print(Z[i][j] + " ");
            }
            System.out.println();
        }
    }
}
