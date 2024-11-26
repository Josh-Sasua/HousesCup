package org.generation.italy.ravenclaw.HousesCup.models.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Access(AccessType.FIELD)
@Table(name="studenti")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cognome;
    private String sesso;
    private LocalDate data;
    private String email;
    private String telefono;
    private String titolo;
    private String background;
    private String casata;
    public Student(){};
    public Student(long id, String nome, String cognome, String sesso, LocalDate data, String email, String telefono, String titolo_di_studio, String background, String casata) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.data = data;
        this.email = email;
        this.telefono = telefono;
        this.titolo = titolo_di_studio;
        this.background = background;
        this.casata = casata;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCasata() {
        return casata;
    }

    public void setCasata(String casata) {
        this.casata = casata;
    }
}
