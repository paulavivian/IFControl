package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String args[]) {
		try {

			ServerSocket server = new ServerSocket(3320);
			System.out.println("Servidor iniciado na porta 3320");
			while (true) {
				Socket cliente = server.accept();
				System.out.println("Cliente conectado do IP "
						+ cliente.getInetAddress().getHostAddress());
				Scanner entrada = new Scanner(cliente.getInputStream());
				while (entrada.hasNextLine()) {
					System.out.println(entrada.nextLine());
				}
				cliente.close();
				entrada.close();
			}
		} catch (IOException ex) {
			System.out.println("Erro no servidor!");
		}

	}
}
