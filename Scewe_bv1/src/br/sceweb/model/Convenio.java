package br.sceweb.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;

public class Convenio {
	
	private String cnpj;
	private DateTime dataInicio;
	private DateTime dataTerminino;
	
	/**
	* valida a data de inicio
	* @param dataInicio - data do inicio da vigencia de um convenio
	* @throws IllegalArgumentException
	*/
	public void setDataInicio(String dataInicio) throws IllegalArgumentException {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>data inicio = " + dataInicio);
		if (validaData(dataInicio)) {
			this.dataInicio = new DateTime(Integer.parseInt(dataInicio.substring(6, 10)),
			Integer.parseInt(dataInicio.substring(3, 5)),
			Integer.parseInt(dataInicio.substring(0, 2)), 0, 0);
		} else {
			throw new IllegalArgumentException("data invalida");
		}
	}
	
	/**
	* valida o formato da data
	* @param data no formato dd/MM/yyyy
	* @return true se a data estiver no formato valido e false para formato invalido
	*/
	public boolean validaData(String data){
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		df.setLenient (false); //
		try {
			df.parse (data); // data válida
			return true;
		} catch (ParseException ex) {
			System.out.println("Erro na validacao de data - " + ex.getMessage());
			return false;
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public DateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(DateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public DateTime getDataTerminino() {
		return dataTerminino;
	}

	public void setDataTerminino(DateTime dataTerminino) {
		this.dataTerminino = dataTerminino;
	}
	
}
