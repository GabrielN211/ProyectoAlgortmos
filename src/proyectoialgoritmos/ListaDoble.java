package proyectoialgoritmos;

import java.io.PrintStream;

public class ListaDoble extends Thread {
  private NodoDoble start;
  private NodoDoble end;
  
  public ListaDoble() {
    start = this.end = null;
  }
  
          
  public boolean vacia()
  {
    return start == null;
  }
  
  public void addToEnd(Pelicula dato)
  {
    if (!vacia()) {
      end = new NodoDoble(dato, null, end);
      end.previous.next = end;
    } else {
      start = (this.end = new NodoDoble(dato));
    }
  }
  
  public void addToStart(Pelicula dato)
  {
    if (!vacia()) {
      start = new NodoDoble(dato, start, null);
      start.next.previous = start;
    } else {
      start = (this.end = new NodoDoble(dato));
    }
  }
  

  public String showListStartToEnd()
  {
    String datos = "|||<=>";
    if (!vacia())
    {
      NodoDoble aux = start;
      while (aux != null) {
        datos = datos + "[" + aux.dato + "]<=>\n";
        aux = aux.next;
      }
      datos = datos + "|||   <<< lista doblemente enlazada ";
    }
    return datos;
  }
  

  public String showListEndToStar()
  {
    String datos = "";
    if (!vacia())
    {
      NodoDoble aux = end;
      while (aux != null) {
        datos = datos + "<" + aux.dato.getCodigo() + "<" + aux.dato.getTitulo() + "<" + aux.dato.getGenero() + "<" + aux.dato.getTotal() + "<" + aux.dato.getSubtitulos() + "<" + aux.dato.getPremier() + "\n";
        aux = aux.previous;
      }
    }
    return datos;
  }
  



  public Pelicula buscarPelicula(String n)
  {
    Pelicula pelicula = null;
    if (!vacia())
    {
      NodoDoble aux = end;
      while (aux != null)
      {
        if (n.equalsIgnoreCase(aux.dato.getTitulo().trim()))
        {
          pelicula = aux.dato;
        }
        aux = aux.previous;
      }
    }
    return pelicula;
  }
  

  public Pelicula deleteAtStart()
  {
    Pelicula dato = start.dato;
    if (start == end) {
      start = (this.end = null);
    } else {
      start = start.next;
      start.previous = null;
    }
    return dato;
  }
  
  public void run() {}
}