import entities.Word;
import service.WordService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        new Main().runner();
    }

    public void runner() {
        List<Word> words = List.of(
                new Word("Java", generatePagesWithProbability(0.03)),
                new Word("Architecture", generatePagesWithProbability(0.03)),
                new Word("OOP", generatePagesWithProbability(0.02)),
                new Word("Stream", generatePagesWithProbability(0.1)),
                new Word("Immutable", generatePagesWithProbability(0.01))
        );

        WordService service = new WordService(words);

        printWords("Words on more than 2 pages", service.filterByMinPageCount(2));
        printWords("Words sorted alphabetically", service.sortByAlphabeticalOrder());
        printPagesForWord("OOP", service.getPageNumbersForWord("OOP"));
    }

    private List<Integer> generatePagesWithProbability(double probability) {
        Random random = new Random();
        return IntStream.rangeClosed(1, 100)
                .filter(page -> random.nextDouble() < probability)
                .boxed()
                .collect(Collectors.toList());
    }

    private void printWords(String title, List<Word> words) {
        System.out.println("\n=== " + title + " ===");
        if (words.isEmpty()) {
            System.out.println("No words found matching the criteria.");
        } else {
            words.forEach(System.out::println);
        }
    }

    private void printPagesForWord(String targetWord, List<Integer> pages) {
        System.out.println("\n=== Pages for the word '" + targetWord + "' ===");
        if (pages.isEmpty()) {
            System.out.println("No pages found for the specified word.");
        } else {
            System.out.println("Pages: " + pages);
        }
    }
}