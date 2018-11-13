package sali.gymi.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sali.gymi.domain.Sali;
import sali.gymi.domain.SaliRepository;
import sali.gymi.domain.LiikeRepository;
import sali.gymi.domain.VisitRepository;
import sali.gymi.domain.Visit;

@Controller
public class SaliController {
	@Autowired
	private SaliRepository saliRepository;
	@Autowired
	private LiikeRepository liikeRepository;
	@Autowired
	private VisitRepository visitRepository;
	

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/date")
	public String addDate(Model model){
		model.addAttribute("visits", new Visit());
		return "date";
	}
	
	@RequestMapping(value="/list")
	public String getSalit(Model model) {
		model.addAttribute("salit", saliRepository.findAll());
		return "list";
	}
	
	@RequestMapping(value="/add")
	public String addLiike(Model model) {
		model.addAttribute("sali", new Sali());
		model.addAttribute("liikkeet", liikeRepository.findAll());
		model.addAttribute("visits", visitRepository.findAll());
		return "sali";
	}
	
	@RequestMapping(value="/salit", method = RequestMethod.GET)
	public @ResponseBody List<Sali> saliListRest() {
		return (List<Sali>) saliRepository.findAll();
	}
	
	@RequestMapping(value="/sali/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Sali> findSaliRest(@PathVariable("id") Long saliId) {
		return saliRepository.findById(saliId);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveSali(@ModelAttribute Sali sali){
		saliRepository.save(sali);
		return "redirect:list";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteSali(@PathVariable("id") Long saliId, Model model) {
		saliRepository.deleteById(saliId);
		return "redirect:../list";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/modify/{id}", method=RequestMethod.GET)
	public String modifySali(@PathVariable("id") Long Id, Model model) {
		model.addAttribute("sali", saliRepository.findById(Id));
		model.addAttribute("liikkeet", liikeRepository.findAll());
		return "modify";
	}
	
	
	
}







