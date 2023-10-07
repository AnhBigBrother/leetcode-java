package LeetCode.CourseSchedule;

public class Entry {
    public static void main(String[] args) {
        int numCourses = 10;
        int [][] prerequisites = {{1,2}, {3,4}, {2,4}, {7,8}, {8, 4}};
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    }
}
