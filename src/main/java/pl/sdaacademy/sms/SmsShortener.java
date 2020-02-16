package pl.sdaacademy.sms;

public class SmsShortener {

    public String shortenSms(String longSms) {

        String[] shortSms = longSms.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (String word: shortSms) {
            String trimmed = word.trim();
            if (word != null && !trimmed.isEmpty()) {
                stringBuilder.append(trimmed.substring(0, 1).toUpperCase() + trimmed.substring(1).toLowerCase());
            }
        }

        return stringBuilder.toString();
    }
}