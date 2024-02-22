package test.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.models.*;

public class TestAnswer{

    @Test public void TestCreateAnswer(){
        Answer expectedAnswer = new Answer("En efecto, es un filtro", true, "1", "1", "1");
        
        Assertions.assertEquals("En efecto, es un filtro", expectedAnswer.getAnswerText());
        Assertions.assertTrue(expectedAnswer.isCorrect());
        Assertions.assertEquals(1, expectedAnswer.getAnswerText());
    }
}