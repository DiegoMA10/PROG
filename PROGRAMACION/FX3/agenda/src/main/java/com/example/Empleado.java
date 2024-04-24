package com.example;

import java.sql.Date;

public class Empleado {
    private String idEmpleado;
    private String nombre;
    private String apellidos;
    private String telefono;
    private Date fechaNacimiento;
    private String cargo;

    public Empleado(String idEmpleado, String nombre, String apellidos, String telefono, Date fechaNacimiento,
            String cargo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public void actualizarEmpleado(String nombre, String apellidos, String telefono, Date fechaNacimiento,String cargo){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.cargo = cargo;
    }

}
