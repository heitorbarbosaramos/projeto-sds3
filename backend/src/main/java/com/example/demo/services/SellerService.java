package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SellerDTO;
import com.example.demo.entities.Seller;
import com.example.demo.repositories.SellerRepository;

@Service
public class SellerService {
	
	private final SellerRepository repo;
	
	@Autowired
	public SellerService(SellerRepository repo) {
		this.repo = repo;
	}
	
	public List<SellerDTO> findAll(){
		List<Seller> lista = repo.findAll();
		List<SellerDTO> listaDTO = lista.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		return listaDTO;
	}

}
