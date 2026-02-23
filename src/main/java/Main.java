import dao.ProductDaoHibernateImpl;
import models.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductsService service = new ProductsService(
                new ProductDaoHibernateImpl()
        );
        List<Product> products = service.getProductsFromFile("productos.csv");
        service.insertProducts(products);
    }
}
