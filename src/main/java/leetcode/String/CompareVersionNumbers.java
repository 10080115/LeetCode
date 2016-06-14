package leetcode.String;

/**
 * Created by lishiwei on 16/6/8.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        int size1 = version1.length();
        int size2 = version2.length();
        int i1 = 0;
        int i2 = 0;
        if (!version1.contains(".") && !version2.contains(".")) {
            if (Double.valueOf(version1) - Double.valueOf(version2) > 0)
                return 1;
            else if (Double.valueOf(version1) - Double.valueOf(version2) < 0)
                return -1;
            else
                return 0;
        }
        while (i1 < size1 && i2 < size2) {
            String t1 = version1.substring(i1, i1 + 1);
            String t2 = version2.substring(i2, i2 + 1);
            if (t1.equals(".")) {
                i1++;
                t1 = version1.substring(i1, i1 + 1);
            }
            if (t2.equals(".")) {
                i2++;
                t2 = version2.substring(i2, i2 + 1);
            }
            if (Double.valueOf(t1) - Double.valueOf(t2) > 0)
                return 1;
            else if (Double.valueOf(t1) - Double.valueOf(t2) < 0)
                return -1;
            i1++;
            i2++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("01", "1"));
    }
}
