package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSeverLeitura extends Thread
{
  private Socket cliente;
  
  public ThreadSeverLeitura(Socket cliente)
  {
    this.cliente = cliente;
  }
  
  public void run()
  {
    try {
      DataInputStream entrada = new DataInputStream(cliente.getInputStream());
      String buffer = entrada.readUTF();
      while (buffer != null && !(buffer.trim().equals(""))) {
        JogoDaVelhaServer.getInstance().receberDados(buffer);
        buffer = entrada.readUTF();
      }
    }
    catch (IOException e) {
      JogoDaVelhaServer.getInstance().tratarDesconexaoOutroJogador();
    }
  }
}
