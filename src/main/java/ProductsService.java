import dao.ProductDaoHibernateImpl;
import models.Product;

import java.util.List;

public class ProductsService {
    private ProductDaoHibernateImpl dao;

    public ProductsService(ProductDaoHibernateImpl dao) {
        this.dao = dao;
    }

    public List<Product> getProductsFromFile(String fileName) {
        return importerService.getInstance().readFromCSV(fileName);
    }

    public void insertProducts(List<Product> videojuegos) {
        dao.insertAll(videojuegos);
    }
}
