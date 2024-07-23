package org.itstack.demo.desgin.test;

import org.itstack.demo.design.QuestionBankController;
import org.junit.Test;

public class ApiTest {
    @Test
    public void test_questionBankController() throws CloneNotSupportedException {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("大菜", "1241232132"));
        System.out.println(questionBankController.createPaper("中菜", "2424324324"));
        System.out.println(questionBankController.createPaper("小菜", "2324325344"));
    }
}
