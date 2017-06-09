package GUI;

import DATA.Data;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyectoialgoritmos.Pelicula;
import proyectoialgoritmos.Tabla;

public class Gui extends JFrame implements java.awt.event.ActionListener, Runnable, java.awt.event.MouseListener
{
  private JDesktopPane desktopPane;
  private JMenuBar barra;
  private JMenu menu1;
  private JMenuItem item1;
  private JMenuItem item3;
  private JMenuItem item4;
  private JMenuItem item5;
  private JMenuItem item6;
  private JMenuItem guardar;
  private JFileChooser chooser;
  private FileNameExtensionFilter filtro;
  private Data data;
  private String[] vec;
  private JButton bbuscar;
  private JButton bagregar;
  private JButton Buscar;
  private JButton agreg;
  private JButton genero;
  private JButton left;
  private JButton right;
  public static JButton bcatalogo;
  public static JPanel panel1;
  public static JPanel panel2;
  private boolean ejecutar;
  private int count = 0;
  
  private Thread hilo;
  
  private javax.swing.JProgressBar progressBar;
  private JLabel label1;
  private JLabel advertencia;
  private JLabel llene;
  private JLabel der;
  private JLabel selectGenero;
  private JTextField field1;
  private JTextField fiel2;
  
  public Gui()
  {
    setResizable(false);
    setLayout(null);
    setSize(800, 600);
    setDefaultCloseOperation(3);
    setVisible(true);
    setLocationRelativeTo(null);
    desktopPane = new JDesktopPane();
    desktopPane.setLayout(null);
    add(desktopPane);
    desktopPane.setBackground(Color.black);
    panel1 = new JPanel();
    panel1.setBackground(desktopPane.getBackground());
    panel1.setBounds(0, 0, getWidth(), getHeight());
    panel1.setLayout(null);
    add(panel1);
    this.ejecutar = false;

    panel1.add(new proyectoialgoritmos.Imagen(120, 3));
    

    filtro = new FileNameExtensionFilter("Archivos .csv", new String[] { "csv" });
    

    barra = new JMenuBar();
    setJMenuBar(barra);
    barra.setBackground(new Color(108, 52, 131));
    barra.setBorder(null);
    barra.setForeground(Color.white);
    

    menu1 = new JMenu("Archivo");
    menu1.setForeground(Color.white);
    
    barra.add(menu1);
    



    der = new JLabel("© 2017 - Gabriel Navarro - all rights reserved");
    der.setForeground(Color.white);
    der.setBounds(10, 533, 300, 30);
    der.setFont(new Font(null, 4, 6));
    panel1.add(der);
    
    item1 = new JMenuItem("Cargar archivo .csv");
    menu1.add(item1);
    
    item1.addActionListener(this);
    



    item3 = new JMenuItem("Busqueda de pelicula por nombre");
    menu1.add(item3);
    item3.setEnabled(false);
    item3.addActionListener(this);
    
    item4 = new JMenuItem("Mostar Catalogo");
    menu1.add(item4);
    item4.setEnabled(false);
    item4.addActionListener(this);
    
    item5 = new JMenuItem("insertar pelicula");
    menu1.add(item5);
    item5.setEnabled(false);
    item5.addActionListener(this);
    
    guardar = new JMenuItem("Guardar lista actual...");
    menu1.add(guardar);
    guardar.addActionListener(this);
    
    item6 = new JMenuItem("Salir...");
    menu1.add(item6);
    item6.addActionListener(this);
    





    bcatalogo = new JButton("Catalogo");
    bcatalogo.setBounds(70, 100, 100, 33);
    bcatalogo.setBackground(new Color(91, 44, 111));
    bcatalogo.setForeground(Color.white);
    bcatalogo.setBorder(null);
    bcatalogo.setFocusable(false);
    bcatalogo.setFont(new Font("purisa", 0, 14));
    bcatalogo.addActionListener(this);
    bcatalogo.setVisible(false);
    panel1.add(bcatalogo);
    

    bbuscar = new JButton("Buscar");
    bbuscar.setBounds(175, 100, 100, 27);
    bbuscar.setBackground(new Color(154, 125, 10));
    bbuscar.setForeground(Color.white);
    bbuscar.setBorder(null);
    bbuscar.addActionListener(this);
    bbuscar.setFocusable(false);
    bbuscar.setFont(new Font("purisa", 0, 14));
    bbuscar.setVisible(false);
    panel1.add(bbuscar);
    
    bagregar = new JButton("Agregar");
    bagregar.setBounds(280, 100, 100, 27);
    bagregar.setBackground(new Color(21, 67, 96));
    bagregar.setForeground(Color.white);
    bagregar.setBorder(null);
    bagregar.addActionListener(this);
    bagregar.setFocusable(false);
    bagregar.setVisible(false);
    bagregar.setFont(new Font("purisa", 0, 14));
    panel1.add(bagregar);
    
    panel2 = new JPanel();
    panel2.setBackground(bcatalogo.getBackground());
    panel2.setBounds(70, 130, 600, 410);
    panel2.setLayout(null);
    panel2.setVisible(false);
    panel1.add(panel2);
    




    label1 = new JLabel("Ingrese un Titulo: ");
    label1.setBounds(80, 50, 150, 30);
    label1.setForeground(Color.white);
    panel2.add(label1);
    
    field1 = new JTextField();
    field1.setBounds(90, 80, 300, 25);
    panel2.add(field1);
    
    Buscar = new JButton("Buscar");
    Buscar.setBounds(90, 110, 100, 25);
    Buscar.setForeground(new Color(0, 0, 0));
    Buscar.setBackground(Color.white);
    Buscar.setFocusable(false);
    Buscar.addActionListener(this);
    panel2.add(Buscar);
    
    advertencia = new JLabel("No se encontro el Titulo");
    advertencia.setBounds(85, 150, 500, 30);
    advertencia.setForeground(Color.red);
    panel2.add(advertencia);
    
    label1.setVisible(false);
    field1.setVisible(false);
    Buscar.setVisible(false);
    advertencia.setVisible(false);
    


    llene = new JLabel("LLene los espacios:");
    llene.setBounds(25, 60, 300, 30);
    llene.setForeground(Color.white);
    panel2.add(llene);
    
    fiel2 = new JTextField("-codigo-");
    fiel2.setBounds(5, 100, 75, 25);
    panel2.add(fiel2);
    
    field3 = new JTextField("-titulo-");
    field3.setBounds(85, 100, 75, 25);
    field3.setVisible(false);
    panel2.add(field3);
    
    field4 = new JTextField("-genero-");
    field4.setBounds(165, 100, 75, 25);
    panel2.add(field4);
    
    field5 = new JTextField("-total-");
    field5.setBounds(245, 100, 75, 25);
    panel2.add(field5);
    
    field6 = new JTextField("-subtitulos-");
    field6.setBounds(325, 100, 75, 25);
    panel2.add(field6);
    
    field7 = new JTextField("-premier-");
    field7.setBounds(405, 100, 75, 25);
    panel2.add(field7);
    setSize(801, 601);
    
    agreg = new JButton("Agregar");
    agreg.setBounds(10, 135, 100, 25);
    agreg.setFocusable(false);
    agreg.setBackground(Color.white);
    agreg.addActionListener(this);
    panel2.add(agreg);
    
    llene.setVisible(false);
    fiel2.setVisible(false);
    field3.setVisible(false);
    field4.setVisible(false);
    field5.setVisible(false);
    field6.setVisible(false);
    field7.setVisible(false);
    agreg.setVisible(false);
    
    panel2.setVisible(false);
    bbuscar.setVisible(false);
    bagregar.setVisible(false);
    bcatalogo.setVisible(false);
  }
  

  private JTextField field3;
  
  private JTextField field4;
  private JTextField field5;
  private JTextField field6;
  private JTextField field7;
  private Tabla tabla;
  public static File file;

  
  public void cargarArchivo()
  {
    panel2.setVisible(false);
    
    chooser = new JFileChooser();
    chooser.setCurrentDirectory(null);
    chooser.setAcceptAllFileFilterUsed(false);
    chooser.addChoosableFileFilter(filtro);
    if (chooser.showOpenDialog(null) == 0) {
      file = chooser.getSelectedFile();
      
      data = new Data(file);
      data.LeerArchivo(file.getPath());
      data.LLenarListas();
      


      if (data.archivoLeido())
      {
        this.ejecutar=true;
        JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente!");
        item3.setEnabled(true);
        item4.setEnabled(true);
        item5.setEnabled(true);
        tabla = new Tabla(data);
        
        bbuscar.setVisible(true);
        bcatalogo.setVisible(true);
        bagregar.setVisible(true);
        
        tabla = new Tabla(data);
        panel2.setVisible(false);
        panel1.add(tabla);
        tabla.repaint();
      }
    }
  }
  



  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == item1) {
      cargarArchivo();
    }
    if (e.getSource() == item3) {
      advertencia.setVisible(false);
      label1.setVisible(true);
      field1.setVisible(true);
      Buscar.setVisible(true);
      

      bcatalogo.setBounds(70, 100, 100, 27);
      bbuscar.setBounds(175, 100, 100, 33);
      bagregar.setBounds(280, 100, 100, 27);
      panel2.setBackground(bbuscar.getBackground());
      
      llene.setVisible(false);
      fiel2.setVisible(false);
      field3.setVisible(false);
      field4.setVisible(false);
      field5.setVisible(false);
      field6.setVisible(false);
      field7.setVisible(false);
      agreg.setVisible(false);
      
      panel2.setVisible(true);
      panel1.remove(tabla);
    }
    if (e.getSource() == item4) {
      label1.setVisible(false);
      field1.setVisible(false);
      Buscar.setVisible(false);
      advertencia.setVisible(false);
      
      bcatalogo.setBounds(70, 100, 100, 33);
      bbuscar.setBounds(175, 100, 100, 27);
      bagregar.setBounds(280, 100, 100, 27);
      panel2.setBackground(bcatalogo.getBackground());
      
      llene.setVisible(false);
      fiel2.setVisible(false);
      field3.setVisible(false);
      field4.setVisible(false);
      field5.setVisible(false);
      field6.setVisible(false);
      field7.setVisible(false);
      agreg.setVisible(false);
      
      panel2.setVisible(false);
      panel1.add(tabla);
    }
    


    if (e.getSource() == item5) {
      label1.setVisible(false);
      field1.setVisible(false);
      Buscar.setVisible(false);
      advertencia.setVisible(false);
      
      llene.setVisible(true);
      fiel2.setVisible(true);
      field3.setVisible(true);
      field4.setVisible(true);
      field5.setVisible(true);
      field6.setVisible(true);
      field7.setVisible(true);
      agreg.setVisible(true);
      
      panel2.setVisible(true);
      panel1.remove(tabla);
      
      bcatalogo.setBounds(70, 100, 100, 27);
      
      bbuscar.setBounds(174, 100, 100, 27);
      bagregar.setBounds(280, 100, 100, 33);
      panel2.setBackground(bagregar.getBackground());
    }
    


    if (e.getSource() == bcatalogo) {
      tabla = new Tabla(data);
      panel2.setVisible(false);
      
      panel1.add(tabla);
      label1.setVisible(false);
      field1.setVisible(false);
      Buscar.setVisible(false);
      advertencia.setVisible(false);
      
      bcatalogo.setBounds(70, 100, 100, 33);
      bbuscar.setBounds(175, 100, 100, 27);
      bagregar.setBounds(280, 100, 100, 27);
      panel2.setBackground(bcatalogo.getBackground());
      
      llene.setVisible(false);
      fiel2.setVisible(false);
      field3.setVisible(false);
      field4.setVisible(false);
      field5.setVisible(false);
      field6.setVisible(false);
      field7.setVisible(false);
      agreg.setVisible(false);
      panel1.add(tabla);
      tabla.repaint();

    }
    

    if (e.getSource() == bbuscar)
    {
      advertencia.setVisible(false);
      label1.setVisible(true);
      field1.setVisible(true);
      Buscar.setVisible(true);
      

      bcatalogo.setBounds(70, 100, 100, 27);
      bbuscar.setBounds(175, 100, 100, 33);
      bagregar.setBounds(280, 100, 100, 27);
      panel2.setBackground(bbuscar.getBackground());
      
      llene.setVisible(false);
      fiel2.setVisible(false);
      field3.setVisible(false);
      field4.setVisible(false);
      field5.setVisible(false);
      field6.setVisible(false);
      field7.setVisible(false);
      agreg.setVisible(false);
      
      panel2.setVisible(true);
      panel1.remove(tabla);
    }
    if (e.getSource() == bagregar)
    {
      label1.setVisible(false);
      field1.setVisible(false);
      Buscar.setVisible(false);
      advertencia.setVisible(false);
      
      llene.setVisible(true);
      fiel2.setVisible(true);
      field3.setVisible(true);
      field4.setVisible(true);
      field5.setVisible(true);
      field6.setVisible(true);
      field7.setVisible(true);
      agreg.setVisible(true);
      
      panel2.setVisible(true);
      panel1.remove(tabla);
      
      bcatalogo.setBounds(70, 100, 100, 27);
      
      bbuscar.setBounds(174, 100, 100, 27);
      bagregar.setBounds(280, 100, 100, 33);
      panel2.setBackground(bagregar.getBackground());
    }
    if (e.getSource() == agreg) {
      Pelicula pelicula = new Pelicula(fiel2.getText(), field3.getText(), field4.getText(), field5.getText(), field6.getText(), field7.getText());
      switch (field4.getText()) {
      case "Drama":  data.agregarALista(1, pelicula);
        JOptionPane.showMessageDialog(null, "Se agrego correcta mente");
        break;
      case "Comedia":  data.agregarALista(2, pelicula);
        JOptionPane.showMessageDialog(null, "Se agrego correcta mente");
        break;
      case "Infantil":  data.agregarALista(3, pelicula);
        JOptionPane.showMessageDialog(null, "Se agrego correcta mente");
        break;
      case "Accion":  data.agregarALista(4, pelicula);
        JOptionPane.showMessageDialog(null, "Se agrego correcta mente");
        break;
      case "Romance":  data.agregarALista(5, pelicula);
        JOptionPane.showMessageDialog(null, "Se agrego correcta mente");
        break;
      case "Ficcion":  data.agregarALista(6, pelicula);
        JOptionPane.showMessageDialog(null, "Se agrego correcta mente");
        break;
      default:  JOptionPane.showMessageDialog(null, "Elgenero que intenta ingresar no se encuentra registrado");
      }
      data.LLenarListas();
    }
    
    if (e.getSource() == Buscar)
    {

      if (Buscar.getText() == "") {
        advertencia.setText("ingrese un dato");
        advertencia.setBackground(Color.red);
      }
      else
      {
        advertencia.setVisible(true);
        Pelicula pelicula = data.buscarPelicula(field1.getText());
        if (pelicula != null) {
          advertencia.setForeground(Color.white);
          advertencia.setText("[" + pelicula.getCodigo() + "] [" + pelicula.getTitulo() + "] [" + pelicula.getGenero() + "] [" + pelicula.getTotal() + "] [" + pelicula.getSubtitulos() + "] [" + pelicula.getPremier() + "]");
        }
        else
        {
          advertencia.setForeground(Color.red);
          advertencia.setText("no se encontro la pelicula");
        }
      }
    }
    if (e.getSource() == guardar) {
      if(this.ejecutar)
        data.guardarLista();
      else
        JOptionPane.showMessageDialog(null,"Intenta cargar un archivo ");
    }
    

    if (e.getSource() == item6) {
      System.exit(0);
    }
  }
  

  public void iniciar()
  {
    ejecutar = true;
  }
  
  public void addNotify()
  {
    super.addNotify();
    if (hilo == null) {
      hilo = new Thread(this);
      addMouseListener(this);
      hilo.start();
    }
  }
  


  public void run()
  {
    iniciar();
  }
  
  public void mouseClicked(MouseEvent e) {}
  
  public void mousePressed(MouseEvent e) {}
  
  public void mouseReleased(MouseEvent e) {}
  
  public void mouseEntered(MouseEvent e) {}
  
  public void mouseExited(MouseEvent e) {}
}