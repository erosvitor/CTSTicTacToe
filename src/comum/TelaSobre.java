package comum;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class TelaSobre extends JDialog
{
  private static final long serialVersionUID = 1L;

  private JLabel lblLogotipo;
  private JLabel lblTitulo;
  private JLabel lblVersao;
  private JLabel lblAutor;
  private JLabel lblCopyright;
  private JLabel lblEmail;
  private JLabel lblHomepage;
  private JSeparator linha;
  private JButton btnOk;

  private Container container;
  
  public TelaSobre()
  {
    // Construindo os componentes do formulário 
    lblLogotipo = new JLabel();
    lblLogotipo.setBounds(20, 10, 32, 32);
    lblLogotipo.setIcon(new ImageIcon(getClass().getResource("/imagens/icone.png")));
    
    lblTitulo = new JLabel();
    lblTitulo.setText("Jogo da Velha");
    lblTitulo.setFont(new Font("", Font.BOLD, 14));
    lblTitulo.setBounds(80, 10, 200, 20);

    lblVersao = new JLabel();
    lblVersao.setText("Versão 1.0.0");
    lblVersao.setBounds(80, 30, 200, 20);
    
    lblAutor = new JLabel();
    lblAutor.setText("Eros Vitor Bornatowski");
    lblAutor.setBounds(80, 70, 200, 20);
    
    lblCopyright = new JLabel();
    lblCopyright.setText("Software OpenSource");
    lblCopyright.setBounds(80, 90, 360, 20);

    lblEmail = new JLabel();
    lblEmail.setText("erosborna@gmail.com");
    lblEmail.setBounds(80, 130, 360, 20);
    
    lblHomepage = new JLabel();
    lblHomepage.setText("https://br.linkedin.com/in/erosvitor");
    lblHomepage.setBounds(80, 150, 360, 20);
    
    linha = new JSeparator(JSeparator.HORIZONTAL);
    linha.setBounds(20, 190, 320, 2);
    
    btnOk = new JButton();
    btnOk.setText("Ok");
    btnOk.setIcon(new ImageIcon(getClass().getResource("/imagens/ok.png")));
    btnOk.setBounds(280, 205, 60, 23);
    btnOk.setMargin(new Insets(0, 0, 0, 0));
    btnOk.setFocusable(false);
    btnOk.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent arg0)
      {
        dispose();
      }
    });
    
    // Adicionando os componentes no container do formulário
    container = this.getContentPane();
    container.add(lblLogotipo);
    container.add(lblTitulo);
    container.add(lblVersao);
    container.add(lblAutor);
    container.add(lblCopyright);
    container.add(lblEmail);
    container.add(lblHomepage);
    container.add(linha);
    container.add(btnOk);
    
    // Configurando o formulário
    this.setTitle("Sobre...");
    this.setSize(370, 270);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setModal(true);
    this.setLayout(null);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  }
}