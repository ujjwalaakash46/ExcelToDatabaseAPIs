package project.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	//find product name by supplier and which is not expired
	@Query("select DISTINCT p.name from Product p where p.supplier like %?1% and p.exp>=?2")
	Page<String> findBySupplierAndExp( String supplier, Date date, Pageable p);
	
	//find product name by supplier and which is in stock
	@Query("select DISTINCT p.name from Product p where p.supplier like %?1% and p.stock>=0")
	Page<String> findBySupplierAndInstock(String supplier, Pageable p);

	//find product details by product name
	Page<Product> findByName(String name, Pageable p);

}
