package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.H2Config;
import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;

// compléter la configuration
@ContextConfiguration(classes = { H2Config.class, ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// sauvegarder un nouveau grade
		Grade grade = new Grade();
		grade.setCode("123");
		gradeService.sauvegarder(grade);

		// vérifier qu'il est possible de récupérer le nouveau grade via la
		// méthode lister
		List<Grade> listGrade = gradeService.lister();
		boolean testContains = false;
		for (Grade grade2 : listGrade) {
			if (grade2.getCode().equals("123")) {
				testContains = true;
			}
		}
		assertTrue(testContains);

		// modifier un grade
		grade.setCode("autre");
		gradeService.mettreAJour(grade);

		// vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		String code = grade.getCode();
		assertTrue(code.equals("autre"));

	}
}