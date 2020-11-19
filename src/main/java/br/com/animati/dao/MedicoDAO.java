package br.com.animati.dao;

import java.util.List;

import br.com.animati.entity.Medico;

public interface MedicoDAO {

	public void cadastrar(Medico m);
	public List<Medico> list();
	public void editar(Medico m);
	public void deletar(long idMedico);
	public Medico listarPeloId(long idMedico);
	public void limparLista();

}