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
public class insertar {

    /**
     * Conectar a la base de datos y pedimos introducri la tabla para hacer
     * modificaciones en ella
     *  @param url ubicacioin de base de datos
     */
    public static void insercion() {
        String url = "jdbc:sqlite:a.tabla.db";
        String tabla = JOptionPane.showInputDialog(null, "Intoduce la tabla en la que quieras introducir los datos");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /**
         * introducir las variables para introducirlas en la tabla Generar los
         * inserts para ambas tablas con sus valores
         */
        long imei = Long.parseLong(JOptionPane.showInputDialog(null, "Introdice el imei del dispositivo"));
        String marca = JOptionPane.showInputDialog(null, "Introduce la marca del dispositivo");
        String operadora = JOptionPane.showInputDialog(null, "Operadora destino");
        String sql = "INSERT INTO " + tabla + "(imei, marca) VALUES(?,?)";
        String sql2 = "INSERT INTO " + tabla + "companhias(imei, operadora) VALUES(?,?)";
/**
 * @param imei imei del telefono
 * @param marca marca del telefono
 */
        try (Connection connect = conn;
                PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setLong(1, imei);
            pstmt.setString(2, marca);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Insertados datos para los moviles");
            System.out.println("1 Fila insertada en " + tabla);
          
           /**
 * @param imei imei del telefono
 * @param operadora operaora destino del telefono
 */
            try (Connection connect2 = conn;
                    PreparedStatement pstmt2 = connect2.prepareStatement(sql2)) {
                pstmt2.setLong(1, imei);
                pstmt2.setString(2, operadora);
                pstmt2.execute();
                JOptionPane.showMessageDialog(null, "Insertados datos de la compañía telefónica");
                System.out.println("1 Fila insertada en " + tabla + "_compañías");
                            


            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Fallo al introducir, puede ser por el IMEI, revisalo y vuelve a introducirlo");
                System.out.println("no se han insertado filas");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Fallo al introducir, puede ser por el IMEI, revisalo y vuelve a introduucirlo");
            System.out.println("no se han insertado filas");
        }

    }
}
