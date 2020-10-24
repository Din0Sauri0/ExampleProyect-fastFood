package com.ovalle.exampleproyect;

public class Usuario {
    public String Nombre;
    public String Apellido;
    public String Email;
    public String Password;
    public String Genero;
    public String Telefono;

    public Usuario(String nombre, String apellido, String email, String password, String genero, String telefono) {
        Nombre = nombre;
        Apellido = apellido;
        Email = email;
        Password = password;
        Genero = genero;
        Telefono = telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
