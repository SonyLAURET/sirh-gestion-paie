package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.BulletinSalaire;

public interface bulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {

}
