package br.ufpi.jbooks.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.model.Emprestimo;

public class PesquisarEmprestimo {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbooks");
	EntityManager em = emf.createEntityManager();

	em.getTransaction().begin();
	Emprestimo emprestimo = em.find(Emprestimo.class, 11);
	System.out.println("Emprestimo" + emprestimo.getId() + "-"+ emprestimo.getStatus().name());
	emprestimo.getLivros().forEach(l -> System.out.println(l.getTitulo()));
	em.getTransaction().commit();
	em.close();
}
}
