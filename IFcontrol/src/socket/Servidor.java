package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		// Declaro o ServerSocket
		ServerSocket serv = null;

		// Declaro o Socket de comunica��o
		Socket s = null;

		// Declaro o leitor para a entrada de dados
		BufferedReader entrada = null;

		try {

			// Cria o ServerSocket na porta 7000 se estiver dispon�vel
			serv = new ServerSocket(7000);

			// Aguarda uma conex�o na porta especificada e cria retorna o socket
			// que ir� comunicar com o cliente
			s = serv.accept();

			// Cria um BufferedReader para o canal da stream de entrada de dados
			// do socket s
			entrada = new BufferedReader(new InputStreamReader(
					s.getInputStream()));

			// Aguarda por algum dado e imprime a linha recebida quando recebe
			System.out.println(entrada.readLine());

			// trata poss�veis excess�es de input/output. Note que as excess�es
			// s�o as mesmas utilizadas para as classes de java.io
		} catch (IOException e) {

			// Imprime uma notifica��o na sa�da padr�o caso haja algo errado.
			System.out
					.println("Algum problema ocorreu para criar ou receber o socket.");

		} finally {

			try {

				// Encerro o socket de comunica��o
				s.close();

				// Encerro o ServerSocket
				serv.close();

			} catch (IOException e) {
			}
		}

	}
}
}
