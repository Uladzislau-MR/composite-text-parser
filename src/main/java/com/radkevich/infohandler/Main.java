package com.radkevich.infohandler;

import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.exeption.ParsingException;
import com.radkevich.infohandler.parser.*;
import com.radkevich.infohandler.reader.CustomReader;
import com.radkevich.infohandler.reader.CustomReaderImpl;
import com.radkevich.infohandler.service.TextService;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParsingException {
        TextService textService = new TextService();
        CustomReader customReader = new CustomReaderImpl();

        TextParser symbolParser = new SymbolParser();
        TextParser wordParser = new WordParser(symbolParser);
        TextParser lexemeParser = new LexemeParser(wordParser);
        TextParser sentenceParser = new SentenceParser(lexemeParser);
        TextParser paragraphParser = new ParagraphParser(sentenceParser);
        TextParser textParser = new TextParserImp(paragraphParser);

        String textData = customReader.readAllData("Data.txt");
        TextComponent root = textParser.parse(textData);

        System.out.println("=== FULL TEXT ANALYSIS ===");
        printStructure(root);

        System.out.println("\n\n=== TEXT_SERVICE METHODS TESTING ===");

        int maxCommon = textService.getMaxSentencesWithCommonWord(root);
        System.out.println("1. Max sentences with common word: " + maxCommon);

        char target = 'a';
        List<TextComponent> sorted = textService.sortSentencesByCharCount(root, target);
        System.out.println("\n2. Sentences sorted by character '" + target + "' count:");
        sorted.forEach(s -> System.out.println("   -> " + s.toString().trim()));

        System.out.println("\n3. Executing Swap (first and last words)...");
        textService.swapFirstAndLastWords(root);

        System.out.println("\n=== TEXT AFTER CHANGES (SWAP) ===");
        System.out.println(root.toString());
    }

    private static void printStructure(TextComponent result) {
        List<TextComponent> paragraphs = result.getChildren();
        System.out.println("TOTAL PARAGRAPHS: " + paragraphs.size());

        for (int i = 0; i < paragraphs.size(); i++) {
            TextComponent paragraph = paragraphs.get(i);
            List<TextComponent> sentences = paragraph.getChildren();
            System.out.println("\nPARAGRAPH #" + (i + 1) + " (Sentences: " + sentences.size() + ")");

            for (int j = 0; j < sentences.size(); j++) {
                TextComponent sentence = sentences.get(j);
                System.out.println("  [S" + (j + 1) + "]: " + sentence.toString().trim());
            }
        }
    }
}