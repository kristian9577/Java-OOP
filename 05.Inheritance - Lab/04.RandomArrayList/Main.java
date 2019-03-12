package RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> words = new RandomArrayList<String>();

        words.add("First word");
        words.add("Second word");
        words.add("Third word");

        System.out.println(words.getRandomElement());
        System.out.println(words.getRandomElement());
        System.out.println(words.getRandomElement());
    }
}