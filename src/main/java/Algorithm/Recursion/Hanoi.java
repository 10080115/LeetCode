package Algorithm.Recursion;

/**
 * Created by lishiwei on 16/5/26.
 */
public class Hanoi {
    public static void move(int count, int start, int finsh, int temp) {
        if (count > 0) {
            move(count - 1, start, temp, finsh);
            System.out.println("移动" + count + "物体从" + start + "到" + finsh);
            move(count - 1, temp, finsh, start);
        }
    }

    public static void main(String[] args) {
        move(3, 1, 3, 2);
    }
}
