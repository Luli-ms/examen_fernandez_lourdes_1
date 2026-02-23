package dao;

import models.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import providers.SessionProvider;

import java.util.List;

public class ProductDaoHibernateImpl {
    public Integer insertAll(List<Product> products) {
        int salida = 0;
        Transaction tx = null;
        try(Session session = SessionProvider.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            for(Product product : products){
                product.setId(null); // Forzar a que se autogeneren
                session.persist(product); // Para objetos sin ID
                salida++;
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new RuntimeException("Error al insertar productos", e);
        }
        return salida;
    }

    public List<Product> findLowStock(Integer min) {
        try (Session session = SessionProvider.getSessionFactory().openSession()) {

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar videojuegos", e);
        }
        return null;
    }

    public List<Product> findIn(Double min, Double max) {
        try (Session session = SessionProvider.getSessionFactory().openSession()) {

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar videojuegos", e);
        }
        return null;
    }
}
