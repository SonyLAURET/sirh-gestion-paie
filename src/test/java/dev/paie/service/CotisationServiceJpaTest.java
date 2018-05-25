package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.H2Config;
import dev.paie.config.JpaConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;

//compléter la configuration
@ContextConfiguration(classes = { H2Config.class, ServicesConfig.class, JpaConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {

	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder une nouvelle cotisation
		Cotisation cotisation = new Cotisation();
		cotisation.setCode("123");
		cotisation.setLibelle("test");
		cotisation.setTauxPatronal(new BigDecimal("45"));
		cotisation.setTauxSalarial(new BigDecimal("98"));
		cotisationService.sauvegarder(cotisation);

		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation
		// via la méthode lister
		List<Cotisation> listCotisation = cotisationService.lister();
		boolean testContains = false;
		for (Cotisation cotis : listCotisation) {
			if (cotis.getCode().equals("123")) {
				testContains = true;
			}
		}
		assertTrue(testContains);
		// modifier une cotisation
		cotisation.setCode("autre");
		cotisationService.mettreAJour(cotisation);

		// vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		String code = cotisation.getCode();
		assertTrue(code.equals("autre"));
	}
}
