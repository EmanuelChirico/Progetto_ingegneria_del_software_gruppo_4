package it.unisa.diem.ingsoft.gruppo4.Rubrica.Test;


import it.unisa.diem.ingsoft.gruppo4.Rubrica.Contatto;
import it.unisa.diem.ingsoft.gruppo4.Rubrica.GestoreFile;
import it.unisa.diem.ingsoft.gruppo4.Rubrica.OperazioniRubrica;
import it.unisa.diem.ingsoft.gruppo4.Rubrica.Rubrica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestoreFileTest {

    private GestoreFile gestoreFile;
    private File testFile;
    private OperazioniRubrica rubrica;

    @BeforeEach
    public void setUp() {
        gestoreFile = new GestoreFile();
        rubrica = new Rubrica(); 
    }

    @AfterEach
    public void tearDown() {
        if (testFile != null && testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testImportaContatti_ValidFile() throws IOException {
        testFile = new File("testRubricaValid.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Mario|Rossi|1234567890|mario.rossi@example.com\n");
            writer.write("Luca|Bianchi|0987654321|luca.bianchi@example.com\n");
        }

        boolean result = gestoreFile.importaContatti(testFile, rubrica);

        assertTrue(result);
        assertEquals(2, rubrica.getContatti().size());
    }
    
    @Test
    public void testImportaContatti_EmptyLines() throws IOException {
        File testFile = new File("testRubricaEmptyLines.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("\n");
            writer.write("Mario|Rossi|1234567890|mario.rossi@example.com\n");
            writer.write("\n");
        }

        boolean result = gestoreFile.importaContatti(testFile, rubrica);

        assertTrue(result, "Le righe vuote non devono influire sull'importazione.");
        assertEquals(1, rubrica.getContatti().size(), "La rubrica dovrebbe contenere 1 contatto.");
    }
    
    @Test
    public void testImportaContatti_MalformedLines() throws IOException {
        File testFile = new File("testRubricaMalformed.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Mario|Rossi|1234567890\n"); // Manca un campo
            writer.write("Luca|Bianchi|0987654321|luca.bianchi@example.com\n");
        }

        boolean result = gestoreFile.importaContatti(testFile, rubrica);

        assertFalse(result, "L'importazione dovrebbe fallire per righe malformattate.");
        assertEquals(0, rubrica.getContatti().size(), "La rubrica non dovrebbe contenere contatti.");
        assertEquals(1, gestoreFile.getRigaErrore(), "La riga 1 dovrebbe essere segnalata come errore.");
    }
    
    @Test
    public void testGetRigaErrore() {
        testFile = new File("testRubricaInvalid.txt");
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Mario Rossi|1234567890\n"); // Mancano campi
        } catch (IOException e) {
            fail("Errore nella scrittura del file di test.");
        }

        gestoreFile.importaContatti(testFile, rubrica);

        assertEquals(1, gestoreFile.getRigaErrore());
    }
    
    @Test
    public void testEsportaContatti_ValidList() throws IOException {
    testFile = new File("testEsportaRubrica.txt");
    ObservableList<Contatto> contatti = FXCollections.observableArrayList();
    
    Contatto contatto1 = new Contatto();
    contatto1.setNome("Mario");
    contatto1.setCognome("Rossi");
    ArrayList<String> numeri1 = new ArrayList<>();
    numeri1.add("1234567890");
    contatto1.setNumTel(numeri1);
    ArrayList<String> email1 = new ArrayList<>();
    email1.add("mario.rossi@example.com");
    contatto1.setEmail(email1);
    contatti.add(contatto1);
    
    Contatto contatto2 = new Contatto();
    contatto2.setNome("Luca");
    contatto2.setCognome("Bianchi");
    ArrayList<String> numeri2 = new ArrayList<>();
    numeri2.add("0987654321");
    contatto2.setNumTel(numeri2);
    ArrayList<String> email2 = new ArrayList<>();
    email2.add("luca.bianchi@example.com");
    contatto2.setEmail(email2);
    contatti.add(contatto2);
    
    gestoreFile.esportaContatti(testFile, contatti);

    assertTrue(testFile.exists());
    try (BufferedReader reader = new BufferedReader(new FileReader(testFile))) {
        long lineCount = reader.lines().count();
        assertEquals(2, lineCount); // Verifica che ci siano esattamente 2 contatti nel file
    }
}
    @Test
    public void testEsportaContatti_EmptyList() throws IOException {
        testFile = new File("testEsportaRubricaVuota.txt");
        ObservableList<Contatto> contatti = FXCollections.observableArrayList();

        gestoreFile.esportaContatti(testFile, contatti);

        assertTrue(testFile.exists());
        assertEquals(0, testFile.length());
    }
}
