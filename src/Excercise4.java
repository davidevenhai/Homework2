public class Excercise4 {
    public static void main(String[] args) {
        int[] array = {10,5,6,7,5,2,1}; //Should return -1
        int index;
        index = isClimax(array);
        System.out.print(index);
    }

    public static int isClimax(int[] isClimax) {
        final int TOP = -1;
        int climax = TOP;
        boolean isUp = true;
        boolean isDown = false;
        for (int i = 0; i < isClimax.length-1; i++) {
            if (isClimax[i] < isClimax[i + 1] && isUp) {
                climax = i + 1;
            } else {
                isUp = false;
                isDown = true;
            }
            if (!isUp) {
                if (isClimax[i] <= isClimax[i + 1]) {
                    climax = -1;
                    isDown = false;
                    break;
                }
            }
        }
        if(!isDown){
            climax = TOP;
        }

        return climax;
    }
}