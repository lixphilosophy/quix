package quix.starter;

import quix.domain.UserInfo;
import quix.service.UserInfoService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Starter {

    public static void main(String[] args) {

        Starter applicationStarter = new Starter();
        Properties properties = applicationStarter.loadPropertiesFile("db.properties");
        properties.forEach((k, v) -> System.out.println(k + " : " + v));

        UserInfo userInfo = UserInfoService.getUser("martin", "123456");

        System.out.println(userInfo);

//        Session session = HibernateConfigUtil.openSession();
//        Transaction transaction = null;
//
//        try {
//            System.out.println("connected!");
//
//            transaction = session.beginTransaction();
//
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
//            Root<UserInfo> root = cq.from(UserInfo.class);
//
//            cq.select(root);
//
//            List<UserInfo> res = session.createQuery(cq).getResultList();
//
//            System.out.println(res);
//
//            transaction.commit();
//
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }

    }

    public Properties loadPropertiesFile(String filePath) {

        Properties prop = new Properties();

        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
}
