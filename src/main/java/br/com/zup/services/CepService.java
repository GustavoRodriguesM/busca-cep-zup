package br.com.zup.services;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zup.configs.exception.CepException;
import br.com.zup.interfaces.ICepService;
import br.com.zup.models.Cep;

@Service
public class CepService implements ICepService {
	
	private String CEP_URL = "https://viacep.com.br/ws/{cep}/json/";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Cep buscaCep(String valor) throws CepException {
		
		if(Strings.isEmpty(valor) || Strings.isEmpty(valor.trim()) ) {
			throw new CepException("CEP está inválido!");
		}
		
		return this.restTemplate.getForEntity(CEP_URL.replace("{cep}", valor), Cep.class).getBody();
	}
	
	

}
