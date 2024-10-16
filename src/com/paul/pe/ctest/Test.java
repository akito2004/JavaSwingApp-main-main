
package com.paul.pe.ctest;

import com.paul.pe.cnegocio.TipoDocumentoBO;
import com.paul.pe.cmodelo.TipoDocumento;
import java.sql.SQLException;
import java.text.ParseException;


public class Test {
    TipoDocumentoBO tdbo = new TipoDocumentoBO();
    TipoDocumento td = new TipoDocumento();
    
    public void insertar()  throws SQLException, ParseException{
        td.setNombre("Registro Nacional de Identidad");
        td.setEstado("1");
        td.setOrden(1);
        td.setSigla("DNI");
        td.setFechaActualiza("09-10-24");
        tdbo.agregarTipoDocomento(td);
    }
    
    public static void main(String[] args) throws SQLException, ParseException{
        Test t = new Test();
        t.insertar();
    }
}
jhijhbkhkh 