
public class Text {
	
	public static void intro() {
		System.out.println("\nDobrodošli U Basic Cosole Verziju Ovog Programa.\n"
				+ "Imate Mogućnosti Da Vježbate I Spremate Testove Za Externu Maturu.\n"
				+ "Program Prati Vaša Netačno Odgovorena Pitanja I Daje Vam Priliku Da Ih Ispravite!\n"
				+ "-------------------\n"
				+ "Kontrole:\n"
				+ "-Za Navigaciju Pratite Brojeve Pokraj Opcije Koju Želite,\n"
				+ "\tUnesete Broj A Zatim ENTER!\n"
				+ "-U Toku Testa Pišete Slovo Ispred Željenog Odgovora Pa ENTER!\n"
				+ "\t!!!Test Možete Napustiti Ako Unesete 0 (nulu)\n"
				+ "\nSRETNO I UŽIVAJTE");
	}
	
	public static void mainMenu() {
		System.out.println("\n___________________\n"
				+ "\n--MAIN MENU--\n\n"
				+ "1) Test Simulacija (u razvoju)\n"
				+ "2) Pojedinacni predmeti\n"
				+ "3) Izborni Predmeti\n\n"
				+ "00) Ispravi Test (Admin)\n\n"
				+ "0) IZLAZ");
	}

	public static void subjectMenu() {
		System.out.println("\n___________________\n"
				+ "\n--PREDMETI--\n\n"
				+ " 1) Kiraet\n"
				+ " 2) Akaid\n"
				+ " 3) Fikh\n"
				+ " 4) Ahlak\n"
				+ " 5) Tefsir\n"
				+ " 6) Hadis\n"
				+ " 7) Povijest islama\n"
				+ " 8) Bosanski jezik i književnost\n"
				+ " 9) Engleski jezik\n"
				+ "10) Historija\n"
				+ "11) Geografija\n"
				+ "12) Filozofija\n"
				+ "13) Psiholgija\n"
				+ "14) Logika\n"
				+ "15) Pedagogija feat. DIDAKTIKA\n"
				+ "16) Sociologija\n"
				+ "17) Fizika\n"
				+ "18) Hemija\n"
				+ "19) Biologija\n"
				+ "20) Informatika\n"
				+ "21) Tizo\n"
				+ "22) Demokratija i ljudska prava\n\n"
				+ "0) NAZAD");
	}
	
	public static void additionalSubj() {
		System.out.println("\n___________________\n"
				+ "\n--PREDMETI--\n\n"
				+ "1) Informatika");
	}
	
	public static void response() {
		System.out.print("\nVaš Odgovor: ");
	}
	
	public static void choice() {
		System.out.print("\nVaš Odabir: ");
	}
	
	public static void correctAnsw() {
		System.out.println("----------------------\n"
				+ "Vaš Odgovor Je Tačan!"
				+ "\n----------------------\n");
	}
	
	public static void wrongAnsw(Question q) {
		System.out.println("----------------------\n"
				+ "Netačan Odgovor!\n\n"
				+ q.getQ()
				+ "\n\nTačan Odgovor Je: \n"
				+ q.getCorrectAnswer()
				+ "\n----------------------\n");
	}
	
	public static void testResult() {
		System.out.println("\nBroj Tačnih: " + Test.numberOfCorrect);
		System.out.println("Broj Netačnih: " + Test.numberOfWrong);
	}
	
	public static void mark(int mark) {
		System.out.println("Ocijena: " + mark);
		System.out.println("\n\n--SKALA--\n"
				+ "_________________\n"
				+ "od  0 do  39 = 1\n"
				+ "od 40 do  54 = 2\n" 
				+ "od 55 do  69 = 3\n" 
				+ "od 70 do  84 = 4\n" 
				+ "od 85 do 100 = 5\n"); 
	}
	
	public static void repeat() {
		System.out.print("\nŽelite li ponoviti pogrešno odgovorena pitanja (y/n)? - ");
	}
	
	public static void endMsg() {
		System.out.println("\nNapustili Ste Program!"
				+ "\nSretno Na Maturi!!!");
	}
	
	public static void wrongPIN() {
		System.out.println("Pogrešan PIN!");
	}
	
	public static void inputPIN() {
		System.out.print("\nUnesite PIN: ");
	}
	
	public static void wrongInput() {
		System.out.print("\n___________________\n\n"
				+ "Pogrešan Unos!");
	}
	
}
