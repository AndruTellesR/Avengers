/**
 * Write a description of class Personaje here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Personaje
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String alias;
    private String descripcion;
    private String armas;
    private Date fechaAparicion;
    private Date fechaNacimiento;
    private Boolean aparicion;
    private Genero genero;
    private Estado estado;

    /**
     * Constructor for objects of class Personaje
     */
    public Personaje()
    {

    }

    public Personaje(String nombre,String alias,String descripcion,String armas,Date fechaAparicion,Date fechaNacimiento,Boolean aparicion,Genero genero,Estado estado){
        this.nombre=nombre;
        this.alias=alias;
        this.descripcion=descripcion;
        this.armas=armas;
        this.fechaAparicion=fechaAparicion;
        this.fechaNacimiento=fechaNacimiento;
        this.aparicion=aparicion;
        this.genero=genero;
        this.estado=estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArmas() {
        return armas;
    }

    public void setArmas(String armas) {
        this.armas = armas;
    }

    public Date getFechaAparicion() {
        return fechaAparicion;
    }

    public void setFechaAparicion(Date fechaAparicion) {
        this.fechaAparicion = fechaAparicion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getAparicion() {
        return aparicion;
    }

    public void setAparicion(Boolean aparicion) {
        this.aparicion = aparicion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
 @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personaje other = (Personaje) obj;
        if (!Objects.equals(this.alias, other.alias)) {
            return false;
        }
        return true;
    }
    
}
