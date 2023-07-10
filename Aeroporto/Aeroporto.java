package Aeroporto;

import java.util.Scanner;

public class Aeroporto {
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Atributos da Classe Aeroporto -------------------------------------	
	
	private Scanner entrada = new Scanner(System.in);
	
	boolean simularVoo = true;
	String userInput;
	int gerarId = 1;
	int nivelCombustivel = 0;
	int avioesNaPistaDeDecolagem = 0;
	int avioesNaPistaDeAterrissagem = 0;
	boolean avioesPista1 = true;
	boolean avioesPista2 = true;
	int PousosDeEmergencia = 0;
	float tempoDeAterrissagem = 0;
	float tempoDeDecolagem = 0;
	float mediaFinalDecolagem = 0;
	float mediaFinalAterrissagem = 0;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Construor da Classe Aeroporto -------------------------------------
	
	public Aeroporto() {
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Método -------------------------------------	

//        **SIMULA O FUNCIONAMENTO DO AEROPORTO**
	
	public void simular() {
		
		Pista pista1 = new Pista();
		Pista pista2 = new Pista();
		int contador = 1;
		
		while(simularVoo) {
			
			System.out.println(contador + "° Simulação");

			
			if(avioesPista1 == true)
				avioesPista1 = false;
			else
				avioesPista1 = true;
			
			if(avioesPista2 == true) 
				avioesPista2 = false;
			else 
				avioesPista2 = true;
			
			tempoDeAterrissagem = 0;
			tempoDeDecolagem = 0;
			avioesNaPistaDeDecolagem = 0;
			avioesNaPistaDeAterrissagem = 0;
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			//       **QUANTIDAES DE SIMULAÇÕES A SEREM FEITAS**
			
			for (int i = 3 ; i > 0; i--) {

				
				System.out.println();
				System.out.println("Total de Unidades de tempo para percorrer: " + i);
				System.out.println("Deseja simular voo?");
				System.out.println("[1] - Sim");
				System.out.println("[2] - Não");
				System.out.print("=> ");
				userInput = entrada.next();
				
				while(!userInput.equals("1") && !userInput.equalsIgnoreCase("2")) {
				    System.out.println("Opção inválida!!\n");
				    System.out.println("Deseja simular o voo?");
					System.out.println("[1] - Sim");
					System.out.println("[2] - Não");
					System.out.print("=> ");
					userInput = entrada.next();
				}
				
				if(userInput.equals("1")) {
					System.out.println("\nStatus do Avião:");
					System.out.println("[1] - Decolar");
					System.out.println("[2] - Aterrissar");
					System.out.print("=> ");
					userInput = entrada.next();
					
					while(!userInput.equals("1") && !userInput.equals("2")) {
						System.out.println("Opção inválida!!\n");
						System.out.println("Status do Avião:");
						System.out.println("[1] - Decolar");
						System.out.println("[2] - Aterrissar");
						System.out.print("=> ");
						userInput = entrada.next();
					}

					
					if(userInput.equals("1")) {
						if(avioesNaPistaDeDecolagem < 2) {
							avioesNaPistaDeDecolagem++;
							if(pista1.getpistaDecolagem().contadorAvioes() > pista2.getpistaDecolagem().contadorAvioes()) {
								pista2.addAviaopistaDecolagem(gerarId += 2, "Decolar");
							}else {
								pista1.addAviaopistaDecolagem(gerarId += 2, "Decolar");
							}
						}else {
							System.out.println("Já foram adicionados 2 avioes para Decolar");
							System.out.println("Adicionar este avião para a Fila de Decolagem?");
							System.out.println("[1] - Sim");
							System.out.println("[2] - Não");
							System.out.print("=> ");
							userInput = entrada.next();
							
							while(!userInput.equals("1") && !userInput.equals("2")) {
								System.out.println("Opção inválida!!\n");
								System.out.println("Adicionar este avião para a lista de Decolagem?");
								System.out.println("[1] - Sim");
								System.out.println("[2] - Não");
								System.out.print("=> ");
								userInput = entrada.next();
							}
							
							if(userInput.equalsIgnoreCase("1")) {
								if(pista1.getpistaDecolagem().contadorAvioes() > pista2.getpistaDecolagem().contadorAvioes()) {
									pista2.addAviaopistaDecolagem(gerarId += 2, "Decolar");
									mediaFinalDecolagem++;
								}
								
								else {
									pista1.addAviaopistaDecolagem(gerarId += 2, "Decolar");
									mediaFinalDecolagem++;
								}
							}
							
						}
				
					}
					
					if(userInput.equals("2")) {
						 if(avioesNaPistaDeAterrissagem < 2) {
							 avioesNaPistaDeAterrissagem++;
							System.out.print("Nível de combustivel deste avião [1-20]: ");
							nivelCombustivel = entrada.nextInt();
							if(pista1.getpistaAterrissagem().contadorAvioes() > pista2.getpistaAterrissagem().contadorAvioes()) {
								pista2.addAviaopistaAterrissagem(gerarId += 2, nivelCombustivel, "Aterrissar");
							}else {
								pista1.addAviaopistaAterrissagem(gerarId += 2, nivelCombustivel, "Aterrissar");
							}
						}else {
							System.out.println("Já foram adicionados 2 avioes para Aterrissar");
							System.out.println("Adicionar este avião para a lista de Aterrissagem?");
							System.out.println("[1] - Sim");
							System.out.println("[2] - Não");
							System.out.print("=> ");
							userInput = entrada.next();
							
							while(!userInput.equals("1") && !userInput.equals("2")) {
								System.out.println("Opção inválida!!\n");
								System.out.println("Adicionar este avião para a lista de Aterrissagem?");
								System.out.println("[1] - Sim");
								System.out.println("[2] - Não");
								System.out.print("=> ");
								userInput = entrada.next();
							}
							
							if(userInput.equals("1")) {
								System.out.print("Nível de combustivel deste avião [1-20]: ");
								nivelCombustivel = entrada.nextInt();
								if(pista1.getpistaAterrissagem().contadorAvioes() > pista2.getpistaAterrissagem().contadorAvioes()) {
									pista2.addAviaopistaAterrissagem(gerarId += 2, nivelCombustivel, "Aterrissar");
									mediaFinalAterrissagem++;
								}
								
								else {
									pista1.addAviaopistaAterrissagem(gerarId += 2, nivelCombustivel, "Aterrissar");
									mediaFinalAterrissagem++;
								}
							}
						}
					}
				}
			}
			
			if(pista1.getpistaAterrissagem().AvioesEmEmergencia() != null) {
				Aviao aux = pista1.getpistaAterrissagem().AvioesEmEmergencia();
				pista1.getpistaAterrissagem().deletarAViaoPeloId(aux.getId());
				pista1.getpistaAterrissagem().inserirInicio(aux);
				PousosDeEmergencia++;
				avioesPista1 = true;
			}
			
			if(pista2.getpistaAterrissagem().AvioesEmEmergencia() != null){
				Aviao aux = pista2.getpistaAterrissagem().AvioesEmEmergencia();
				pista2.getpistaAterrissagem().deletarAViaoPeloId(aux.getId());
				pista2.getpistaAterrissagem().inserirInicio(aux);
				PousosDeEmergencia++;
				avioesPista2 = true;
			}
	
			System.out.println("\n====  ====  ====  ====  ====  ====  ====");
			
			if(avioesPista1 == true) {
				
				if(pista1.getpistaAterrissagem().getinicio() != null) {
					System.out.println(pista1.getpistaAterrissagem().getinicio().StringPousar() + " => Aterrissou na Pista 1");
					pista1.getpistaAterrissagem().deletarAViaoPeloId(pista1.getpistaAterrissagem().getinicio().getId());
				}
				
				else if(pista1.getpistaDecolagem().getinicio()!=null) {
						System.out.println(pista1.getpistaDecolagem().getinicio().StringDecolar() + " => Decolou na Pista 1");
						pista1.getpistaDecolagem().deletarAViaoPeloId(pista1.getpistaDecolagem().getinicio().getId());
					}
				
				else 
					System.out.println("A fila de Aterrissagem e Pouso da Pista 1 estão vazias");
				
			}
			if(avioesPista2 == true) {
				if(pista2.getpistaAterrissagem().getinicio() != null) {
					System.out.println(pista2.getpistaAterrissagem().getinicio().StringPousar() + " => Aterrissou na Pista 2");
					pista2.getpistaAterrissagem().deletarAViaoPeloId(pista2.getpistaAterrissagem().getinicio().getId());
				}
				
				else if(pista2.getpistaDecolagem().getinicio() != null) {
					System.out.println(pista2.getpistaDecolagem().getinicio().StringDecolar() + " => Decolou na Pista 2");
					pista2.getpistaDecolagem().deletarAViaoPeloId(pista2.getpistaDecolagem().getinicio().getId());
				}
				
				else 
					System.out.println("A fila de Aterrissagem e Pouso da Pista 2 estão vazias");
				
			}
			if(avioesPista1 == false) {
				
				if(pista1.getpistaDecolagem().getinicio() != null) {
					System.out.println(pista1.getpistaDecolagem().getinicio().StringDecolar() + " => Decolou na Pista 1");
					pista1.getpistaDecolagem().deletarAViaoPeloId(pista1.getpistaDecolagem().getinicio().getId());
				}
				
				else if(pista1.getpistaAterrissagem().getinicio() != null) {
					System.out.println(pista1.getpistaAterrissagem().getinicio().StringPousar() + " => Aterrissou na Pista 1");
					pista1.getpistaAterrissagem().deletarAViaoPeloId(pista1.getpistaAterrissagem().getinicio().getId());
				}
				
				else 
					System.out.println("A fila de Aterrissagem e Pouso da Pista 1 estão vazias");
			}
			
			if(avioesPista2 == false) {
				
				if(pista2.getpistaDecolagem().getinicio()!=null) {
					System.out.println(pista2.getpistaDecolagem().getinicio().StringDecolar() + " => Decolou na Pista 2");
					pista2.getpistaDecolagem().deletarAViaoPeloId(pista2.getpistaDecolagem().getinicio().getId());
				}
				
				else if(pista2.getpistaAterrissagem().getinicio() != null) {
					System.out.println(pista2.getpistaAterrissagem().getinicio().StringPousar() + " => Aterrissou na Pista 2");
					pista2.getpistaAterrissagem().deletarAViaoPeloId(pista2.getpistaAterrissagem().getinicio().getId());
				}
				
				else 
					System.out.println("A Fila de Aterrissagem e Pouso da Pista 2 estão vazias");	
			}
			
			pista1.getpistaAterrissagem().diminuirCombustivel();
			pista2.getpistaAterrissagem().diminuirCombustivel();
			
			pista1.getpistaAterrissagem().aumentaUnidadeDeTempo();
			pista2.getpistaAterrissagem().aumentaUnidadeDeTempo();
			pista1.getpistaDecolagem().aumentaUnidadeDeTempo();
			pista2.getpistaDecolagem().aumentaUnidadeDeTempo();
			
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//--------------------------- Monta a Classe Aeroport -------------------------------------	
			
			System.out.println("\n/ = = = = = = = = = = = = = = = = = = / \n");
			System.out.println("Fila De Aterrissagem Da Pista 1: ");
			pista1.getpistaAterrissagem().mostraFilaAterrissagem();
			
			System.out.println("Fila De Aterrissagem Da Pista 2:");
			pista2.getpistaAterrissagem().mostraFilaAterrissagem();
			
			System.out.println("Fila De Decolagem Da Pista 1: ");
			pista1.getpistaDecolagem().mostraFilaDecolagem();
			
			System.out.println("Fila De Decolagem Da Pista 2:");
			pista2.getpistaDecolagem().mostraFilaDecolagem();
			
			System.out.println("---------------------------------------");
			System.out.println("|          RESULTADOS FINAIS          |");
			System.out.println("---------------------------------------");
			System.out.println("\nTEMPO MÉDIO DE ESPERA PARA ATERRISSAGEM:");
			System.out.println(mediaFinalAterrissagem + " Unidade(s) de tempo\n");
			
			System.out.println("TEMPO MÉDIO DE ESPERA PARA DECOLAGEM:");
			System.out.println(mediaFinalDecolagem + " Unidade(s) de tempo\n");
			
			System.out.println("NÚMERO DE AVIÕES QUE ATERRISSARAM EM EMERGÊNCIA:");
			System.out.println(PousosDeEmergencia + " avi(ão/ões)");
			
			System.out.println("\n/ = = = = = = = = = = = = = = = = = = / \n");
			
			
			System.out.println("Deseja continuar com a simulação?");
			System.out.println("[1] - Sim");
			System.out.println("[2] - Não");
			System.out.print("=> ");
			userInput = entrada.next();
			
			while(!userInput.equals("1") && !userInput.equals("2")) {
				System.out.println("Opção inválida!!\n");
				System.out.println("Deseja continuar com a simulação?");
				System.out.println("[1] - Sim");
				System.out.println("[2] - Não");
				System.out.print("=> ");
				userInput = entrada.next();
			}
			
			if(userInput.equalsIgnoreCase("2")) {
				simularVoo = false;
			}
			contador++;
			pista1.messagemFinal();
			
		}	
	}
}