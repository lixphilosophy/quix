package quix.dao;

import org.hibernate.Session;
import quix.domain.Question;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QuestionDAO {

    public Question getQuestion(int questionID, Session session) {

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Question> cq = cb.createQuery(Question.class);
        Root<Question> root = cq.from(Question.class);

        cq.where(cb.equal(root.get("questionID"), questionID));

        List<Question> res = session.createQuery(cq).getResultList();

        return res == null || res.size() != 1 ? null : res.get(0);
    }

}
//	private static final String GET_QUESTIONS = "SELECT * FROM dbo.Question WHERE QuizID = ?";
//	private static final String GET_QUESTION_BY_ID = "SELECT * FROM dbo.Question WHERE QuestionID = ?";
//
//
//
//	public static List<Question> getQuestions(int quizID, int pickNum) {
//		Connection connection = DBConnection.getConnection();
//		PreparedStatement preparedStatement = null;
//		List<Question> res = new ArrayList<>();
//
//		try {
//			preparedStatement = connection.prepareStatement(GET_QUESTIONS);
//
//			preparedStatement.setInt(1, quizID);
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while(resultSet.next()) {
//
//				Question question = new Question();
//
//				int questionID = resultSet.getInt("QuestionID");
//
//				question.setQuestionID(questionID);
//				question.setQuestionType(resultSet.getString("QuestionType"));
//				question.setQuestionString(resultSet.getString("QuestionString"));
//				question.setQuizID(resultSet.getString("QuizID"));
//
//				question.setChoices(ChoiceDAO.getChoices(questionID));
//
//				res.add(question);
//			}
//
//		} catch (SQLException e) {
//
//			res = null;
//
//			System.err.println(e.getMessage());
//			try {
//				connection.rollback();
//				System.out.println("The transaction is rolled back");
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		} finally {
//
//			if (preparedStatement != null) {
//				try {
//					preparedStatement.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return res;
//	}
//
//	public static Question getQuestionsByID(int questionID) {
//		Connection connection = DBConnection.getConnection();
//		PreparedStatement preparedStatement = null;
//		Question question = new Question();
//
//		try {
//			preparedStatement = connection.prepareStatement(GET_QUESTION_BY_ID);
//
//			preparedStatement.setInt(1, questionID);
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			if(resultSet.next()) {
//
//				question.setQuestionID(resultSet.getInt("QuestionID"));
//				question.setQuestionType(resultSet.getString("QuestionType"));
//				question.setQuestionString(resultSet.getString("QuestionString"));
//				question.setQuizID(resultSet.getString("QuizID"));
//
//				question.setChoices(ChoiceDAO.getChoices(questionID));
//
//			} else {
//				question = null;
//			}
//
//		} catch (SQLException e) {
//
//			question = null;
//
//			System.err.println(e.getMessage());
//			try {
//				connection.rollback();
//				System.out.println("The transaction is rolled back");
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		} finally {
//
//			if (preparedStatement != null) {
//				try {
//					preparedStatement.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return question;
//	}
//}
