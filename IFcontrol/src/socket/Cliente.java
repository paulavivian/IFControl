package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		// Declaro o socket cliente
		Socket s = null;

		// Declaro a Stream de saida de dados
		PrintStream ps = null;

		try {

			String x = "conexão bem sucedidade"
					+ " ";
			// Cria o socket com o recurso desejado na porta especificada
			s = new Socket("127.0.0.1", 7000);

			// Cria a Stream de saida de dados
			ps = new PrintStream(s.getOutputStream());

			// Imprime uma linha para a stream de saída de dados
			ps.println(x);
		} catch (IOException e) {
			System.out
					.println("Erro");
		} finally {

			try {

				// Encerra o socket cliente
				s.close();

			} catch (IOException e) {
			}

		}

	}
}
