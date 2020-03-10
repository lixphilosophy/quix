package quix.dao;

import org.hibernate.Session;
import quix.domain.QuizInfo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QuizInfoDAO {

    public List<QuizInfo> getQuizzes(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<QuizInfo> cq = cb.createQuery(QuizInfo.class);
        Root<QuizInfo> root = cq.from(QuizInfo.class);

        cq.select(root);

        return session.createQuery(cq).getResultList();
    }

    public QuizInfo getQuiz(int quizID, Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<QuizInfo> cq = cb.createQuery(QuizInfo.class);
        Root<QuizInfo> root = cq.from(QuizInfo.class);

        cq.where(cb.equal(root.get("quizID"), quizID));

        List<QuizInfo> res = session.createQuery(cq).getResultList();

        return res == null || res.size() != 1 ? null : res.get(0);
    }
}
