package br.ufpi.jbooks.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.model.Categoria;

public class CadastroCategoria {
	public static void main(String[] args) {
		Categoria categoria = new Categoria();
		categoria.setDescricao("Desenvolvimento de Software");

		EntityManagerFactory efm = Persistence.createEntityManagerFactory("jbooks");
		EntityManager em = efm.createEntityManager();

		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
		em.close();

	}
}
