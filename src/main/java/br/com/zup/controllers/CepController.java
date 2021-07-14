package br.com.zup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.configs.exception.CepException;
import br.com.zup.interfaces.ICepService;
import br.com.zup.models.Cep;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "cep")
@Api(tags = { "CEP" })
public class CepController {

	@Autowired
	private ICepService cepService;

	@GetMapping("/busca/{cep}")
	public ResponseEntity<Cep> buscaCep(@PathVariable String cep) throws CepException {
		Cep cepSearch = this.cepService.buscaCep(cep);

		return ResponseEntity.ok(cepSearch);
	}

}
