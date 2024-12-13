package it.unisa.diem.ingsoft.gruppo4.Rubrica.Test;

import it.unisa.diem.ingsoft.gruppo4.Rubrica.Contatto;
import org.junit.jupiter.api.Test;
import javafx.collections.FXCollections;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContattoTest {

    @Test
    void testSetAndGetNome() {
        Contatto contatto = new Contatto();
        contatto.setNome("Mario");
        assertEquals("Mario", contatto.getNome());
    }

    @Test
    void testSetAndGetCognome() {
        Contatto contatto = new Contatto();
        contatto.setCognome("Rossi");
        assertEquals("Rossi", contatto.getCognome());
    }

    @Test
    void testSetAndGetNumTel() {
        Contatto contatto = new Contatto();
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        numeri.add("987654321");
        numeri.add("555555555");
        numeri.add("111111111"); // Questo numero dovrebbe essere ignorato (MAX_CONTACTS = 3)
        contatto.setNumTel(numeri);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("123456789");
        expected.add("987654321");
        expected.add("555555555");

        assertEquals(expected, contatto.getNumTel());
    }

    @Test
    void testSetAndGetEmail() {
        Contatto contatto = new Contatto();
        ArrayList<String> emails = new ArrayList<>();
        emails.add("test1@example.com");
        emails.add("test2@example.com");
        emails.add("test3@example.com");
        emails.add("test4@example.com"); // Questa email dovrebbe essere ignorata (MAX_CONTACTS = 3)
        contatto.setEmail(emails);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("test1@example.com");
        expected.add("test2@example.com");
        expected.add("test3@example.com");

        assertEquals(expected, contatto.getEmail());
    }
    
    @Test
    void testToString() {
        Contatto contatto = new Contatto();
        contatto.setNome("Mario");
        contatto.setCognome("Rossi");
        ArrayList<String> numeri = new ArrayList<>();
        numeri.add("123456789");
        numeri.add("987654321");
        contatto.setNumTel(numeri);
        ArrayList<String> emails = new ArrayList<>();
        emails.add("test@example.com");
        contatto.setEmail(emails);

        // Costruzione stringa attesa
        String expected = String.join("|",
        "Mario",
        "Rossi",
        "123456789, 987654321",
        "test@example.com");

    assertEquals(expected, contatto.toString());
}

}