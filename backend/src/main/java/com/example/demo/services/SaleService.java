package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.SaleDTO;
import com.example.demo.entities.Sale;
import com.example.demo.repositories.SaleRepository;
import com.example.demo.repositories.SellerRepository;

@Service
public class SaleService {
	
	private final SaleRepository repo;
	
	private final SellerRepository sallerRepository;
	
	@Autowired
	public SaleService(SaleRepository repo, SellerRepository sallerRepository) {
		this.repo = repo;
		this.sallerRepository = sallerRepository;
	}
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sallerRepository.findAll();
		Page<Sale> lista = repo.findAll(pageable);
		Page<SaleDTO> listaDTO = lista.map(x -> new SaleDTO(x));
		return listaDTO;
	}

}
