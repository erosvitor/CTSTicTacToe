package servidor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import comum.Constantes;
import comum.Mensagens;
import comum.TelaSobre;

public class JogoDaVelhaServer extends JFrame
{
  private static final long serialVersionUID = 1L;

  private JMenu menuArquivo;
  private JMenuItem miReiniciarJogo;
  private JMenuItem miSair;
  private JMenu menuAjuda;
  private JMenuItem miSobre;
  private JMenuBar menuBar;

  private JTextField edtStatus;
  
  private JPanel pnlBotoes;
  private JButton btn1;
  private JButton btn2;
  private JButton btn3;
  private JButton btn4;
  private JButton btn5;
  private JButton btn6;
  private JButton btn7;
  private JButton btn8;
  private JButton btn9;
  
  private TCPServerSocket servidor;
  
  private boolean aguardandoJogadaOutroJogador;
  private boolean outroJogadorEstaConectado;
  
  private static JogoDaVelhaServer jogoDaVelha = null;
  
  public static JogoDaVelhaServer getInstance()
  {
    if (jogoDaVelha == null) {
      jogoDaVelha = new JogoDaVelhaServer();
    }
    return jogoDaVelha;
  }

  private JogoDaVelhaServer()
  {
    miReiniciarJogo = new JMenuItem("Reiniciar Jogo");
    miReiniciarJogo.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        if (outroJogadorEstaConectado) {
          resetarJogo();
          servidor.enviarDados(Constantes.RESETAR_JOGO);
        }
      }
    });
    miSair = new JMenuItem("Sair");
    miSair.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        servidor.desativarServidor();
        System.exit(0);
      }
    });
    menuArquivo = new JMenu("Arquivo");
    menuArquivo.add(miReiniciarJogo);
    menuArquivo.add(miSair);
    
    miSobre = new JMenuItem("Sobre...");
    miSobre.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        new TelaSobre().setVisible(true);
      }
    });
    menuAjuda = new JMenu("Ajuda");
    menuAjuda.add(miSobre);
    
    menuBar = new JMenuBar();
    menuBar.add(menuArquivo);
    menuBar.add(menuAjuda);

    edtStatus = new JTextField();
    edtStatus.setEditable(false);
    edtStatus.setFont(new Font("", Font.PLAIN|Font.BOLD, 12));
    edtStatus.setForeground(Color.BLUE);
    edtStatus.setMaximumSize(new Dimension(32767, 35));
    edtStatus.setOpaque(true);
    edtStatus.setBackground(Color.WHITE);
    edtStatus.setBorder(BorderFactory.createEmptyBorder(5,  5,  5,  5));
    edtStatus.setMargin(new Insets(10,  5,  5,  5));
    
    btn1 = new JButton("");
    btn1.setFont(new Font("Arial", Font.PLAIN, 36));
    btn1.setName("btn1");
    btn1.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn1);
      }
    });
    btn2 = new JButton("");
    btn2.setFont(new Font("Arial", Font.PLAIN, 36));
    btn2.setName("btn2");
    btn2.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn2);
      }
    });
    btn3 = new JButton("");
    btn3.setFont(new Font("Arial", Font.PLAIN, 36));
    btn3.setName("btn3");
    btn3.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn3);
      }
    });
    btn4 = new JButton("");
    btn4.setFont(new Font("Arial", Font.PLAIN, 36));
    btn4.setName("btn4");
    btn4.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn4);
      }
    });
    btn5 = new JButton("");
    btn5.setFont(new Font("Arial", Font.PLAIN, 36));
    btn5.setName("btn5");
    btn5.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn5);
      }
    });
    btn6 = new JButton("");
    btn6.setFont(new Font("Arial", Font.PLAIN, 36));
    btn6.setName("btn6");
    btn6.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn6);
      }
    });
    btn7 = new JButton("");
    btn7.setFont(new Font("Arial", Font.PLAIN, 36));
    btn7.setName("btn7");
    btn7.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn7);
      }
    });
    btn8 = new JButton("");
    btn8.setFont(new Font("Arial", Font.PLAIN, 36));
    btn8.setName("btn8");
    btn8.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn8);
      }
    });
    btn9 = new JButton("");
    btn9.setFont(new Font("Arial", Font.PLAIN, 36));
    btn9.setName("btn9");
    btn9.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        efetuarJogada(btn9);
      }
    });

    pnlBotoes = new JPanel();
    pnlBotoes.add(btn1);
    pnlBotoes.add(btn2);
    pnlBotoes.add(btn3);
    pnlBotoes.add(btn4);
    pnlBotoes.add(btn5);
    pnlBotoes.add(btn6);
    pnlBotoes.add(btn7);
    pnlBotoes.add(btn8);
    pnlBotoes.add(btn9);
    
    pnlBotoes.setLayout(new GridLayout(3, 3));
    
    this.setJMenuBar(menuBar);
    this.add(edtStatus);
    this.add(pnlBotoes);

    this.setTitle("Jogo da Velha - Jogador 'X'");
    this.setSize(400, 400);
    this.setMinimumSize(new Dimension(400,  400));
    this.setLocationRelativeTo(null);
    this.setResizable(true);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    ImageIcon img = new ImageIcon(getClass().getResource("/imagens/icone.png"));
    this.setIconImage(img.getImage());
    
    this.repaint();
    
    servidor = new TCPServerSocket();
    servidor.ativarServidor();
    servidor.aguardarConexao();
    
    aguardandoJogadaOutroJogador = false;
    outroJogadorEstaConectado = false;
    edtStatus.setText(Constantes.AGUARDANDO_JOGADOR_0_ENTRAR);
  }
  
  private void efetuarJogada(JButton botao)
  {
    if (botao.getText().equals("")) {
      if (outroJogadorEstaConectado) {
        if (aguardandoJogadaOutroJogador) {
          Mensagens.aguardandoJogada();
        }
        else {
          botao.setText("X");
          servidor.enviarDados(botao.getName()+",X");
          aguardandoJogadaOutroJogador = true;
          edtStatus.setText(Constantes.AGUARDANDO_JOGADA_JOGADOR_O);
          verificarVencedor();
        }
      }
      else {
        Mensagens.outroJogadorNaoConectado();
      }
    }
    else {
      Mensagens.posicaoOcupada();
    }
  }

  public void receberDados(String dados)
  {
    if (dados.equals(Constantes.GAME_OVER)) {
      Mensagens.perdedor();
      resetarJogo();
      return;
    }
    else if (dados.equals(Constantes.EMPATE)) {
      Mensagens.empate();
      resetarJogo();
      return;
    }
    else if (dados.equals(Constantes.RESETAR_JOGO)) {
      resetarJogo();
      return;
    }
    
    String tmp[] = dados.split(",");
    String botao = tmp[0];
    String valor = tmp[1];
    
    if (botao.equals("btn1"))
      getInstance().btn1.setText(valor);
    else if (botao.equals("btn2"))
      getInstance().btn2.setText(valor);
    else if (botao.equals("btn3"))
      getInstance().btn3.setText(valor);
    else if (botao.equals("btn4"))
      getInstance().btn4.setText(valor);
    else if (botao.equals("btn5"))
      getInstance().btn5.setText(valor);
    else if (botao.equals("btn6"))
      getInstance().btn6.setText(valor);
    else if (botao.equals("btn7"))
      getInstance().btn7.setText(valor);
    else if (botao.equals("btn8"))
      getInstance().btn8.setText(valor);
    else if (botao.equals("btn9"))
      getInstance().btn9.setText(valor);
    
    aguardandoJogadaOutroJogador = false;
    edtStatus.setText(Constantes.PENSANDO);
  }
  
  private void verificarVencedor()
  {
    if (
      // Linhas horizontais
      (btn1.getText().equals("X") && btn2.getText().equals("X") && btn3.getText().equals("X")) ||
      (btn4.getText().equals("X") && btn5.getText().equals("X") && btn6.getText().equals("X")) ||
      (btn7.getText().equals("X") && btn8.getText().equals("X") && btn9.getText().equals("X")) ||
        
      // Linhas verticais
      (btn1.getText().equals("X") && btn4.getText().equals("X") && btn7.getText().equals("X")) ||
      (btn2.getText().equals("X") && btn5.getText().equals("X") && btn8.getText().equals("X")) ||
      (btn3.getText().equals("X") && btn6.getText().equals("X") && btn9.getText().equals("X")) ||
        
      // Linhas diagonais
      (btn1.getText().equals("X") && btn5.getText().equals("X") && btn9.getText().equals("X")) ||
      (btn3.getText().equals("X") && btn5.getText().equals("X") && btn7.getText().equals("X"))
      )
    {
      servidor.enviarDados(Constantes.GAME_OVER);
      Mensagens.vencedor();
      resetarJogo();
    }
    else if (
      (!btn1.getText().equals("") && !btn2.getText().equals("") && !btn3.getText().equals("")) &&
      (!btn4.getText().equals("") && !btn5.getText().equals("") && !btn6.getText().equals("")) &&
      (!btn7.getText().equals("") && !btn8.getText().equals("") && !btn9.getText().equals(""))
      )
    {
      servidor.enviarDados(Constantes.EMPATE);
      Mensagens.empate();
      resetarJogo();
    }
  }
  
  public void tratarConexaoOutroJogador()
  {
    edtStatus.setText(Constantes.AGUARDANDO_INICIO_JOGO);
    outroJogadorEstaConectado = true;
  }
  
  public void tratarDesconexaoOutroJogador()
  {
    limparTabuleiro();
    edtStatus.setText(Constantes.AGUARDANDO_JOGADOR_0_ENTRAR);
    outroJogadorEstaConectado = false;
  }
  
  private void resetarJogo()
  {
    limparTabuleiro();
    aguardandoJogadaOutroJogador = false;
    edtStatus.setText(Constantes.AGUARDANDO_INICIO_JOGO);
  }
  
  private void limparTabuleiro()
  {
    btn1.setText("");
    btn2.setText("");
    btn3.setText("");
    btn4.setText("");
    btn5.setText("");
    btn6.setText("");
    btn7.setText("");
    btn8.setText("");
    btn9.setText("");
  }

  public static void main(String args[])
  {
    getInstance().setVisible(true);
  }
}