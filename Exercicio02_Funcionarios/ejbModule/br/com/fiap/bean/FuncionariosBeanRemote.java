package br.com.fiap.bean;

import javax.ejb.Remote;

import br.com.fiap.entity.Funcionarios;

@Remote
public interface FuncionariosBeanRemote {
	
	void add(Funcionarios func);
	Funcionarios consulta(int cpf);
	double CalcularIrpf(double salario);

}
