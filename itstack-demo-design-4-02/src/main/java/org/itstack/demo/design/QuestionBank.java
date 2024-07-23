package org.itstack.demo.design;

import org.itstack.demo.design.util.Topic;
import org.itstack.demo.design.util.TopicRandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class QuestionBank implements Cloneable{
    private String candidate;
    private String number;

    ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<>();
    ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<>();

    public QuestionBank append(ChoiceQuestion choiceQuestion){
        choiceQuestionList.add(choiceQuestion);
        return this;
    }

    public QuestionBank append(AnswerQuestion answerQuestion){
        answerQuestionList.add(answerQuestion);
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();

        //题目乱序
        Collections.shuffle(questionBank.choiceQuestionList);
        Collections.shuffle(questionBank.answerQuestionList);
        //答案乱序
        ArrayList<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestionList;
        for (ChoiceQuestion question : choiceQuestionList) {
            Topic random = TopicRandomUtil.random(question.getOption(), question.getKey());
            question.setOption(random.getOption());
            question.setKey(random.getKey());

        }
        return questionBank;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder detail = new StringBuilder("考生：" + candidate + "\n" +
                "考号：" + number + "\n" +
                "-----------------------------\n" +
                "一、选择题" + "\n\n");
        for (int i = 0; i < choiceQuestionList.size(); i++) {
            detail.append("第").append(i + 1).append("题：").append(choiceQuestionList.get(i).getName()).append("\n");
            Map<String, String> option = choiceQuestionList.get(i).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\n");
            }
            detail.append("答案：").append(choiceQuestionList.get(i).getKey()).append("\n\n");
        }
        detail.append("二、问答题" + "\n\n");

        for (int i = 0; i < answerQuestionList.size(); i++) {
            detail.append("第").append(i + 1).append("题：").append(answerQuestionList.get(i).getName()).append("\n");
            detail.append("答案").append(answerQuestionList.get(i).getKey()).append("\n\n");
        }
        return detail.toString();
    }
}
