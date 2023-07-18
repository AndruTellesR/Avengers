import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class Vista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vista extends JFrame implements ActionListener
{
    // instance variables - replace the example below with your own
    private JTextField nombreTxt;
    private JTextField aliasTxt;
    private JTextField descripcionTxt;
    private JTextField armasTxt;
    private JTextField fechaAparicionTxt;
    private JTextField fechaNacimientoTxt;
    private JCheckBox aparicionCheck;
    private JComboBox generoCombo;
    private JComboBox estadoCombo;
    
    
    private JLabel nombreLbl;
    private JLabel aliasLbl;
    private JLabel descripcionLbl;
    private JLabel armasLbl;
    private JLabel fechaAparicionLbl;
    private JLabel fechaNacimientoLbl;
    private JLabel aparicionLbl;
    private JLabel generoLbl;
    private JLabel estadoLbl;
    
    private JButton agregar;
    private JButton buscar;
    private JButton limpiar;
    private JButton imprimir;
    
    java.util.List<Personaje> personajes = new ArrayList<Personaje>();
    
    public Vista()
    {   
        setSize(400,400);
        setTitle("Registro de Vengadores");
        
        nombreTxt = new JTextField();
        aliasTxt = new JTextField();
        descripcionTxt = new JTextField();
        armasTxt = new JTextField();
        fechaAparicionTxt = new JTextField();
        fechaNacimientoTxt = new JTextField();
        aparicionCheck = new JCheckBox();
        generoCombo = new JComboBox();
        generoCombo.addItem(Genero.HOMBRE.name());
        generoCombo.addItem(Genero.MUJER.name());
        generoCombo.addItem(Genero.ANDROIDE.name());
        generoCombo.addItem(Genero.EXTRATERRESTRE.name());
        estadoCombo = new JComboBox();
        estadoCombo.addItem(Estado.ACTIVO.name());
        estadoCombo.addItem(Estado.DESAPARECIDO.name());
        estadoCombo.addItem(Estado.MUERTO.name());
        
        nombreLbl = new JLabel("Nombre");
        aliasLbl = new JLabel("Alias");
        descripcionLbl = new JLabel("Descripcion");
        armasLbl = new JLabel("Armas");
        fechaAparicionLbl = new JLabel("Fecha Aparición");
        fechaNacimientoLbl = new JLabel("Fecha Nacimiento");
        aparicionLbl = new JLabel("Aparece");
        generoLbl = new JLabel("Genero");
        estadoLbl = new JLabel("Estado");
        
        agregar = new JButton("Agregar");
        buscar = new JButton("Buscar");
        limpiar = new JButton("Limpiar");
        imprimir = new JButton("Imprimir");
        
        limpiar.addActionListener(this);
        agregar.addActionListener(this);
        buscar.addActionListener(this);
        imprimir.addActionListener(this);
        
        getContentPane().setLayout(new GridLayout(11,2));
        
        getContentPane().add(nombreLbl);
        getContentPane().add(nombreTxt);
        getContentPane().add(aliasLbl);
        getContentPane().add(aliasTxt);
        getContentPane().add(descripcionLbl);
        getContentPane().add(descripcionTxt);
        getContentPane().add(armasLbl);
        getContentPane().add(armasTxt);
        getContentPane().add(fechaAparicionLbl);
        getContentPane().add(fechaAparicionTxt);
        getContentPane().add(fechaNacimientoLbl);
        getContentPane().add(fechaNacimientoTxt);
        getContentPane().add(aparicionLbl);        
        getContentPane().add(aparicionCheck);
        getContentPane().add(generoLbl);        
        getContentPane().add(generoCombo);
        getContentPane().add(estadoLbl);
        getContentPane().add(estadoCombo);
        
        getContentPane().add(agregar);
        getContentPane().add(buscar);
        getContentPane().add(limpiar);
        getContentPane().add(imprimir);
        
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == limpiar){
            nombreTxt.setText("");
            aliasTxt.setText("");
            descripcionTxt.setText("");
            armasTxt.setText("");
            fechaAparicionTxt.setText("");
            fechaNacimientoTxt.setText("");
            aparicionCheck.setSelected(false);
            generoCombo.setSelectedIndex(0);
            estadoCombo.setSelectedIndex(0);
        }else if(e.getSource() == agregar) {
            Personaje p =  new Personaje(nombreTxt.getText(),aliasTxt.getText(),descripcionTxt.getText(),armasTxt.getText(),null
            ,null,aparicionCheck.isSelected(),null,null);
            String fechaA[]=fechaAparicionTxt.getText().split("/");
            
            Date fa=new Date(Integer.parseInt(fechaA[0])-1900,Integer.parseInt(fechaA[1]),Integer.parseInt(fechaA[2]));
            
            String fechaN[]=fechaNacimientoTxt.getText().split("/");
            
            Date fn=new Date(Integer.parseInt(fechaN[0])-1900,Integer.parseInt(fechaN[1]),Integer.parseInt(fechaN[2]));
            
            p.setFechaAparicion(fa);
            p.setFechaNacimiento(fn);
            String g=generoCombo.getSelectedItem().toString();
            p.setGenero(Genero.valueOf(g));
            String ec=estadoCombo.getSelectedItem().toString();
            p.setEstado(Estado.valueOf(ec));
           
            personajes.add(p);
            
        }else if(e.getSource() == buscar) {
            Personaje p= new  Personaje();
            p.setAlias(aliasTxt.getText());
            int i=personajes.indexOf(p);
            if (i!=-1){
                Personaje pe = personajes.get(i);
            nombreTxt.setText(pe.getNombre());
            descripcionTxt.setText(pe.getDescripcion());
            armasTxt.setText(pe.getArmas());
            Date tmp=pe.getFechaAparicion();
            fechaAparicionTxt.setText((tmp.getYear()+1900) + "/"+tmp.getMonth()+"/"+tmp.getDate());
            tmp=pe.getFechaNacimiento();
            fechaNacimientoTxt.setText((tmp.getYear()+1900)+"/"+tmp.getMonth()+"/"+tmp.getDate());
            aparicionCheck.setSelected(pe.getAparicion());
            if(pe.getGenero()==Genero.HOMBRE){
                generoCombo.setSelectedIndex(0);
            
            }else if(pe.getGenero()==Genero.MUJER){
                generoCombo.setSelectedIndex(1);
            
            
            }else if(pe.getGenero()==Genero.ANDROIDE){
                generoCombo.setSelectedIndex(2);
            }else if(pe.getGenero()==Genero.EXTRATERRESTRE){
                generoCombo.setSelectedIndex(3);}
            
            
            
            if(pe.getEstado()==Estado.ACTIVO){
                estadoCombo.setSelectedIndex(0);
            } 
             if(pe.getEstado()==Estado.DESAPARECIDO){
                estadoCombo.setSelectedIndex(1);
                }
              if(pe.getEstado()==Estado.MUERTO){
                estadoCombo.setSelectedIndex(2);
                }
            }
            
            
           
        }
            else if(e.getSource() == imprimir) {
                for(Personaje per: personajes){
                if (per.getEstado()==Estado.ACTIVO){
                 System.out.println(per.getAlias());
                }
                
                
                }
            }
    }
}
