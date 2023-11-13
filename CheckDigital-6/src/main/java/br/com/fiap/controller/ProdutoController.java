package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.model.Produto;
import br.com.fiap.service.ProdutoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public String listarProdutos(Model model) {
		model.addAttribute("produtos", produtoService.findAll());
		return "listar-produtos";
	}
	
	@GetMapping("/novo")
	public String mostarFormularioNovamenteProduto(Model model) {
		model.addAttribute("produto", new Produto());
		return "cadastrar-produtos";
	}
	
	@PostMapping
	public String adicionarProduto(@ModelAttribute @Valid Produto produto, BindingResult result) {
		if(result.hasErrors()) {
			return "cadastrar-produtos";
		}
		produtoService.save(produto);
		return "redirect:/produtos";
	}
	
	  @GetMapping("/editar/{id}")
	  public String mostrarFormularioDeEdicao(@PathVariable Long id, Model model) {
	   Produto produto = produtoService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
	    model.addAttribute("produto", produto);
	    return "cadastrar-produtos";
	  }

	  @PostMapping("/editar/{id}")
	  public String atualizarProduto(@PathVariable Long id, @ModelAttribute Produto produto) {
	    produtoService.save(produto);
	    return "redirect:/produtos";
	  }

	  @GetMapping("/deletar/{id}")
	  public String deletarProduto(@PathVariable Long id) {
	    produtoService.deleteById(id);
	    return "redirect:/produtos";
	  }

}
