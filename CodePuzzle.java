package puzzle;

public class CodePuzzle {

	public static void main(String args[]) {
		/*
		 * Puzzle Scenario #1: 
		 * Weights = [1,2,3,4,5,6,7,8,9,10]
		 * Days = 5 
		 */
		int arryWeights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int days = 5;
		
		System.out.println("Minimum capacity to ship packages within 5 days is: " +
				shipWithinSpecifiedDays(arryWeights, days));
		
		/*
		 * Puzzle Scenario #2: 
		 * Weights = [3,2,2,4,1,4]
		 * Days = 3 
		 */
		int arryWeights3[] = { 3, 2, 2, 4, 1, 4 };
		days = 3;
		System.out.println("Minimum capacity to ship packages within 3 days is " + 
				shipWithinSpecifiedDays(arryWeights3, days));
		
		/*
		 * Puzzle Scenario #3:  
		 * Weights = [1,2,3,1,1]
		 * Days = 4 
		 */
		int[] arryWeights4 = { 1,2,3,1,1 };
		days = 4;
		System.out.println("Minimum capacity to ship packages within 4 days is: " + 
				shipWithinSpecifiedDays(arryWeights4, days));
	}

	public static int shipWithinSpecifiedDays(int[] weights, int days) {
		int minCapacity = 0, maxCapacity = 0;
		
		//Loop through the weights to calculate the Minimum and Maximum capacities
		for (int weight : weights) {
			minCapacity = Math.max(minCapacity, weight);
			maxCapacity += weight;
		}
		
		while (minCapacity < maxCapacity) {
			int midCapacity = (minCapacity + maxCapacity) / 2;
			int daysCount = 1, weightSum = 0;
			
			for (int weight : weights) {
				if (weightSum + weight > midCapacity) {
					weightSum = 0;
					daysCount += 1;
				}
				weightSum += weight;
			}
			if (daysCount > days)
				minCapacity = midCapacity + 1;
			else
				maxCapacity = midCapacity;
		}
		return minCapacity;
	}

}