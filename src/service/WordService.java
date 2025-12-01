package service;

import entities.Word;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordService {
    private final List<Word> words;

    public WordService(List<Word> words) {
        this.words = words;
    }

    public List<Word> filterByMinPageCount(int minPageCount) {
        return words.stream()
                .filter(word -> word.getPageCount() > minPageCount)
                .collect(Collectors.toList());
    }

    public List<Word> sortByAlphabeticalOrder() {
        return words.stream()
                .sorted(Comparator.comparing(Word::getWordText))
                .collect(Collectors.toList());
    }

    public List<Integer> getPageNumbersForWord(String targetWord) {
        return words.stream()
                .filter(word -> word.getWordText().equalsIgnoreCase(targetWord))
                .findFirst()
                .map(Word::getPageNumbers)
                .orElse(Collections.emptyList());
    }
}