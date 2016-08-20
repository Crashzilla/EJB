package br.com.fiap.interfaces;

import java.util.List;

public interface Galera {
	
	List<String> buscarNomes(); 
	
	void incluirNome(String nome);
}
