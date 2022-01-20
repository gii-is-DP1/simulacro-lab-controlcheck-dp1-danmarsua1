package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@Size(min = 3, max = 50)
	@Column(name = "name")
	@NotEmpty
    String name;
	
	@Column(name = "price")
	@PositiveOrZero
    double price;
	
	@ManyToOne
	@JoinColumn(name = "product_type")
    ProductType productType;
}
