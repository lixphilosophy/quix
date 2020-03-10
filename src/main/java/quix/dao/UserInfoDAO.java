package quix.dao;

import org.hibernate.Session;
import quix.domain.UserInfo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserInfoDAO {

    public UserInfo getUser(String username, String password, Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
        Root<UserInfo> root = cq.from(UserInfo.class);

        cq.where(cb.and(
                cb.equal(root.get("userName"), username),
                cb.equal(root.get("userPassword"), password)
        ));

        List<UserInfo> res = session.createQuery(cq).getResultList();

        return res == null || res.size() != 1 ? null : res.get(0);
    }

    public UserInfo getUserById(int userId, Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
        Root<UserInfo> root = cq.from(UserInfo.class);

        cq.where(cb.equal(root.get("userId"), userId));

        List<UserInfo> res = session.createQuery(cq).getResultList();

        return res == null || res.size() != 1 ? null : res.get(0);
    }

    public List<UserInfo> getUsers(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
        Root<UserInfo> root = cq.from(UserInfo.class);

        cq.select(root);

        return session.createQuery(cq).getResultList();
    }

}
