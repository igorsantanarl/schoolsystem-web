package br.edu.ifal.schoolsystem.schoolsystemweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifal.schoolsystem.schoolsystemweb.modelo.Curso;
import br.edu.ifal.schoolsystem.schoolsystemweb.repositories.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoResource {

	@Autowired
	CursoRepository cursoRepository;
	
	@RequestMapping(value="carregar", method=RequestMethod.GET)
	public String carregar() {
		Curso c = new Curso("Tecnico em Informatica para WEB");
				
		cursoRepository.save(c);
		return "Ok";
	}
	
	@RequestMapping(value="{id}/detalhes", method=RequestMethod.GET)
	public Curso buscar(@PathVariable("id") Integer id) {
		return cursoRepository.getOne(id);
	}
	
	@RequestMapping(value="listar/todos", method=RequestMethod.GET)
	public List<Curso> listar(){
		return cursoRepository.findAll();
	}
	
	@RequestMapping(value="pesquisar", method=RequestMethod.GET)
	public Curso pesquisar(
		@RequestParam(name="nome", defaultValue="ALL")String nome){
		System.out.println(nome);
		return cursoRepository.findByNome(nome);
	}
}