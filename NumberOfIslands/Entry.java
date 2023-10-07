package LeetCode.NumberOfIslands;

public class Entry {
    public static void main(String[] args) {
        char[][] inp = {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution().numIslands(inp));
    }
}
