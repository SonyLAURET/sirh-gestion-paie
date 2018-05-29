package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.RemunerationEmploye;

public interface RemunationEmployeRepositoy extends JpaRepository<RemunerationEmploye, Integer> {

}
