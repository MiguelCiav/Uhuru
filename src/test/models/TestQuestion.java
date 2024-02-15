package test.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.models.Question;

public class TestQuestion{

    @Test public void TestCreateQuestion(){
        Question expectedQuestion = new Question("Esto es un filtro", "Mucho filtro", 1, 2);
        
        Assertions.assertEquals("Esto es un filtro", expectedQuestion.getDescription());
        Assertions.assertEquals("Mucho filtro", expectedQuestion.getJustificacion());
        Assertions.assertEquals(1, expectedQuestion.getQuestionType());
        Assertions.assertEquals(2, expectedQuestion.getQuestionNumber());
    }
}