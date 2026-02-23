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

        System.out.println("PRODUCTOS CON PRECIO ENTRE 30.00 Y 100.00:");
        System.out.println(service.findIn(30.00, 100.00));
        System.out.println();
        System.out.println("PRODUCTOS CON STOCK MENOR A 20.00:");
        System.out.println(service.findLowStock(20));
    }
}
