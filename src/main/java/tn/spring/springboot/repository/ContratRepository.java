package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.spring.springboot.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
    @Query("Select C from Contrat C where C.dateDebutContrat = ?1 and C.dateFinContrat = ?2 and C.archive=false")
    public List<Contrat> getContratByDate(Date startDate, Date endDate);
}
