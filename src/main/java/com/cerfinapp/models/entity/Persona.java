package com.cerfinapp.models.entity;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "personas") //Los nombres de las tablas en la DB deben ir en minusculas y en plural
//@Inheritance(strategy = InheritanceType.JOINED) //Especifico el tipo de herencia
public class Persona implements Serializable { //Es buena práctica implementar Serializable para guardarlo dentro de los atributos de la sesion
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Debo tener un ID para la DB
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String cedula;
    private String genero;
    @Column(name = "dia_nacimiento")
    private int diaNacimiento;
    @Column(name = "mes_nacimiento")
    private int mesNacimiento;
    @Column(name = "anio_nacimiento")
    private int anioNacimiento;
    @Column(unique = true) //Revisar porque esto no puso en el video
    private String correo;
    @Column(name = "user_password")
    private String userPassword;

    public enum tipoDePersona {

        PACIENTE_PRIORITARIO,
        PACIENTE_NORMAL,
        TERAPEUTA

    }

    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDiaNacimiento() {
        return diaNacimiento;
    }

    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public int getMesNacimiento() {
        return mesNacimiento;
    }

    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     Identificador de la implementacion de la clase Serializable
     */
    @Serial
    private static final long serialVersionUID = 1L;



    //Realizar el cálculo de la edad de persona
    public void calcularEdad() {

    }
}
