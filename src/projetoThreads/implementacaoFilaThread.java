package projetoThreads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

//         extends Threads para reotilizar os comportamentos da thread // porque a classe é para se tornar uma thread //reotilizar todos os recursos
public class implementacaoFilaThread extends Thread {

	// static para ser unica/ paro poder acesar sempre com os mesmos dados,
	// //criando a pilha
	private static ConcurrentLinkedQueue<objetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<objetoFilaThread>();

	// metodo statico pra poder adicionar os objetos na lista
	public static void add(objetoFilaThread objetofilaThread) {
		pilha_fila.add(objetofilaThread);
	}

	@Override // run para ficar procesando
	public void run() {
		System.out.println("fila rodando");
		
		

		while(true) {
		
	    
		synchronized (pilha_fila) {// para bloquear o acesso a esta lista por outros processos// (garantindo que só
									// essa thread ira acessar a lista
			Iterator iteracao = pilha_fila.iterator();
			while (iteracao.hasNext()) {// enquanto conter dados na lista ira processar

				objetoFilaThread processar = (objetoFilaThread) iteracao.next();

				// -- exemplo de coisas possiveis de fazer com muitos dados
				// processar 10 mil notas fiscais
				// gerar lista enorme de pdf
				// gerar um envio em massa de email
				
				
				//--teste
				
				
				System.out.println("-------------------------------------");
				System.out.println(processar.getNome());
				System.out.println(processar.getEmail());
				
				
				
				//--

				// enquanto tiver objetos o metodo vai estar removendo os objetos
				iteracao.remove();

				// dar um tempo para que o java de uma descarga de memoria
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		
		
		
		try {// prossou toda a lista dar um tempo para limpesa de memoria
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	
	}	
	
	

}
