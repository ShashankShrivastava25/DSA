public class TrappingRainWater { // O(n)
    public static int trappedRainWater(int arr[]) {

        int trappedWater = 0;
        int waterLevel = 0;
        int width = 1;

        // auxillary left array
        int leftMax[] = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // auxillary right array
        int rightMax[] = new int[arr.length];
        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - arr[i]) * width;
        }
        return trappedWater;
    }

    public static void main(String args[]) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println("Trapped Water is " + trappedRainWater(height));
    }
}
