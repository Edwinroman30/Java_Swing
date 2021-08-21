package com.itla.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyDataBaseManager {

    private String url = "jdbc:mysql://localhost/itla";
    private String username = "root";
    private String password = "";
    private Connection con;
    private Statement stmnt;
    private ResultSet rs;
    
    public void conectar() {
        try {
            con = DriverManager.getConnection(url, username, password);
            stmnt = con.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void desconectar() {
        try {

            if (con != null) {
                con.close();
            }

            System.out.println("Desconectado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarNota(Nota nota) {
        conectar();

        String sql = "INSERT INTO notas(NOMBRE, MATRICULA, NOTA) "
                + "VALUES('" + nota.getNombre() + "', "
                + "'" + nota.getMatricula() + "', "
                + nota.getNota() + ")";

        try {
            stmnt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        desconectar();

    }

    public Nota buscarNotaPorId(int id) {
        conectar();

        Nota nota = null;

        String sql = "SELECT ID, NOMBRE, MATRICULA, NOTA "
                + "FROM notas WHERE id = " + id;

        try {
            rs = stmnt.executeQuery(sql);
            
            if(rs.next()) {
                nota = new Nota(
                    rs.getInt("ID"),
                    rs.getString("NOMBRE"),
                    rs.getString("MATRICULA"),
                    rs.getInt("NOTA")
                );
            } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        desconectar();
        
        return nota;
    }
    
    public List<Nota> obtenerNotas() {
        List<Nota> notas = new ArrayList<>();
        
        conectar(); 
        
        String sql = "SELECT ID, NOMBRE, MATRICULA, NOTA FROM notas";
        
         try {
            rs = stmnt.executeQuery(sql);
            
            while(rs.next()) {
                   notas.add(new Nota(
                    rs.getInt("ID"),
                    rs.getString("NOMBRE"),
                    rs.getString("MATRICULA"),
                    rs.getInt("NOTA"))
                );
            } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        desconectar();
        
        return notas;
    }
    
    public static void main(String[] args) {
        MyDataBaseManager db = new MyDataBaseManager();

        Nota miNota = new Nota(
                "Luis",
                "2020-56788",
                98
        );

//        db.insertarNota(miNota);
       
        List<Nota> notas = db.obtenerNotas();
        
        for(Nota n : notas) {
            System.out.println(n.getNombre());
        }
    }

}
