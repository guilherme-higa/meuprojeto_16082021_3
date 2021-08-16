package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import entities.enums.NivelTrabalhador;


public class Trabalhador {

	private String nome;
	private NivelTrabalhador nivel;
	private double baseSalario;

	private Departamento departamento;
	private List<HorasContrato> contrato = new ArrayList<>();

	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, double baseSalario, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalario = baseSalario;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getBaseSalario() {
		return baseSalario;
	}

	public void setBaseSalario(double baseSalario) {
		this.baseSalario = baseSalario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasContrato> getContrato() {
		return contrato;
	}

	public void adicionaContrato(HorasContrato contrato) {
		this.contrato.add(contrato);
	}

	public void removeContrato(HorasContrato contrato) {
		this.contrato.remove(contrato);
	}

	public double icome(int ano, int mes) {
		double sum = baseSalario;
		Calendar calendario = Calendar.getInstance();
		for (HorasContrato c : contrato) {
			calendario.setTime(c.getData());
			int c_ano = calendario.get(Calendar.YEAR);
			int c_mes = (calendario.get(Calendar.MONTH) + 1);
			if (ano == c_ano && mes == c_mes ) {
				sum +=  c.valorTotal();
			}
		}
		return sum;
	}
}
