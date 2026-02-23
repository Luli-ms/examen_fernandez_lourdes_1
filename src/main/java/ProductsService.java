import dao.ProductDaoHibernateImpl;
import models.Product;

import java.util.List;

public class ProductsService {
    private ProductDaoHibernateImpl dao;
    public ProductsService(ProductDaoHibernateImpl dao) {
        this.dao = dao;
    }

    public List<Product> getProductsFromFile(String fileName) {
        return ImporterService.getInstance().readFromCSV(fileName);
    }

    public void insertProducts(List<Product> videojuegos) {
        dao.insertAll(videojuegos);
    }

    public List<Product> findLowStock(Integer stock) {
        return dao.getAllProductsByStockLesserThan(stock);
    }

    public List<Product> findIn(Double min, Double max) {
        return dao.getAllProductsByPrecioBetween(min, max);
    }
}
