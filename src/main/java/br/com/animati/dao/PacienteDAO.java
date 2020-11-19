package br.com.animati.dao;

import java.util.List;

import br.com.animati.entity.Paciente;

public interface PacienteDAO {
	
	public void cadastrar(Paciente p);
	public List<Paciente> list();
	public void editar(Paciente p);
	public void deletar(long idPaciente);
	public Paciente listarPeloId(long idPaciente);
	public void limparLista();

}
