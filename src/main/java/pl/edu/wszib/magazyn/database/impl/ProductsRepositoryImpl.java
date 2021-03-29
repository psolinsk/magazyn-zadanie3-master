package pl.edu.wszib.magazyn.database.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.magazyn.database.IProductsRepository;
import pl.edu.wszib.magazyn.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsRepositoryImpl implements IProductsRepository {

    private final List<Product> products = new ArrayList<>();

    @Override
    public boolean addProductQuantity(String code, int quantity) {
        for (Product currentProduct : products){
            if (currentProduct.getCode().equals(code)){
                int newQuantity = quantity + currentProduct.getQuantity();
                currentProduct.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteProductQuantity(String code, int quantity) {
        for (Product currentProduct : products){
            if (currentProduct.getCode().equals(code) && currentProduct.getQuantity() >= quantity){
                int newQuantity = currentProduct.getQuantity() - quantity;
                currentProduct.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.products;
    }
    @Override
    public Product getProductByCode(String code){
        for (Product product : this.products){
            if (product.getCode().equals(code)){
                return product;
            }
        }
        return null;
    }
}
