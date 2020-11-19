package br.com.animati.service;

import java.util.List;

import br.com.animati.entity.Medico;

public interface MedicoService {

	public void cadastrar(Medico m) throws Exception;
	public List<Medico> list();
	public void editar(Medico m);
	public void deletar(long idMedico);
	public Medico listarPeloId(long idMedico);
	public void limparLista();
}
