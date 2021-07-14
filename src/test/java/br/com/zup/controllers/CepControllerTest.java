package br.com.zup.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.zup.configs.HandlerException;
import br.com.zup.configs.exception.CepException;
import br.com.zup.models.Cep;
import br.com.zup.services.CepService;

@RunWith(MockitoJUnitRunner.class)
public class CepControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private CepController controller;
	
	@Mock
	private CepService service;
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new HandlerException()).build();
	}
	
	@Test
	public void testGetCepOK() throws Exception {
		when(service.buscaCep("03932040")).thenReturn(getCep());
		
		mockMvc.perform(get("/cep/busca/03932040")).andExpect(status().isOk());
	}
	
	@Test
	public void testGetCepNotFound() throws Exception {
		when(service.buscaCep(" ")).thenThrow(CepException.class);
		
		mockMvc.perform(get("/cep/busca/ ")).andExpect(status().isNotFound());
	}
	
	private Cep getCep() {
		Cep cep = new Cep();
		cep.setCep("03932040");
		cep.setBairro("Centenário");
		cep.setComplemento("-");
		cep.setLogradouro("Rua Piranguinho");
		cep.setLocalidade("São Paulo");
		
		return cep;
	}

}
