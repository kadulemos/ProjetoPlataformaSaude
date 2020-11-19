package br.com.animati.service;

import java.util.List;

import br.com.animati.entity.Atendimento;

public interface AtendimentoService {

	public void cadastrar(Atendimento at);
	public List<Atendimento> list();
	public void editar(Atendimento at);
	public void deletar(long idAtendimento);
	public Atendimento listarPeloId(long idAtendimento);
	public void limparLista();
	
}