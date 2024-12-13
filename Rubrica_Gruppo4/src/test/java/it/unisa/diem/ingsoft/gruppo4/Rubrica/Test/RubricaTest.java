package it.unisa.diem.ingsoft.gruppo4.Rubrica.Test;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.Contatto;
import it.unisa.diem.ingsoft.gruppo4.Rubrica.Rubrica;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RubricaTest {

    private Rubrica rubrica;

    @BeforeEach
    public void setUp() {
        rubrica = new Rubrica();
    }

    @AfterEach
    public void tearDown() {
        rubrica = null;
    }

    @Test
    public void testAggiungiContatto() {
        
        Contatto contatto = new Contatto();
        contatto.setNome("Mario");
        contatto.setCognome("Rossi");
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        ArrayList<String> email = new ArrayList<>();
        email.add("mariorossi123@example.com");
        boolean result = rubrica.aggiungiContatto(contatto);
        assertTrue(result, "Il contatto dovrebbe essere aggiunto correttamente.");
        assertEquals(1, rubrica.getContatti().size(), "La rubrica dovrebbe contenere un contatto.");
    }
    @Test
    public void testRimuoviContatto() {
        Contatto contatto = new Contatto();
        contatto.setNome("Mario");
        contatto.setCognome("Rossi");
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        ArrayList<String> email = new ArrayList<>();
        email.add("mariorossi123@example.com");
        rubrica.aggiungiContatto(contatto);
        rubrica.rimuoviContatto(contatto);
        assertEquals(0, rubrica.getContatti().size(), "La rubrica dovrebbe essere vuota dopo la rimozione.");
    }

    @Test
    public void testModificaContatto() {
        Contatto contatto1 = new Contatto();
        contatto1.setNome("Mario");
        contatto1.setCognome("Rossi");
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        ArrayList<String> email = new ArrayList<>();
        email.add("mariorossi123@example.com");
        Contatto contatto2 = new Contatto();
        contatto2.setNome("Luigi");
        contatto2.setCognome("Bianchi");
        ArrayList<String> numeri2 = new ArrayList<>();
        numeri.add("1234561234");
        ArrayList<String> email2 = new ArrayList<>();
        email.add("mariobianchi091@example.com");
        rubrica.aggiungiContatto(contatto1);
        boolean result = rubrica.modificaContatto(contatto1, contatto2);
        assertTrue(result, "La modifica del contatto dovrebbe essere effettuata.");
        assertEquals("Luigi", rubrica.getContatti().get(0).getNome(), "Il nome dovrebbe essere aggiornato.");
    }

    @Test
    public void testRicercaContatto() {
        Contatto contatto = new Contatto();
        contatto.setNome("Mario");
        contatto.setCognome("Rossi");
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        ArrayList<String> email = new ArrayList<>();
        email.add("mariorossi123@example.com");
        rubrica.aggiungiContatto(contatto);
        List<Contatto> risultati = rubrica.ricercaContatto("Mario");
        assertEquals(1, risultati.size(), "La ricerca dovrebbe trovare un risultato.");
        assertEquals("Mario", risultati.get(0).getNome(), "Il nome del risultato dovrebbe essere 'Mario'.");
    }

    @Test
    public void testSvuotaRubrica() {
        Contatto contatto = new Contatto();
        contatto.setNome("Mario");
        contatto.setCognome("Rossi");
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        ArrayList<String> email = new ArrayList<>();
        email.add("mariorossi123@example.com");
        rubrica.aggiungiContatto(contatto);
        rubrica.svuotaRubrica();
        assertEquals(0, rubrica.getContatti().size(), "La rubrica dovrebbe essere vuota dopo averla svuotata.");
    }

    @Test
    public void testGetContatti() {
        Contatto contatto1 = new Contatto();
        contatto1.setNome("Mario");
        contatto1.setCognome("Rossi");
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        ArrayList<String> email = new ArrayList<>();
        email.add("mariorossi123@example.com");
        Contatto contatto2 = new Contatto();
        contatto2.setNome("Mario");
        contatto2.setCognome("Bianchi");
        ArrayList<String> numeri2 = new ArrayList<>();
        numeri.add("123456789");
        ArrayList<String> email2 = new ArrayList<>();
        email.add("mariobianchi091@example.com");
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(2, contatti.size(), "La rubrica dovrebbe contenere due contatti.");
    }
    
}