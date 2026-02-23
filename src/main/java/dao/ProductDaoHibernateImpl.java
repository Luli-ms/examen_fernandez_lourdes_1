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

    public List<Product> getAllProductsByStockLesserThan(Integer min) {
        List<Product> products;
        try (Session session = SessionProvider.getSessionFactory().openSession()) {
            products = session
                    .createQuery("from Product where stock<:min", Product.class)
                    .setParameter("min", min)
                    .list();
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar videojuegos", e);
        }
        return products;
    }

    public List<Product> getAllProductsByPrecioBetween(Double min, Double max) {
        List<Product> products;
        try (Session session = SessionProvider.getSessionFactory().openSession()) {
            products = session
                    .createQuery("from Product where precio>:min and precio<:max", Product.class)
                    .setParameter("min", min)
                    .setParameter("max", max)
                    .list();
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar videojuegos", e);
        }
        return products;
    }
}
