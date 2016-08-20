package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.fiap.interfaces.Galera;

@Stateful
public class GaleraBean implements Galera{

	private List<String> nomes;
	
	public GaleraBean() {
		super();
		nomes = new ArrayList<>();
	}

	@Override
	public List<String> buscarNomes() {
		return nomes;
	}

	@Override
	public void incluirNome(String nome) {
		nomes.add(nome);		
	}

}
