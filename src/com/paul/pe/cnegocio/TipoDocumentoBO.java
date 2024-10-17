
package com.paul.pe.cnegocio;

import com.paul.pe.cdatosDao.TipoDocumentosDao;
import java.sql.Connection;
import com.paul.pe.db.Conexion;
import java.sql.SQLException;
import javax.swing.JTable;
import com.paul.pe.cmodelo.TipoDocumento;
import java.util.ArrayList;


public class TipoDocumentoBO {
    private String mensaje;
    TipoDocumentosDao tdd = new TipoDocumentosDao();
    
    public String agregarTipoDocomento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.agregarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public String eliminarTipoDocomento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.elimiarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public String modificarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.modificarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
    public void listarTipoDocumento(JTable table){
        Connection c = Conexion.getConnection();
        tdd.listarTipoDocumento(c, table);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }

    
        public ArrayList<TipoDocumento>listarTipoDocumentosCombo(){
         ArrayList<TipoDocumento> listaTipoDocumento = new ArrayList<>();
      Connection c = Conexion.getConnection();
        listaTipoDocumento = tdd.listarTipoDocumentoCombo(c);
        try {
        } catch (Exception e) {
            System.out.println("error; "+e.getMessage());
        }
        return  listaTipoDocumento;
    }  
    
}
