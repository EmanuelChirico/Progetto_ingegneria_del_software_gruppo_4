package it.diem.unisa.ingsoft.gruppoiv.rubrica;

import java.util.List;

/**
 * @file Contatto.java
 * @brief La classe Contatto rappresenta un contatto con informazioni personali.
 * 
 * Questa classe include le seguenti informazioni:
 * -nome
 * -cognome
 * -numeri di telefono 
 * -email
 * 
 * @author Gruppo IV 
 */
public class Contatto {

    private String Nome;
    private String Cognome;
    private List<String> numTel;
    private List<String> email;

    /**
     * @brief Il metodo getNome() restituisce il nome del contatto.
     * 
     * @post restituisce il valore corrente dell'attributo associato.
     * @invariant lo stato dell'oggetto non deve essere modificato.
     * 
     * @return il nome del contatto.
     */
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief il metodo getCognome() restituisce il cognome del contatto.
     * 
     * @post restituisce il valore corrente dell'attributo associato.
     * @invariant lo stato dell'oggetto non deve essere modificato.
     * 
     * @return il cognome del contatto.
     */
    public String getCognome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief il metodo getNumTel() restituisce la lista dei numeri di telefono del contatto.
     * 
     * @post restituisce il valore corrente dell'attributo associato.
     * @invariant lo stato dell'oggetto non deve essere modificato.
     * 
     * @return la lista dei numeri di telefono.
     */
    public List<String> getNumTel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief il metodo getEmail() restituisce la lista delle email del contatto.
     * 
     * @post restituisce il valore corrente dell'attributo associato.
     * @invariant lo stato dell'oggetto non deve essere modificato.
     * 
     * @return la lista delle email.
     */
    public List<String> getEmail() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief il metodo setNome() imposta il nome del contatto.
     * 
     * @pre il valore passato come parametro è valido.
     * @post l'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] nome il nome del contatto.
     */
    public void setNome(String nome) {
        this.Nome = nome;
    }

    /**
     * @brief il metodo setCognome() imposta il cognome del contatto.
     * 
     * @pre il valore passato come parametro è valido.
     * @post l'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] cognome il cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.Cognome = cognome;
    }

    /**
     * @brief il metodo setNumTel() imposta la lista dei numeri di telefono del contatto.
     * 
     * @pre il valore passato come parametro è valido.
     * @post l'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] numTel la lista dei numeri di telefono.
     */
    public void setNumTel(List<String> numTel) {
        this.numTel = numTel;
    }

    /**
     * @brief il metodo setEmail() imposta la lista delle email del contatto.
     * 
     * @pre il valore passato come parametro è valido.
     * @post l'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] email la lista delle email.
     */
    public void setEmail(List<String> email) {
        this.email = email;
    }

    /**
     * @brief il metodo toString() restituisce una rappresentazione del contatto come stringa.
     * 
     * @return una stringa che rappresenta il contatto.
     */
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
