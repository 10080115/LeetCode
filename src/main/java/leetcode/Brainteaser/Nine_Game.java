package leetcode.Brainteaser;

/**
 * Created by lishiwei on 16/7/20.
 */

/**
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.Show Hint
 * 两个人轮流拿石子 每次可以拿1个到3个 谁拿走最后一个石头谁就是胜者
 * 1 2 3 你先拿一定赢 4个石头的时候 无论你怎么拿 最后都是你的对手获胜 答案呈周期性
 */


public class Nine_Game {
    public boolean canWinNim(int n) {
        if (n < 0) return true;

        if (n == 0) return false;

        return n % 4 != 0;
    }
}
