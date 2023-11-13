package br.com.fiap;

import br.com.fiap.model.Produto;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.fiap.model.Produto;
import br.com.fiap.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {

	@Mock
	private ProdutoRepository produtoRepository;

	@InjectMocks
	private ProdutoService produtoService;

	@Test
    void findAll() {
        when(produtoRepository.findAll()).thenReturn(Arrays.asList(new Produto(), new Produto()));

        List<Produto> produtos = produtoService.findAll();
        assertNotNull(produtos);
        assertEquals(2, produtos.size());

        verify(produtoRepository, times(1)).findAll();
    }

	@Test
    void findById_CenarioDeSucesso() {
     
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(new Produto()));

   
        Optional<Produto> produto = produtoService.findById(1L);
        assertTrue(produto.isPresent());

   
        verify(produtoRepository, times(1)).findById(1L);
    }

	@Test
    void findById_CenarioDeNaoEncontrado() {
   
        when(produtoRepository.findById(1L)).thenReturn(Optional.empty());

        
        Optional<Produto> produto = produtoService.findById(1L);
        assertFalse(produto.isPresent());

        
        verify(produtoRepository, times(1)).findById(1L);
    }

	@Test
	void save() {

		Produto produtoParaSalvar = new Produto();

		when(produtoRepository.save(produtoParaSalvar)).thenReturn(new Produto());

		Produto produtoSalvo = produtoService.save(produtoParaSalvar);
		assertNotNull(produtoSalvo);

		verify(produtoRepository, times(1)).save(produtoParaSalvar);
	}

	@Test
	void deleteById() {

		produtoService.deleteById(1L);

		verify(produtoRepository, times(1)).deleteById(1L);
	}
}
