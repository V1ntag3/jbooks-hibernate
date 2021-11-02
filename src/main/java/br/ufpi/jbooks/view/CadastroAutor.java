package br.ufpi.jbooks.view;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.model.Autor;
import br.ufpi.jbooks.model.Livro;

public class CadastroAutor {
	public static void main(String[] args) {
		Autor autor = new Autor();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbooks");
		EntityManager em = emf.createEntityManager();
		
		 Livro livro = em.find(Livro.class, 8);
		 ArrayList<Livro> livrosAutor = new ArrayList<Livro>(); 
		 livrosAutor.add(livro);
		 autor.setLivros(livrosAutor);
		autor.setNome("Marcos Vinicius");
		em.getTransaction().begin();
		em.persist(autor);
		em.getTransaction().commit();
		em.close();
	}
}
