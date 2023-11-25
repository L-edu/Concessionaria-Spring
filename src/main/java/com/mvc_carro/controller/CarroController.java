package com.mvc_carro.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mvc_carro.model.Carro;
import com.mvc_carro.repository.CarroRepository;

@Controller
@RequestMapping("carro")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;

	// CREATE
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("carro/cadastro");
		modelAndView.addObject("carro", new Carro());
		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Carro carro, @RequestParam("filecarro") MultipartFile file) throws IOException {

		try {
			carro.setFoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("redirect:/carro");
		carroRepository.save(carro);

		return modelAndView;

	}

	// READ
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("carro/listar.html");
		List<Carro> carros = carroRepository.findAll();
		modelAndView.addObject("carros", carros);
		return modelAndView;
	}

	// READ BY ID
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("carro/detalhar.html");

		Carro carro = carroRepository.getReferenceById(id);
		modelAndView.addObject("carro", carro);

		return modelAndView;
	}

	@GetMapping("/foto/{id}")
	@ResponseBody
	public byte[] exibirFoto(@PathVariable("id") Long id) {
		Carro carro = this.carroRepository.getReferenceById(id);
		return carro.getFoto();
	}

	// UPDATE
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {

		ModelAndView modelAndView = new ModelAndView("carro/edicao");
		Carro carro = carroRepository.getReferenceById(id);
		modelAndView.addObject("carro", carro);
		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Carro carro, @RequestParam("filecarro") MultipartFile file) throws IOException {

		try {
			carro.setFoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		carroRepository.save(carro);
		ModelAndView modelAndView = new ModelAndView("redirect:/carro");

		return modelAndView;

	}

	// DELETE
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/carro");
		carroRepository.deleteById(id);
		return modelAndView;
	}
}
