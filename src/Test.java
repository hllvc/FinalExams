import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
	static {
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
	
	private static ArrayList<Question> allQ = new ArrayList<Question>(); 
	private static ArrayList<String> answers = new ArrayList<String>();
	private static Question q;
	private static String question;
	private static String correctAnswer;
	
	private static int numberOfCorrect;
	private static int numberOfWrong;
	private static ArrayList<Question> wrongAnswers = new ArrayList<Question>();
	
	private static Scanner input = new Scanner(System.in);
	private static Scanner textInput;
	private static File file;
	
	private static void loadData(String destination) {
		
		allQ.clear();
		answers.clear();
		wrongAnswers.clear();
		q = null;
		String answer;
		file = new File("Questions/" + destination);
		try {
			textInput = new Scanner(file);
			while (textInput.hasNextLine() && textInput.hasNext()) {
				question = textInput.nextLine();
				for (int i = 0; i < 4; i++) {
					answer = textInput.nextLine();
					if (answer.contains("*")) {
						answer = answer.substring(0, answer.length() - 1);
						correctAnswer = answer;
					}
					answers.add(answer);
				}
				q = new Question(question, correctAnswer, answers);
				allQ.add(q);
				answers.clear();
				q = null;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private static void writeQuestion() {
		
		numberOfCorrect = 0;
		numberOfWrong = 0;
		
		System.out.println();
		for (Question subject : allQ) {
			q = subject;
			System.out.println(q.getQ() + "\n");
			answers = q.getAnswers();
			for (String answ : answers)
				System.out.println(answ);
			System.out.println();
			System.out.print("Vaš Odgovor: ");
			char answer = input.next().charAt(0);
			if(checkQuestion(answer) == "exit")
				break;
			if(checkQuestion(answer) == "correct") {
				numberOfCorrect++;
				System.out.println("----------------------\n"
						+ "Vaš Odgovor Je Tačan!"
						+ "\n----------------------\n");
			} else {
				numberOfWrong++;
				wrongAnswers.add(q);
				System.out.println("----------------------\n"
						+ "Netačan Odgovor!\n\n"
						+ q.getQ()
						+ "\n\nTačan Odgovor Je: \n"
						+ q.getCorrectAnswer()
						+ "\n----------------------\n");
			}
		}
		
		System.out.println("\nBroj Tačnih: " + numberOfCorrect);
		System.out.println("Broj Netačnih: " + numberOfWrong);
		if (!wrongAnswers.isEmpty()) {
			allQ = wrongAnswers;
			wrongAnswers = new ArrayList<Question>();
			missedQ();
		}
		wrongAnswers.clear();
		
	}
	
	private static String checkQuestion(char answer) {
		
		if (answer == '0')
			return "exit";
		if (answer == q.getCorrectAnswer().charAt(0))
			return "correct";
		else
			return "incorrect";
	}
	
	private static void missedQ() {
		
		System.out.println("\nŽelite li ponoviti pogrešno odgovorena pitanja (y/n)? - ");
		char answer = input.next().charAt(0);
		if (answer == 'y')
			writeQuestion();
		else
			return;
		
	}
	
	private static void subjectMenu() {
		
		byte choice;
		try {
			
			do {
				Text.subjectMenu();
				System.out.print("\nVaš Odabir: ");
				choice = input.nextByte();
				
				switch (choice) {
				case 1:
					loadData("KIRAET");
					writeQuestion();
					break;
					
				case 2:
					loadData("AKAID");
					writeQuestion();
					break;
					
				case 3:
					loadData("FIKH");
					writeQuestion();
					break;
					
				case 4:
					loadData("AHLAK");
					writeQuestion();
					break;
					
				case 5:
					loadData("TEFSIR");
					writeQuestion();
					break;
					
				case 6:
					loadData("HADIS");
					writeQuestion();
					break;
					
				case 7:
					loadData("POVIJEST ISLAMA");
					writeQuestion();
					break;
					
				case 8:
					loadData("BOSANSKI JEZIK");
					writeQuestion();
					break;
					
				case 9:
					loadData("ENGLESKI JEZIK");
					writeQuestion();
					break;
					
				case 10:
					loadData("HISTORIJA");
					writeQuestion();
					break;
					
				case 11:
					loadData("GEOGRAFIJA");
					writeQuestion();
					break;
					
				case 12:
					loadData("FILOZOFIJA");
					writeQuestion();
					break;
					
				case 13:
					loadData("PSIHOLOGIJA");
					writeQuestion();
					break;
					
				case 14:
					loadData("LOGIKA");
					writeQuestion();
					break;
					
				case 15:
					loadData("PEDAGOGIJA");
					writeQuestion();
					break;
					
				case 16:
					loadData("SOCIOLOGIJA");
					writeQuestion();
					break;
					
				case 17:
					loadData("HEMIJA");
					writeQuestion();
					break;
					
				case 18:
					loadData("BIOLOGIJA");
					writeQuestion();
					break;
					
				case 19:
					loadData("INFORMATIKA");
					writeQuestion();
					break;
					
				case 20:
					loadData("TIZO");
					writeQuestion();
					break;
					
				case 21:
					loadData("DEMOKRATIJA");
					writeQuestion();
					break;
				}
				
			} while (choice != 0);
			
		} catch (Exception e) {
		}
		
	}
	
	private static void randomQuestion(int numberOfQuestionOnTest, int allQuestions) {
		
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		boolean existing;
		int random;
		for (int i = 0; i < numberOfQuestionOnTest; i++) {
			 do {
				existing = false;
				random = (int)(Math.random() * (allQuestions + 1));
				for (int x : randomNumbers)
					if (x == random)
						existing = true;
			 } while (!existing);
			 randomNumbers.add(random);
			 wrongAnswers.add(allQ.get(random));
		}
		
	}
	
	private static void randomTest() {
		
		for (int i = 0; i < 22; i++) {
			loadData("KIRAET");
			randomQuestion(5, 50);
			loadData("AKAID");
			randomQuestion(5, 50);
			loadData("FIKH");
			randomQuestion(5, 50);
			loadData("AHLAK");
			randomQuestion(4, 35);
			loadData("TEFSIR");
			randomQuestion(4, 30);
			loadData("HADIS");
			randomQuestion(4, 30);
			loadData("POVIJEST ISLAMA");
			randomQuestion(4, 35);
			loadData("BOSANSKI JEZIK");
			randomQuestion(13, 108);
			loadData("ENGLESKI JEZIK");
			randomQuestion(10, 100);
			loadData("HISTORIJA");
			randomQuestion(4, 25);
			loadData("GEOGRAFIJA");
			randomQuestion(4, 25);
			loadData("FILOZOFIJA");
			randomQuestion(4, 25);
			loadData("PSIHOLOGIJA");
			randomQuestion(4, 20);
			loadData("LOGIKA");
			randomQuestion(3, 20);
			loadData("PEDAGOGIJA");
			randomQuestion(3, 25);
			loadData("SOCIOLOGIJA");
			randomQuestion(4, 25);
			loadData("HEMIJA");
			randomQuestion(4, 35);
			loadData("BIOLOGIJA");
			randomQuestion(4, 35);
			loadData("INFORMATIKA");
			randomQuestion(4, 25);
			loadData("TIZO");
			randomQuestion(4, 25);
			loadData("DEMOKRATIJA");
			randomQuestion(4, 25);
				
		}
		
	}
	
	private static void updateAnsw() {
		
		try {
			
			final int pass = 210500;
			int pass1;
			System.out.print("\nUnesite PIN: ");
			pass1 = input.nextInt();
			if (pass1 == pass) {
				File file = new File("Questions");
				Desktop.getDesktop().open(file);
			} else
				System.out.println("Pogrešan PIN!");
			
		} catch (Exception e) {
		}
		
	}
	
	private static void mainMenu() {
		
		byte choice;
		try {
			
			do {
				Text.mainMenu();
				System.out.print("\nVaš Odabir: ");
				choice = input.nextByte();
				
				switch (choice) {
				case 1:
					randomTest();
					allQ = wrongAnswers;
					wrongAnswers = new ArrayList<Question>();
					writeQuestion();
					break;
					
				case 2:
					subjectMenu();
					break;
					
				case 3:
					updateAnsw();
					break;
				}
				
			} while (choice != 0);
			
		} catch (Exception e) {
		}
		
	}
	
	public static void main(String[] args) {

		mainMenu();
		System.out.println("\nNapustili Ste Program!\nSretno Na Maturi!!!");
		
	}
	
}
