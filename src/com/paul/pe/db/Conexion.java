
package com.paul.pe.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
        private static Connection con = null;
        private static String usuario = "USUARIO_MATRICULA"; 
        private static String clave = "1234560"; 
        private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
        
        public static Connection getConnection(){
            try {
                //Cargar el controlador JDBC
                Class.forName("oracle.jdbc.OracleDriver");
                //Establecer la coneccion con la base de datos
                con = DriverManager.getConnection(url,usuario,clave);
                con.setAutoCommit(false);
                System.out.println("========================");
                System.out.println(" ´PAUL ANDRES :) ");
                System.out.println("========================");
                if(con != null){
                    System.out.println("Conexion Exitosa :)");
                }else{
                    System.out.println("Error: Conexion Fallida");
                }
            } catch(Exception e){
                System.out.println("Error_>: "+e.getMessage());
            }
            return con;
        };
        
        public void closeConnection(){
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la connecion "+e.getMessage());
            }
        }
        

    public static void main(String[] args) {
   //      Conexion con = new Conexion();
        Conexion.getConnection();
    }
          
}