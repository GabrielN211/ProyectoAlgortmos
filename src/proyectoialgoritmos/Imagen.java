package proyectoialgoritmos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Imagen
  extends JPanel
{
  public Imagen(int x, int y) { setBounds(x, y, 500, 200); }
  
  public void paintComponent(Graphics g) {
    BufferedImage imagen = loadImage("/assets/cine.png");
    g.drawImage(imagen, 0, 0, null);
  }
  
  public BufferedImage loadImage(String m) { BufferedImage i = null;
    try {
      i = ImageIO.read(getClass().getResourceAsStream(m));
    } catch (IOException ex) {
      Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
    }
    

    return i;
  }
}