/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablafinal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author r618b
 */
public class Modificar {
//     public static void update(long imei, String marca){
//    String url = "jdbc:sqlite:a.tabla.db";
//      String tabla=JOptionPane.showInputDialog(null,"Intoduce la tabla en la que quieras cambiar los datos");
//        Connection conn = null;
//        try{
//             conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
// //           long imei=Long.parseLong(JOptionPane.showInputDialog(null,"Introduce el imei para cambiar su marca"));
//            String Nmarca=JOptionPane.showInputDialog(null,"Introduzca el nombre del mejor jugador");
//            String sql = "UPDATE "+tabla+" SET imei= ? ,"
//            + "marca = ? , "
//            + "WHERE imei = ?";
//            
//try (Connection connect = conn;
////                PreparedStatement pstmt = connect.prepareStatement(sql)) {
//            // set the corresponding param
//            pstmt.setLong(1, imei);
//            pstmt.setString(2, Nmarca);
//            // update 
//            pstmt.executeUpdate();
//            System.out.println("Campo Modificado");
//     }   catch (SQLException ex) {
//    System.out.println(ex.getMessage());
//     }
//     }
////public static void update2(){
//    String url = "jdbc:sqlite:a.tabla.db";
//      String tabla=JOptionPane.showInputDialog(null,"Intoduce la tabla en la que quieras cambiar los datos");
//        Connection conn = null;
//        try{
//             conn = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//long imei=Long.parseLong(JOptionPane.showInputDialog(null,"Introduce el imei para cambiar su operadora"));
//String operadora=JOptionPane.showInputDialog(null,"Introduzca el nombre de la nueva operadora");
//            String sql = "UPDATE "+tabla+"companhias SET imei= ? ,"
//            + "operadora = ? "
//            + "WHERE imei = ?";        
//        try (Connection connect = conn;
//            PreparedStatement pstmt2 = connect.prepareStatement(sql)) {
//            // set the corresponding param
//            pstmt2.setLong(1, imei);
//            pstmt2.setString(2, operadora);
//            // update 
//            pstmt2.executeUpdate();
//        sql=sql+imei;
//        System.out.println("Campo Modificado");
//     }   catch (SQLException ex) {
//    System.out.println(ex.getMessage());
//     }
//
//}
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:a.tabla.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Update data of a tabla specified by the imei
     *
     * @param imei
     * @param operadora name de la compañía para cambiar
     */
    public void update(Long imei, String operadora) {
        String tabla=JOptionPane.showInputDialog(null,"Intoduce la tabla en la que quieras cambiar los datos");

        String sql = "UPDATE "+tabla+"companhias SET imei = ? , "   
                + "operadora = ? "
                + "WHERE imei = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setLong(1, imei);
            pstmt.setString(2, operadora);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
   
    
}
