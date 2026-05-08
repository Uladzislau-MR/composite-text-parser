package com.radkevich.infohandler.parser;

import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.entity.TextComponent;
import com.radkevich.infohandler.exception.ParsingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextParserTest {

    private TextParser textParser;

    @BeforeEach
    void setUp() {
        TextParser symbolParser = new SymbolParser();
        TextParser wordParser = new WordParser(symbolParser);
        TextParser lexemeParser = new LexemeParser(wordParser);
        TextParser sentenceParser = new SentenceParser(lexemeParser);
        TextParser paragraphParser = new ParagraphParser(sentenceParser);
        textParser = new TextParserImp(paragraphParser);
    }

    @Test
    void shouldParseTextToCorrectHierarchy() throws ParsingException {
        String input = "    Hello world. Next sentence.";

        TextComponent root = textParser.parse(input);

        assertAll(
                () -> assertEquals(ComponentType.TEXT, root.getType()),
                () -> assertEquals(1, root.getChildren().size()),
                () -> assertEquals(ComponentType.PARAGRAPH, root.getChildren().get(0).getType()),
                () -> assertEquals(2, root.getChildren().get(0).getChildren().size())
        );
    }

    @Test
    void shouldThrowParsingExceptionWhenDataIsNull() {
        ParsingException exception = assertThrows(
                ParsingException.class,
                () -> textParser.parse(null)
        );

        assertEquals("Data is missing or empty", exception.getMessage());
    }

    @Test
    void shouldThrowParsingExceptionWhenDataIsBlank() {
        assertThrows(
                ParsingException.class,
                () -> textParser.parse("   ")
        );
    }

    @Test
    void shouldRestoreOriginalTextStructure() throws ParsingException {
        String input = "    First paragraph.\n    Second paragraph.";

        TextComponent root = textParser.parse(input);
        String result = root.toString();

        assertEquals(input.trim(), result.trim());
    }

    @Test
    void shouldCorrectlyChainParsers() throws ParsingException {
        String input = "    Word.";
        TextComponent root = textParser.parse(input);

        TextComponent paragraph = root.getChildren().get(0);
        TextComponent sentence = paragraph.getChildren().get(0);
        TextComponent lexeme = sentence.getChildren().get(0);

        assertNotNull(lexeme);
        assertEquals(ComponentType.LEXEME, lexeme.getType());
    }
}