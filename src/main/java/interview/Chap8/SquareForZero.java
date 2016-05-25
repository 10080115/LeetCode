package interview.Chap8;

/**
 * Created by lishiwei on 16/4/19.
 */
public class SquareForZero {
    public static void main(String[] args) {
        int[][] square = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        SquareForZero2(square);
    }

    private static void SquareForZero2(int[][] square) {
        //维持两个行数组
        boolean[] row = new boolean[square.length];
        boolean[] col = new boolean[square[0].length];
        System.out.println(row[0]);

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j <square[0].length ; j++) {
                if(square[i][j]==0) {
                    row[i] = true;
                    col[j] = true;
                }

            }
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j <square[0].length ; j++) {
                if( row[i] || row[j]){
                    square[i][j] = 0;
                }
            }
        }

    }
}
