package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import comum.Mensagens;

public class ThreadServerAguardarConexao extends Thread
{
  private ServerSocket servidor;
  private Socket cliente;
  private DataOutputStream saida;
  
  public ThreadServerAguardarConexao(ServerSocket servidor)
  {
    this.servidor = servidor;
  }
  
  public void run()
  {
    try {
      while (!isInterrupted()) {
        cliente = servidor.accept();
        saida = new DataOutputStream(cliente.getOutputStream());
        Thread threadLeitura = new ThreadSeverLeitura(cliente);
        threadLeitura.start();
        JogoDaVelhaServer.getInstance().tratarConexaoOutroJogador();
      }
    }
    catch (IOException e) {
    }
  }
  
  public void enviarDados(String dados)
  {
    try {
      saida.writeUTF(dados);
    }
    catch (IOException erro) {
      Mensagens.erro("Não foi possível enviar a jogada.\n\n" + erro.getMessage());
    }
  }
}
