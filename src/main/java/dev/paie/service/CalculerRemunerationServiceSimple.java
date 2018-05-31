package dev.paie.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.bulletinSalaireRepository;
import dev.paie.util.PaieUtils;

@Service
@Transactional
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	PaieUtils paieUtils;

	@Autowired
	bulletinSalaireRepository bulletinSalaireRepository;

	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();
		BigDecimal salaire_de_base = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		resultat.setSalaireDeBase(paieUtils.formaterBigDecimal(salaire_de_base));

		BigDecimal salaire_brut = salaire_de_base.add(bulletin.getPrimeExceptionnelle());
		String salaire_brutString = (paieUtils.formaterBigDecimal(salaire_brut));
		resultat.setSalaireBrut(salaire_brutString);
		BigDecimal salaire_brut2 = new BigDecimal(salaire_brutString);

		List<Cotisation> cotisationList = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsNonImposables();
		BigDecimal retenueSalariale = new BigDecimal("0.00");
		BigDecimal cotisationPatronale = new BigDecimal("0.00");
		for (Cotisation cotisation : cotisationList) {
			if (cotisation.getTauxSalarial() != null) {
				retenueSalariale = retenueSalariale.add(cotisation.getTauxSalarial().multiply(salaire_brut2));
			}
			if (cotisation.getTauxPatronal() != null) {
				cotisationPatronale = cotisationPatronale.add(cotisation.getTauxPatronal().multiply(salaire_brut2));
			}
		}
		String retenue = paieUtils.formaterBigDecimal(retenueSalariale);
		BigDecimal retenueD = new BigDecimal(paieUtils.formaterBigDecimal(retenueSalariale));
		resultat.setTotalRetenueSalarial(retenue);

		resultat.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(cotisationPatronale));

		BigDecimal netImposable = salaire_brut2.subtract(retenueD);
		String netImposableString = paieUtils.formaterBigDecimal(netImposable);
		resultat.setNetImposable(netImposableString);

		List<Cotisation> cotisationImposableList = bulletin.getRemunerationEmploye().getProfilRemuneration()
				.getCotisationsImposables();
		BigDecimal netAPayerPro = new BigDecimal("0.00");
		for (Cotisation cotisation2 : cotisationImposableList) {
			if (cotisation2.getTauxSalarial() != null) {
				netAPayerPro = netAPayerPro.add(cotisation2.getTauxSalarial().multiply(salaire_brut));
			}
		}
		BigDecimal netAPayer = netImposable.subtract(netAPayerPro);
		resultat.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));
		return resultat;
	}

	@Override
	public Map<BulletinSalaire, ResultatCalculRemuneration> fullBulletin() {
		Map<BulletinSalaire, ResultatCalculRemuneration> BulletinCalcule = new HashMap<>();
		for (BulletinSalaire bulletin : bulletinSalaireRepository.findAll()) {
			BulletinCalcule.put(bulletin, calculer(bulletin));
		}
		return BulletinCalcule;
	}

<<<<<<< HEAD
	// @Override
	// public BulletinResultatCalcul recupererBulletinAvecCalcul(Integer id) {
	// BulletinSalaire bulletinSalaire = bulletinSalaireRepository.findOne(id);
	// return BulletinResultatCalcul(bulletinSalaire,
	// calculer(bulletinSalaire));
	// }
=======
	@Override
	public BulletinResultatCalcul recupererBulletinAvecCalcul(Integer id) {
		BulletinSalaire bulletinSalaire = bulletinSalaireRepository.findOne(id);
		return new BulletinResultatCalcul(bulletinSalaire, calculer(bulletinSalaire));
	}
>>>>>>> master

}
