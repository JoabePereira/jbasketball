package br.com.jbasketball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jbasketball.model.Jogo;
import br.com.jbasketball.repository.Jogos;

@Controller
public class JogoController {
	
	@Autowired
	private Jogos jogos;
	
	//@GetMapping("/inserirJogo")
	@GetMapping("/jogo/novo")
	//public ModelAndView inserirJogo(Jogo jogo) {
	public ModelAndView novo(Jogo jogo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jogo/CadastroJogo");
		mv.addObject("jogo", new Jogo());
		return mv;
	}
	
	@PostMapping("insertJogo")
	public ModelAndView salvar(Jogo jogo) {
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("redirect:/Jogo/listJogos");
		mv.setViewName("redirect:/jogo/novo");
		jogos.save(jogo);
		return mv;
	}
}
