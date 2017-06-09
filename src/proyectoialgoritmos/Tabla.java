package proyectoialgoritmos;

import DATA.Data;
import GUI.Gui;
import java.awt.Color;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JPanel
{
  private JTable jtbPrueba;
  private DefaultTableModel dtmModeloPrueba;
  Data data;
  
  public Tabla(Data data)
  {
    setBounds(70, 130, 600, 410);
    setBackground(Gui.panel2.getBackground());
    this.data = data;
    setLayout(null);
    init();
  }
  
  private void init() {
    String n = data.mostrarListas(1);
    String[] vec = n.split("<");
    
    String n2 = data.mostrarListas(2);
    String[] vec2 = n2.split("<");
    
    String n3 = data.mostrarListas(3);
    String[] vec3 = n3.split("<");
    
    String n4 = data.mostrarListas(4);
    String[] vec4 = n4.split("<");
    
    String n5 = data.mostrarListas(5);
    String[] vec5 = n5.split("<");
    
    String n6 = data.mostrarListas(6);
    String[] vec6 = n6.split("<");
    Object[][] datos = new Object[0][];
    String[] nombreColumnas = { "Codigo", "Titulo", "Genero", "Total", "Subtitulos", "Premier" };
    dtmModeloPrueba = new DefaultTableModel(datos, nombreColumnas);
    dtmModeloPrueba.addRow(new Object[] { "DRAMA>>" });
    

    for (int i = 7; i < vec.length; i += 6) {
      dtmModeloPrueba.addRow(new Object[] { vec[i], vec[(i + 1)], vec[(i + 2)], vec[(i + 3)], vec[(i + 4)], vec[(i + 5)] });
    }
    
    dtmModeloPrueba.addRow(new Object[] { "COMEDIA>>" });
    for (int i = 7; i < vec2.length; i += 6) {
      dtmModeloPrueba.addRow(new Object[] { vec2[i], vec2[(i + 1)], vec2[(i + 2)], vec2[(i + 3)], vec2[(i + 4)], vec2[(i + 5)] });
    }
    
    dtmModeloPrueba.addRow(new Object[] { "INFANTIL>>" });
    
    for (int i = 7; i < vec3.length; i += 6) {
      dtmModeloPrueba.addRow(new Object[] { vec3[i], vec3[(i + 1)], vec3[(i + 2)], vec3[(i + 3)], vec3[(i + 4)], vec3[(i + 5)] });
    }
    
    dtmModeloPrueba.addRow(new Object[] { "ACCION>>" });
    for (int i = 7; i < vec4.length; i += 6) {
      dtmModeloPrueba.addRow(new Object[] { vec4[i], vec4[(i + 1)], vec4[(i + 2)], vec4[(i + 3)], vec4[(i + 4)], vec4[(i + 5)] });
    }
    
    dtmModeloPrueba.addRow(new Object[] { "ROMANCE>>" });
    for (int i = 7; i < vec5.length; i += 6) {
      dtmModeloPrueba.addRow(new Object[] { vec5[i], vec5[(i + 1)], vec5[(i + 2)], vec5[(i + 3)], vec5[(i + 4)], vec5[(i + 5)] });
    }
    
    dtmModeloPrueba.addRow(new Object[] { "FICCION>>" });
    for (int i = 7; i < vec6.length; i += 6) {
      dtmModeloPrueba.addRow(new Object[] { vec6[i], vec6[(i + 1)], vec6[(i + 2)], vec6[(i + 3)], vec6[(i + 4)], vec6[(i + 5)] });
    }
    

    jtbPrueba = new JTable(dtmModeloPrueba);
    jtbPrueba.setBackground(Gui.bcatalogo.getBackground());
    jtbPrueba.setForeground(Color.white);
    

    JScrollPane scrollPane = new JScrollPane(jtbPrueba);
    scrollPane.createHorizontalScrollBar();
    jtbPrueba.setSize(500, 310);
    scrollPane.setBounds(0, 3, 600, 405);
    add(scrollPane);
    

    jtbPrueba.setEnabled(false);
  }
}