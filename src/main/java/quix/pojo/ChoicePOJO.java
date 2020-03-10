package quix.pojo;

import quix.domain.Question;

public class ChoicePOJO {

    private int choiceID;
    private String choiceString;
    private boolean ifCorrect;
    private Question question;
	private int questionID;

    public int getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(int choiceID) {
        this.choiceID = choiceID;
    }

    public String getChoiceString() {
        return choiceString;
    }

    public void setChoiceString(String choiceString) {
        this.choiceString = choiceString;
    }

    public boolean isIfCorrect() {
        return ifCorrect;
    }

    public void setIfCorrect(boolean ifCorrect) {
        this.ifCorrect = ifCorrect;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
}
