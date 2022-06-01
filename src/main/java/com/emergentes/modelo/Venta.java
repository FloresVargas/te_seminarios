
package com.emergentes.modelo;

import java.sql.Date;

public class Venta {
    private int id;
    private String titulo;
    private Date fecha;
    private int cupo;
    
    public Venta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", cupo=" + cupo + '}';
    }

   
    
}
