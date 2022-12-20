import java.util.Arrays;

public class Excercise3 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 5, 6, 7, 8, 9, 9, 5, 6, 6, 6, 66, 1}; //Example - needs to return [0,1,5,6,7,8,9,66]
        System.out.println(Arrays.toString(noDuplicate(arr)));
    }

    public static int[] noDuplicate(int[] oldArr) {
        int counter = 0;
        boolean isDuplicate;
        for (int i = 0; i < oldArr.length; i++) {
            isDuplicate = false;
            for (int j = i + 1; j < oldArr.length; j++) {
                if (oldArr[i] == oldArr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                counter++;
            }
        }
        int k = 1;
        int[] newArray = new int[oldArr.length - counter];
        newArray[0] = oldArr[0];
        for (int i = 1; i < oldArr.length; i++) {
            isDuplicate = false;
            for (int j = 0; j < newArray.length; j++) {
                if (newArray[j] == oldArr[i]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newArray[k] = oldArr[i];
                k++;
            }
        }
        return newArray;

    }
}
