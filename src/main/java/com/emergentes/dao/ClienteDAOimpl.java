
package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends ConexionDB implements ClienteDAO {

    @Override
    public void insert(Cliente cliente) throws Exception {
        String sql = "insert into participantes (apellidos,nombres,id_seminario,confirmado) values (?,?,?.?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombres());
        ps.setString(2, cliente.getApellidos());
        ps.setInt(3, cliente.getId_seminario());
        ps.setInt(4, cliente.getConfirmado());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Cliente cliente) throws Exception {
        String sql = "update participantes set nombres=?,apellidos=?,id_seminario=?,confirmado=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, cliente.getNombres());
        ps.setString(2, cliente.getApellidos());
        ps.setInt(3, cliente.getId_seminario());
        ps.setInt(4, cliente.getConfirmado());
        ps.setInt(5, cliente.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from participantes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente cli = new Cliente();
        String sql = "select * from participantes where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            cli.setId(rs.getInt("id"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setId_seminario(rs.getInt("id_Seminario"));
            cli.setConfirmado(rs.getInt("confirmado"));
        }
        this.desconectar();
        return cli;
    }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        String sql = "select * from clientes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Cliente>();
        while (rs.next()) {            
            Cliente cli = new Cliente();
            cli.setId(rs.getInt("id"));
            cli.setNombres(rs.getString("nombres"));
            cli.setApellidos(rs.getString("apellidos"));
            cli.setId_seminario(rs.getInt("id_seminario"));
            cli.setConfirmado(rs.getInt("confirmado"));
            lista.add(cli);
        }
        this.desconectar();
        return lista;
    }
    
}
