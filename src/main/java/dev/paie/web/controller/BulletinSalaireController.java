package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunationEmployeRepositoy;
import dev.paie.repository.bulletinSalaireRepository;
import dev.paie.service.CalculerRemunerationService;

@Controller
@RequestMapping("/bulletin")
public class BulletinSalaireController {

	@Autowired
	RemunationEmployeRepositoy remunerationEmployeRepository;
	@Autowired
	PeriodeRepository periode;
	@Autowired
	bulletinSalaireRepository bulletin;
	@Autowired
	CalculerRemunerationService calculerRemunerationService;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/creerBulletin");

		List<Periode> periodeList = periode.findAll();
		mv.addObject("periode", periodeList);

		List<RemunerationEmploye> RemunerationEmployeList = remunerationEmployeRepository.findAll();
		mv.addObject("remunerationEmploye", RemunerationEmployeList);

		mv.addObject("bulletin", new BulletinSalaire());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerBulletinPost(@ModelAttribute("bulletin") BulletinSalaire bulletinSalaire) {
		bulletinSalaire.setDate(LocalDateTime.now());
		bulletin.save(bulletinSalaire);
		return "redirect:/mvc/bulletin/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView ListerBulletin() {
		ModelAndView mv = new ModelAndView();
		List<BulletinSalaire> bulletinSalaires = bulletin.findAll();
		mv.addObject("bulletinSalaire", bulletinSalaires);
		mv.addObject("calcul", calculerRemunerationService.fullBulletin());
		mv.setViewName("bulletin/listerBulletin");
		return mv;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/visualiser/{id}")
	public ModelAndView VisualiserBulletin(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		List<BulletinSalaire> bulletinSalaires = bulletin.findAll();
		RemunerationEmploye remunerationEmploye = remunerationEmployeRepository.findOne(id);
		mv.addObject("remuneration", remunerationEmploye);
		mv.setViewName("bulletin/visualiserBulletin");
		return mv;
	}
}
