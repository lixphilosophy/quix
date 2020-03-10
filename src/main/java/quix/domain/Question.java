package quix.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Question")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	private int questionID;

	@Column(name = "QUESTION_TYPE")
	private String questionType;

	@Column(name = "QUESTION_STRING")
	private String questionString;

	@Column(name = "QUIZ_ID", insertable = false, updatable = false)
	private int quizID;

	@Column(name = "MODIFIED_TIME")
	private String modifiedTime;

	@Column(name = "STATUS")
	private int status;

	@ManyToOne
	@JoinColumn(name = "QUIZ_ID")
	private QuizInfo quizInfo;

	@OneToMany(mappedBy = "question")
	private List<Choice> choices = new ArrayList<>();

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}

	public int getQuizID() {
		return quizID;
	}

	public void setQuizID(int quizID) {
		this.quizID = quizID;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public QuizInfo getQuizInfo() {
		return quizInfo;
	}

	public void setQuizInfo(QuizInfo quizInfo) {
		this.quizInfo = quizInfo;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
