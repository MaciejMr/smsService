package pl.sdaacademy.sms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmsShortenerTest {

    @Test
    void shouldShortenValidSms() {
        // given
        String longSms = "Ala ma kota";
        String expected = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithSpaces() {
        // given
        String longSms = "Ala ma         kota";
        String expected = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldShortenSmsWithTab() {
        // given
        String longSms = "Ala ma\t kota";
        String expected = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldShortenSmsWith() {
        // given
        String longSms = "Ala \t ma\t kota";
        String expected = "AlaMaKota";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldShortenSmsWIthCapitalLetter() {
        // given
        String longSms = "\t";
        String expected = "";

        //when
        String shortenedSms = new SmsShortener(longSms).shortenSms();

        //then
        assertEquals(expected, shortenedSms);
    }

    @Test
    void shouldCountMessagesOnEmptyInput() {
        // given
        String longSms = "   \t";
        int excpectedCount = 0;

        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();

        //then
        assertEquals(excpectedCount, actualMessageCount);
    }

    @Test
    void shouldCountMessages() {
        // given
        String longSms = "Ala ma kota";
        int excpectedCount = 1;

        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();

        //then
        assertEquals(excpectedCount, actualMessageCount);
    }

    @Test
    void shouldCountMoreThanOneMessage() {
        // given
        String longSms = "Loremipsumdolorsit  amet,consecteturadipiscingelit." +
                "Duisrutrumv  estibulumdoloridpulvinar." +
                "Seddignissim,temporultrices,\tlibe.Seddignissim,temporultrices,liberr.Seddig.";
        int excpectedCount = 2;

        //when
        int actualMessageCount = new SmsShortener(longSms).countMessages();

        //then
        assertEquals(excpectedCount, actualMessageCount);
    }
}