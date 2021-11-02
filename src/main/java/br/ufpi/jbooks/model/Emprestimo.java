package br.ufpi.jbooks.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.ufpi.jbooks.enums.StatusEmprestimoEnum;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Enumerated(EnumType.STRING)
	private StatusEmprestimoEnum status;
	@ManyToMany
	@JoinTable(name = "emprestimos_livros", joinColumns = {
			@JoinColumn(name = "emprestimo_id") }, inverseJoinColumns = { @JoinColumn(name = "livro_id") })
	private List<Livro> livros;
	@ManyToOne
	private Aluno aluno;

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusEmprestimoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEmprestimoEnum status) {
		this.status = status;
	}

}
