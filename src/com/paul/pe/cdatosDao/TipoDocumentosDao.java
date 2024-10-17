package com.paul.pe.cdatosDao;

import com.paul.pe.cmodelo.TipoDocumento;
import com.paul.pe.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoDocumentosDao {
    private String mensaje;
    
    //Primer metodo - INSERTAR TIPO DOCUMENTOS A LA DB
    public String agregarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "INSERT INTO TIPO_DOCUMENTO(NOMBRE,SIGLA,ESTADO,ORDEN,FECHA_ACTUALIZACION)"
                + "VALUES(?,?,?,?,?)";
        try {
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
            ps.setString(5, tipoDocumento.getFechaActualiza());
            //ps.setString(6, tipoDocumento.getFecha());
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue creado corectamente";
        } catch (Exception e) {
            mensaje = "Alto! error al crear tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
    //Segundo Metodo Eliminar
    public String elimiarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "DELETE FROM TIPO_DOCUMENTO WHERE ID_TIPO_DOCUMENTO = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, tipoDocumento.getIdTipoDocumento());
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue eliminado corectamente";
        } catch (Exception e) {
            mensaje = "Alto! error al eliminar tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
    //Tercero Metodo - Modificar Tipo documento.
    public String modificarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "UPDATE TIPO_DOCUMENTO "
                + " SET NOMBRE=?, SIGLA=?, ESTADO=?, ORDEN=?, FECHA_ACTUALIZA=?"
                + " WHERE ID_TIPO_DOCUMENTO=?";
        try {
            
            ps.setInt(7, tipoDocumento.getIdTipoDocumento());
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSigla());
            ps.setString(3, tipoDocumento.getEstado());
            ps.setInt(4, tipoDocumento.getOrden());
            //ps.setString(5, tipoDocumento.getFecha());
            ps.setString(6, tipoDocumento.getFechaActualiza());            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue actualizado corectamente";
        } catch (Exception e) {
            mensaje = "Alto! error al actualizar tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
            
        }
        return mensaje;
    }
    
    //Cuarto Metodo - Listar Tipo Documento.
    public void listarTipoDocumento(Connection conn, JTable table){
        System.out.println("aquiiii");
        DefaultTableModel model;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String[] columnas = {"ID_TIPO_DOCUMENTO","NOMBRE","SIGLA","ESTADO","ORDEN","FECHA_ACTUALIZACION"};
        model = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT * FROM TIPO_DOCUMENTO";
        String[] datosTP = new String[6];
        System.out.println("1");
        try {
            System.out.println("2");
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                
                System.out.println("5");
                TipoDocumento td = new TipoDocumento();
                td.setIdTipoDocumento(resultSet.getInt("ID_TIPO_DOCUMENTO"));
                td.setNombre(resultSet.getString("NOMBRE"));
                td.setSigla(resultSet.getString("SIGLA"));
                td.setEstado(resultSet.getString("ESTADO"));
                td.setOrden(resultSet.getInt("ORDEN"));
                //td.setFecharesultSet.getString("FECHA_REGISTRO"));
                td.setFechaActualiza(resultSet.getString("FECHA_ACTUALIZACION"));
                System.out.println("7");
                datosTP[0] = td.getIdTipoDocumento()+"";
                datosTP[1] = td.getNombre()+"";
                datosTP[2] = td.getSigla()+"";
                datosTP[3] = td.getEstado()+"";
                datosTP[4] = td.getOrden()+"";
                datosTP[5] = td.getFechaActualiza()+"";
                model.addRow(datosTP);
                System.out.println("6");
            }
            System.out.println("3");
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
    
    
    }
    
    public ArrayList<TipoDocumento>listarTipoDocumentoCombo(Connection conn){
        ArrayList<TipoDocumento>listaTipoDocumento = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        
        String sql = "SELECT ID_TIPO_DOCUMENTO, NOMBRE FROM TIPO_DOCUMENTO "
                + "order by orden";
    
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
                TipoDocumento td = new TipoDocumento();
                td.setIdTipoDocumento(resultSet.getInt("ID_TIPO_DOCUMENTO"));
                td.setNombre(resultSet.getString("NOMBRE"));
               
                listaTipoDocumento.add(td);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,  "error: "+e.getMessage());
            System.out.println(e.getMessage());

        }
        return listaTipoDocumento;

    }
}