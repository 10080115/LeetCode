package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lishiwei on 16/4/26.
 */
public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> container = new ArrayList<List<Integer>>();
        List<Integer> level = new ArrayList<Integer>();
        level.add(1);
        if(numRows==0){
            return container;
        }
        if(numRows==1){
            container.add(0,level);
            return container;
        }
        container.add(0,level);
        int count = 1;
        for(int i = 2;i<=numRows;i++){
            List<Integer> level2= new ArrayList<Integer>();
            level2.add(1);
            for(int j=1;j<i;j++){
                if((level2.size()+1)<i){
                    level2.add(level.get(j-1) + level.get(j));
                }
            }
            level2.add(1);
            container.add(count++,level2);
            level=level2;
        }
        return container;
    }
}
