package comum;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Mensagens
{
  private static final String MSG_POSICAO_OCUPADA = "Por favor, escolha outra posição.";
  private static final String MSG_POSICAO_OCUPADA_TITULO = "Posição indisponível";
  
  private static final String MSG_AGUARDANDO_JOGADA = "Por favor, aguarde o outro jogador fazer a jogada.";
  private static final String MSG_AGUARDANDO_JOGADA_TITULO = "Jogada já efetuada.";
  
  private static final String MSG_OUTRO_JOGADOR_NAO_CONECTADO = "Por favor, aguarde o outro jogador efetuar a conexão.";
  private static final String MSG_OUTRO_JOGADOR_NAO_CONECTADO_TITULO = "Jogador O não conectado.";
  
  private static final String MSG_JOGADOR_X_NAO_ATIVO = "Por favor, verifique se o jogador X esta ativo.";
  private static final String MSG_JOGADOR_X_NAO_ATIVO_TITULO = "Jogador X não ativo.";

  private static final String MSG_VENCEDOR = "Parabéns, você venceu a partida.";
  private static final String MSG_VENCEDOR_TITULO = "Game Over";
  
  private static final String MSG_PERDEDOR = "Infelizmente você perdeu a partida.";
  private static final String MSG_PERDEDOR_TITULO = "Game Over";
  
  private static final String MSG_EMPATE = "Infelizmente a partida não teve vencedor.";
  private static final String MSG_EMPATE_TITULO = "Empate";

  public static void posicaoOcupada()
  {
    JOptionPane.showMessageDialog(null, MSG_POSICAO_OCUPADA, MSG_POSICAO_OCUPADA_TITULO, JOptionPane.ERROR_MESSAGE);
  }
  
  public static void aguardandoJogada()
  {
    JOptionPane.showMessageDialog(null, MSG_AGUARDANDO_JOGADA, MSG_AGUARDANDO_JOGADA_TITULO, JOptionPane.ERROR_MESSAGE);
  }
  
  public static void outroJogadorNaoConectado()
  {
    JOptionPane.showMessageDialog(null, MSG_OUTRO_JOGADOR_NAO_CONECTADO, MSG_OUTRO_JOGADOR_NAO_CONECTADO_TITULO, JOptionPane.ERROR_MESSAGE);
  }
  
  public static void jogadorXNaoEstaAtivo()
  {
    JOptionPane.showMessageDialog(null, MSG_JOGADOR_X_NAO_ATIVO, MSG_JOGADOR_X_NAO_ATIVO_TITULO, JOptionPane.ERROR_MESSAGE);
  }
  
  public static void erro(String msg)
  {
    JOptionPane.showMessageDialog(null, "Operação falhou", msg, JOptionPane.ERROR_MESSAGE);
  }

  public static void vencedor()
  {
    ImageIcon icon = new ImageIcon(System.class.getResource("/imagens/vencedor 72x72.png"));
    JOptionPane.showMessageDialog(null, MSG_VENCEDOR, MSG_VENCEDOR_TITULO, JOptionPane.INFORMATION_MESSAGE, icon);
  }
  
  public static void perdedor()
  {
    ImageIcon icon = new ImageIcon(System.class.getResource("/imagens/perdedor 72x72.png"));
    JOptionPane.showMessageDialog(null, MSG_PERDEDOR, MSG_PERDEDOR_TITULO, JOptionPane.INFORMATION_MESSAGE, icon);
  }
  
  public static void empate()
  {
    ImageIcon icon = new ImageIcon(System.class.getResource("/imagens/empate 72x72.png"));
    JOptionPane.showMessageDialog(null, MSG_EMPATE, MSG_EMPATE_TITULO, JOptionPane.INFORMATION_MESSAGE, icon);
  }
}
