package quix.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import quix.config.HibernateConfigUtil;
import quix.dao.QuestionDAO;
import quix.domain.Choice;
import quix.domain.Question;
import quix.domain.QuizInfo;
import quix.pojo.ChoicePOJO;
import quix.pojo.QuestionPOJO;

import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    public static Question getQuestion(int questionID, boolean currentSession) {

        Session session = null;
        if(currentSession) session = HibernateConfigUtil.getCurrentSession();
        else session = HibernateConfigUtil.openSession();

        Transaction transaction = null;
        QuestionDAO questionDAO = new QuestionDAO();

        Question question = null;

        try {

            transaction = session.beginTransaction();

            question = questionDAO.getQuestion(questionID, session);
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

        return question;
    }

    public static boolean updateQuestionStatus(int questionID, int questionStatus) {
        Session session = HibernateConfigUtil.getCurrentSession();
        Transaction transaction = null;

        boolean success = true;

        try {
            transaction = session.beginTransaction();

            Question question = getQuestion(questionID, false);
            question.setStatus(questionStatus);

            session.merge(question);

            transaction.commit();

        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            success = false;
            e.printStackTrace();
        } finally {
            session.close();
        }

        return success;
    }

    public static boolean addQuestion(QuestionPOJO questionPOJO) {
        Session session = HibernateConfigUtil.getCurrentSession();
        Transaction transaction = null;

        boolean success = true;

        try {
            transaction = session.beginTransaction();

            Question question = new Question();

            question.setQuestionType(questionPOJO.getQuestionType());
            question.setQuestionString(questionPOJO.getQuestionString());
            question.setModifiedTime(questionPOJO.getModifiedTime());
            question.setStatus(questionPOJO.getStatus());

            List<ChoicePOJO> choicePOJOS = questionPOJO.getChoicesPOJOs();

            List<Choice> choices = new ArrayList<>();
            for(ChoicePOJO choicePOJO : choicePOJOS) {
                Choice choice = new Choice();
                choice.setChoiceString(choicePOJO.getChoiceString());
                choice.setIfCorrect(choicePOJO.isIfCorrect());
                choice.setQuestion(question);
                choices.add(choice);
            }
            question.setChoices(choices);

            QuizInfo quizInfo = QuizInfoService.getQuizById(questionPOJO.getQuizID(), false);

            quizInfo.getQuestions().add(question);
            question.setQuizInfo(quizInfo);

            session.merge(question);

            transaction.commit();

        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            success = false;
            e.printStackTrace();
        } finally {
            session.close();
        }

        return success;
    }
}
