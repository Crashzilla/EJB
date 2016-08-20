package br.com.fiap.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Funcionarios;

@Stateless
public class FuncionariosBean implements FuncionariosBeanRemote {

	@PersistenceContext(unitName="fiapPU")
	private EntityManager em;

	@Override
	public void add(Funcionarios func) {
		em.persist(func);
	}

	@Override
	public Funcionarios consulta(int cpf) {
		TypedQuery<Funcionarios> query = em.createQuery("select u from Funcionarios where cpf= '" + cpf + "'", Funcionarios.class);
		Funcionarios func = query.getSingleResult();
		return func;
	}

	@Override
	public double CalcularIrpf(double salario) {
		double[] taxas = { 0, 7.5, 15, 22.5, 27.5 };
		double[] valores = { 0, 1499.15, 2246.75, 2995.7, 3743.19 };

		double imposto = 0;

		for (int i = taxas.length - 1; i >= 0; i--)
		{
			if (salario > valores[i])
			{
				imposto += (salario - valores[i]) * taxas[i] / 100;
				salario = valores[i];
			}
		}
		return imposto;

	}




}
