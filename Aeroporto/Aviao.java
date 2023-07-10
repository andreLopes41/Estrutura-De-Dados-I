package Aeroporto;

import java.util.Scanner;

public class Aviao {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe Avião -------------------------------------	
	
	private Scanner entrada = new Scanner(System.in);
	
	private int id;
	private int combustivel;
	private String status;
	private Aviao prox;
	private float tempo = 1;
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Construores da Classe Avião -------------------------------------
	
	public Aviao(int id) {
		this.id = id;
		this.prox = null;
	}
	
	public Aviao(int id,String status) {
		this.id = id;
		this.status = status;
		this.prox = null;
	}
	
	public Aviao(int id, int combustivel, String status) {
		setCombustivel(combustivel);
		this.id = id;
		this.status = status;
		this.prox = null;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Getters and Setters da Classe AVião -------------------------------------	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCombustivel() {
		return combustivel;
	}
	
	public void setCombustivel(int combustivel) {
		
		while(combustivel < 1 || combustivel > 20) {
			System.out.print("Digite um valor válido [1-20]: ");
			combustivel = entrada.nextInt();
			
		}
		this.combustivel = combustivel;
	}
	
	public Aviao getProx() {
		return prox;
	}
	
	public void setProx(Aviao prox) {
		this.prox = prox;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public float getTempo() {
		return tempo++;
	}
	
	public void setTempo(float tempo) {
		this.tempo = tempo;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe Avião -------------------------------------	
	
	public String StringDecolar() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avião: [#ID = ");
		builder.append(id);
		builder.append(", Status = ");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	public String StringPousar() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avião: [#ID = ");
		builder.append(id);
		builder.append(", Combustível = ");
		builder.append(combustivel);
		builder.append(", Status = ");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
}