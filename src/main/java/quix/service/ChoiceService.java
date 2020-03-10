package quix.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import quix.config.HibernateConfigUtil;
import quix.dao.ChoiceDAO;
import quix.domain.Choice;

public class ChoiceService {

    public static boolean ifCorrect(int questionID, String choiceString, boolean currentSession) {

        Session session = null;
        if(currentSession) session = HibernateConfigUtil.getCurrentSession();
        else session = HibernateConfigUtil.openSession();

        Transaction transaction = null;
        ChoiceDAO choiceDAO = new ChoiceDAO();
        boolean res = true;

        try {
            transaction = session.beginTransaction();

            res = choiceDAO.ifCorrect(questionID, choiceString, session);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return res;
    }
}
