package dev.paie.service;

import java.time.LocalDate;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	private static final Logger LOG = LoggerFactory.getLogger(InitialiserDonneesServiceDev.class);

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void initialiser() {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"cotisations-non-imposables.xml", "entreprises.xml", "grades.xml", "profils-remuneration.xml")) {

			// Stream de Classe qui est correspond à des objets à cause du
			// "flatMap" qui applatit les stream.
			// on fait alors une boucle sur les objets et on les persiste.
			Stream.of(Entreprise.class, Grade.class, Cotisation.class, ProfilRemuneration.class)
					.flatMap(uneClasse -> context.getBeansOfType(uneClasse).values().stream()).forEach(em::persist);

			/*
			 * // Sans le stream Collection<Entreprise> entrepriseCollection =
			 * context.getBeansOfType(Entreprise.class).values(); for
			 * (Entreprise entreprise : entrepriseCollection) {
			 * em.persist(entreprise); } Collection<Grade> gradeCollection =
			 * context.getBeansOfType(Grade.class).values(); for (Grade grade :
			 * gradeCollection) { em.persist(grade); }
			 * Collection<ProfilRemuneration> profilRemunerationCollection =
			 * context .getBeansOfType(ProfilRemuneration.class).values(); for
			 * (ProfilRemuneration profilRemuneration :
			 * profilRemunerationCollection) { em.persist(profilRemuneration); }
			 * Collection<Cotisation> cotisationsCollection =
			 * context.getBeansOfType(Cotisation.class).values(); for
			 * (Cotisation cotisation : cotisationsCollection) {
			 * em.persist(cotisation); }
			 */

			LocalDate start = null;
			LocalDate end = null;
			for (int i = 1; i < 13; i++) {
				Periode periode = new Periode();
				start = LocalDate.of(LocalDate.now().getYear(), i, 1);
				end = LocalDate.of(LocalDate.now().getYear(), i, LocalDate.now().withMonth(i).lengthOfMonth());
				periode.setDateDebut(start);
				periode.setDateFin(end);
				em.persist(periode);
			}
			/*
			 * IntStream.rangeClosed(1, 12).mapToObj(i -> { Periode periode =
			 * new Periode(); periode.setDateDebut(
			 * LocalDate.of(LocalDate.now().getYear(), i, 1));
			 * periode.setDateFin(LocalDate.of(LocalDate.now().getYear(), i,
			 * LocalDate.now().withMonth(i).lengthOfMonth())); return p;
			 * }).forEach(em::persist);
			 */

		}
		// désormais inutile car try(resource){} -> try-with-resources
		// context.close();

	}

}
