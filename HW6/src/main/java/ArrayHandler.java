public class ArrayHandler {

    public int[] getValuesAfterLastFour(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                return getSliceArray(i, array);
            }
        }
        throw new RuntimeException();
    }

    private int[] getSliceArray(int fromIndex, int[] originalArray) {
        int[] resultArray = new int[originalArray.length - fromIndex];

        for (int i = fromIndex, j = 0; i < originalArray.length; i++, j++) {
            resultArray[j] = originalArray[i];
        }
        return resultArray;
    }
    public boolean findFourOrOneNumberInArray(int[ ] array) {
        boolean hasFour = false;
        boolean hasOne = false;

        for (int value:array) {
            if (value == 4){
                hasFour = true;
            } else if (value == 1){
                hasOne = true;
            } else {
                return false;
            }

        }
        return hasFour && hasOne;
    }
}