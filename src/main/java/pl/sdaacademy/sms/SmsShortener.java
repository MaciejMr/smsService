package pl.sdaacademy.sms;

public class SmsShortener {

    private final String longSms;

    public SmsShortener(String longSms) {
        this.longSms = longSms;
    }

    public int countMessages() {

        String shortenedSms = shortenSms();
        if (shortenedSms.isBlank()) {
            return 0;
        }

        int fullCount = shortenedSms.length() / 160;

        return fullCount + (hasRemainingCharacters(shortenedSms) ? 1 : 0);
    }

    private boolean hasRemainingCharacters(String shortenedSms) {
        return shortenedSms.length() % 160 != 0;
    }

    public String shortenSms() {

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