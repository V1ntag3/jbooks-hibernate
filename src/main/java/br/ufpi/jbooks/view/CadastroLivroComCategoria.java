package br.ufpi.jbooks.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.model.Categoria;
import br.ufpi.jbooks.model.Livro;

public class CadastroLivroComCategoria {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbooks");
		EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
			Categoria categoria = em.find(Categoria.class, 3);
				Livro livro = new Livro();
				livro.setAnoPublicacao(2011);
				livro.setTitulo("Engenharia de Software");
				livro.setCategoria(categoria);
				
				em.persist(livro);
				em.getTransaction().commit();
				em.close();
	}
}
