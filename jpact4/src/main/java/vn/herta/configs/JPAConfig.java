package vn.herta.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@PersistenceContext

public class JPAConfig {
 public static EntityManager getEntityManager() {                    //name trong persistence
 EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate-sql");
 return factory.createEntityManager();
 }
}