package quix.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "Choice")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Choice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHOICE_ID")
	private int choiceID;

	@Column(name = "CHOICE_STRING")
	private String choiceString;

	@Column(name = "IF_CORRECT")
	private boolean ifCorrect;

	@ManyToOne
	@JoinColumn(name = "QUESTION_ID")
	private Question question;

	@Column(name = "QUESTION_ID", insertable = false, updatable = false)
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

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
