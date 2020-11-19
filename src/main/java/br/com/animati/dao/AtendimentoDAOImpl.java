package br.com.animati.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.animati.entity.Atendimento;

public class AtendimentoDAOImpl implements AtendimentoDAO {
	
	private List<Atendimento> listaAtendimentos;
	
	public AtendimentoDAOImpl() {
		listaAtendimentos = new ArrayList<Atendimento>();
	}

	@Override
	public void cadastrar(Atendimento at) {
		listaAtendimentos.add(at);
	}

	@Override
	public List<Atendimento> list() {
		return listaAtendimentos;
	}

	@Override
	public void editar(Atendimento at) {
		boolean encontrar = true;
		int indice = 0;
		
		do {
			if(listaAtendimentos.get(indice).getIdAtendimento() == at.getIdAtendimento()) {
				listaAtendimentos.set(indice, at);
				encontrar = false;
			}
			indice++;
		} while(encontrar);
	}

	@Override
	public void deletar(long idAtendimento) {
		boolean encontrar = true;
		int indice = 0;
		
		do {
			if(listaAtendimentos.get(indice).getIdAtendimento() == idAtendimento) {
				listaAtendimentos.remove(indice);
				encontrar = false;
			}
			indice++;
		} while (encontrar);

	}

	@Override
	public Atendimento listarPeloId(long idAtendimento) {
		Atendimento atendimentoEncontrado = null;
		boolean encontrar = true;
		int indice = 0;
		
		do {
			if (listaAtendimentos.get(indice).getIdAtendimento() == idAtendimento) {
				atendimentoEncontrado = listaAtendimentos.get(indice);
				encontrar = false;
			} 
			indice++;
		} while (encontrar);
		return atendimentoEncontrado;
	}

	@Override
	public void limparLista() {
		listaAtendimentos.clear();
		
	}

}
