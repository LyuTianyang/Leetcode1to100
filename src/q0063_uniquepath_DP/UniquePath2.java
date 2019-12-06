package q0063_uniquepath_DP;

public class UniquePath2 {
	/**
	Q0063一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
	说明：m 和 n 的值均不超过 100。
	
	示例 1:
	输入:
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	输出: 2
	解释:
	3x3 网格的正中间有一个障碍物。
	从左上角到右下角一共有 2 条不同的路径：
	1. 向右 -> 向右 -> 向下 -> 向下
	2. 向下 -> 向下 -> 向右 -> 向右
	 */
	
	/*
	1.状态变量
	2.init初始化
	3.转译方程 [i][j] = [i-1][j]+[i][j-1]
	4.结果
	 */
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		//state
		int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //init
        for(int i=0; i<m; i++){
        	if(obstacleGrid[i][0] == 1) break;
        	dp[i][0] = 1;
        }
        
        for(int j=0; j<n; j++){
        	if(obstacleGrid[0][j] == 1) break;
        	dp[0][j] = 1;
        }
        //function: [i][j] = [i-1][j]+[i][j-1]
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        		if(obstacleGrid[i][j] == 1) continue;
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        //result
        return dp[m-1][n-1];
    }
	
	public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
		if(obstacleGrid == null || (obstacleGrid.length == 0 && obstacleGrid[0].length==0)) return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			if(obstacleGrid[i][0] == 1) break;
			dp[i][0] = 1;
		}
		for(int i=0; i<n; i++){
			if(obstacleGrid[0][i] == 1) break;
			dp[0][i] = 1;
		}
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(obstacleGrid[i][j] == 1) continue;
				dp[i][j] = dp[i][j-1]+dp[i-1][j];
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0,0},
								{1,0,1,0},
								{0,0,0,0}};
		
		int result = uniquePathsWithObstacles1(obstacleGrid);
		System.out.println(result);
	}
}
