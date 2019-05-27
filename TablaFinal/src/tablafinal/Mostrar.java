/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablafinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author r618b
 */
public class Mostrar {
//    public static ArrayList<Object[]> selectT1(String tabla){
//        ArrayList <Object[]>MM=new ArrayList<>();
//
//        Connection conne = null;
//        try {
//            conne = DriverManager.getConnection("jdbc:sqlite:a.tabla.db");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        String sql = "SELECT imei,marca FROM"+tabla;
//
//        
//        try (Connection conn=conne;
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)){
//            
//            // loop through the result set
//            while (rs.next()) {
//                Object[] base=new Object[2];
//                base[0]=rs.getLong("imei");
//                base[1]=rs.getString("marca");
//                MM.add(base);
//                
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        finally{
//            try {
//                conne.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(Mostrar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return MM;
//    }
//    public static ArrayList<Object[]> selectT2(String nombre){
//                ArrayList <Object[]>MC=new ArrayList<>();
//        
//        String url = "jdbc:sqlite:a.tabla.db";
//        Connection conne = null;
//        try {
//            conne = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        String sql = "SELECT ano,mvp,usado FROM "+nombre+"companhias";
//
//        
//        try (Connection conn=conne;
//             Statement stmt  = conn.createStatement();
//             ResultSet rs    = stmt.executeQuery(sql)){
//            
//            // loop through the result set
//            while (rs.next()) {
//                Object[] base=new Object[2];
//                base[0]=rs.getLong("imei");
//                base[1]=rs.getString("operadora");
//                MC.add(base);
//                
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        finally{
//            try {
//                conne.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(Mostrar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return MC;
//    }
//    public static DefaultTableModel blanco(){
//        MenuPrincipal obx=new MenuPrincipal();
//        DefaultTableModel blancos=(DefaultTableModel) obx.tablaMarca.getModel();
//        blancos.setRowCount(0);
//        return blancos;
//    }
//    public static DefaultTableModel blanco2(){
//        MenuPrincipal obx=new MenuPrincipal();
//        DefaultTableModel blancos=(DefaultTableModel) obx.tablaComp.getModel();
//        blancos.setRowCount(0);
//        return blancos;
//    }
    
    public static Connection getConnection(){
        Connection cn=null;
        try {
            cn=DriverManager.getConnection("jdbc:sqlite:a.tabla.db");
        } catch (Exception e) {
            System.out.println(String.valueOf(e));
        }
        return cn;
    }
    public static ResultSet getTabla(String consulta) throws SQLException {
        Connection cn=getConnection();
        Statement st;
        ResultSet datos=null;
        try{
            st=cn.createStatement();
            datos=st.executeQuery(consulta);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    return datos;
    }
    
    
}
