package pl.sdaacademy.sms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SmsShortenerTest {

    SmsShortener smsShortener = new SmsShortener();

    @Test
    void shouldShortenValidSms() {
        // given
        String longSms = "Ala ma kota";
        String expected = "AlaMaKota";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithSpaces() {
        // given
        String longSms = "Ala ma         kota";
        String expected = "AlaMaKota";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithTab() {
        // given
        String longSms = "Ala \t ma kota";
        String expected = "AlaMaKota";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldShortenSmsWIthCapitalLetter() {
        // given
        String longSms = "\t";
        String expected = "";

        //when
        String shortenedSms = smsShortener.shortenSms(longSms);

        //then
        assertEquals(expected, shortenedSms);
    }
}