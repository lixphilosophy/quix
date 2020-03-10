package quix.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import quix.config.HibernateConfigUtil;
import quix.dao.QuizInfoDAO;
import quix.domain.Question;
import quix.domain.QuizInfo;

import java.util.List;

public class QuizInfoService {

    public static List<QuizInfo> getQuizzes() {
        Session session = HibernateConfigUtil.getCurrentSession();
        Transaction transaction = null;
        QuizInfoDAO quizInfoDAO = new QuizInfoDAO();

        List<QuizInfo> quizInfos = null;

        try {

            transaction = session.beginTransaction();

            quizInfos = quizInfoDAO.getQuizzes(session);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return quizInfos;
    }

    public static QuizInfo getQuizById(int quizID, boolean currentSession) {

        Session session = null;
        if(currentSession) session = HibernateConfigUtil.getCurrentSession();
        else session = HibernateConfigUtil.openSession();

        Transaction transaction = null;
        QuizInfoDAO quizInfoDAO = new QuizInfoDAO();

        QuizInfo quizInfo = null;

        try {

            transaction = session.beginTransaction();

            quizInfo = quizInfoDAO.getQuiz(quizID, session);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return quizInfo;
    }

    public static QuizInfo getQuizWithCache(int quizID) {
        Session session = HibernateConfigUtil.getCurrentSession();
        Transaction transaction = null;
        QuizInfoDAO quizInfoDAO = new QuizInfoDAO();

        QuizInfo quizInfo = null;

        try {

            transaction = session.beginTransaction();

            quizInfo = quizInfoDAO.getQuiz(quizID, session);

            List<Question> questions = quizInfo.getQuestions();
            for(Question question : questions)
                question.getChoices().size();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return quizInfo;
    }
}
