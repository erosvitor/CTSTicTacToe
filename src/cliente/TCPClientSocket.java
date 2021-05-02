package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import comum.Mensagens;

public class TCPClientSocket
{
  private Socket cliente;
  private DataOutputStream saida;
  private ThreadClientLeitura threadLeitura;
  
  public boolean conectar(String ipServidor, int portaServidor)
  {
    try {
      cliente = new Socket(ipServidor, portaServidor);
      saida = new DataOutputStream(cliente.getOutputStream());
      threadLeitura = new ThreadClientLeitura(cliente);
      threadLeitura.start();
      return true;
    } catch (IOException e) {
      return false;
    }
  }
  
  public boolean desconectar()
  {
    try {
      cliente.close();
      return true;
    } catch (IOException e) {
      return false;
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
