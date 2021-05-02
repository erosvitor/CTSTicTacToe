package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import comum.Mensagens;

public class ThreadClientLeitura extends Thread
{
  private Socket cliente;
  private DataInputStream entrada;
  
  public ThreadClientLeitura(Socket cliente)
  {
    this.cliente = cliente;
    try {
      entrada = new DataInputStream(this.cliente.getInputStream());
    }
    catch (IOException erro) {
      Mensagens.erro("Não foi possível criar o canal de comunicação com o servidor.\n\n" + erro.getMessage());
    }
  }
  
  public void run()
  {
    String dados;
    while (!isInterrupted()) {
      try {
        dados = entrada.readUTF();
        if (dados != null)
          JogoDaVelhaClient.getInstance().receberDados(dados);
        else
          break;
      }
      catch (IOException e) {
      }
    }
  }
}
