package Aeroporto;

public class Pista {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe Pista -------------------------------------	
	
	private Fila pistaDecolagem;
	private Fila pistaAterrissagem;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Construor da Classe Pista -------------------------------------
	
	public Pista() {
		Fila pistaDecolagem = new Fila();
		Fila pistaAterrissagem = new Fila();
		this.pistaDecolagem = pistaDecolagem;
		this.pistaAterrissagem = pistaAterrissagem;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Métodos -------------------------------------	

	//        **ADICIONA UM AVIÃO NA PISTA DE ATERRISSAGEM**
	
	public void addAviaopistaAterrissagem(int id, int combustivel, String status) {
		
		Aviao aux = new Aviao(id,combustivel,status);
		
		pistaAterrissagem.inserirAviaoNoFinalAterrissagem(aux);
		System.out.println("Aviao #ID: " + id + " Inserido na Pista de Aterrissagem!!");
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//       **ADICIONA UM AVIÃO NA PISTA DE DECOLAGEM**
	
	public void addAviaopistaDecolagem(int id, String status) {
		
		Aviao aux = new Aviao(id,status);
					
		pistaDecolagem.inserirAviaoNoFinalDecolagem(aux);
		System.out.println("Avião #ID: " + id + " Inserido na Pista de Decolagem!!");
	}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//       **ARRUMA A FILA DE DECOLAGEM PRIORIZANDO O AVIÃO COM MENOR NÍVEL DE COMBUSTÍVEL**
	
	public void arrumarFilaDecolagem() {
	    int quantAvioes = pistaDecolagem.contadorAvioes();

	    Aviao aviaoAtual = pistaDecolagem.getinicio();
	    Aviao menorCombustivel;

	    for (int i = 0; i < quantAvioes - 1; i++) {
	        menorCombustivel = aviaoAtual;
	        Aviao aux = aviaoAtual.getProx();
	        while (aux != null) {
	            if (aux.getCombustivel() < menorCombustivel.getCombustivel()) {
	                menorCombustivel = aux;
	            }
	            aux = aux.getProx();
	        }
	        
	        if (aviaoAtual != menorCombustivel) {
	            if (aviaoAtual == pistaDecolagem.getinicio()) {
	                pistaDecolagem.setinicio(menorCombustivel);
	            } else {
	                Aviao anterior = pistaDecolagem.getinicio();
	                while (anterior.getProx() != aviaoAtual) {
	                    anterior = anterior.getProx();
	                }
	                anterior.setProx(menorCombustivel);
	            }
	            
	            Aviao proximo = menorCombustivel.getProx();
	            menorCombustivel.setProx(aviaoAtual.getProx());
	            aviaoAtual.setProx(proximo);
	            
	            aviaoAtual = menorCombustivel;
	        } else {
	            aviaoAtual = aviaoAtual.getProx();
	        }
	    }
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//		**ARRUMA A FILA DE AERRISSAGEM PRIORIZANDO O AVIÃO COM MENOR NÍVEL DE COMBUSTÍVEL**	
	
	public void arrumarFilaAterrissagem() {
	    int quantAvioes = pistaAterrissagem.contadorAvioes();
	    Aviao atual = pistaAterrissagem.getinicio();
	    Aviao menorCombustivel;

	    for (int i = 0; i < quantAvioes - 1; i++) {
	        menorCombustivel = atual;
	        Aviao aux = atual.getProx();
	        while (aux != null) {
	            if (aux.getCombustivel() < menorCombustivel.getCombustivel()) {
	                menorCombustivel = aux;
	            }
	            aux = aux.getProx();
	        }
	        
	        if (atual != menorCombustivel) {
	            if (atual == pistaAterrissagem.getinicio()) {
	                pistaAterrissagem.setinicio(menorCombustivel);
	            } else {
	                Aviao anterior = pistaAterrissagem.getinicio();
	                while (anterior.getProx() != atual) {
	                    anterior = anterior.getProx();
	                }
	                anterior.setProx(menorCombustivel);
	            }
	            
	            Aviao proximo = menorCombustivel.getProx();
	            menorCombustivel.setProx(atual.getProx());
	            atual.setProx(proximo);
	            
	            atual = menorCombustivel;
	        } else {
	            atual = atual.getProx();
	        }
	    }
	}

	
	public void messagemFinal() {
		System.out.println();
		System.out.println("Simulação Encerrada!!\n");
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Getters and Setters da Classe Pista -------------------------------------

	public Fila getpistaDecolagem() {
		return pistaDecolagem;
	}

	public void setpistaDecolagem(Fila pistaDecolagem) {
		this.pistaDecolagem = pistaDecolagem;
	}

	public Fila getpistaAterrissagem() {
		return pistaAterrissagem;
	}

	public void setpistaAterrissagem(Fila pistaAterrissagem) {
		this.pistaAterrissagem = pistaAterrissagem;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe Pista -------------------------------------	


	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pista: [Pista Decolagemgem = ");
		builder.append(pistaDecolagem);
		builder.append(" Pista Decolagemgem = ");
		builder.append(pistaAterrissagem);
		builder.append("]");
		return builder.toString();
	}

	

}
