package quix.pojo;

import quix.domain.UserAnswer;

import java.util.ArrayList;
import java.util.List;

public class UserSubmissionPOJO {

    private int submissionID;
    private String startTime;
    private String endTime;
    private int userID;
    private int quizId;
    private List<UserAnswerPOJO> userAnswerPOJOs = new ArrayList<>();

    public int getSubmissionID() {
        return submissionID;
    }

    public void setSubmissionID(int submissionID) {
        this.submissionID = submissionID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<UserAnswerPOJO> getUserAnswerPOJOs() {
        return userAnswerPOJOs;
    }

    public void setUserAnswerPOJOs(List<UserAnswerPOJO> userAnswerPOJOs) {
        this.userAnswerPOJOs = userAnswerPOJOs;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
}
