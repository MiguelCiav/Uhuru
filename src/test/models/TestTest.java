package test.models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestTest{

    @Test public void TestCreateTest(){
        main.models.Test expectedTest = new main.models.Test("Calculo", "Filtro", 45, "0123456789");
        
        Assertions.assertEquals("Calculo", expectedTest.getName());
        Assertions.assertEquals("Filtro", expectedTest.getType());
        Assertions.assertEquals(45, expectedTest.getDuration());
        Assertions.assertEquals("0123456789", expectedTest.getTestID());
    }
}