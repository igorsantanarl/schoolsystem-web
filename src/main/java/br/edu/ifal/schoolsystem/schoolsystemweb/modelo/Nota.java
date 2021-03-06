package br.edu.ifal.schoolsystem.schoolsystemweb.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="nota")
public class Nota {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Disciplina disciplina;
	
	
	@Column(precision=2)
	private Double mediaFinal;
	
	@ElementCollection
	private List<Double> notas;

	public Nota() {
		
	}

	public Nota(Integer id, Aluno aluno, Disciplina disciplina, Double valor) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.mediaFinal = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public double getValor() {
		return mediaFinal;
	}

	public Double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(Double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	
	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

	

}
