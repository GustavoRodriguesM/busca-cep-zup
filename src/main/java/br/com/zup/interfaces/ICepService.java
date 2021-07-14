package br.com.zup.interfaces;

import br.com.zup.configs.exception.CepException;
import br.com.zup.models.Cep;

public interface ICepService {
	
	Cep buscaCep(String valor) throws CepException;

}
