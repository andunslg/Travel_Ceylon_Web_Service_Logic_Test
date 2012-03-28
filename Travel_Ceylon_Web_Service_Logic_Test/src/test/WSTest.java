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
		float lngt = ws.getLongitude_City("Matara");
		float orginal = (float) 80.5494;
		assertTrue(lngt == orginal);
	}

	@Test
	public void testlatitude_city() {
		ws.connectToDB();
		float latt = ws.getLatitude_City("Matara");
		float orginal = (float) 5.94413;
		assertTrue(latt == orginal);
	}

	@Test
	public void testlatitude_impt_place() {
		ws.connectToDB();
		float latt = ws.getLatitude_Im_Place("Galle Face");
		float orginal = (float)6.92496 ;
		System.out.println(latt);
		System.out.println(orginal);
		assertTrue(latt == orginal);
	}

	@Test
	public void testlongitude_impt_place() {
		ws.connectToDB();
		float lngt = ws.getLongitude_Im_Place("Galle Face");
		float orginal = (float) 79.8446;
		assertTrue(lngt == orginal);
	}

	@Test
	public void testCategory_impt_place() {
		ws.connectToDB();
		String cat = ws.getCategory_Im_Place("Galle Face");
		assertTrue("Leisure,History".equals(cat));
	}

	@Test
	public void testDecription_impt_place() {
		ws.connectToDB();
		String des = ws.getDescription_Im_Place("Galle Face");
		assertTrue("Park".equals(des));
	}

	@Test
	public void testTripPlan_I() {

		ws.connectToDB();
		String plan = ws.planTheTrip("Weligama", "Hikkaduwa", "1",
				"History;Nature;Leisure;", "", "", "");
		assertTrue("Weligama:5.97369:80.4294:Agrabhodi Raja Maha Viharaya|Religon - Buddhisum,History|A aention temple.|5.97132|80.4196#;Ahangama:5.97305:80.362:;Koggala:5.98855:80.324:;Habaraduwa:5.99378:80.3077:;Unawatuna:6.02017:80.2476:;Galle:6.03276:80.2157:Galle Fort|History|A fortress build by Dutches |6.02948|80.2161#Kottawa Jungle|Nature|A tropical rain forest|6.10147|80.3183#;Hikkaduwa:6.14029:80.0998:;"
				.equals(plan));
	}
	@Test
	public void testTripPlan_I_SVC() {

		ws.connectToDB();
		String plan = ws.planTheTrip("Weligama", "Hikkaduwa", "1",
				"History;Nature;Leisure;", "Ahangama", "", "");
		assertTrue("Weligama:5.97369:80.4294:Agrabhodi Raja Maha Viharaya|Religon - Buddhisum,History|A aention temple.|5.97132|80.4196#;Ahangama:5.97305:80.362:;Koggala:5.98855:80.324:;Habaraduwa:5.99378:80.3077:;Unawatuna:6.02017:80.2476:;Galle:6.03276:80.2157:Galle Fort|History|A fortress build by Dutches |6.02948|80.2161#Kottawa Jungle|Nature|A tropical rain forest|6.10147|80.3183#;Hikkaduwa:6.14029:80.0998:;"
				.equals(plan));
	}
	@Test
	public void testTripPlan_I_SVC_SAC() {

		ws.connectToDB();
		String plan = ws.planTheTrip("Weligama", "Hikkaduwa", "1",
				"History;Nature;Leisure;", "Ahangama", "Imaduwa", "");
		assertTrue("Weligama:5.97369:80.4294:Agrabhodi Raja Maha Viharaya|Religon - Buddhisum,History|A aention temple.|5.97132|80.4196#;Ahangama:5.97305:80.362:;Koggala:5.98855:80.324:;Habaraduwa:5.99378:80.3077:;Unawatuna:6.02017:80.2476:;Galle:6.03276:80.2157:Galle Fort|History|A fortress build by Dutches |6.02948|80.2161#Kottawa Jungle|Nature|A tropical rain forest|6.10147|80.3183#;Hikkaduwa:6.14029:80.0998:;"
				.equals(plan));
	}
	
	@Test
	public void testTripPlan_I_SVC_SAC_OC() {

		ws.connectToDB();
		String plan = ws.planTheTrip("Weligama", "Hikkaduwa", "1",
				"History;Nature;Leisure;", "Ahangama", "Imaduwa", "Weligama");
		assertTrue("Weligama:5.97369:80.4294:Agrabhodi Raja Maha Viharaya|Religon - Buddhisum,History|A aention temple.|5.97132|80.4196#;Ahangama:5.97305:80.362:;Koggala:5.98855:80.324:;Habaraduwa:5.99378:80.3077:;Unawatuna:6.02017:80.2476:;Galle:6.03276:80.2157:;Hikkaduwa:6.14029:80.0998:;"
				.equals(plan));
	}
}
