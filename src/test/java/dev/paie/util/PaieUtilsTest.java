package dev.paie.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PaieUtilsTest {

	private PaieUtils paieUtils;
	private ClassPathXmlApplicationContext context;

	@Before
	public void onSetup() {
		context = new ClassPathXmlApplicationContext("appConfig.xml");
		paieUtils = context.getBean(PaieUtils.class);
	}

	@Test
	public void test_formaterBigDecimal_entier_positif() {

		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2"));

		assertThat(resultat, equalTo("2.00"));

	}

	@Test
	public void test_formaterBigDecimal_trois_chiffres_apres_la_virgule() {

		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2.199"));

		assertThat(resultat, equalTo("2.20"));

	}

	@Test
	public void test_additionBigDecimal() {
		BigDecimal a = new BigDecimal("2.499");
		BigDecimal b = new BigDecimal("5.5");
		String resultat = paieUtils.formaterBigDecimal(a.add(b));

		assertThat(resultat, equalTo("8.00"));

	}

	@After
	public void onExit() {
		context.close();
	}
}