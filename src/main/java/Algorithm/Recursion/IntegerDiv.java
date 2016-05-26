package Algorithm.Recursion;

/**
 * Created by lishiwei on 16/5/26.
 */

/**
 * 根据n和m的关系，考虑以下几种情况：
 * 
 * (1)当n=1时，不论m的值为多少（m>0)，只有一种划分即{1};
 * 
 * (2)当m=1时，不论n的值为多少，只有一种划分即n个1，{1,1,1,...,1};
 * 
 * (3)当n=m时，根据划分中是否包含n，可以分为两种情况：
 * 
 * (a)划分中包含n的情况，只有一个即{n}；
 * 
 * (b)划分中不包含n的情况，这时划分中最大的数字也一定比n小，即n的所有(n-1)划分。
 * 
 * 因此 f(n,n) =1 + f(n,n-1);
 * 
 * (4)当n<m时，由于划分中不可能出现负数，因此就相当于f(n,n);
 * 
 * (5)但n>m时，根据划分中是否包含最大值m，可以分为两种情况：
 * 
 * (a)划分中包含m的情况，即{m, {x1,x2,...xi}}, 其中{x1,x2,... xi} 的和为n-m，因此这情况下
 * 
 * 为f(n-m,m)
 * 
 * (b)划分中不包含m的情况，则划分中所有值都比m小，即n的(m-1)划分，个数为f(n,m-1);
 * 
 * 因此 f(n, m) = f(n-m, m)+f(n,m-1);
 */

public class IntegerDiv {
    public static int q(int n, int m) {
        if ((n < 1) || (m < 1)) return 0;
        if ((n == 1) || (m == 1)) return 1;
        if (n < m) return q(n, n);
        if (n == m) return q(n, m - 1) + 1;
        return q(n, m - 1) + q(n - m, m);
    }

    public static void main(String[] args) {
        System.out.println(q(3, 3));
    }
}
