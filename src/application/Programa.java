package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departamento;
import entities.HorasContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com o nome do departamento : ");
		String departamento = sc.nextLine();
		System.out.println("Entre com os dados do trabalhador : ");
		System.out.println("Nome : ");
		String nome = sc.nextLine();
		System.out.println("Nivel : ");
		String nivel = sc.nextLine();
		System.out.println("Base salarial : ");
		double baseSalario = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), baseSalario,new Departamento(departamento));

		System.out.println("Quantos contratos estão vinculados a este trabalhador ? ");
		int num_contrato = sc.nextInt();

		for (int i = 0; i < num_contrato; i++) {
			System.out.println("Entre com os dados do contrato #" + (i + 1)+ ":");
			System.out.println("Data (DD/MM/YYYY) : ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.println("Valor por hora : ");
			double valorHora = sc.nextDouble();
			System.out.println("Duração (horas) : ");
			int horas = sc.nextInt();

			HorasContrato contratos = new HorasContrato(dataContrato, valorHora, horas);
			trabalhador.adicionaContrato(contratos);
		}
		System.out.println();
		System.out.println("Entre com o mês e ano para que seja realizado o calculo  (mm/yyyy) : ");
		String mesAno = sc.next();
		
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome : " + trabalhador.getNome());
		System.out.println("Nivel : "+ trabalhador.getDepartamento().getNome());
		System.out.println("Data : " + mesAno + " valor total : "+String.format("%.2f",trabalhador.icome(ano, mes)));
		
		
		sc.close();
	}

}
