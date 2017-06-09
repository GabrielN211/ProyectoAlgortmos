package DATA;

import com.csvreader.CsvReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectoialgoritmos.ListaDoble;
import proyectoialgoritmos.Pelicula;

public class Data
{
  private File file;
  private boolean leido = false;
  private String cadena;
  private ListaDoble lista1;
  private ListaDoble lista2;
  private ListaDoble lista3;
  private ListaDoble lista4;
  private ListaDoble lista5;
  private ListaDoble lista6;
  private String datos;
  private List<Pelicula> listPeliculas;
  
  public Data() {}
  
  public Data(File file) { this.file = file;
    lista1 = new ListaDoble();
    lista2 = new ListaDoble();
    lista3 = new ListaDoble();
    lista4 = new ListaDoble();
    lista5 = new ListaDoble();
    lista6 = new ListaDoble();
    lista1.addToStart(new Pelicula());
    lista2.addToStart(new Pelicula());
    lista3.addToStart(new Pelicula());
    lista4.addToStart(new Pelicula());
    lista5.addToStart(new Pelicula());
    lista6.addToStart(new Pelicula());
  }
  

  public void LeerArchivo(String path)
  {
    try
    {
      listPeliculas = new ArrayList();
      CsvReader file1 = new CsvReader(path);
      file1.readHeaders();
      while (file1.readRecord()) {
        Pelicula pelicula = new Pelicula();
        pelicula.setCodigo(file1.get(0));
        pelicula.setTitulo(file1.get(1));
        pelicula.setGenero(file1.get(2));
        pelicula.setTotal(file1.get(3));
        pelicula.setSubtitulos(file1.get(4));
        pelicula.setPremier(file1.get(5));
        
        listPeliculas.add(pelicula);
      }
      

      file1.close();
      leido = true;
    }
    catch (FileNotFoundException ex)
    {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public void agregarALista(int n, Pelicula pelicula) {
    switch (n) {
    case 1:  lista1.addToStart(pelicula); break;
    case 2:  lista2.addToStart(pelicula); break;
    case 3:  lista3.addToStart(pelicula); break;
    case 4:  lista4.addToStart(pelicula); break;
    case 5:  lista5.addToStart(pelicula); break;
    case 6:  lista6.addToStart(pelicula); break;
    default:  JOptionPane.showMessageDialog(null, "A ocurrido un error :)");
    }
  }
  
  public void LLenarListas()
  {
    for (int i = 0; i < listPeliculas.size(); i++) {
      Pelicula pelicula = (Pelicula)listPeliculas.get(i);
      
      switch (pelicula.getGenero())
      {
      case "1000": 
        pelicula.setGenero("Drama");
        lista1.addToStart(pelicula);
        break;
      case "2000": 
        pelicula.setGenero("Comedia");
        lista2.addToStart(pelicula);
        break;
      case "3000": 
        pelicula.setGenero("Infantil");
        lista3.addToStart(pelicula);
        break;
      case "4000": 
        pelicula.setGenero("Accion");
        lista4.addToStart(pelicula);
        break;
      case "5000": 
        pelicula.setGenero("Romance");
        lista5.addToStart(pelicula);
        break;
      case "6000": 
        pelicula.setGenero("Ficcion");
        lista6.addToStart(pelicula);
      }
      
    }
  }
  

  public String mostrarListas(int num)
  {
    String datos = "";
    switch (num) {
    case 1:  datos = lista1.showListEndToStar(); break;
    case 2:  datos = lista2.showListEndToStar(); break;
    case 3:  datos = lista3.showListEndToStar(); break;
    case 4:  datos = lista4.showListEndToStar(); break;
    case 5:  datos = lista5.showListEndToStar(); break;
    case 6:  datos = lista6.showListEndToStar();
    }
    
    

    return datos;
  }
  
  public Pelicula buscarPelicula(String nombre) { String n = nombre;
    Pelicula pelicula = lista1.buscarPelicula(n);
    if (pelicula == null)
      pelicula = lista2.buscarPelicula(n);
    if (pelicula == null)
      pelicula = lista3.buscarPelicula(n);
    if (pelicula == null)
      pelicula = lista4.buscarPelicula(n);
    if (pelicula == null)
      pelicula = lista5.buscarPelicula(n);
    if (pelicula == null) {
      pelicula = lista6.buscarPelicula(n);
    }
    return pelicula;
  }
  
  public void guardarLista() {
    String n = JOptionPane.showInputDialog(null, "Escriba el nombre del archivo");
    n = n + ".csv";
    
    //System.out.println(n+"<<<<<<");
    File file = new File(n);
    if (n.equals(null+".csv") || n.equals(".csv")) {
      JOptionPane.showMessageDialog(null, "no ingresaste un nombre");
    } else {
      if (file.exists()) {
        JOptionPane.showMessageDialog(null, "El archivo a sido actualizado");
      }
      else
         JOptionPane.showMessageDialog(null, "El archivo se guardo correctamente"); 
      
      try
      {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(lista1.showListEndToStar().replace('<', ','));
        bw.write(lista2.showListEndToStar().replace('<', ','));
        bw.write(lista3.showListEndToStar().replace('<', ','));
        bw.write(lista4.showListEndToStar().replace('<', ','));
        bw.write(lista5.showListEndToStar().replace('<', ','));
        bw.write(lista6.showListEndToStar().replace('<', ','));
        
        bw.close();
        JOptionPane.showMessageDialog(null, "El archivo se guardo correctamente");
      } catch (IOException ex) {
        Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
  
  public boolean archivoLeido()
  {
    return leido;
  }
  
  public String getCadena() {
    return cadena;
  }
}