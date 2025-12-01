package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Word {

    private final String wordText;
    private final List<Integer> pageNumbers;
    private final int pageCount;

    public Word(String wordText, List<Integer> pageNumbers) {
        if (wordText == null || wordText.trim().isEmpty()) {
            throw new IllegalArgumentException("Word text cannot be null or empty.");
        }
        if (pageNumbers == null) {
            throw new IllegalArgumentException("Page numbers list cannot be null.");
        }

        this.wordText = wordText;
        this.pageNumbers = new ArrayList<>(pageNumbers);
        this.pageCount = this.pageNumbers.size();
    }

    public String getWordText() {
        return wordText;
    }

    public List<Integer> getPageNumbers() {
        return Collections.unmodifiableList(pageNumbers);
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public String toString() {
        return "word = '" + wordText + '\'' +
                ", pageNumbers = " + pageNumbers.stream().map(String::valueOf).collect(Collectors.joining(", ")) +
                ", pageCount = " + pageCount;
    }
}