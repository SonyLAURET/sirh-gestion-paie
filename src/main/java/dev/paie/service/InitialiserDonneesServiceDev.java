package dev.paie.service;

import java.time.LocalDate;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	private static final Logger LOG = LoggerFactory.getLogger(InitialiserDonneesServiceDev.class);

	@PersistenceContext
	EntityManager em;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {
		String iciUnMotDePasse = "topSecret";
		String iciMotDePasseHashe = this.passwordEncoder.encode(iciUnMotDePasse);

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"cotisations-non-imposables.xml", "entreprises.xml", "grades.xml", "profils-remuneration.xml")) {

			// Stream de Classe qui est correspond à des objets à cause du
			// "flatMap" qui applatit les stream.
			// on fait alors une boucle sur les objets et on les persiste.
			Stream.of(Entreprise.class, Grade.class, Cotisation.class, ProfilRemuneration.class)
					.flatMap(uneClasse -> context.getBeansOfType(uneClasse).values().stream()).forEach(em::persist);

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

			// creation d'un utilisateur
			Utilisateur user = new Utilisateur();
			user.setNomUtilisateur("utilisateur");
			user.setMotDePasse(iciMotDePasseHashe);
			user.setEstActif(true);
			user.setRole(ROLES.ROLE_UTILISATEUR);
			em.persist(user);

			Utilisateur admin = new Utilisateur();
			admin.setNomUtilisateur("admin");
			admin.setMotDePasse(iciMotDePasseHashe);
			admin.setEstActif(true);
			admin.setRole(ROLES.ROLE_ADMINISTRATEUR);
			em.persist(admin);
		}
		// désormais inutile car try(resource){} -> try-with-resources
		// context.close();

	}

}
