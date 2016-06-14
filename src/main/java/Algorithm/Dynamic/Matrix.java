package Algorithm.Dynamic;

/**
 * Created by lishiwei on 16/5/30.
 */

/**
 * 一个P矩阵是 p * q
 * 一个P矩阵式 q * r 的 那么他们需要的次数是 p * q * r次运算
 */
public class Matrix {
    public static void main(String[] args) {
        int[][] mart1 = {{1, 4}, {2, 5}, {3, 6}};
        int[][] mart2 = {{1, 2, 3}, {4, 5, 6}};
        getValue(mart1, mart2);
    }

    public static void getValue(int[][] mart1, int[][] mart2) {
        int raRow = mart1.length;
        int raCol = mart1[0].length;
        int rbRow = mart2.length;
        int rbCol = mart2[0].length;
        int sum = 0;
        if (raCol != rbRow)
            return;
        //定义结果矩阵
        int[][] valMart = new int[raRow][rbCol];
        for (int i = 0; i < raRow; i++) {
            for (int j = 0; j < rbCol; j++) {
                sum = mart1[i][0] * mart2[0][j];
                for (int k = 1; k < raCol; k++) {
                    sum += mart1[i][k] * mart2[k][j];
                }
                valMart[i][j] = sum;
            }
        }

        for (int i = 0; i < valMart.length; i++) {
            for (int j = 0; j < valMart[0].length; j++) {
                System.out.print(valMart[i][j] + " ");
            }

            System.out.println();
        }
    }
}
