package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.SaleSuccessDTO;
import com.example.demo.dto.SaleSumDTO;
import com.example.demo.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("select "
			+ "new com.example.demo.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "from Sale obj "
			+ "group by obj.seller")
	List<SaleSumDTO> amountGroupBySeller();
	
	@Query("select "
			+ "new com.example.demo.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "from Sale obj "
			+ "group by obj.seller")
	List<SaleSuccessDTO> successGroupBySeller();
}
