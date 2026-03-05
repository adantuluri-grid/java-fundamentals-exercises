package com.bobocode.se;

import java.util.regex.Pattern;

public class CrazyRegex {

    public Pattern findSpecificWord() {
        return Pattern.compile("\\bCuriosity\\b");
    }

    public Pattern findFirstWord() {
        return Pattern.compile("^\\b\\w+\\b");
    }

    public Pattern findLastWord() {
        return Pattern.compile("\\b\\w+\\b$");
    }

    public Pattern findAllNumbers() {
        return Pattern.compile("\\d+");
    }

    public Pattern findDates() {
        return Pattern.compile("\\b\\d{4}-\\d{2}-\\d{2}\\b");
    }

    public Pattern findDifferentSpellingsOfColor() {
        return Pattern.compile("\\bcolou?rs?\\b");
    }

    public Pattern findZipCodes() {
        return Pattern.compile("\\s\\d{5}\\s");
    }

    public Pattern findDifferentSpellingsOfLink() {
        return Pattern.compile("l[yi (]nk");
    }

    public Pattern findSimplePhoneNumber() {
        return Pattern.compile("\\b\\d{3}-\\d{3}-\\d{4}\\b");
    }

    public Pattern findNumbersFromZeroToFiveWithLengthThree() {
        return Pattern.compile("[0-5]{3}");
    }

    public Pattern findAllWordsWithFiveLength() {
        return Pattern.compile("\\b[a-zA-Z]{5}\\b");
    }

    public Pattern findAllLettersAndDigitsWithLengthThree() {
        return Pattern.compile("\\b[\\w]{2,3}\\b");
    }

    public Pattern findAllWordsWhichBeginWithCapitalLetter() {
        return Pattern.compile("\\b[A-Z][a-z]+\\b");
    }

    public Pattern findAbbreviation() {
        return Pattern.compile("\\b(AK|AL|AR|AZ|CA|CO|CT|PR|PA|PD)\\b");
    }

    public Pattern findAllOpenBraces() {
        return Pattern.compile("\\{+");
    }

    public Pattern findOnlyResources() {
        return Pattern.compile("(?<=\\[)[^\\]]+(?=\\])");
    }

    public Pattern findOnlyLinksInNote() {
        return Pattern.compile("https://[^\\s)]+");
    }

    public Pattern findOnlyLinksInJson() {
        return Pattern.compile("http://[^\\s\"']+");
    }

    public Pattern findAllEmails() {
        return Pattern.compile("\\b[\\w.]+@[\\w.]+\\.(com|net|edu)\\b");
    }

    public Pattern findAllPatternsForPhoneNumbers() {
        return Pattern.compile("\\(\\d{3}\\)\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4}");
    }

    public Pattern findOnlyDuplicates() {
        return Pattern.compile("\\b(\\w+)\\s+\\1\\b");
    }

    public String replaceFirstAndLastNames(String names) {
        return names.replaceAll("(\\w+),\\s*(\\w+)", "$2 $1");
    }

    public String replaceLastSevenDigitsOfPhoneNumberToX(String phones) {
        return phones.replaceAll("[\\(]?(\\d{3})[\\)\\.-]?\\d{3}[\\.-]?\\d{4}", "$1-XXX-XXXX");
    }

    public String insertLinksAndResourcesIntoHref(String links) {
        return links.replaceAll("\\[(.+?)]\\((https://[^)]+)\\)", "<a href=\"$2\">$1</a>");
    }
}