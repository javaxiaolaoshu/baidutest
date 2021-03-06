package baidu;

import java.util.Scanner;
/*
 * 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,
 * 度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。
 * 但是现在度度熊手中只有k个小于符号即('<')和n-k-1个大于符号(即'>'),
 * 度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
 * 
 * 输入描述:   
 * 输入包括一行,包含两个整数n和k(k < n ≤ 1000) 
 * 输出描述:输出满足条件的排列数,答案对2017取模。
 * 示例1：
 * 输入 ：5 2
 * 输出  66
 */
public class Main{
    /*
	 * 思想：动态规划：dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] *(j +
	 * 1))%2017;dp[i][j]表示有i个数字及j个小于号所能组成的数量(大于号数量当然是i - j - 1次，后面需要使用）而加入第i +
	 * 1个数字时，分以下四种情况：
	 * 1.如果将i+1插入当前序列的开头，即有了1<2，加入后成为3>1<2，会发现等于同时加入了一个大于号！(此时可以无视1与2之间的关系，因为i+1>i)
	 * 2.如果将i+1插入当前序列末尾,即1<2变成了 1<2<3，会发现等于同时加入了一个小于号！(此时可以无视1与2之间的关系，因为i+1>i)
	 * 3.如果将i+1加入一个小于号之间，即已经有1<2了，向中间加入3,会发现变成了1<3>2，等于同时加入了一个大于号！
	 * 4.如果将i+1加入一个大于号中间，即有了2>1，变成了2<3>1，等于同时加入了一个小于号！综上所述，dp[i][j]等于以上四种情况之和：
	 * dp[i - 1][j] 将i加在开头等于加入一个大于号，即要求i-1个数时已经有了j个小于号
	 * dp[i - 1][j -1] 将i加在末尾等于加入一个小于号，即要求i-1个数时已经有了j-1个小于号
	 * dp[i - 1][j]*j将i加在任意一个小于号之间，等于加入了一个大于号，即要求i-1个数时已经有了j个小于号，每个小于号都可以进行这样的一次插入
	 * dp[i - 1][j- 1] * (i- j - 1)将i加载任意一个大于号之间，等于加入了一个小于号；即要求i-1个数时有了j-1个小于号，而此时共有(i -1) - (j - 1)- 1个大于号，
	 * 每个大于号都要进行一次这样的操作
	 * 合并同类项即为dp[i][j] = (dp[i - 1][j - 1] *(i - j) + dp[i - 1][j] * (j + 1))
	 */
	static int dp[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		dp = new int[n][k + 1];
		for (int i = 1; i < n; i++) {
			dp[i][0] = 1; // 当前i个数不含小于符号的排列数记1
		}
		System.out.print(permutationAmount(n, k));
	}

	// 动态规划过程函数
	public static int permutationAmount(int n, int k) {
		// 如果数字个数为2，且小于符号0
		if (n == 2 && k == 0) {
			dp[n - 1][k] = 1;
			return 1;
		}
		// 如果数字个数2，且小于符号1
		if (n == 2 && k == 1) {
			dp[n - 1][k] = 1;
			return 1;
		}
		// 如果数字个数小于小于符号个数
		if (n <= k)
			return 0;
		// 如果以上条件都不满足
		if (dp[n - 1][k] != 0)
			return dp[n - 1][k];
		dp[n - 1][k] = (permutationAmount(n - 1, k - 1) * (n - k) + permutationAmount(n - 1, k) * (k + 1)) % 2017;
		return dp[n - 1][k];
	}
}