package quix.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "UserAnswer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_ID")
    private int answerID;

    @Column(name = "ANSWER_STRING")
    private String answerString;

    @Column(name = "IF_CORRECT")
    private boolean ifCorrect;

    @Column(name = "QUESTION_ID", insertable = false, updatable = false)
    private int questionID;

    @Column(name = "SUBMISSION_ID", insertable = false, updatable = false)
    private int submissionID;

    @ManyToOne
    @JoinColumn(name = "SUBMISSION_ID")
    private UserSubmission userSubmission;

    @OneToOne
    @JoinColumn(name="QUESTION_ID")
    private Question question;

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

    public UserSubmission getUserSubmission() {
        return userSubmission;
    }

    public void setUserSubmission(UserSubmission userSubmission) {
        this.userSubmission = userSubmission;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
