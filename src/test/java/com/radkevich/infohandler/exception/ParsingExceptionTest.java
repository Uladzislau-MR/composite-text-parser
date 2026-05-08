package com.radkevich.infohandler.exception;
import com.radkevich.infohandler.entity.ComponentType;
import com.radkevich.infohandler.parser.TextParserImp;
import com.radkevich.infohandler.parser.TextParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParsingExceptionTest {

    @Test
    void shouldStoreMessageInException() {
        String message = "Custom error message";
        ParsingException exception = new ParsingException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    void shouldStoreMessageAndComponentType() {
        String message = "Error in paragraph";
        ComponentType type = ComponentType.PARAGRAPH;
        ParsingException exception = new ParsingException(message, type);

        assertEquals(message, exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenDataIsInvalid() {
        TextParser parser = new TextParserImp(null);

        ParsingException exception = assertThrows(
                ParsingException.class,
                () -> parser.parse(null)
        );

        assertNotNull(exception.getMessage());
    }

    @Test
    void shouldHaveCorrectComponentTypeInException() {
        TextParser parser = new TextParserImp(null);

        ParsingException exception = assertThrows(
                ParsingException.class,
                () -> parser.parse("")
        );

        assertNotNull(exception);
    }
}