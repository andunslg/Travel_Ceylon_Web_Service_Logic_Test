package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import web_service_logic.*;

public class WSTest {
	private static Web_Service ws;
	
	@BeforeClass
	public static void setup() {
		ws = new Web_Service();
	}
	
	@Test
	public void testlongitude_city() {
		ws.connectToDB();
		float lngt=ws.getLongitude_City("Matara");
		float orginal=(float) 5.94413;
		assertTrue(lngt == orginal );
	}
	@Test
	public void testlatitude_city() {
		ws.connectToDB();
		float latt=ws.getLatitude_City("Matara");
		float orginal=(float) 80.5494;
		assertTrue(latt == orginal );
	}
	@Test
	public void testlatitude_impt_place() {
		ws.connectToDB();
		float latt=ws.getLatitude_Im_Place("Galle Face");
		float orginal=(float) 79.8446;
		assertTrue(latt == orginal );
	}
	@Test
	public void testlongitude_impt_place() {
		ws.connectToDB();
		float lngt=ws.getLongitude_Im_Place("Galle Face");
		float orginal=(float) 6.92496;
		assertTrue(lngt == orginal );
	}
	@Test
	public void testCategory_impt_place() {
		ws.connectToDB();
		String cat=ws.getCategory_Im_Place("Galle Face");
		assertTrue("Lesuire,History".equals(cat));
	}
	@Test
	public void testDecription_impt_place() {
		ws.connectToDB();
		String des=ws.getDescription_Im_Place("Galle Face");
		assertTrue("Park".equals(des));
	}
}
