public class Task2_4 {

    public static void main(String[] args) {

        String phone_number1 = "8(947) 55 55 432";
        String phone_number2 = "(( () +7(999)9399999";
        String phone_number3 = "89656667878";
        String phone_number4 = "+7666";
        String phone_number5 = "8932 3433 34 34";

        String[] result1 = check_phone_number(phone_number1);
        String[] result2 = check_phone_number(phone_number2);
        String[] result3 = check_phone_number(phone_number3);
        String[] result4 = check_phone_number(phone_number4);
        String[] result5 = check_phone_number(phone_number5);

        print_result(result1);
        print_result(result2);
        print_result(result3);
        print_result(result4);
        print_result(result5);
    }

    private static String[] check_phone_number(String number) {

        String[] result = new String[2];
        result[0] = number;

        if (result[0].contains(" ") || result[0].contains("(") || result[0].contains(")")) {
            result[0] = result[0].replaceAll(" ", "").replaceAll("\\(", "")
                    .replaceAll("\\)", "");
            result[1] = "В номере есть пробелы и/или скобки";
        }

        String first_chars = result[0].substring(0, 2);
        if (first_chars.equals("+7")) {
            result[0] = result[0].replaceFirst("\\+7", "8");
            if (result[1] != null){
                result[1] += "; Замена +7 на 8";
            } else { result[1] = "Замена +7 на 8"; }
        }

        if (result[0].equals(number)){
            result[1] = "Не было изменений";
        }

        if (result[0].length()!= 11) {
            if (result[0].length() > 11) {
                result[1] += "; Сумма символов больше 11";
            } else { result[1] += "; Сумма символов меньше 11"; }
            result[0] = "Введен некорректный номер";
        }
        return result;
    }

    public static void print_result(String[] result) {
        for (int i = 0; i < result.length ; i++ ) System.out.println(result[i]);
        System.out.println();
    }

}
