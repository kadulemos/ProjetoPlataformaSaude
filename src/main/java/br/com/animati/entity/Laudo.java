  package br.com.animati.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Laudo {
	
	private long idLaudo;
	private String texto;
	private Medico medico;
	private Atendimento atendimento;

}