package Тelephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;
    private static final String PHONE_REGEX = "^[0-9]+$";
    private static final String URL_REGEX = "^\\D+$";

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        final Pattern pattern = Pattern.compile(URL_REGEX, Pattern.MULTILINE);

        StringBuilder stringBuilder = new StringBuilder();

        for (String url : this.urls) {
            if (this.matchesRegex(url, pattern)) {
                stringBuilder.append(String.format("Browsing: %s!%n", url));
            } else {
                stringBuilder.append(String.format("Invalid URL!%n"));
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String call() {
        final Pattern pattern = Pattern.compile(PHONE_REGEX, Pattern.MULTILINE);

        StringBuilder stringBuilder = new StringBuilder();

        for (String number : this.numbers) {
            if (this.matchesRegex(number, pattern)) {
                stringBuilder.append(String.format("Calling... %s%n", number));
            } else {
                stringBuilder.append(String.format("Invalid number!%n"));
            }
        }
        return stringBuilder.toString();
    }

    private boolean matchesRegex(String input, Pattern pattern) {
        final Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
