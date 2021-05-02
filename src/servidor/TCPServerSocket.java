package servidor;

import java.io.IOException;
import java.net.ServerSocket;

import comum.Mensagens;

public class TCPServerSocket
{
  private ServerSocket servidor;
  private ThreadServerAguardarConexao threadAguardarConexao;
  
  public boolean ativarServidor()
  {
    try {
      servidor = new ServerSocket(5577);
      return true;
    } catch (IOException erro) {
      Mensagens.erro("Não foi possível ativar o servidor.\n\n" + erro.getMessage());
      return false;
    }
  }
  
  public boolean desativarServidor()
  {
    try {
      servidor.close();
      return true;
    } catch (IOException erro) {
      Mensagens.erro("Não foi possível desativar o servidor.\n\n" + erro.getMessage());
      return false;
    }
  }
  
  public void aguardarConexao()
  {
    threadAguardarConexao = new ThreadServerAguardarConexao(servidor);
    threadAguardarConexao.start();
  }
  
  public void enviarDados(String dados)
  {
    threadAguardarConexao.enviarDados(dados);
  }
}
