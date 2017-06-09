package proyectoialgoritmos;

public class NodoDoble
{
  public Pelicula dato;
  public NodoDoble next;
  public NodoDoble previous;
  
  public NodoDoble(Pelicula dato) {
    this(new Pelicula(), null, null);
  }
  
  public NodoDoble(Pelicula dato, NodoDoble next, NodoDoble previous)
  {
    this.dato = dato;
    this.next = next;
    this.previous = previous;
  }
}