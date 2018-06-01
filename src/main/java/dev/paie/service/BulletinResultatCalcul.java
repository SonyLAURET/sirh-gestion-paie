package dev.paie.service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

public class BulletinResultatCalcul {

	private BulletinSalaire bulletin;
	private ResultatCalculRemuneration resultatCalcul;

	public BulletinResultatCalcul(BulletinSalaire bulletin, ResultatCalculRemuneration resultatCalcul) {
		super();
		this.bulletin = bulletin;
		this.resultatCalcul = resultatCalcul;
	}

	public BulletinSalaire getBulletin() {
		return bulletin;
	}

	public void setBulletin(BulletinSalaire bulletin) {
		this.bulletin = bulletin;
	}

	public ResultatCalculRemuneration getResultatCalcul() {
		return resultatCalcul;
	}

	public void setResultatCalcul(ResultatCalculRemuneration resultatCalcul) {
		this.resultatCalcul = resultatCalcul;
	}
}