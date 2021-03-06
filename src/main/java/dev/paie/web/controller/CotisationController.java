package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@RestController
@ControllerAdvice
@RequestMapping("/api/cotisations")
public class CotisationController extends ResponseEntityExceptionHandler {

	@Autowired
	CotisationRepository cotisationRepository;

	@RequestMapping(method = RequestMethod.GET)
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public List<Cotisation> listerCotisation() {
		return cotisationRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{code}")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public Cotisation cotisationByCode(@PathVariable("code") String code) {
		return cotisationRepository.findByCode(code);
	}

	@RequestMapping(method = RequestMethod.POST)
	@Secured("ROLE_ADMINISTRATEUR")
	public void insererCotisation(@RequestBody Cotisation cotisation) {
		cotisationRepository.save(cotisation);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{code}")
	@Secured("ROLE_ADMINISTRATEUR")
	public void cotisationMAJ(@PathVariable String code, @RequestBody Cotisation cotisation) {
		cotisation.setId(cotisationRepository.findByCode(code).getId());
		cotisationRepository.save(cotisation);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{code}")
	@Secured("ROLE_ADMINISTRATEUR")
	public void deleteCotisation(@PathVariable String code) {
		cotisationRepository.delete(cotisationRepository.findByCode(code).getId());
	}
}