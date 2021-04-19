package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.CadastroDAO;
import br.com.fiap.model.Cadastro;

@Named
@RequestScoped
public class CadastroBean {

	private Cadastro cadastro = new Cadastro();

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public void save() {
		new CadastroDAO().save(this.cadastro);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário cadastrado com sucesso!"));
	}
	
	public List<Cadastro> getCadastros(){
		return new CadastroDAO().getAll();
	}
	
}
