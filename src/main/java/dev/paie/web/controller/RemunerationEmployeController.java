package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Collegue;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.CollegueRepository;
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
	@Autowired
	CollegueRepository collegueRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");

		List<Entreprise> entrepriseList = entreprise.findAll();
		mv.addObject("entreprise", entrepriseList);

		List<ProfilRemuneration> profilList = profil.findAll();
		mv.addObject("profil", profilList);

		List<Grade> gradeList = grade.findAll();
		mv.addObject("grade", gradeList);

		RestTemplate rt = new RestTemplate();
		Collegue[] result = rt.getForObject("http://collegues-api.cleverapps.io/collegues", Collegue[].class);
		List<String> collegueList = new ArrayList<>();
		for (Collegue collegue : result) {
			collegueList.add(collegue.getMatricule());
		}
		mv.addObject("matricule", collegueList);

		mv.addObject("employe", new RemunerationEmploye());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creer")
<<<<<<< HEAD
=======
	@Secured("ROLE_ADMINISTRATEUR")
>>>>>>> master
	public String creerEmployePost(@ModelAttribute("employe") RemunerationEmploye remunerationEmploye,
			Collegue collegue) {
		remunerationEmploye.setDate(LocalDateTime.now());
		remunerationEmployeRepository.save(remunerationEmploye);
		return "redirect:/mvc/employes/lister";

	}

	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	@Secured({ "ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR" })
	public ModelAndView ListerEmploye() {
		ModelAndView mv = new ModelAndView();
		List<RemunerationEmploye> remunerationEmployesList = remunerationEmployeRepository.findAll();
		mv.addObject("remunerationEmploye", remunerationEmployesList);
		mv.setViewName("employes/listerEmploye");
		return mv;

	}

}