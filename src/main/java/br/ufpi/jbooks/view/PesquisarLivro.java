package br.ufpi.jbooks.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.model.Livro;

public class PesquisarLivro {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbooks");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Livro emprestimo = em.find(Livro.class, 8);
		System.out.println("Emprestimo" + emprestimo.getId() + "-"+ emprestimo.getTitulo());
		emprestimo.getEmprestimos().forEach(l -> System.out.println(l.getId()));
		em.getTransaction().commit();
		em.close();
	}
}
