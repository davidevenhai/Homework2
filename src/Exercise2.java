import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phoneNumber;
        System.out.println("Enter Your Phone Number");
        phoneNumber = scanner.nextLine(); //Scan phone number
        System.out.println(phoneNumber(phoneNumber));

    }

    public static String phoneNumber(String phoneNum) {
        if (phoneNum.startsWith("050")&&(phoneNum.length()==10)) {
            phoneNum = "050-" + phoneNum.substring(phoneNum.length() - 7);
        }
        if (phoneNum.startsWith("97250")&&(phoneNum.length()==12)) {
            phoneNum = "050-" + phoneNum.substring(phoneNum.length() - 7);
        }
        if (phoneNum.startsWith("050-")&&(phoneNum.length()==11)) {
            phoneNum = "050-" + phoneNum.substring(phoneNum.length() - 7);
        } else {
            phoneNum = "False number, please reenter a new number";
        }
        return phoneNum;
    }
}
