package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
	@Test
	public void testEnSousService() {
		untel.ajouteEnseignement(uml, 12, 10, 0);
		untel.ajouteEnseignement(java, 12, 40, 10);
		assertEquals(true, untel.enSousService(), "l'enseignant est en sous service");
		
	}
	@Test
	public void testResteAPlanifier() {
		UE uml = new UE("test", 10, 10, 10);
		assertEquals(182, untel.resteAPlanifier(uml, TypeIntervention.TD), "plus d'heures à planifier");
		assertEquals(182, untel.resteAPlanifier(uml, TypeIntervention.TP), "plus d'heures à planifier");
		assertEquals(182, untel.resteAPlanifier(uml, TypeIntervention.CM), "plus d'heures à planifier");


		
	}
	
	
}
