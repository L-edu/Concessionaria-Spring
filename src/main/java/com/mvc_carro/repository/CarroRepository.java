package com.mvc_carro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mvc_carro.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
