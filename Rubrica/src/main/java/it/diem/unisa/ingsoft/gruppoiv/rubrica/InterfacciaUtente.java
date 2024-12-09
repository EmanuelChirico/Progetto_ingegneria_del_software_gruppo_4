package it.diem.unisa.ingsoft.gruppoiv.rubrica;

/**
 * @file InterfacciaUtente.java
 * @brief La classe InterfacciaUtente gestisce un'interfaccia grafica per interagire con l'utente.
 * 
 * Questa classe include le seguenti funzionalità:
 * - visualizzazione della rubrica
 * - ricerca di contatti
 * - interazione con l'utente tramite bottoni
 * 
 * @author Gruppo IV
 */
public class InterfacciaUtente {

    private Rubrica rubrica; 
    private GestioneFile gestioneFile; 

    /**
     * @brief Il metodo start() avvia l'interazione con l'utente tramite l'interfaccia grafica.
     * 
     * @post L'utente può visualizzare la rubrica
     */
    public void start() {
    }

    /**
     * @brief Il metodo main() è il metodo per avviare il thread di esecuzione principale.
     *  
     * @post I metodi start e init vengono chiamati.
     *  
     */
    public static void main(String[] args) {
    }

    /**
     * @brief Il metodo visualizzaRubrica() mostra tutti i contatti presenti nella rubrica.
     * 
     * @post Non modifica lo stato della rubrica.
     */
    public void visualizzaRubrica() {
    }

    /**
     * @brief Il metodo visualizzaRicerca() mostra i risultati di una ricerca nella rubrica.
     * 
     * @post Non modifica lo stato della rubrica.
     */
    public void visualizzaRicerca() {
    }

    /**
     * @brief Il metodo init() inizializza la rubrica tendendo conto dell'ultimo salvataggio effettuato.
     * 
     * @pre Le interfacce grafiche devono essere correttamente configurate.
     * @post L'interfaccia grafica viene visualizzata dall'utente.
     */
    public void init() {
    }

    /**
     * @brief Il metodo stop() effettua il salvataggio dello stato corrente della rubrica ed arresta l'interfaccia grafica.
     * 
     * @pre L'applicazione deve essere in esecuzione.
     * @post Tutte le risorse vengono rilasciate e l'applicazione termina.
     */
    public void stop() {
        // Logica per arrestare l'interfaccia
    }
}