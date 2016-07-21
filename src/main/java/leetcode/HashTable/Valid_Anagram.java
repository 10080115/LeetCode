package leetcode.HashTable;

import java.util.Hashtable;

/**
 * Created by lishiwei on 16/7/21.
 */
public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;
        int[] arr = new int[255];

        for (int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            if (--arr[t.charAt(i) - 'a'] < 0)
                return false;
        return true;
    }
}
