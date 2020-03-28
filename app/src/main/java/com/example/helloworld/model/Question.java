package com.example.helloworld.model;

public class Question {
    public String Qustion, Option1, Option2, Option3, answer, IsImageQuestion;

    public Question(String question, String option1, String option2, String option3, String answer, String isImageQuestion) {
        Qustion = question;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        this.answer = answer;
        IsImageQuestion = isImageQuestion;
    }

    public String getQuestion() {
        return Qustion;
    }

    public void setQuestion(String question) {
        Qustion = question;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIsImageQuestion() {
        return IsImageQuestion;
    }

    public void setIsImageQuestion(String isImageQuestion) {
        IsImageQuestion = isImageQuestion;
    }
}