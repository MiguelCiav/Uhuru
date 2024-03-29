package test.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import main.models.Question;

public class TestQuestion{

    @Test public void TestCreateQuestion(){
        Question expectedQuestion = new Question("Esto es un filtro", 1, "2", "3");
        
        Assertions.assertEquals("Esto es un filtro", expectedQuestion.getDescription());
        Assertions.assertEquals("Mucho filtro", expectedQuestion.getJustificacion());
        Assertions.assertEquals(1, expectedQuestion.getQuestionType());
        Assertions.assertEquals(2, expectedQuestion.getQuestionNumber());
    }
}