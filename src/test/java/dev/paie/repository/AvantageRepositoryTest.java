package dev.paie.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {
	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage
		Avantage avantage = new Avantage();
		avantage.setCode("test");
		avantage.setId(1);
		avantage.setMontant(new BigDecimal("45"));
		avantage.setNom("Maxime");
		avantageRepository.save(avantage);

		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
		assertTrue((avantageRepository.findOne(avantage.getId()).getCode()).equals("test"));

		// TODO modifier un avantage
		avantage.setCode("modification");
		avantageRepository.save(avantage);

		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		assertTrue((avantageRepository.findOne(avantage.getId()).getCode()).equals("modification"));
	}

	@Test
	public void test_recherche_code() {
		assertEquals("modification", avantageRepository.findByCode("modification").getCode());
	}
}
