package LeetCode.CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {return true;}
        boolean [][] require = new boolean[numCourses][numCourses];
        // require[i][j] == 1 : must passed j first to pass i.
        int [] preCourses = new int [numCourses];
        for (int[] a : prerequisites){
            require[a[0]][a[1]] = true;
            preCourses[a[0]] ++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        int n = 0;
        for (int i=0; i<numCourses; i++){
            if (preCourses[i] == 0){
                q.add(i);
                n++;
            }
        }
        while (q.size() > 0){
            int p = q.poll();
            for (int i=0; i<numCourses; i++){
                if (require[i][p] == true){
                    preCourses[i] --;
                    if (preCourses[i] == 0){
                        q.offer(i);
                        n++;
                    }
                }
            }
        }
        if (n < numCourses){return false;}
        return true;
    }
}
