package com.emergentes.dao;

import com.emergentes.modelo.Evento;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventoDAOimpl extends ConexionBD implements EventoDAO{

    @Override
    public void insert(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "Insert into seminarios(titulo,expositor,fecha,hora,cupo)values(?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, evento.getTitulo());
            ps.setString(2, evento.getExpositor());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            ps.setInt(5, evento.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Evento evento) throws Exception {
        try {
            this.conectar();
            String sql = "update seminarios set titulo=?, expositor=?, fecha=?, hora=? ,cupo=? where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, evento.getTitulo());
            ps.setString(2, evento.getExpositor());
            ps.setString(3, evento.getFecha());
            ps.setString(4, evento.getHora());
            ps.setInt(5, evento.getCupo());
            ps.setInt(6, evento.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "delete from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
             this.desconectar();
         }
    }

    @Override
    public Evento getById(int id) throws Exception {
        Evento ev = new Evento();
        try {
            this.conectar();
            String sql = "select * from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ev.setId(rs.getInt("id"));
                ev.setTitulo(rs.getString("titulo"));
                ev.setExpositor(rs.getString("expositor"));
                ev.setFecha(rs.getString("fecha"));
                ev.setHora(rs.getString("hora"));
                ev.setCupo(rs.getInt("cupo"));
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return ev;
    }

    @Override
    public List<Evento> getAll() throws Exception {
        List<Evento>lista = null;
        try {
            this.conectar();
            String sql = "select * from seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Evento>();
            while(rs.next()){
                Evento ev = new Evento();
                ev.setId(rs.getInt("id"));
                ev.setTitulo(rs.getString("titulo"));
                ev.setExpositor(rs.getString("expositor"));
                ev.setFecha(rs.getString("fecha"));
                ev.setHora(rs.getString("hora"));
                ev.setCupo(rs.getInt("cupo"));
                lista.add(ev);
            }
        } catch (Exception e) { 
            throw e;
        } finally{
            this.desconectar();
        }
        return lista;
    }
    
}
