package br.com.senacrs.alp.aulas;

public class MeuFuncionario implements Funcionario {

	private Empresa empresa;
	private Departamento departamento;
	private String nome;
	private double salario;
	
	
	public MeuFuncionario(Empresa empresa, Departamento departamento, String nome, double salario) {
	
		if (nome == null) {
			throw new IllegalArgumentException();
		}
		
		if (departamento == null) {
			throw new IllegalArgumentException();
		}
		
		if (salario < 0) {
			throw new IllegalArgumentException();
		}
		
		this.empresa      = empresa;
		this.departamento = departamento;
		this.nome         = nome;
		this.salario      = salario;
	}
	
	
	@Override
	public Empresa getEmpresa() {
		return this.empresa;
	}
	
	@Override
	public Departamento getDepartamento() {
		return this.departamento;
	}
	
	@Override
	public String getNome() {	
		return this.nome;
	}
	
	@Override
	public double getSalario() {
		return this.salario;
	}
}