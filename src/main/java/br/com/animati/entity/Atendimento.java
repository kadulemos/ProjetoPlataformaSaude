package br.com.animati.entity;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class Atendimento {
	
	private long idAtendimento;
	private Date dataHora;
	private String nomeProcedimento;
	private String modalidade;
	private Medico medico;
	private Paciente paciente;
}
