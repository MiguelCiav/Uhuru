package test.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.models.*;

public class TestMultipleSelect {
    @Test public void
    TestMultipleSelect(){
        Answer expectedAnswer = new Answer("En efecto, es un filtro", 1, true, "1", "1", "1");
            
        Assertions.assertEquals("En efecto, es un filtro", expectedAnswer.getAnswerText());
        Assertions.assertTrue(expectedAnswer.isCorrect());
        Assertions.assertEquals(1, expectedAnswer.getAnswerNumber());
    }
}
