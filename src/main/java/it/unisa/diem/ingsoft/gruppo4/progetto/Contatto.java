package it.unisa.diem.ingsoft.gruppoIV;

import java.util.List;

/**
 * La classe Contatto rappresenta un contatto con informazioni 
 * personali come nome, cognome, numeri di telefono ed email.
 */
public class Contatto {

    private String Nome;
    private String Cognome;
    private List<String> numTel;
    private List<String> email;

    /**
     * Restituisce il nome del contatto.
     * 
     * @return il nome del contatto.
     */
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Restituisce il cognome del contatto.
     * 
     * @return il cognome del contatto.
     */
    public String getCognome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Restituisce la lista dei numeri di telefono del contatto.
     * 
     * @return la lista dei numeri di telefono.
     */
    public List<String> getNumTel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Restituisce la lista delle email del contatto.
     * 
     * @return la lista delle email.
     */
    public List<String> getEmail() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Imposta il nome del contatto.
     * 
     * @param nome il nome del contatto.
     */
    public void setNome(String nome) {
        this.Nome = nome;
    }

    /**
     * Imposta il cognome del contatto.
     * 
     * @param cognome il cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.Cognome = cognome;
    }

    /**
     * Imposta la lista dei numeri di telefono del contatto.
     * 
     * @param numTel la lista dei numeri di telefono.
     */
    public void setNumTel(List<String> numTel) {
        this.numTel = numTel;
    }

    /**
     * Imposta la lista delle email del contatto.
     * 
     * @param email la lista delle email.
     */
    public void setEmail(List<String> email) {
        this.email = email;
    }

    /**
     * Restituisce una rappresentazione del contatto come stringa.
     * 
     * @return una stringa che rappresenta il contatto.
     */
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
