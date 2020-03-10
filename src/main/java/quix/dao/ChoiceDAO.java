package quix.dao;

import org.hibernate.Session;
import quix.domain.Choice;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ChoiceDAO {

    public boolean ifCorrect(int questionID, String choiceString, Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Choice> cq = cb.createQuery(Choice.class);
        Root<Choice> root = cq.from(Choice.class);

        cq.where(cb.and(
                cb.equal(root.get("questionID"), questionID),
                cb.equal(root.get("choiceString"), choiceString)
        ));

        List<Choice> res = session.createQuery(cq).getResultList();

        return res != null && res.size() == 1 && res.get(0).isIfCorrect();
    }
}

////	private static final String GET_CHOICES = "SELECT * FROM dbo.Choice WHERE QuestionID = ?";
////	private static final String CHECK_CHOICE = "SELECT * FROM dbo.Choice WHERE QuestionID = ? AND ChoiceString = ?";
////
////	public static List<Choice> getChoices(int questionID) {
////		Connection connection = DBConnection.getConnection();
////		PreparedStatement preparedStatement = null;
////		List<Choice> res = new ArrayList<>();
////
////		try {
////			preparedStatement = connection.prepareStatement(GET_CHOICES);
////
////			preparedStatement.setInt(1, questionID);
////
////			ResultSet resultSet = preparedStatement.executeQuery();
////
////			while(resultSet.next()) {
////
////				Choice choice = new Choice();
////
////				choice.setQuestionID(resultSet.getInt("QuestionID"));
////				choice.setChoiceString(resultSet.getString("ChoiceString"));
////				choice.setIfCorrect(resultSet.getBoolean("ifCorrect"));
////
////				res.add(choice);
////			}
////
////		} catch (SQLException e) {
////
////			res = null;
////
////			System.err.println(e.getMessage());
////			try {
////				connection.rollback();
////				System.out.println("The transaction is rolled back");
////			} catch (SQLException e1) {
////				e1.printStackTrace();
////			}
////		} finally {
////
////			if (preparedStatement != null) {
////				try {
////					preparedStatement.close();
////				} catch (SQLException e) {
////					e.printStackTrace();
////				}
////			}
////		}
////
////		return res;
////	}
////
////	public static boolean ifCorrect(int questionID, String choiceString) {
////		Connection connection = DBConnection.getConnection();
////		PreparedStatement preparedStatement = null;
////		boolean res = true;
////
////		try {
////			preparedStatement = connection.prepareStatement(CHECK_CHOICE);
////
////			preparedStatement.setInt(1, questionID);
////			preparedStatement.setString(2, choiceString);
////
////			ResultSet resultSet = preparedStatement.executeQuery();
////
////			if(resultSet.next()) {
////				res = resultSet.getBoolean("ifCorrect");
////			} else {
////				res = false;
////			}
////
////		} catch (SQLException e) {
////
////			res = false;
////
////			System.err.println(e.getMessage());
////			try {
////				connection.rollback();
////				System.out.println("The transaction is rolled back");
////			} catch (SQLException e1) {
////				e1.printStackTrace();
////			}
////		} finally {
////
////			if (preparedStatement != null) {
////				try {
////					preparedStatement.close();
////				} catch (SQLException e) {
////					e.printStackTrace();
////				}
////			}
////		}
////
////		return res;
////	}
////
//}
