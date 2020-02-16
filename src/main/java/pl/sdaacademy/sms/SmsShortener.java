package pl.sdaacademy.sms;

public class SmsShortener {

    public String shortenSms(String longSms) {

        String[] shortSms = longSms.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (String word: shortSms) {
            if (word != null && !word.isBlank()) {
                stringBuilder.append(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
            }
        }

        return stringBuilder.toString();
    }
}