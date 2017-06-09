package proyectoialgoritmos;

public class Pelicula
{
  private String codigo;
  private String titulo;
  private String genero;
  private String total;
  private String subtitulos;
  private String premier;
  
  public Pelicula()
  {
    this("", "", "", "", "", "");
  }
  
  public Pelicula(String codigo, String titulo, String genero, String total, String subtitulos, String premier)
  {
    this.codigo = codigo;
    this.titulo = titulo;
    this.genero = genero;
    this.total = total;
    this.subtitulos = subtitulos;
    this.premier = premier;
  }
  

  public String getCodigo()
  {
    return codigo;
  }
  
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  
  public String getTitulo() {
    return titulo;
  }
  
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
  public String getGenero() {
    return genero;
  }
  
  public void setGenero(String genero) {
    this.genero = genero;
  }
  
  public String getTotal() {
    return total;
  }
  
  public void setTotal(String total) {
    this.total = total;
  }
  
  public String getSubtitulos() {
    return subtitulos;
  }
  
  public void setSubtitulos(String subtitulos) {
    this.subtitulos = subtitulos;
  }
  
  public String getPremier() {
    return premier;
  }
  
  public void setPremier(String premier) {
    this.premier = premier;
  }
}