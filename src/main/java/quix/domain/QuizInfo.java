package quix.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "QuizInfo")
public class QuizInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUIZ_ID")
    private int quizID;

    @Column(name = "QUIZ_NAME")
    private String quizName;

    @Column(name = "QUIZ_IMG")
    private String quizImg;

    @Column(name = "QUIZ_DESC")
    private String quizDesc;

    @Column(name = "QUIZ_COUNT")
    private int quizCount;

    @Column(name = "MODIFIED_TIME")
    private String modifiedTime;

    @OneToMany(mappedBy = "quizInfo")
    private List<Question> questions = new ArrayList<>();

    public int getQuizID() {
        return quizID;
    }

    public void setQuizID(int quizID) {
        this.quizID = quizID;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizImg() {
        return quizImg;
    }

    public void setQuizImg(String quizImg) {
        this.quizImg = quizImg;
    }

    public String getQuizDesc() {
        return quizDesc;
    }

    public void setQuizDesc(String quizDesc) {
        this.quizDesc = quizDesc;
    }

    public int getQuizCount() {
        return quizCount;
    }

    public void setQuizCount(int quizCount) {
        this.quizCount = quizCount;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
