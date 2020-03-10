package quix.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserSubmission")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserSubmission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBMISSION_ID")
	private int submissionID;

	@Column(name = "START_TIME")
	private String startTime;

	@Column(name = "END_TIME")
	private String endTime;

	@Column(name = "USER_ID", insertable = false, updatable = false)
	private int userID;

	@Column(name = "CORRECT_COUNT")
	private int correctCount;

	@Column(name = "TOTAL_COUNT")
	private int totalCount;

	@Column(name = "QUIZ_ID", insertable = false, updatable = false)
	private int quizID;

	@OneToMany(mappedBy = "userSubmission")
	private List<UserAnswer> userAnswers = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserInfo userInfo;

	@OneToOne
	@JoinColumn(name="QUIZ_ID")
	private QuizInfo quizInfo;

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

	public List<UserAnswer> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(List<UserAnswer> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public int getCorrectCount() {
		return correctCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getQuizID() {
		return quizID;
	}

	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public QuizInfo getQuizInfo() {
		return quizInfo;
	}

	public void setQuizInfo(QuizInfo quizInfo) {
		this.quizInfo = quizInfo;
	}
}
