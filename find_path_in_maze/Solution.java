/*************************************************************************
    > File Name: Solution.java
    > Author: Chengyu Cui
    > Mail: ccy604080969@gmail.com 
    > Created Time: Sun Nov 22 22:23:14 2015
 ************************************************************************/

import java.util.Arrays;

public class Solution {
	private static boolean canGetFoodHelper(int[][] maze, boolean[][] visited, int x, int y) {
		if(x<0 || y<0 || x>=maze.length || y>=maze[0].length || maze[x][y]==1 || visited[x][y]==true)
			return false;

		if(maze[x][y]==9)
			return true;

		visited[x][y] = true;

		return canGetFoodHelper(maze, visited, x+1, y) || canGetFoodHelper(maze, visited, x, y+1)
			|| canGetFoodHelper(maze, visited, x, y-1) || canGetFoodHelper(maze, visited, x-1, y);
	}

	public static boolean canGetFood(int[][] maze) {
		if(maze==null || maze.length==0)	return false;

		return canGetFoodHelper(maze, new boolean[maze.length][maze[0].length], 0, 0);
	}

	public static void main(String[] args) {
		int[][] maze = { {0, 0, 1}, {0, 1, 0}, { 0, 0, 9}};

		System.out.println("[Maze]");
		for(int i=0; i<maze.length; i++)
			System.out.println(Arrays.toString(maze[i]));
		System.out.println(canGetFood(maze));
	}
}