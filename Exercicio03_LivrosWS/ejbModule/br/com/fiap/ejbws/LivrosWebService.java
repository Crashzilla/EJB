package br.com.fiap.ejbws;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import br.com.fiap.entity.Livros;

@Remote
@WebService(name = "LivroWebServicePortType", targetNamespace = "http://jaxws.exemplos.fiap.com.br")
public interface LivrosWebService {
	void add(Livros livro);
	List<Livros> getAll();
}
