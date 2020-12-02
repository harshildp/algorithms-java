/* Given a grid of "1" and "0"'s where 1 denotes land and 0 denotes water.
Count the number of islands in the grid. An island as a landmass surrounded by water
or edges on all sides */
import java.util.Set;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    public static void main(String[] args) {
        String[][] input = {
            {"1","1","0","1","1"},
            {"1","1","0","1","0"},
            {"0","1","0","0","1"},
            {"1","0","1","0","1"}
        };
        System.out.println(numOfIslands(input));
    }

    // Loop through the grid and find instances of land. Updated the island counter
    // and then use DFS to "sink" the surrounding tiles which are also land. Since these
    // tiles would technically be part of the same island you just discovered. 
    public static int numOfIslands(String[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Set<Integer> sizes = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == "1") {
                    int size = sink(grid, i, j);
                    sizes.add(size);
                }
            }
        }

        return sizes.size();
    }

    // Return if a tile is already water or out of bounds.
    // Otherwise sink the tile and recurse on the 4 surrounding tiles.
    public static int sink(String[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == "0") return 0;

        grid[i][j] = "0";
        return 1 + sink(grid, i - 1, j)
                 + sink(grid, i + 1, j)
                 + sink(grid, i, j - 1)
                 + sink(grid, i, j + 1);
    }
}