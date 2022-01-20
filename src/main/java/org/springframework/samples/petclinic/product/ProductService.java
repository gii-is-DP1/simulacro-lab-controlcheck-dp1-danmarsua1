package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Transactional(readOnly = true)
	public Optional<Product> findProductById(int id) throws DataAccessException {
		return productRepository.findById(id);
	}
	
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public List<ProductType> getAllProductTypes(){
        return productRepository.findAllProductTypes();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepository.getProductType(typeName);
    }

    public Product save(Product p){
        return null;       
    }

    
}
