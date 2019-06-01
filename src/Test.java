import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	
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
		
		writeQuestion();
		
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
					break;
					
				case 2:
					loadData("AKAID");
					break;
					
				case 3:
					loadData("FIKH");
					break;
					
				case 4:
					loadData("AHLAK");
					break;
					
				case 5:
					loadData("TEFSIR");
					break;
					
				case 6:
					loadData("HADIS");
					break;
					
				case 7:
					loadData("POVIJEST ISLAMA");
					break;
					
				case 8:
					loadData("BOSANSKI JEZIK");
					break;
					
				case 9:
					loadData("ENGLESKI JEZIK");
					break;
					
				case 10:
					loadData("HISTORIJA");
					break;
					
				case 11:
					loadData("GEOGRAFIJA");
					break;
					
				case 12:
					loadData("FILOZOFIJA");
					break;
					
				case 13:
					loadData("PSIHOLOGIJA");
					break;
				}
				
			} while (choice != 0);
			
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
					System.out.println("\nJoš Se Radi.\nPristup Ne Odobren!!");
					break;
					
				case 2:
					subjectMenu();
					break;
				}
				
			} while (choice != 0);
			
		} catch (Exception e) {
		}
		
	}
	
	public static void main(String[] args) {

		mainMenu();
		
	}
	
}
