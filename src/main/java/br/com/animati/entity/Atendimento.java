package br.com.animati.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Atendimento {
	
	private long idAtendimento;
	private String dataHora;
	private String nomeProcedimento;
	private String modalidade;
	private Medico medico;
	private Paciente paciente;
}
