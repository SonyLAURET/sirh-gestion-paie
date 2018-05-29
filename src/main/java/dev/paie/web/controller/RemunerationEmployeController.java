package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunationEmployeRepositoy;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {

	@Autowired
	EntrepriseRepository entreprise;
	@Autowired
	ProfilRemunerationRepository profil;
	@Autowired
	GradeRepository grade;
	@Autowired
	RemunationEmployeRepositoy remunerationEmployeRepository;
	@Autowired
	PeriodeRepository periode;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");

		List<Entreprise> entrepriseList = entreprise.findAll();
		mv.addObject("entreprise", entrepriseList);

		List<ProfilRemuneration> profilList = profil.findAll();
		mv.addObject("profil", profilList);

		List<Grade> gradeList = grade.findAll();
		mv.addObject("grade", gradeList);

		mv.addObject("employe", new RemunerationEmploye());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmployePost(@ModelAttribute("employe") RemunerationEmploye remunerationEmploye) {
		remunerationEmploye.setDate(LocalDateTime.now());
		remunerationEmployeRepository.save(remunerationEmploye);
		return "redirect:/mvc/employes/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView ListerEmploye() {
		ModelAndView mv = new ModelAndView();
		List<RemunerationEmploye> remunerationEmployesList = remunerationEmployeRepository.findAll();
		mv.addObject("remunerationEmploye", remunerationEmployesList);
		mv.setViewName("employes/listerEmploye");
		return mv;

	}

}