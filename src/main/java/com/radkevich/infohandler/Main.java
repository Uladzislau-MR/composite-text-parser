package com.radkevich.infohandler;

import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.exception.ParsingException;
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

        String original = textData;
        String reconstructed = root.toString();

        System.out.println("--- ORIGINAL ---");
        System.out.println(original);

        System.out.println("\n--- RECONSTRUCTED ---");
        System.out.println(reconstructed);

        System.out.println("Root object type: " + root.getType());
        System.out.println("Children count at root: " + root.getChildren().size());

        for (TextComponent child : root.getChildren()) {
            System.out.println("--- Child type: " + child.getType());
        }

        int maxCommon = textService.getMaxSentencesWithCommonWord(root);
        System.out.println("\nMax sentences with common word: " + maxCommon);

        char target = 'a';
        List<TextComponent> sorted = textService.sortSentencesByCharCount(root, target);
        System.out.println("Sentences sorted by char '" + target + "' count: " + sorted.size());

        textService.swapFirstAndLastWords(root);
        System.out.println("\n--- AFTER SWAP ---");
        System.out.println(root.toString());
    }
}