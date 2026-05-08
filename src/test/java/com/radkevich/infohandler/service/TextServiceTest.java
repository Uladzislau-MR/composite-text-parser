package com.radkevich.infohandler.service;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.Symbol;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.entity.TextComposite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceTest {

    private TextService textService;
    private TextComposite root;

    @BeforeEach
    void setUp() {
        textService = new TextService();
        root = new TextComposite(ComponentType.TEXT);
    }

    @Test
    void shouldFindMaxSentencesWithCommonWord() {
        TextComposite p1 = new TextComposite(ComponentType.PARAGRAPH);

        TextComposite s1 = createSentence("It has survived not only five centuries");
        TextComposite s2 = createSentence("The point of using Ipsum is that it has a");
        TextComposite s3 = createSentence("It is a long established fact");

        p1.add(s1);
        p1.add(s2);
        p1.add(s3);
        root.add(p1);

        int result = textService.getMaxSentencesWithCommonWord(root);

        assertEquals(3, result);
    }

    @Test
    void shouldSortSentencesByCharCount() {
        TextComposite p = new TextComposite(ComponentType.PARAGRAPH);

        TextComposite s1 = createSentence("It has survived");
        TextComposite s2 = createSentence("It is a long established fact");

        p.add(s2);
        p.add(s1);
        root.add(p);

        List<TextComponent> sorted = textService.sortSentencesByCharCount(root, 'a');

        assertTrue(sorted.get(0).toString().contains("survived"));
        assertEquals(2, sorted.size());
    }

    @Test
    void shouldSwapFirstAndLastWordsInLoremIpsum() {
        TextComposite sentence = createSentence("It has survived not only five centuries");
        TextComposite paragraph = new TextComposite(ComponentType.PARAGRAPH);
        paragraph.add(sentence);
        root.add(paragraph);

        textService.swapFirstAndLastWords(root);

        String result = sentence.toString().trim();
        assertTrue(result.startsWith("centuries") && result.endsWith("It"));
    }

    private TextComposite createSentence(String text) {
        TextComposite sentence = new TextComposite(ComponentType.SENTENCE);
        String[] words = text.split(" ");
        for (String w : words) {
            sentence.add(createLexemeWithWord(w));
        }
        return sentence;
    }

    private TextComposite createLexemeWithWord(String wordText) {
        TextComposite lexeme = new TextComposite(ComponentType.LEXEME);
        TextComposite word = new TextComposite(ComponentType.WORD);
        for (char c : wordText.toCharArray()) {
            word.add(new Symbol(c));
        }
        lexeme.add(word);
        return lexeme;
    }
}