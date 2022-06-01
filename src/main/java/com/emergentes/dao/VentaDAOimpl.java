
package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimpl extends ConexionDB implements VentaDAO {

    @Override
    public void insert(Venta venta) throws Exception {
        String sql = "insert into seminarios (titulo,fecha,cupo) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, venta.getTitulo());
        ps.setDate(2, venta.getFecha());
        ps.setInt(3, venta.getCupo());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Venta venta) throws Exception {
        String sql = "update seminarios set titulo=?,fecha=?,cupo=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, venta.getTitulo());
        ps.setDate(2, venta.getFecha());
        ps.setInt(3, venta.getCupo());
        ps.setInt(4, venta.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from seminarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public Venta getById(int id) throws Exception {
        Venta ven = new Venta();
        String sql = "select * from seminarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            ven.setId(rs.getInt("id"));
            ven.setTitulo(rs.getString("titulo"));
            
            ven.setFecha(rs.getDate("fecha"));
            ven.setCupo(rs.getInt("cupo"));
        }
        this.desconectar();
        return ven;
    }

    @Override
    public List<Venta> getAll() throws Exception {
        List<Venta> list = null;
        String sql = "SELECT v.*,p.nombre as producto,c.nombre as cliente from ventas v ";
        sql += "left join productos p on v.producto_id = p.id ";
        sql += "left join clientes c on v.cliente_id = c.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Venta>();
        while (rs.next()) {            
            Venta ven = new Venta();
            ven.setId(rs.getInt("id"));
            ven.setTitulo(rs.getString("titulo")); 
            ven.setFecha(rs.getDate("fecha"));
            ven.setCupo(rs.getInt("cupo"));
            
            list.add(ven);
        }
        this.desconectar();
        return list;
    }
    
}
