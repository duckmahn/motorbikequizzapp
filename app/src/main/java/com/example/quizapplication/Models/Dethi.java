package com.example.quizapplication.Models;

public class Dethi {
    int id, made,score;
    String question,optionA,optionB,optionC,optionD,correctAnswer;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Dethi(int id, String question, String optionA, String optionB, String optionC, String optionD, int made, String correctAnswer) {
        this.id = id;
        this.made = made;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }
    public Dethi(int id,  String question, String optionA, String optionB, String optionC, String optionD, int made, String correctAnswer,int score) {
        this.id = id;
        this.made = made;
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }

    public Dethi(int made, int score) {
        this.made= made;
        this.score = score;
    }

//    public Dethi(int id) {
//        this.id = id;
//    }

    public int getMade() {
        return made;
    }

    public void setMade(int made) {
        this.made = made;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
