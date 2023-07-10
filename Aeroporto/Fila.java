package Aeroporto;

public class Fila {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe Fila -------------------------------------	
	
	private Aviao inicio;
	private Aviao fim;
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Construor da Classe Fila -------------------------------------
	
	public Fila() {
		inicio = null;
		fim = null;
		
	}	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Getters and Setters da Classe Fila -------------------------------------	
	
	public Aviao getinicio() {
		return inicio;
	}
	
	public void setinicio(Aviao inicio) {
		this.inicio = inicio;
	}
	
	public Aviao getfim() {
		return fim;
	}
	
	public void setfim(Aviao fim) {
		this.fim = fim;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Métodos -------------------------------------	

	//        **VERIFICA SE A FLILA ESTÁ VAZIA**
	
	public boolean vazia() {
		return inicio == null;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//        **INSERIR UM AVIÃO NO INÍCIO**
	
	public void inserirInicio(Aviao aviao) {
		Aviao novoAviao = new Aviao(aviao.getId(),aviao.getCombustivel(),aviao.getStatus());
		novoAviao.setProx(inicio);
		inicio = novoAviao;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**MOSTRA A LISTA DE DECOLAGEM**
	
	public void mostraFilaDecolagem() {
		if(vazia()) {
			System.out.println("Fila Vazia\n");
			return;
		}
		
		Aviao aux = inicio;
		int contDecolagem = 0;
		
		while(aux != null) {
			contDecolagem++;
			System.out.println(contDecolagem + "° " + aux.StringDecolar() + " ");
			
			aux = aux.getProx();
		}
		System.out.println();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**MOSTRA A LISTA DE ATERRISSAGEM**
	
	public void mostraFilaAterrissagem() {
		if(vazia()) {
			System.out.println("Fila Vazia\n");
			return;
		}
		
		Aviao aux = inicio;
		int contAterrissagem = 0;
		
		while(aux!=null) {
			contAterrissagem++;
			System.out.println(contAterrissagem + "° " + aux.StringPousar() + " ");
			
			aux = aux.getProx();
		}
		System.out.println();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**DELETA O AVIÃO PELO ID**
	
	public void deletarAViaoPeloId(int id) {
		if(vazia())
			return;
		
		if (inicio.getId() == id) {
			inicio = inicio.getProx();
			return;
		}
		
		Aviao aux = inicio;
		
		while(aux != null) {
			
		if(aux.getProx().getId() == id) {
			aux.setProx(aux.getProx().getProx());
			return;
		}
		aux = aux.getProx();
		}
		System.out.println(" Avião: #ID " + id + " Não Existe");	
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**INSERIR AVIÃO NO FINAL DA FILA DE ATERRISSAGEM**	
	
	public void inserirAviaoNoFinalAterrissagem(Aviao aviao) {
		Aviao novoAviao = new Aviao(aviao.getId(),aviao.getCombustivel(),aviao.getStatus());
		Aviao aux = inicio;
		
		if(inicio == null) {
			inicio = novoAviao;
			return;
		}
		
		if(novoAviao.getCombustivel() <= 5) {
			inserirInicio(novoAviao);
			return;
		}
		
		while(aux.getProx() != null) {
			aux = aux.getProx();
		}
		
		aux.setProx(novoAviao);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**INSERIR AVIÃO NO FINAL DA FILA DE DECOLAGEM**	
	
	public void inserirAviaoNoFinalDecolagem(Aviao aviao) {
		Aviao novoAviao = new Aviao(aviao.getId(),aviao.getStatus());
		Aviao aux = inicio;
		
		if(inicio == null) {
			inicio = novoAviao;
			return;
		}
		
		while(aux.getProx() != null) {
			aux=aux.getProx();
		}
		
		aux.setProx(novoAviao);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**VERIFICA  FILA DE DECOLAGEM**		
	
	public void verificaFilaDeAterrissagem() {
		if(vazia()) {
			System.out.println("Fila Vazia\n");
			return;
		}
		Aviao aux = inicio;
		
		while(aux != null) {
			if(aux.getCombustivel() <= 5) {
				inserirInicio(aux);
			}
			aux = aux.getProx();
		}
		return;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//		**CONTA QUANTOS AVIÕES EXISTEM EM CADA FILA**		

	public int contadorAvioes() {
		int cont = 0;
		if(vazia()) {
			return cont;
		}
		Aviao aux = inicio;
		while(aux != null) {
			cont++;
			aux = aux.getProx();
		}
		return cont;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**VERIFICA SE O AVIÃO ESTÁ EM EMERGÊNCIA**		
	
	public Aviao AvioesEmEmergencia() {
		Aviao aux = inicio;
		
		while(aux != null) {
			if(aux.getCombustivel() <= 4) {
				return aux;
			}
			return null;
		}
		return null;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//		**DIMINUI UMA UNIDADE DE COMBUSTÍVEL A CADA CICLO**		
	
	public void diminuirCombustivel() {
		if(vazia()) {
			return;
		}
		Aviao aux = inicio;
		
		while(aux!=null) {
			aux.setCombustivel(aux.getCombustivel() - 1);
			aux = aux.getProx();
		}
		return;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**AUMENTA A UNIDADE DE TEMPO A CADA VOLTA PARA TOTALIZAR A QUANTIA DE CICLOS **			
	
	public void aumentaUnidadeDeTempo() {
		if(vazia()) {
			return;
		}
		Aviao aux = inicio;
		
		while(aux != null) {
			aux.setTempo(aux.getTempo() + 1);
			aux = aux.getProx();
		}
		return;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe Fila -------------------------------------	
	
	
	public String toString(Aviao aviao, int cont) {
		StringBuilder builder = new StringBuilder();
		builder.append("Fila = ");
		builder.append(cont);
		builder.append("° Aviao");
		builder.append(aviao);
		return builder.toString();
	}
	
}
