package Sort;

/**
 * Created by lishiwei on 16/6/27.
 */
public class stack_sort {
    //插入总是将新数据放在数组最后
    //删除元素总是在A[0]处 然后用最后一个元素弥空缺


    //最小堆 新加入的结点放在
    public static void stack_sort(int[] arr, int sonIndex) {
        int fatherIndex, temp;
        temp = arr[sonIndex];
        //记录父节点位置
        fatherIndex = (sonIndex - 1) / 2;
        while (fatherIndex > 0 && sonIndex != 0) {
            //父节点已经小于了子结点
            if (arr[sonIndex] <= temp)
                break;
            arr[sonIndex] = arr[fatherIndex];

        }
    }

    public static void main(String[] args) {

    }
}
