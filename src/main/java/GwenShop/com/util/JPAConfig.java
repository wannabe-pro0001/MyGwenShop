package GwenShop.com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfig {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("springDBMSSQL");
        return factory.createEntityManager();

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("springDBMSSQL");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}