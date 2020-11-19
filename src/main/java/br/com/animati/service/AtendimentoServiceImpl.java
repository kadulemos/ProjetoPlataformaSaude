package br.com.animati.service;

import java.util.List;

import br.com.animati.dao.AtendimentoDAO;
import br.com.animati.dao.AtendimentoDAOImpl;
import br.com.animati.entity.Atendimento;

public class AtendimentoServiceImpl implements AtendimentoService {
	
	private AtendimentoDAO dao;
	
	public AtendimentoServiceImpl() {
		dao = new AtendimentoDAOImpl();
	}

	@Override
	public void cadastrar(Atendimento at) {
		dao.cadastrar(at);

	}

	@Override
	public List<Atendimento> list() {
		return dao.list();
	}

	@Override
	public void editar(Atendimento at) {
		dao.editar(at);

	}

	@Override
	public void deletar(long idAtendimento) {
		dao.deletar(idAtendimento);

	}

	@Override
	public Atendimento listarPeloId(long idAtendimento) {
		return dao.listarPeloId(idAtendimento);
	}

}