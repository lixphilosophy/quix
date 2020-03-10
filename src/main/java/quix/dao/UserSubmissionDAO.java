package quix.dao;


import org.hibernate.Session;
import quix.domain.UserSubmission;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserSubmissionDAO {

    public UserSubmission getSubmission(int submissionID, Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserSubmission> cq = cb.createQuery(UserSubmission.class);
        Root<UserSubmission> root = cq.from(UserSubmission.class);

        cq.where(cb.equal(root.get("submissionID"), submissionID));

        List<UserSubmission> res = session.createQuery(cq).getResultList();

        return res == null || res.size() != 1 ? null : res.get(0);
    }

    public List<UserSubmission> getSubmissions(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserSubmission> cq = cb.createQuery(UserSubmission.class);
        Root<UserSubmission> root = cq.from(UserSubmission.class);

        cq.select(root);

        return session.createQuery(cq).getResultList();
    }
}
//	private static final String SET_SUBMISSION = "INSERT INTO dbo.Submission VALUES (?, ?, ?, ?)";
//	private static final String GET_SUBMISSION = "SELECT * FROM dbo.Submission WHERE AttemptID = ?;";
//
//	public static void setSubmission(int attemptID, int questionID, String userAnswer) {
//		Connection connection = DBConnection.getConnection();
//		PreparedStatement preparedStatement = null;
//
//		try {
//			preparedStatement = connection.prepareStatement(SET_SUBMISSION);
//			preparedStatement.setInt(1, attemptID);
//			preparedStatement.setInt(2, questionID);
//			preparedStatement.setString(3, userAnswer);
//			preparedStatement.setBoolean(4, ChoiceDAO.ifCorrect(questionID, userAnswer));
//
//			preparedStatement.executeUpdate();
//			connection.commit();
//
//		} catch (SQLException e) {
//
//			System.err.println(e.getMessage());
//
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
//	}
//
//	public static List<UserSubmission> getSubmission(int attemptID) {
//		Connection connection = DBConnection.getConnection();
//		PreparedStatement preparedStatement = null;
//		List<UserSubmission> res = new ArrayList<>();
//
//		try {
//			preparedStatement = connection.prepareStatement(GET_SUBMISSION);
//
//			preparedStatement.setInt(1, attemptID);
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while(resultSet.next()) {
//				UserSubmission userSubmission = new UserSubmission();
//
//				userSubmission.setAttemptID(resultSet.getInt("AttemptID"));
//				userSubmission.setQuestionID(resultSet.getInt("QuestionID"));
//				userSubmission.setUserAnwser(resultSet.getString("userAnswer"));
//				userSubmission.setIfCorrect(resultSet.getBoolean("ifCorrect"));
//
//				res.add(userSubmission);
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
//	public static boolean ifPass(int attempID) {
//		Connection connection = DBConnection.getConnection();
//		PreparedStatement preparedStatement = null;
//		int cnt = 0;
//
//		try {
//			preparedStatement = connection.prepareStatement(GET_SUBMISSION);
//
//			preparedStatement.setInt(1, attempID);
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//
//			while(resultSet.next()) {
//				if(resultSet.getBoolean("ifCorrect"))
//					cnt++;
//			}
//
//		} catch (SQLException e) {
//
//			cnt = 0;
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
//		return cnt >= 6 ? true : false;
//	}
//}
