/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablafinal;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author r618b
 */
public class Borrar {
    
     /**
     * Conectar a la base de datos y pedimos introducri la tabla para hacer
     * modificaciones en ella
     *@param url ubicacioin de base de datos
     */
    public static void eliminar(){
    String url = "jdbc:sqlite:a.tabla.db";
      String tabla=JOptionPane.showInputDialog(null,"Intoduce la tabla en la que quieras introducir los datos");
        Connection conn = null;
        try{
            conn=DriverManager.getConnection(url);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        /**
     *introducimos el imei qpara saber que fila borrar
     * @param imei clave primaria para saber que linea borrar
     */
        long imei=Long.parseLong(JOptionPane.showInputDialog(null,"Introduce el IMEI para borrar esa fila"));
        String sql="DELETE FROM "+tabla+" WHERE imei= ?";
        String sql2="DELETE FROM "+tabla+"companhias WHERE imei= ?";
        try (Connection connect = conn;
                PreparedStatement pstmt=connect.prepareStatement(sql)){
                pstmt.setLong(1, imei);
                pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"1 Fila borrada");
            System.out.println("1 fila borrada en " + tabla);
            try (Connection connect2 = conn;
                PreparedStatement pstmt2=connect2.prepareStatement(sql2)){
                pstmt2.setLong(1, imei);
                pstmt2.executeUpdate();
            JOptionPane.showMessageDialog(null,"1 Fila borrada"); 
                System.out.println("1 fila borrada en "+tabla + "_compañias");
            connect2.close();
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                
}
}

