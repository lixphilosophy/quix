package quix.pojo;


public class UserAnswerPOJO {

    private int answerID;
    private String answerString;
    private boolean ifCorrect;
    private int questionID;
    private int submissionID;

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getAnswerString() {
        return answerString;
    }

    public void setAnswerString(String answerString) {
        this.answerString = answerString;
    }

    public boolean isIfCorrect() {
        return ifCorrect;
    }

    public void setIfCorrect(boolean ifCorrect) {
        this.ifCorrect = ifCorrect;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getSubmissionID() {
        return submissionID;
    }

    public void setSubmissionID(int submissionID) {
        this.submissionID = submissionID;
    }
}
