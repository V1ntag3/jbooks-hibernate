package br.ufpi.jbooks.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufpi.jbooks.model.Livro;

public class CadastroLivro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Livro livro = new Livro();
		livro.setTitulo("Arquitetura Limpa");
		livro.setAnoPublicacao(2019);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jbooks");
		// esta apontando para o banco de dados
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		em.close();
	}

}
