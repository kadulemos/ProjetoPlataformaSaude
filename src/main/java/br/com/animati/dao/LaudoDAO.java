package br.com.animati.dao;

import java.util.List;

import br.com.animati.entity.Laudo;

public interface LaudoDAO {
	
	public void cadastrar(Laudo l);
	public List<Laudo> list();
	public void editar(Laudo l);
	public void deletar(long idLaudo);
	public Laudo listarPeloId(long idLaudo);
	public Laudo listarPeloIdMedico(long idMedico);
	public void limparLista();

}
