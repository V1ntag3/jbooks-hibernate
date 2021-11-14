package br.ufpi.jbooks.view;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.model.Aluno;
import br.ufpi.jbooks.model.Emprestimo;

public class CadastroAluno {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbooks");
		EntityManager em = emf.createEntityManager();
		Emprestimo emprestimo = em.find(Emprestimo.class, 11);
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		emprestimos.add(emprestimo);
		Aluno aluno = new Aluno();
		aluno.setMatricula(3498573);
		aluno.setNome("Jucelino Kubicheque");
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	}
}
