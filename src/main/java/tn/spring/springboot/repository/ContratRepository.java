package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entities.Contrat;

import java.util.Date;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
