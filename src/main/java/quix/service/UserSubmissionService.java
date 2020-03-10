package quix.service;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import quix.config.HibernateConfigUtil;
import quix.dao.UserInfoDAO;
import quix.dao.UserSubmissionDAO;
import quix.domain.*;
import quix.pojo.UserAnswerPOJO;
import quix.pojo.UserSubmissionPOJO;

import java.util.ArrayList;
import java.util.List;

public class UserSubmissionService {

    public static boolean setSubmission(UserSubmissionPOJO userSubmissionPOJO) {
        return setSubmissionWithReturn(userSubmissionPOJO) != null;
    }

    public static UserSubmission setSubmissionWithReturn(UserSubmissionPOJO userSubmissionPOJO) {
        Session session = HibernateConfigUtil.getCurrentSession();
        Transaction transaction = null;
        UserSubmission userSubmission = null;

        try {
            transaction = session.beginTransaction();
            userSubmission = new UserSubmission();

            userSubmission.setStartTime(userSubmissionPOJO.getStartTime());
            userSubmission.setEndTime(userSubmissionPOJO.getEndTime());

            UserInfo userInfo = UserInfoService.getUserById(userSubmissionPOJO.getUserID(), false);
            userInfo.getUserSubmissions().add(userSubmission);
            userSubmission.setUserInfo(userInfo);

            QuizInfo quizInfo = QuizInfoService.getQuizById(userSubmissionPOJO.getQuizId(), false);
            userSubmission.setQuizInfo(quizInfo);

            userSubmission = (UserSubmission) session.merge(userSubmission);

            int correctCount = 0, totalCount = 0;
            for(UserAnswerPOJO userAnswerPOJO : userSubmissionPOJO.getUserAnswerPOJOs()) {

                UserAnswer userAnswer = new UserAnswer();
                String answerString = userAnswerPOJO.getAnswerString();
                int questionID = userAnswerPOJO.getQuestionID();

                userAnswer.setAnswerString(answerString);

                Question question = QuestionService.getQuestion(questionID, false);
                userAnswer.setQuestion(question);

                boolean ifCorrect = ChoiceService.ifCorrect(questionID, answerString, false);
                if(ifCorrect) correctCount++;
                userAnswer.setIfCorrect(ifCorrect);

                totalCount++;

                userAnswer.setUserSubmission(userSubmission);

                session.merge(userAnswer);
            }
            userSubmission.setCorrectCount(correctCount);
            userSubmission.setTotalCount(totalCount);

            userSubmission = (UserSubmission) session.merge(userSubmission);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userSubmission;
    }

    public static UserSubmission getSubmission(int submissionId) {

        Session session =  HibernateConfigUtil.getCurrentSession();

        Transaction transaction = null;
        UserSubmissionDAO userSubmissionDAO = new UserSubmissionDAO();

        UserSubmission userSubmission = null;

        try {

            transaction = session.beginTransaction();

            userSubmission = userSubmissionDAO.getSubmission(submissionId, session);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userSubmission;
    }

    public static UserSubmission getSubmissionWithCache(int submissionId) {

        Session session =  HibernateConfigUtil.getCurrentSession();

        Transaction transaction = null;
        UserSubmissionDAO userSubmissionDAO = new UserSubmissionDAO();

        UserSubmission userSubmission = null;

        try {

            transaction = session.beginTransaction();

            userSubmission = userSubmissionDAO.getSubmission(submissionId, session);

            userSubmission.getUserAnswers().size();

            for(UserAnswer userAnswer : userSubmission.getUserAnswers())
                userAnswer.getQuestion().getChoices().size();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userSubmission;
    }

    public static List<UserSubmission> getSubmissions() {

        Session session =  HibernateConfigUtil.getCurrentSession();

        Transaction transaction = null;
        UserSubmissionDAO userSubmissionDAO = new UserSubmissionDAO();

        List<UserSubmission> userSubmissions = new ArrayList<>();

        try {

            transaction = session.beginTransaction();

            userSubmissions = userSubmissionDAO.getSubmissions(session);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userSubmissions;
    }
}
