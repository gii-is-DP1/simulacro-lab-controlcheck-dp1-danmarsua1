package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.owner.Owner;



public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("SELECT product FROM Product product")
	List<Product> findAll();
    
    @Query("SELECT type FROM ProductType type")
    List<ProductType> findAllProductTypes();
    
    @Query("SELECT product FROM Product product WHERE product.id =:id")
    Optional<Product> findById(@Param("id") int id);
    
    Product findByName(String name);
    
    @Query("SELECT type FROM ProductType type WHERE type.name = :name")
    ProductType getProductType(String name);
    
    @Query("SELECT product FROM Product product WHERE product.price < :cost")
	List<Product> findByPriceLessThan(double cost);
    
    Product save(Product p);
}
