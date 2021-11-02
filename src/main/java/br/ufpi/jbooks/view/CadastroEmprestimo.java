package br.ufpi.jbooks.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.enums.StatusEmprestimoEnum;
import br.ufpi.jbooks.model.Aluno;
import br.ufpi.jbooks.model.Emprestimo;
import br.ufpi.jbooks.model.Livro;

public class CadastroEmprestimo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbooks");
		EntityManager em = emf.createEntityManager();
		Aluno aluno = em.find(Aluno.class, 16);
		em.getTransaction().begin();
		Livro livro1 = em.find(Livro.class, 2);
		Livro livro2 = em.find(Livro.class, 8);
		List<Livro> livrosemprestados = new ArrayList<Livro>();
		livrosemprestados.add(livro2);
		livrosemprestados.add(livro1);
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setLivros(livrosemprestados);
		emprestimo.setStatus(StatusEmprestimoEnum.ATIVO);
		emprestimo.setAluno(aluno);
		em.persist(emprestimo);
		em.getTransaction().commit();
		em.close();
	}

}
