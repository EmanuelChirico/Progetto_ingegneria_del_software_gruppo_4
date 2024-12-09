package it.unisa.diem.ingsoft.gruppo4.Rubrica;

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
 * @author Gruppo 4
 */
public class Contatto {

    private String Nome;
    private String Cognome;
    private List<String> numTel;
    private List<String> email;

    Contatto(String nome, String cognome, String numero, String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @brief Il metodo getNome() restituisce il nome del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return Il nome del contatto.
     */
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Il metodo getCognome() restituisce il cognome del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return Il cognome del contatto.
     */
    public String getCognome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Il metodo getNumTel() restituisce la lista dei numeri di telefono del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return La lista dei numeri di telefono.
     */
    public List<String> getNumTel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Il metodo getEmail() restituisce la lista delle email del contatto.
     * 
     * @post Restituisce il valore corrente dell'attributo associato.
     * @invariant Lo stato dell'oggetto non deve essere modificato.
     * 
     * @return La lista delle email.
     */
    public List<String> getEmail() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Il metodo setNome() imposta il nome del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] nome il nome del contatto.
     */
    public void setNome(String nome) {
        this.Nome = nome;
    }

    /**
     * @brief Il metodo setCognome() imposta il cognome del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] cognome Il cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.Cognome = cognome;
    }

    /**
     * @brief Il metodo setNumTel() imposta la lista dei numeri di telefono del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] numTel La lista dei numeri di telefono.
     */
    public void setNumTel(List<String> numTel) {
        this.numTel = numTel;
    }

    /**
     * @brief Il metodo setEmail() imposta la lista delle email del contatto.
     * 
     * @pre Il valore passato come parametro è valido.
     * @post L'attributo deve essere aggiornato con il parametro passato.
     * 
     * @param[in] email La lista delle email.
     */
    public void setEmail(List<String> email) {
        this.email = email;
    }

    /**
     * @brief Il metodo toString() restituisce una rappresentazione del contatto come stringa.
     * 
     * @return Una stringa che rappresenta il contatto.
     */
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
