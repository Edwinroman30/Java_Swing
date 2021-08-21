package com.itla.db;

public class Nota {
    private int id;
    private String nombre;
    private String matricula;
    private int nota;

    public Nota() {
    }

    public Nota(int id, String nombre, String matricula, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.nota = nota;
    }

    public Nota(String nombre, String matricula, int nota) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.nota = nota;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
}
