package mytranslator.model.writers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import mytranslator.model.logic.Word;
import mytranslator.model.readers.ReaderDom;
import mytranslator.model.writers.WriterDom;



public class DomTest {

	
	@Test
	@DisplayName("Escribir Hello")
	void writeExcel() {
		try {
			WriterDom.write(new Word("Hello", Arrays.asList("Hola")));
			assertTrue(true, "Palabra agregada correctamente");
		}catch(Exception ex) {
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}
	
	@Test
	@DisplayName("Traducir Hello")
	void readerExcel() {
		String word = "Hello", traduction = "hola";
		try {
			Word chain = ReaderDom.read(word);
			assertEquals(traduction, 
				chain.getTranslations().get(0), ()-> "traduccion de " +word+ " es "+ traduction);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}
}
