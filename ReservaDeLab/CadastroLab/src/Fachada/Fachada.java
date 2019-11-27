package Fachada;

import javax.swing.JPanel;

import Banco.Conexao;
import Banco.ConsultarCadastroProfessor;
import Banco.ConsultarNomeProfessor;
import Banco.ConsultarReserva;
import Banco.CriarTabelas;
import Banco.InserirProfessor;
import Gui.Calendario;
import Modelo.Laboratorio;
import Modelo.Professor;

public class Fachada {
	
	/*
	 * Classe que serve de fachada
	 */
	private Professor prof;
	private Laboratorio lab;
	private InserirProfessor insert;
	private ConsultarCadastroProfessor consultaProf;
	private CriarTabelas createTable;
	private Conexao conexao;
	private Calendario calendario;
	private ConsultarNomeProfessor consultaNome;
	private ConsultarReserva consultaReserva;
	
	public Fachada(){
		prof = new Professor();
		lab = new Laboratorio();
		insert = new InserirProfessor();
		consultaProf = new ConsultarCadastroProfessor();
		conexao = new Conexao();
		createTable = new CriarTabelas(conexao);
		calendario = new Calendario();
		consultaNome = new ConsultarNomeProfessor();
		consultaReserva = new ConsultarReserva();
	}

	//InserirProfessor
	public void cadastrarProf(String matricula, String nome, String senha){
		insert.cadastrarProfessor(matricula, nome, senha);
	}
	//InserirProfessor
	public void criarProf(String nome, String matricula, String senha){
		prof.setNome(nome);
		prof.setMatricula(matricula);
		prof.setSenha(senha);
	}
	
	//ConsultarProfessor
	public boolean consultaProfessor(String matricula, String senha) {
		return consultaProf.consultaProfessor(matricula, senha);
	}
	
	//ConsultaNome
	public String consultaNome(String matricula) {
		return consultaNome.consultaNome(matricula);
	}
	
	//CriarTabelas
	public void criarTabelas() {
		try {
			createTable.criarTabelas();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Calendario
	public void criaCalendario(JPanel panel) {
		calendario.criaCalendario(panel);
	}
	//Calendario
	public boolean enviarData(String codigoLab) {
		return consultaReserva.consultaReserva(new String(), codigoLab);
	}
	//calendario
	public String diaNome(String dia) {
		return calendario.getDiaNome();
	}
	
	//ConsultarReserva
	public boolean consultaReserva(String dataConsulta, String codigoLab) {
		return consultaReserva.consultaReserva(dataConsulta, codigoLab);
	}
}
