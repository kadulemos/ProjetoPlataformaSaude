package br.com.animati.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.animati.entity.Laudo;

public class LaudoDAOImpl implements LaudoDAO {
	
	private List<Laudo> listaLaudos;
	
	public LaudoDAOImpl() {
		listaLaudos = new ArrayList<Laudo>();
	}

	@Override
	public void cadastrar(Laudo l) {
		listaLaudos.add(l);

	}

	@Override
	public List<Laudo> list() {
		return listaLaudos;
	}

	@Override
	public void editar(Laudo l) {
		boolean encontrar = true;
		int indice = 0;
		
		do {
			if(listaLaudos.get(indice).getIdLaudo() == l.getIdLaudo()) {
				listaLaudos.set(indice, l);
				encontrar = false;
			}
			indice++;
		} while (encontrar);

	}

	@Override
	public void deletar(long idLaudo) {
		boolean encontrar = true;
		int indice = 0;
		
		do {
			if(listaLaudos.get(indice).getIdLaudo() == idLaudo) {				
				listaLaudos.remove(indice);
				encontrar = false;
			}
		} while (encontrar);

	}

	@Override
	public Laudo listarPeloId(long idLaudo) {
		
		Laudo laudoEncontrado = null;
		boolean encontrar = true;
		int indice = 0;
		
		do {
			if(listaLaudos.get(indice).getIdLaudo() == idLaudo) {
				laudoEncontrado = listaLaudos.get(indice);
				encontrar = false;
			}
			indice++;
		} while (encontrar);
		return laudoEncontrado;
	}

}
