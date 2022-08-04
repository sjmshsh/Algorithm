public class PackingMachine {
	public static int MinOps(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int size = arr.length;
		int sum = 0;
		for	(int i = 0; i < size; i++) {
			sum += arr[i];
		}
		if (sum % size != 0) {
			return -1;
		}
		int avg = sum / size;
		int leftSum = 0; // 我们这里不需要求出累加和数组，因为我们用一个变量就可以表示累加和了。而右边的累加和是可以计算出来的
		int ans = 0;
		// 每个位置都求各自的
		for	(int i = 0; i < arr.length; i++) {
			// i号机器人，是中间机器，左(0~i-1) i 右(i+1~N-1)
			//负 需要输入   正 需要输出
			int leftRest = leftSum - i * avg; // a - b
			//负 需要输入   正 需要输出
			int rightRest = (sum - leftSum - arr[i]) - (size - i - 1) * avg;
			if (leftRest < 0 && rightRest < 0) {
				ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
			} else {
				ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
			}
			leftSum += arr[i];
		}
		return ans;
	}
}
