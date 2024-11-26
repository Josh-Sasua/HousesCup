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
    @Column(name = "data")
    private LocalDate data_di_nascita;
    private String email;
    private String telefono;
    @Column(name = "titolo")
    private String titolo_di_studio;
    private String background;
    private String casata;
    public Student(){};
    public Student(long id, String nome, String cognome, String sesso, LocalDate data_di_nascita, String email, String telefono, String titolo_di_studio, String background, String casata) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
        this.data_di_nascita = data_di_nascita;
        this.email = email;
        this.telefono = telefono;
        this.titolo_di_studio = titolo_di_studio;
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

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
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

    public String getTitolo_di_studio() {
        return titolo_di_studio;
    }

    public void setTitolo_di_studio(String titolo_di_studio) {
        this.titolo_di_studio = titolo_di_studio;
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
