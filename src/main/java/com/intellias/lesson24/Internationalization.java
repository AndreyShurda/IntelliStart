package com.intellias.lesson24;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class Internationalization {
    public static void main(String[] args) {
        Arrays.stream(DateFormat.getAvailableLocales()).forEach(System.out::println);

        List<Locale> locales = new ArrayList<>();
        locales.add(new Locale("de", "DE"));
        locales.add(Locale.FRANCE);
        locales.add(new Locale("en", "US"));
        locales.add(new Locale("en", "GB"));
        locales.add(Locale.JAPAN);

        for (Locale locale : locales) {
            translateMessage(locale);
        }

//        String ranges = "en-US;q=0.7,en-GB;q=0.8,fr-FR;q=0.0";
        String ranges = "it-IT;q=0.7,zh-SG;q=0.8,en-CA;q=0.0";
        Locale lookup = getSupportedLocale(locales, ranges);
        System.out.println(lookup);

        DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols();
        unusualSymbols.setDecimalSeparator('|');
        unusualSymbols.setGroupingSeparator('^');

        String strangePattern = "#,##0.###";
        DecimalFormat decimalFormat = new DecimalFormat(strangePattern, unusualSymbols);
        decimalFormat.setGroupingSize(4);
        String number = decimalFormat.format(123456.6789);
        System.out.println(number);
    }

    private static Locale getSupportedLocale(List<Locale> locales, String ranges) {
        List<Locale.LanguageRange> languageRanges = Locale.LanguageRange.parse(ranges);
        Locale lookup = Locale.lookup(languageRanges, locales);
        if (Objects.isNull(lookup)){
            return Locale.ENGLISH;
        }
        return lookup;
    }

    private static void translateMessage(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle", locale);
        System.out.printf("How call on %s in %s and iso %s\n", locale.getDisplayLanguage(), locale.getDisplayCountry(), locale.getISO3Country());
        printMessage(resourceBundle, "greeting");
        printMessage(resourceBundle, "farewell");
        printMessage(resourceBundle, "inquiry");
        printCurrency(locale);
        printDate(locale);
        System.out.println();
    }

    private static void printDate(Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT).withLocale(locale);
        System.out.println("date format: " + formatter.format(LocalDateTime.now()));
    }

    private static void printCurrency(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println("currency iso: " + currency);
        System.out.println("currency: " + currency.getDisplayName());
        System.out.println("currency code: " + currency.getNumericCode());
        System.out.println("currency format: " + numberFormat.format(123456789.1234));
    }

    private static void printMessage(ResourceBundle resourceBundle, String key) {
        System.out.println(key + " = " + resourceBundle.getString(key));
    }
}
