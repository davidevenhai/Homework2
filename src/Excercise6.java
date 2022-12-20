import java.util.Scanner;

public class Excercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean checkUserEquation;
        String userEquation;
        do {
            System.out.println("please insert your Quadratc equatiom:");
            userEquation = scanner.nextLine();
            checkUserEquation = checkInputUser(userEquation);
            if (!checkUserEquation) {
                System.out.println("Your insert Not according to the format ");
            } else System.out.println("Your insert is good and according to the format ");
        } while (!checkUserEquation);
        int a = checkAInputUser(userEquation);
        int b = checkBInputUser(userEquation);
        int c = checkCInputUser(userEquation);
        PrintSolution(a, b, c);
    }

    public static boolean checkInputUser(String userEquation) {
        boolean check = false;
        int counter = 0;
        int counterX = 0;
        for (int i = 0; i < userEquation.length(); i++) {
            if (userEquation.charAt(i) == '-' || userEquation.charAt(i) == '+') {
                counter++;
            } else if (userEquation.charAt(i) == 'x') counterX++;
        }
        if (counter == 2 || counter == 3) {
            if (userEquation.charAt(userEquation.length() - 1) == '0' && userEquation.charAt(userEquation.length() - 2) == '=') {
                if (userEquation.contains("x^2") && counterX == 2) {
                    check = true;
                }
            }
        }
        return check;
    }

    public static int checkAInputUser(String userEquation) {
        int a;
        int indexfirstX = userEquation.indexOf("x");
        String variableA = userEquation.substring(0, indexfirstX);
        if (variableA.equals("")) {
            a = 1;
        } else a = Integer.parseInt(variableA);
        return a;
    }

    public static int checkBInputUser(String userEquation) {
        int indexBeginB = userEquation.indexOf("^");
        indexBeginB = indexBeginB + 2;
        int indexEndB = 0;
        for (int i = 0; i < userEquation.length(); i++) {
            if (userEquation.charAt(i) == 'x' && userEquation.charAt(i + 1) != '^') {
                indexEndB = i;
                break;
            }
        }
        String variableB = userEquation.substring(indexBeginB, indexEndB);
        int b = Integer.parseInt(variableB);
        return b;
    }

    public static int checkCInputUser(String userEquation) {
        int indexEndC = userEquation.indexOf("=");
        int indexBeginC = 0;
        for (int i = 0; i < userEquation.length(); i++) {
            if (userEquation.charAt(i) == 'x' && userEquation.charAt(i + 1) != '^') {
                indexBeginC = i + 1;
                break;
            }
        }
        String variableC = userEquation.substring(indexBeginC, indexEndC);
        int c = Integer.parseInt(variableC);
        return c;
    }

    public static void PrintSolution(int a, int b, int c) {
        double pow = Math.pow(b, 2);
        double sqrt = Math.sqrt(pow - (4 * a * c));
        if ((sqrt < 0) || Double.isNaN(sqrt)) {
            System.out.println("There is no solutions for this quadratic equation");
        } else {
            double solution1 = ((-b) + sqrt) / (2 * a);
            double solution2 = ((-b) - sqrt) / (2 * a);
            if (solution1 == solution2) {
                System.out.println("There is one solution for this quadratic equation, x1= " + solution1);
            } else {
                System.out.println("There are two solutions for this quadratic equation, x1= " + solution1 + ", x2 = " + solution2);
            }
        }

    }
}
