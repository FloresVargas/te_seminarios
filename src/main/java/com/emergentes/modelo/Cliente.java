
package com.emergentes.modelo;

public class Cliente {
    private int id;
    private String nombres;
    private String apellidos;
    private int id_seminario;
    private int confirmado;
   

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(int id_seminario) {
        this.id_seminario = id_seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }



    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", id_seminario=" + id_seminario + ", confirmado=" + confirmado + '}';
    }


    


    
    
}
